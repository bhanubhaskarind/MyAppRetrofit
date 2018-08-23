package com.work.bhaskar.myappretrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private List<PostRegister> userListList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, user_id;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);
            user_id = (TextView) view.findViewById(R.id.user_id);
        }
    }

    public UserListAdapter(List<PostRegister> moviesList) {
        this.userListList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PostRegister postRegister = userListList.get(position);
        holder.name.setText(postRegister.getName());
        holder.email.setText(postRegister.getEmail());
        holder.user_id.setText(Integer.toString(postRegister.getId()));
    }

    @Override
    public int getItemCount() {
        return userListList.size();
    }
}