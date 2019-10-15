package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.waagrechterwurf.datenbank.User;
import com.example.waagrechterwurf.datenbank.UserDAO;
import com.example.waagrechterwurf.datenbank.UserListAdapter;
import com.example.waagrechterwurf.datenbank.UserRoomDatabase;

import java.util.List;

public class Activity4_Auflistung extends Activity {

    private UserDAO dao;
    private RecyclerView recyclerView;
    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4__auflistung);

        recyclerView = findViewById(R.id.user_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter();
        recyclerView.setAdapter(adapter);

        dao = UserRoomDatabase.getDatabase(this).userDAO();
    }

    class LadeUsersTask extends AsyncTask<Void, Void, List<User>>{

        @Override
        protected List<User> doInBackground(Void... voids) {
            return dao.getAll();
        }
    }

    protected void onResume(){
        super.onResume();
        new LadeUsersTask().execute();
    }
}
