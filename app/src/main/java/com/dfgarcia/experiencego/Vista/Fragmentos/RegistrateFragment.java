package com.dfgarcia.experiencego.Vista.Fragmentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.Vista.HomeActivity;
import com.dfgarcia.experiencego.Vista.webExperienceGo;
import com.dfgarcia.experiencego.databinding.FragmentRegistrateBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrateFragment extends Fragment {

    private FragmentRegistrateBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrateFragment newInstance(String param1, String param2) {
        RegistrateFragment fragment = new RegistrateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegistrateBinding.inflate(inflater,container,false);



        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Este fragmento va a esa clase
//                Intent intent = new Intent(getContext(), webExperienceGo.class);
//                startActivity(intent);

                if (binding.checkAceptar.isChecked() == true) {
                    //menuHome
                    Navigation.findNavController(view).navigate(R.id.action_registrateFragment_to_homeActivity);

                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            //activity
                            Navigation.findNavController(view).navigate(R.id.action_registrateFragment_to_webExperienceGo2);
                            //fragmet
                            // Navigation.findNavController(view).navigate(R.id.action_registrateFragment_to_webExpericenGoFragment);
                        }
                    });
                }else if(binding.checkAceptar.isChecked()==false){
                // Navigation.findNavController(view).navigate(R.id.action_registrateFragment_to_homeActivity);
                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
            }
            }
        });
    }
}