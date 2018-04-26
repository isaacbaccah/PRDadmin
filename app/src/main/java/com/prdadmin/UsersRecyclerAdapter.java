package com.prdadmin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Naenae XPS on 4/26/2018.
 */

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder> {

    private List<UserList> userList;
    private Context context;

    public UsersRecyclerAdapter(Context context, List<UserList> usersList){

        this.userList = usersList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
                return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.user_name_view.setText(userList.get(position).getName());
        holder.user_phone_view.setText(userList.get(position).getPhone());
        holder.user_address_view.setText(userList.get(position).getAddress());

        CircleImageView user_image_view = holder.user_image_view;
        Glide.with(context).load(userList.get(position).getImage()).into(user_image_view);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private CircleImageView user_image_view;
        private TextView user_name_view;
        private TextView user_phone_view;
        private TextView user_address_view;


        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            user_image_view = (CircleImageView) mView.findViewById(R.id.user_list_image);
            user_name_view = (TextView) mView.findViewById(R.id.user_list_name);
            user_phone_view = (TextView) mView.findViewById(R.id.user_list_phone);
            user_address_view = (TextView) mView.findViewById(R.id.user_list_address);
        }
    }
}
