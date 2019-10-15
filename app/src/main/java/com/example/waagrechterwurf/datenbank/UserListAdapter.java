package com.example.waagrechterwurf.datenbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waagrechterwurf.R;

import java.util.Collections;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//Liste erstellen
    private List<User> users = Collections.emptyList();

//Leerer Konstruktor??
public UserListAdapter() {
    }

// UserViewHolder??
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout, parent, false);
        return new UserViewHolder(view);
    }
// Brauche ich für jeden Wert (Hoehe, Besch., Ergebnis) eine eigene TextView?
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView userView = holder.itemView.findViewById(R.id.list_item_user);
        Double test = users.get(position).getHoehe();
        String testH = String.valueOf(test);
        userView.setText(testH);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
