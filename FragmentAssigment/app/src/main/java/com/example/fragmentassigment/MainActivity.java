package com.example.fragmentassigment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fragmentassigment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final List<String[]> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        backend();
    }

    public void backend() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (items.size() == 0){
            binding.fragmentContainer.setVisibility(View.GONE);
            binding.textView.setVisibility(View.VISIBLE);
        } else {
            binding.fragmentContainer.setVisibility(View.VISIBLE);
            binding.textView.setVisibility(View.GONE);
        }

        HomeFragment homeFragment = new HomeFragment();
        Fragment fragmentHome = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragmentHome instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .replace(binding.fragmentContainer.getId(), homeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }

        binding.btnHome.setOnClickListener(v -> {
            if (items.size() == 0){
                binding.fragmentContainer.setVisibility(View.GONE);
                binding.textView.setVisibility(View.VISIBLE);
            } else {
                binding.fragmentContainer.setVisibility(View.VISIBLE);
                binding.textView.setVisibility(View.GONE);
            }
            if (!(fragmentHome instanceof HomeFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(binding.fragmentContainer.getId(), homeFragment)
                        .commit();
            }
        });

        AddFragment addFragment = new AddFragment();
        Fragment fragmentAdd = fragmentManager.findFragmentByTag(AddFragment.class.getSimpleName());
        binding.btnAdd.setOnClickListener(v -> {
            binding.fragmentContainer.setVisibility(View.VISIBLE);
            binding.textView.setVisibility(View.GONE);
            if (!(fragmentAdd instanceof AddFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(binding.fragmentContainer.getId(), addFragment)
                        .commit();
            }
        });

        ProfileFragment profileFragment = new ProfileFragment();
        Fragment fragmentProfile = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
        binding.btnProfile.setOnClickListener(v -> {
            binding.fragmentContainer.setVisibility(View.VISIBLE);
            binding.textView.setVisibility(View.GONE);
            if (!(fragmentProfile instanceof ProfileFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(binding.fragmentContainer.getId(), profileFragment)
                        .commit();
            }
        });
    }

    public void addPost(Uri uriImage, String caption){
        String[] post = {String.valueOf(uriImage),caption};
        items.add(post);
    }

    public List<String[]> getItems() {
        List<String[]> itemsNewest = items;
        Collections.reverse(itemsNewest);
        return itemsNewest;
    }
}