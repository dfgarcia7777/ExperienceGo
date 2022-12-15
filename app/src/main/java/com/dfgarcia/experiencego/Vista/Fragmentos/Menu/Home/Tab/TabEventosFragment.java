package com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dfgarcia.experiencego.Model.Eventos;
import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.Controladores.AdapterHome;
import com.dfgarcia.experiencego.Controladores.AdapterTabEventos;
import com.dfgarcia.experiencego.databinding.FragmentTabEventosBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabEventosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabEventosFragment extends Fragment {

    private FragmentTabEventosBinding binding;
    private AdapterTabEventos adapterTabEventos;
    private RecyclerView recyclerViewTabEventos;
    private List<Eventos> listaEventos;
    private ArrayList<String> titles;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabEventosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabEventosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabEventosFragment newInstance(String param1, String param2) {
        TabEventosFragment fragment = new TabEventosFragment();
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
        binding = FragmentTabEventosBinding.inflate(inflater,container,false);



        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //primer ReciclerView
        initEventos();
        initRecycler();
        //Segundo ReciclerView
        initEnlaces();
        initRecycler();
        //tercero ReciclerView
        initArticulos();
        initRecycler();
    }
    private void initEventos(){
        recyclerViewTabEventos = binding.recyclerViewEnlaces;
    }

    private void initEnlaces(){
        recyclerViewTabEventos = binding.recyclerViewEventos;
    }
    private void initArticulos(){
        recyclerViewTabEventos = binding.recyclerViewArticulos;
    }
    private void initRecycler(){
        //vertical
        //recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        //Horizontal
        recyclerViewTabEventos.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        releadRecycler();
    }
    private void releadRecycler(){
        AdapterHome adapterCategorias = new AdapterHome(leerCategorias());
        recyclerViewTabEventos.setAdapter(adapterCategorias);
    }
    private ArrayList<Eventos> leerCategorias(){

        ArrayList<Eventos> listaEventos = new ArrayList<>();

        listaEventos.add(new Eventos(R.drawable._8octubre,"Promocion de tus productos"));
        listaEventos.add(new Eventos(R.drawable._deagosto,"Desayuno circulo de mujeres"));
        listaEventos.add(new Eventos(R.drawable._8octubre,"Promocion de tus productos"));
        listaEventos.add(new Eventos(R.drawable._deagosto,"Desayuno circulo de mujeres"));
        listaEventos.add(new Eventos(R.drawable._8octubre,"Promocion de tus productos"));
        listaEventos.add(new Eventos(R.drawable._deagosto,"Desayuno circulo de mujeres"));
        listaEventos.add(new Eventos(R.drawable._8octubre,"Promocion de tus productos"));
        listaEventos.add(new Eventos(R.drawable._deagosto,"Desayuno circulo de mujeres"));
        listaEventos.add(new Eventos(R.drawable._8octubre,"Promocion de tus productos"));
        listaEventos.add(new Eventos(R.drawable._deagosto,"Desayuno circulo de mujeres"));
        System.out.println(listaEventos);
        return listaEventos;
    }

}