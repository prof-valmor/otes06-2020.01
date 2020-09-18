package br.edu.oprofvalmor.contatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import br.edu.oprofvalmor.cliente2.modelo.ListaUsuarios;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        //
        //
        ListaUsuarios.getListaDeUsuarios().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
            }
        });
    }

//    public void onBackPressed() {
//        if (viewPager.getCurrentItem() == 0) {
//            super.onBackPressed();
//        } else {
//            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
//        }
//    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        Login fragLogin = new Login();
        Contatos contatos = new Contatos();

        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
            //
            ListaUsuarios.getListaDeUsuarios().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable sender, int propertyId) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(1);
                        }
                    };
                    runOnUiThread(r);

                }
            });
        }

        @Override
        public Fragment createFragment(int position) {
            if(position == 0) {
                return fragLogin;
            }
            if(position == 1) {
                return contatos;
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}