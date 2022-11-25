package com.hieunguyen.bda.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hieunguyen.bda.Model.User;
import com.hieunguyen.bda.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private Context context;
    private List<User> usersList;

    public UserAdapter(Context context, List<User> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.user_displayed_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user = usersList.get(position);

        holder.userType.setText(user.getType());

        if(user.getType().equals("donor"))
        {
            holder.emailNow.setVisibility(View.GONE);
        }

        holder.userEmail.setText(user.getEmail());
        holder.userName.setText(user.getName());
        holder.userPhoneNumber.setText(user.getPhonenumber());
        holder.userBloodGroup.setText(user.getBloodgroup());

        Glide.with(context).load(user.getProfilepictureurl()).into(holder.userProfileImage);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView userProfileImage;
        public TextView userType, userName, userEmail, userBloodGroup, userPhoneNumber;
        public Button emailNow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userProfileImage = itemView.findViewById(R.id.userProfileImage);

            userName = itemView.findViewById(R.id.userName);
            userType = itemView.findViewById(R.id.userType);
            userEmail = itemView.findViewById(R.id.userEmail);
            userBloodGroup = itemView.findViewById(R.id.userBloodGroup);
            userPhoneNumber = itemView.findViewById(R.id.userPhoneNumber);

            emailNow = itemView.findViewById(R.id.emailNow);
        }
    }
}
