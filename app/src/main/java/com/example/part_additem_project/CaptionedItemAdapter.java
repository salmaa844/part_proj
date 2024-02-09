package com.example.part_additem_project;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedItemAdapter extends RecyclerView.Adapter<CaptionedItemAdapter.ViewHolder> {

    private String[] captions;
    private String[] price;
    private int[] imageIds;

    public CaptionedItemAdapter(String[] captions , String[] price, int[] imageIds){
        this.captions =captions;
         this.price=price;
        this.imageIds =imageIds;
    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        CardView v =(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_like,
                parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView =holder.cardView;
        ImageView imageView =(ImageView) cardView .findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(dr);
        TextView txt =(TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);
        TextView txt2 =(TextView)cardView.findViewById(R.id.txtPrice);
        txt2.setText(price[position]);
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){}

        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }
}
