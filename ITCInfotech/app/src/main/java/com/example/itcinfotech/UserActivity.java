package com.example.itcinfotech;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class UserActivity extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Data> list;
    RecyclerView recyclerView;
    SearchView searchView;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user.getEmail().equals("pranav@gmail.com")){
        ref = FirebaseDatabase.getInstance().getReference().child("data").child("manager1");}
        else if(user.getEmail().equals("pranavr@gmail.com")){
            ref = FirebaseDatabase.getInstance().getReference().child("data").child("manager2");
        }
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView);

    }

    @Override
    protected void onStart() {

        super.onStart();
        if(ref != null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        list = new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren()){
                            list.add(ds.getValue(Data.class));

                        }
                        AdapterClass adapterClass = new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(UserActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });
        }
        if(searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);

                    return true;
                }
            });
        }
    }
    private  void search(String str){
        ArrayList<Data> myList = new ArrayList<>();

        for(Data object : list){
            if(object.getName().toLowerCase().contains(str.toLowerCase())||
            object.getTempID().toLowerCase().contains(str.toLowerCase())||
            object.getGuide().toLowerCase().contains(str.toLowerCase())||
            object.getStartDate().toLowerCase().contains(str.toLowerCase())||
            object.getEndDate().toLowerCase().contains(str.toLowerCase())){
                myList.add(object);
            }
        }
        AdapterClass adapterClass = new AdapterClass(myList);
        recyclerView.setAdapter(adapterClass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FirebaseAuth.getInstance().signOut();
        Intent I = new Intent(UserActivity.this, MainActivity.class);
        startActivity(I);
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){

    }
}
