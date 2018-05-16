package com.example.admin.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by admin on 2018/3/27.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mcontext;
    private List<Fruit> mFruitList;


    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            fruitImage=itemView.findViewById(R.id.fruit_image);
            fruitName=itemView.findViewById(R.id.fruit_name);
        }

    }
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (mcontext==null){
           mcontext=parent.getContext();
       }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.feuit_item,parent, false);
        //return new ViewHolder(view);
        final ViewHolder holder=new ViewHolder(view); //给RecycleView增加点击事件

       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = holder.getAdapterPosition();
               Fruit fruit = mFruitList.get(position);
               Intent intent=new Intent(mcontext,FruitActivity.class);
               intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
               intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImaged());
               mcontext.startActivity(intent);
           }
       });
       return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
    Fruit fruit=mFruitList.get(position);
    holder.fruitName.setText(fruit.getName());
        Glide.with(mcontext).load(fruit.getImaged()).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }





}
