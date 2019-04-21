package com.example.fragmetss;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragments.FristFragments;
import fragments.SecondFragments;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFragment;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnFragment = findViewById(R.id.btnLoad);
         btnFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (status){
            FristFragments firstFragment = new FristFragments();
            fragmentTransaction.add(R.id.fragmentContainer,firstFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnFragment.setText("Load Second Fragment");
            status = false;


        } else {

            SecondFragments secondFragments = new SecondFragments();
            fragmentTransaction.add(R.id.fragmentContainer,secondFragments);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnFragment.setText("load First Fragment");
            status = true;
        }

    }
}
