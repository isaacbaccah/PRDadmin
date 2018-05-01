package com.prdadmin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Requests extends Fragment {

    private RecyclerView mRequestListView;
    private String user_id;
    private FirebaseAuth mAuth;

    private List<RequestList> requestList;
    private RequestsRecyclerAdapter requestsRecyclerAdapter;

    private FirebaseFirestore mFirestore;


    public Requests() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_requests, container, false);

        mFirestore = FirebaseFirestore.getInstance();

        mRequestListView = (RecyclerView) view.findViewById(R.id.requests_list_view);

        requestList = new ArrayList<>();
        requestsRecyclerAdapter = new RequestsRecyclerAdapter(container.getContext(), requestList);

        mRequestListView.setHasFixedSize(true);
        mRequestListView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mRequestListView.setAdapter(requestsRecyclerAdapter);

        mAuth = FirebaseAuth.getInstance();



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


        user_id = mAuth.getCurrentUser().getUid();


        mFirestore.collection("requests").addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {


                for(DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED ) {

                        RequestList requests = doc.getDocument().toObject(RequestList.class);
                        requestList.add(requests);

                        requestsRecyclerAdapter.notifyDataSetChanged();

                    }
                }
            }
        });
    }

    public void callParentMethod(){
        getActivity().onBackPressed();
    }

}
