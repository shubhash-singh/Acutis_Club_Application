package com.ragnar.acutisclub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ragnar.acutisclub.Backend.GetUserData;
import com.ragnar.acutisclub.Callbacks.UserDataCallback;

import java.util.List;

public class ProfileFragment extends Fragment {
    TextView nameTextView, rollNoTextView, logoutButton;
    ImageView profilePitureImageView, leetcodeButton, hackerRankButton, gitHubButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        nameTextView = view.findViewById(R.id.displayName);
        rollNoTextView = view.findViewById(R.id.displayRollNo);
        profilePitureImageView = view.findViewById(R.id.profileImage);

        leetcodeButton = view.findViewById(R.id.leetCodeIcon);
        hackerRankButton = view.findViewById(R.id.hackerRankIcon);
        gitHubButton = view.findViewById(R.id.giHubIcon);

        logoutButton = view.findViewById(R.id.logoutButton);


        logoutButton.setOnClickListener(item -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        GetUserData getUserData = new GetUserData();

        setUserData(getUserData);


        leetcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The URL you want to open
                String url = "https://www.leetcode.com";

                // Create an intent with ACTION_VIEW
                Intent intent = new Intent(Intent.ACTION_VIEW);

                // Set the data as the URL
                intent.setData(Uri.parse(url));

                // Start the activity to open the browser
                startActivity(intent);
            }
        });
        return view;
    }
    private void setUserData(GetUserData getUserData){

        getUserData.getNameRollNo(new UserDataCallback() {
            @Override
            public void onSuccess(List<String> userData) {
                nameTextView.setText(userData.get(0));
                rollNoTextView.setText(userData.get(1));
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}