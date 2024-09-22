package com.ragnar.acutisclub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    TextView nameTextView, rollNoTextView, editProfileTextView;
    ImageView profilePitureImageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        nameTextView = view.findViewById(R.id.displayName);
        rollNoTextView = view.findViewById(R.id.displayRollNo);
        profilePitureImageView = view.findViewById(R.id.profileImage);

        return view;
    }
}