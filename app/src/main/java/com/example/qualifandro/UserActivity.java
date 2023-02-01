package com.example.qualifandro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.qualifandro.adapter.UserViewPagerAdapter;
import com.example.qualifandro.fragment.LoginFragment;
import com.example.qualifandro.fragment.RegisterFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy{
    private ArrayList<Fragment> vpUserList;
    private ArrayList<String> tlUserList;
    private UserViewPagerAdapter uvpa;
    private TabLayout tlUser;
    private ViewPager2 vpUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tlUserList = new ArrayList<>();
        tlUserList.add("Login");
        tlUserList.add("Register");

        tlUser = findViewById(R.id.tl_user);
        vpUser = findViewById(R.id.vp_user);

        vpUserList = new ArrayList<>();
        vpUserList.add(new LoginFragment());
        vpUserList.add(new RegisterFragment());

        uvpa = new UserViewPagerAdapter(this);
        uvpa.setFragments(vpUserList);
        vpUser.setAdapter(uvpa);


        new TabLayoutMediator(tlUser, vpUser, this).attach();
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(tlUserList.get(position));
    }
}
