package com.example.android.imageupload;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext ;
    private List<Upload> mUploads ;
    private onItemClickListener mListener ;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener ;
    }

    public ImageAdapter(Context context , List<Upload> uploadImages){
        mContext = context ;
        mUploads = uploadImages ;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.single_item , parent , false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(v , mListener);
        return imageViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload currentUpload = mUploads.get(position);
        Picasso.with(mContext)
                .load(currentUpload.getImageUrl())
                .placeholder(R.mipmap.app_icon)
                .fit()
                .into(holder.imageView);
        holder.nameTextView.setText(currentUpload.getName());
        holder.descTextView.setText(currentUpload.getmModel()
                +" - "
                +  currentUpload.getmSubModel() + "\n" + currentUpload.getmYear());



    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView ;
        public TextView nameTextView ;
        public TextView descTextView ;

        public ImageViewHolder(@NonNull View itemView , final onItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view_upload);
            nameTextView = itemView.findViewById(R.id.text_view_name);
            descTextView = itemView.findViewById(R.id.text_view_desc);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });



        }
    }

}
