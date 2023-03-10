package com.example.barangay_cleaning.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barangay_cleaning.R;
import com.example.barangay_cleaning.models.Resident;
import com.example.barangay_cleaning.views.ResidentActivity;

import java.util.ArrayList;

public class ResidentsAdapter  extends RecyclerView.Adapter<ResidentsAdapter.MyViewHolder>{
    Context context;
    ArrayList<Resident> residents;

    public ResidentsAdapter(Context context, ArrayList<Resident> residents){
        this.context = context;
        this.residents = residents;
    }

    @NonNull
    @Override
    public ResidentsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResidentsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.resident_item_row, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentsAdapter.MyViewHolder holder, int position) {
        holder.name.setText(residents.get(position).getFullName());
        holder.age.setText(String.valueOf(residents.get(position).getAge()));
        holder.address.setText(residents.get(position).getAddress());
        holder.image.setImageResource(residents.get(position).getImage());
        holder.viewButton.setOnClickListener(view->{
            Intent intent = new Intent(context, ResidentActivity.class);
            intent.putExtra("resident", residents.get(position));
            context.startActivity(intent);
        });

        holder.image.setOnClickListener(view -> {
            Dialog settingsDialog = new Dialog(context);

            LayoutInflater inflater = LayoutInflater.from(context);
            View newView = (View) inflater.inflate(R.layout.image_layout, null);

            settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            settingsDialog.setContentView(newView);

            ImageView iv= (ImageView) newView.findViewById(R.id.image_popup);
            Bitmap bm=((BitmapDrawable)holder.image.getDrawable()).getBitmap();
            iv.setImageBitmap(bm);

            settingsDialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return residents.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView age;
        TextView address;
        Button viewButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.resident_image);
            name = itemView.findViewById(R.id.resident_name);
            age = itemView.findViewById(R.id.resident_age);
            address = itemView.findViewById(R.id.resident_address);
            viewButton = itemView.findViewById(R.id.view_button);
        }
    }
}