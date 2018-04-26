package com.prdadmin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

public class RequestsRecyclerAdapter extends RecyclerView.Adapter<RequestsRecyclerAdapter.ViewHolder> {

    private List<RequestList> requestList;
    private Context context;

    public RequestsRecyclerAdapter(Context context, List<RequestList> requestList){

        this.requestList = requestList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_list_item, parent, false);
                return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestsRecyclerAdapter.ViewHolder holder, int position) {

        holder.request_name_view.setText(requestList.get(position).getName());
        holder.request_phone_view.setText(requestList.get(position).getPhone());
        holder.request_address_view.setText(requestList.get(position).getAddress());
        holder.request_amount_view.setText(requestList.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;

        private TextView request_name_view;
        private TextView request_phone_view;
        private TextView request_address_view;
        private TextView request_amount_view;


        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            request_name_view = (TextView) mView.findViewById(R.id.request_list_name);
            request_phone_view = (TextView) mView.findViewById(R.id.request_list_phone);
            request_address_view = (TextView) mView.findViewById(R.id.request_list_address);
            request_amount_view = (TextView) mView.findViewById(R.id.request_list_amount);


        }
    }

}
