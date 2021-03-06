package id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.fragment.HomeFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.model.Results;

/**
 * Created by ERIKA-MOKLET on 14/05/2017.
 */

public class Home extends RecyclerView.Adapter<Home.MyViewHolder>  {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> mlist;
    HomeFragment homefragment;
    Context context;
    private int lastposition = -1;

    public Home (HomeFragment homefragment, ArrayList<Results> mlist, Context context) {
        this.mlist = mlist;
        this.homefragment = homefragment;
        this.context = context;
    }

    @Override
    public Home.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Home.MyViewHolder holder, int position) {
        Results results = mlist.get(position);
        holder.tvName.setText(results.title);
        holder.tvDesc.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imageView;

        public MyViewHolder(View v) {
            super(v);

            tvName = (TextView) v.findViewById(R.id.tv_text);
            tvDesc = (TextView) v.findViewById(R.id.tv_desc);
            imageView = (ImageView) v.findViewById(R.id.iv_image);
        }
    }
}
