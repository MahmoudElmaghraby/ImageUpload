package com.example.android.imageupload;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public static int loggedIn ;
    public static String loggedPhone;
    public static String loggedName;
    public static String loggedLocation;
    public static String loggedEmail;

    public static String productName;
    public static float productPrice;
    public static String productType;
    public static String productPtNo;
    public static String productImage ;

    private TextView userNameTv, phoneNumberTv, locatioTv, imageTv;
    private DrawerLayout drawer;
    private Query query;
    private EditText userNameEditText, userPassword, userEmailEditText, userPhoneNumber, userLocation;
    private Button registrationButton, loginButton, leftButton, middleButton, rightButton;
    private Users user;
    private FirebaseDatabase database;
    public static DatabaseReference mrPistonDBRef;
    private String name, password, email, phoneNumber, location, id;
    private ImageView userImage;

    //Variables for load and store image
    private static final int PICK_IMAGE_REQUEST = 1;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    private StorageReference mStorage;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to not popup the keyboard when the app begin
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mStorage = FirebaseStorage.getInstance().getReference("Uploads");

        database = FirebaseDatabase.getInstance();
        mrPistonDBRef = database.getReference();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.myColor));
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        leftButton = findViewById(R.id.left_button);
        middleButton = findViewById(R.id.middle_button);
        rightButton = findViewById(R.id.right_button);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LeftButton.class);
                startActivity(intent);
            }
        });

        middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Choose.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_item, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add:

                Dialog dialog = new Dialog(MainActivity.this, R.style.NewDialog);
                dialog.setContentView(R.layout.activity_registration);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                userNameEditText = dialog.findViewById(R.id.user_name_editText);
                userPassword = dialog.findViewById(R.id.password_EditText);
                userEmailEditText = dialog.findViewById(R.id.email_EditText);
                userPhoneNumber = dialog.findViewById(R.id.phone_number_EditText);
                userLocation = dialog.findViewById(R.id.location_editText);
                userNameTv = dialog.findViewById(R.id.user_name_text_view);
                phoneNumberTv = dialog.findViewById(R.id.phone_number_textView);
                locatioTv = dialog.findViewById(R.id.location_textView);
                imageTv = dialog.findViewById(R.id.image_textView);
                loginButton = dialog.findViewById(R.id.login_button);
                registrationButton = dialog.findViewById(R.id.register_button);
                userImage = dialog.findViewById(R.id.user_image);
                mProgressBar = dialog.findViewById(R.id.progress_bar);

                // ADD NEW USERS EL GDEEDA
                registrationButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (userNameEditText.getVisibility() == view.GONE) {
                            userImage.setVisibility(View.VISIBLE);
                            imageTv.setVisibility(View.VISIBLE);
                            userNameEditText.setVisibility(View.VISIBLE);
                            userNameTv.setVisibility(View.VISIBLE);
                            userLocation.setVisibility(View.VISIBLE);
                            locatioTv.setVisibility(View.VISIBLE);
                            userPhoneNumber.setVisibility(View.VISIBLE);
                            phoneNumberTv.setVisibility(View.VISIBLE);
                            loginButton.setVisibility(View.GONE);

                        } else {
                            if (validate()) {
                                uploadFile();
                                addUser();
                                clearViews();
                            }
                        }
                    }
                });

                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // STARTING HERE ATTEMPT 1 !!!
                        query = mrPistonDBRef.child("Users").orderByChild("userEmail").equalTo(userEmailEditText.getText().toString().trim());
                        final String getPasswordFromEditText = userPassword.getText().toString().trim();
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {

                                    for (DataSnapshot childOfDataSnapshot : dataSnapshot.getChildren()) {
                                        String userGetter = childOfDataSnapshot.getKey();
                                        String getPasswordFromFirebase = dataSnapshot.child(userGetter).child("passWord").getValue().toString();
                                        if (getPasswordFromFirebase.equals(getPasswordFromEditText)) {
                                            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                            clearViews();
                                            loggedIn = 1;
                                            loggedLocation = dataSnapshot.child(userGetter).child("location").getValue().toString();
                                            loggedEmail = dataSnapshot.child(userGetter).child("userEmail").getValue().toString();
                                            loggedPhone = dataSnapshot.child(userGetter).child("userPhone").getValue().toString();
                                            loggedName = dataSnapshot.child(userGetter).child("userName").getValue().toString();
                                        } else {
                                            Toast.makeText(MainActivity.this, "Email / Password Combination does not exist!.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, "Wrong Email or password", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });


                //When click on ImageView
                userImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mProgressBar.setVisibility(View.VISIBLE);
                        openFileChooser();

                    }
                });

                dialog.show();

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * To check if there is an empty field or not
     * true --> Every thing is complete
     * false --> there is a field or more not complete
     *
     * @return
     */
    private Boolean validate() {
        Boolean result = false;

        name = userNameEditText.getText().toString();
        password = userPassword.getText().toString();
        email = userEmailEditText.getText().toString();
        phoneNumber = userPhoneNumber.getText().toString();
        location = userLocation.getText().toString();

        if (name.isEmpty() ||
                password.isEmpty() ||
                email.isEmpty() ||
                phoneNumber.isEmpty() ||
                location.isEmpty() ||
                mImageUri == null) {
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }

    /**
     * To clear all the EditTexts
     */
    private void clearViews() {

        userNameEditText.setText("");
        userPassword.setText("");
        userEmailEditText.setText("");
        userPhoneNumber.setText("");
        userLocation.setText("");

    }

    /**
     * To ad user in firebase
     */
    public void addUser() {
        userName = userNameEditText.getText().toString().trim();
        String userEmail = userEmailEditText.getText().toString().trim();
        String userLoc = userLocation.getText().toString().trim();
        String userPass = userPassword.getText().toString().trim();
        String userPhone = userPhoneNumber.getText().toString().trim();
        if (validate()) {
            id = mrPistonDBRef.push().getKey();
            user = new Users(userName, userPass, userEmail, userPhone, userLoc);
            mrPistonDBRef.child("Users").child(userName).setValue(user);
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * To open the photos in the device to choose from it
     */
    private void openFileChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }

    /**
     * It is called when PICK_IMAGE request
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).into(userImage); //or you can use the next line to set the image in the imageView
            //userImage.setImageURI(mImageUri);

        }

    }

    /**
     * To get the Extension of file that will upload to firebase
     * if you don't understand it --> Google it !
     *
     * @return
     */
    private String getFileExtension(Uri uri) {

        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));

    }

    /**
     * To upload images to firebase
     */
    private void uploadFile() {

        if (mImageUri != null) {

            //Set the name of image that will upload to firebase with it ,
            //and we use currentTimeMillis because it is change very fast and can not be repeated
            StorageReference fileReference = mStorage.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));
            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            }, 500);

                            Toast.makeText(MainActivity.this, "Upload Successful", Toast.LENGTH_LONG).show();

                            UploadImages upload = new UploadImages("My Name ","My Description",taskSnapshot.getUploadSessionUri().toString());
                            //String uploadId = mrPistonDBRef.push().getKey();
                            mrPistonDBRef.child(id).setValue(upload);

                        }

                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    mProgressBar.setProgress((int) progress);

                }
            });

        } else {
            Toast.makeText(this, "No file selected !", Toast.LENGTH_SHORT).show();
        }

    }
}