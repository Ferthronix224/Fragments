package mx.com.ferthronix.fragments.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.HashMap;

import mx.com.ferthronix.fragments.R;
import mx.com.ferthronix.fragments.core.FragmentsApplication;
import mx.com.ferthronix.fragments.gui.components.NavigationHost;

public class MainActivity extends AppCompatActivity implements NavigationHost {

    public static HashMap<String, Object> GLOBALS = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        configContext();
        configGlobals();
        configFragmentManager(savedInstanceState);
    }
    private void configContext() {
        FragmentsApplication.setAppContext(getApplicationContext());
    }

    private void configGlobals() {
        GLOBALS.put("app",this);
    }

    private void configFragmentManager(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, new TopJuegos())
                    .commit();
        }
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBaskStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentPanel, fragment);
        if(addToBaskStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
}