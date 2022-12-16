package com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfgarcia.experiencego.Controladores.AdapterHome;
import com.dfgarcia.experiencego.Controladores.AdapterRecyclerMisRecuerdos;
import com.dfgarcia.experiencego.Controladores.AdapterTabEventos;
import com.dfgarcia.experiencego.Model.Eventos;
import com.dfgarcia.experiencego.Model.MisRecuerdos;
import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.databinding.FragmentMisRecuerdosBinding;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MisRecuerdosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MisRecuerdosFragment extends Fragment {

    FragmentMisRecuerdosBinding binding;
    private AdapterRecyclerMisRecuerdos adapterMisRecuerdos;
    private RecyclerView recyclerViewMisRercuerdo;
    private List<MisRecuerdos> listaMisEventos;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MisRecuerdosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MisRecuerdosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MisRecuerdosFragment newInstance(String param1, String param2) {
        MisRecuerdosFragment fragment = new MisRecuerdosFragment();
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
        binding = FragmentMisRecuerdosBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //tercero ReciclerView
        initMisRecuerdos();
        initRecycler();
    }
    private void initMisRecuerdos(){
        recyclerViewMisRercuerdo = binding.recyclerViewMisExperiencias;
    }
    private void initRecycler(){
        //vertical
        recyclerViewMisRercuerdo.setLayoutManager(new LinearLayoutManager(getContext()));
        //Horizontal
       //recyclerViewMisRercuerdo.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        releadRecycler();
    }
    private void releadRecycler(){
        AdapterRecyclerMisRecuerdos adapterCategorias = new AdapterRecyclerMisRecuerdos(leerCategorias());
        recyclerViewMisRercuerdo.setAdapter(adapterCategorias);
    }
    private ArrayList<MisRecuerdos> leerCategorias(){

        ArrayList<MisRecuerdos> listaMisRecuerdos = new ArrayList<>();

        listaMisRecuerdos.add(new MisRecuerdos("Promocion de tus productos","12/12/2022", R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Desayuno circulo de mujeres","01/11/2022",R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Promocion de tus productos","12/12/2022",R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Desayuno circulo de mujeres","01/11/2022",R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Promocion de tus productos","12/12/2022",R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Desayuno circulo de mujeres","01/11/2022",R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Promocion de tus productos","12/12/2022",R.drawable.logo_exper__1_));
        listaMisRecuerdos.add(new MisRecuerdos("Desayuno circulo de mujeres","01/11/2022",R.drawable.logo_exper__1_));
        System.out.println(listaMisRecuerdos);
        return listaMisRecuerdos;
    }
}