package com.example.knowthetrend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    Context context;
    private int[] images;
    private  String[] text_array;
    Intent intent;

    public ListAdapter(Context context, int[] images, String[] text_array,Intent intent) {
        this.context = context;
        this.images = images;
        this.text_array = text_array;
        this.intent=intent;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(text_array[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.fashiontype_pic);
            textView=itemView.findViewById(R.id.fashiontype);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(context,ChartListActivity.class);
                    i.putExtra("POS",getAdapterPosition());
                    i.putExtra("catType",intent.getIntExtra("catType",0));
                    context.startActivity(i);
                }
            });
        }
    }
}
