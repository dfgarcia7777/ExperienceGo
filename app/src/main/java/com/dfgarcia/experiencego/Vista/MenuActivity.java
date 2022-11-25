package com.dfgarcia.experiencego.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.EventosFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.HomeFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.NoticiasFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.PerfilFragment;
import com.dfgarcia.experiencego.databinding.ActivityMenuBinding;
import com.google.android.material.bottomappbar.BottomAppBar;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setBackground(null);

        binding.fabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //falta crear el fragmento
                replaceFragment(new HomeFragment());
            }
        });
        //indicas el fragmento con el que abres
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_eventos:
                    replaceFragment(new EventosFragment());
                    break;
                case R.id.navigation_noticias:
                    replaceFragment(new NoticiasFragment());
                    break;
                case R.id.navigation_perfil:
                    replaceFragment(new PerfilFragment());
                    break;
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //contenedor que va a contener a todos los fragmentos
        fragmentTransaction.replace(R.id.contendorMenu,fragment);
        fragmentTransaction.commit();

    }

}
