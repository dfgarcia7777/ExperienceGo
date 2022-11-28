package com.dfgarcia.experiencego.Vista.Fragmentos.Menu;

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
import com.dfgarcia.experiencego.Model.Eventos;
import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AdapterHome adapterHome;
    private RecyclerView recyclerViewHome;
    private List<Eventos> listaEventos;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        //View vista  = inflater.inflate(R.layout.fragment_home,container,false);

        //PRIMER RECICLERvIEW
//        listaEventos = new ArrayList<>();
//        recyclerViewHome = binding.reciclerViewEventos;
       // recyclerViewHome = (RecyclerView) vista.findViewById(R.id.reciclerViewEventos);
//        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
//        listaEventos = new ArrayList<>();
//        adapterHome = new AdapterHome(leerCategorias());
//        recyclerViewHome.setAdapter(adapterHome);

       return binding.getRoot();
        //return vista;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //primer ReciclerView
        initEventos();
        initRecycler();
        //Segundo ReciclerView
        initPrivilegios();
        initRecycler();
        //tercero ReciclerView
        initArticulos();
        initRecycler();
    }
    private void initEventos(){
        recyclerViewHome = binding.recyclerViewPrivilegios;
    }

    private void initPrivilegios(){
        recyclerViewHome = binding.recyclerViewEventos;
    }
    private void initArticulos(){
        recyclerViewHome = binding.recyclerViewArticulos;
    }
    private void initRecycler(){
        //vertical
        //recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        //Horizontal
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        releadRecycler();
    }
    private void releadRecycler(){
        AdapterHome adapterCategorias = new AdapterHome(leerCategorias());
        recyclerViewHome.setAdapter(adapterCategorias);
    }
    private ArrayList<Eventos> leerCategorias(){

        ArrayList<Eventos> listaEventos = new ArrayList<>();

        listaEventos.add(new Eventos(R.drawable.ic_baseline_home_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_featured_video_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_featured_video_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_featured_video_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_featured_video_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_featured_video_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_newspaper_24));
        listaEventos.add(new Eventos(R.drawable.ic_baseline_featured_video_24));
        System.out.println(listaEventos);
        return listaEventos;
    }

}