package com.omarfer.exa02_pdm_ogonzales;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Main Fragment"); //this will set title of Action Bar
                    com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment fragment1 = new com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fram, fragment1, "Main Fragment");  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("FVerduras Fragment"); //this will set title of Action Bar
                    com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.FVerdurasFragment fragment2 = new com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.FVerdurasFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fram, fragment2, "Vegetales Fragment");  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Carnes Fragment");
                    com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.CarnesFragment fragment3 = new com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.CarnesFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fram, fragment3, "Carnes Fragment");  //create first framelayout with id fram in the activity where fragments will be displayed
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Main Fragment"); //this will set title of Action Bar
        com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment fragment1 = new com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fram, fragment1, "Main Fragment");  //create first framelayout with id fram in the activity where fragments will be displayed
        fragmentTransaction1.commit();
    }

}
