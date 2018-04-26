package com.prdadmin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Users extends Fragment {

    private RecyclerView mUserListView;

    private List<UserList> userList;
    private UsersRecyclerAdapter usersRecyclerAdapter;

    private FirebaseFirestore mFirestore;



    public Users() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        mFirestore = FirebaseFirestore.getInstance();

        mUserListView = (RecyclerView) view.findViewById(R.id.users_list_view);

        userList = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(container.getContext(), userList);

        mUserListView.setHasFixedSize(true);
        mUserListView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mUserListView.setAdapter(usersRecyclerAdapter);



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mFirestore.collection("Users").addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {


                for(DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED ) {

                        UserList users = doc.getDocument().toObject(UserList.class);
                        userList.add(users);

                        usersRecyclerAdapter.notifyDataSetChanged();

                    }
                }


            }
        });
    }
}
