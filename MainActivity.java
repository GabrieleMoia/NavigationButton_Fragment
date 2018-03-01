package com.example.giulia.navigationbutton_fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnHeadLinesFragment{

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment= new SecondFragment();
    ThirdFragment thirdFragment= new ThirdFragment();
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState==null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container,firstFragment);
            fragmentTransaction.addToBackStack(null).commit();
        }else{
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,firstFragment);
            fragmentTransaction.addToBackStack(null).commit();
        }


    }

    @Override
    public void goForward(int position) {

        switch (position){
            case 0:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,firstFragment);
                fragmentTransaction.addToBackStack("Primo").commit();
                break;
            case 1:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,secondFragment);
                fragmentTransaction.addToBackStack(null).commit();
                break;

            case 2:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,thirdFragment);
                fragmentTransaction.addToBackStack(null).commit();
                break;

            case 3:
                fragmentManager.popBackStack("Primo",0);

        }

    }

    @Override
    public void goBack() {
        fragmentManager.popBackStack();
    }

}
