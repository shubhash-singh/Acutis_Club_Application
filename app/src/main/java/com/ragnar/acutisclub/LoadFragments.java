package com.ragnar.acutisclub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class LoadFragments extends AppCompatActivity {
    BottomNavigationView navbar;
    TextView pageNameTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragments);

        pageNameTextView = findViewById(R.id.pageName);
        navbar = findViewById(R.id.bottom_navigation_bar);

        navbar.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.project) {
                loadFragment(new ProjectFragment());
                pageNameTextView.setText(R.string.project);
            } else if (id == R.id.notice) {
                loadFragment(new NoticeFragment());
                pageNameTextView.setText(R.string.notice);
            } else if (id == R.id.profile) {
                loadFragment(new ProfileFragment());
                pageNameTextView.setText(R.string.profile);
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }

}