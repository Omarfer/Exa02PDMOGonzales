package com.omarfer.exa02_pdm_ogonzales;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.AccountFragment;
import com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.BottomNavigationViewHelper;
import com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.CarritoFragment;
import com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment;
import com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.RegistroFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Main Fragment"); //this will set title of Action Bar
                    MainFragment fragment1 = new MainFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fram, fragment1, "Main Fragment");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_carrito:
                    setTitle("Carrito Fragment");
                    CarritoFragment fragment2 = new CarritoFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fram, fragment2, "Carrito Fragment");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Registro Fragment"); //this will set title of Action Bar
                    RegistroFragment fragment3 = new RegistroFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fram, fragment3, "Registro Fragment");
                    fragmentTransaction3.commit();
                    return true;
                case R.id.navigation_account:
                    setTitle("Account Fragment");
                    AccountFragment fragment4 = new AccountFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.fram, fragment4, "Account Fragment");
                    fragmentTransaction4.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Main Fragment");
        com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment fragment1 = new com.omarfer.exa02_pdm_ogonzales.ButtonsFragments.MainFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fram, fragment1, "Main Fragment");  //create first framelayout with id fram in the activity where fragments will be displayed
        fragmentTransaction1.commit();
    }

    private void goLoginScreen(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void logout(View v) {
        FirebaseAuth.getInstance().signOut();
        goLoginScreen();
    }

}
