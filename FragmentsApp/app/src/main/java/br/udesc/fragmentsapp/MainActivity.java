package br.udesc.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame1, new TextFragment());
        ft.commit();
        //
        SeekBar seekBar = findViewById(R.id.seek1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.d(TAG, "onProgressChanged: " + progress + " bool: " + b);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment selectedFragment = new TextFragment();
                //
                switch(progress) {
//                    default:
//                    case 0:
//                        //
//                        break;
                    case 1:
                        selectedFragment = new Fragment2();
                        break;
                    case 2:
                        selectedFragment = new Fragment3();
                        break;
                }
                //
                ft.replace(R.id.frame1, selectedFragment);
                ft.commit();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}