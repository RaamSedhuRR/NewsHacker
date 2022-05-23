package com.example.newshacker.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.newshacker.R;
import com.example.newshacker.databinding.ActivityNewsHackerHomeBinding;
import com.example.newshacker.view.fragment.BestStoriesFragment;
import com.example.newshacker.view.fragment.NewStoriesFragment;
import com.example.newshacker.view.fragment.TopStoriesFragment;

import javax.inject.Inject;

public class NewsHackerHomeActivity extends AppCompatActivity {


    ActivityNewsHackerHomeBinding binding;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsHackerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new TopStoriesFragment());
        setTitle("Top Stories");


        binding.bottomNavViewNewsHackerHome.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.topStoriesFragment:
                    replaceFragment(new TopStoriesFragment());
                    setTitle("Top Stories");
                    break;
                case R.id.BestStoriesFragment:
                    replaceFragment(new BestStoriesFragment());
                    setTitle("Best Stories");
                    break;
                case R.id.NewStoriesFragment:
                    replaceFragment(new NewStoriesFragment());
                    setTitle("New Stories");
                    break;
            }
            return true;
        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.search_view,menu);


        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView =( SearchView ) menuItem.getActionView();
        searchView.setQueryHint("Type Here To Search...");
        return super.onCreateOptionsMenu(menu);
    }

    private void replaceFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.homeFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}