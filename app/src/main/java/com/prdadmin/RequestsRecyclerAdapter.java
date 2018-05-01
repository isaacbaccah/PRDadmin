package com.prdadmin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;



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
    public void onBindViewHolder(@NonNull final RequestsRecyclerAdapter.ViewHolder holder, final int position) {


        holder.request_name_view.setText(requestList.get(position).getName());
        holder.request_phone_view.setText(requestList.get(position).getPhone());
        holder.request_address_view.setText(requestList.get(position).getAddress());
        holder.request_amount_view.setText(requestList.get(position).getAmount());

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_call:

                                Intent intent = new Intent(Intent.ACTION_DIAL);

                                intent.setData(Uri.parse("tel:0123456789"));
                                context.startActivity(intent);
                                //handle menu1 click
                                break;
                            case R.id.action_view:
                                //handle menu2 click
                                break;
                            case R.id.action_delete:
                                //handle menu3 click
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });

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
        private TextView buttonViewOption;


        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            request_name_view = (TextView) mView.findViewById(R.id.request_list_name);
            request_phone_view = (TextView) mView.findViewById(R.id.request_list_phone);
            request_address_view = (TextView) mView.findViewById(R.id.request_list_address);
            request_amount_view = (TextView) mView.findViewById(R.id.request_list_amount);
            buttonViewOption = (TextView) mView.findViewById(R.id.textViewOptions);


        }
    }



}
