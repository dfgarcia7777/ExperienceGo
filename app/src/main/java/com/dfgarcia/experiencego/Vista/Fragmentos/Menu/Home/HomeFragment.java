package com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.dfgarcia.experiencego.Controladores.AdaptadorTab;
import com.dfgarcia.experiencego.Controladores.AdapterTabEventos;
import com.dfgarcia.experiencego.Model.Eventos;
import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab.TabAgendaFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab.TabMisExperienciasFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab.TabNoticiasFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab.TabContactosFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab.TabEnlacesFragment;
import com.dfgarcia.experiencego.Vista.Fragmentos.Menu.Home.Tab.TabEventosFragment;
import com.dfgarcia.experiencego.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements TabLayoutMediator.TabConfigurationStrategy{

    private FragmentHomeBinding binding;
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

        titles = new ArrayList<>();
        titles.add(getString(R.string.tab_eventos));
        titles.add(getString(R.string.tab_mis_experiencia));
        titles.add(getString(R.string.tab_enlaces));
        titles.add(getString(R.string.tab_noticias));
        titles.add(getString(R.string.tab_contactos));
        titles.add(getString(R.string.tab_agenda));


        //titles.add(getString(R.string.tab_grupos));
        //titles.add(getString(R.string.tab_articulos));

        setViewPagerAdapter();
        new TabLayoutMediator(binding.tabLayout, binding.viewPager2, this).attach();

       return binding.getRoot();
        //return vista;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        //primer ReciclerView
//        initEventos();
//        initRecycler();
//        //Segundo ReciclerView
//        initEnlaces();
//        initRecycler();
//        //tercero ReciclerView
//        initArticulos();
//        initRecycler();
    }
//    private void initEventos(){
//        recyclerViewHome = binding.recyclerViewEnlaces;
//    }
//
//    private void initEnlaces(){
//        recyclerViewHome = binding.recyclerViewEventos;
//    }
//    private void initArticulos(){
//        recyclerViewHome = binding.recyclerViewArticulos;
//    }
//    private void initRecycler(){
//        //vertical
//        //recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
//        //Horizontal
//        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
//        releadRecycler();
//    }
//    private void releadRecycler(){
//        AdapterHome adapterCategorias = new AdapterHome(leerCategorias());
//        recyclerViewHome.setAdapter(adapterCategorias);
//    }
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
    public void setViewPagerAdapter(){

        AdaptadorTab adaptadorTab = new AdaptadorTab(requireActivity());// sustituyo this por getActivity()
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TabEventosFragment());
        fragmentList.add(new TabMisExperienciasFragment());
        fragmentList.add(new TabEnlacesFragment());
        fragmentList.add(new TabNoticiasFragment());
        fragmentList.add(new TabContactosFragment());
        fragmentList.add(new TabAgendaFragment());
        //fragmentList.add(new TabGruposFragment());
        // fragmentList.add(new TabArticulosFragment());
        adaptadorTab.setData(fragmentList);


        binding.viewPager2.setAdapter(adaptadorTab);
    }
    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}