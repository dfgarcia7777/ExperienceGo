package com.dfgarcia.experiencego.Vista.Fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.Vista.HomeActivity;
import com.dfgarcia.experiencego.Vista.MainActivity;
import com.dfgarcia.experiencego.databinding.FragmentLoginBinding;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {


    private FragmentLoginBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.btnIrIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    validarUsuario();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        binding.btnIrRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_registrateFragment);
            }
        });

        return binding.getRoot();
    }

    public void validarUsuario() throws MalformedURLException {

        RequestQueue requestQueue;
        // Instantiate the cache
        Cache cache = new DiskBasedCache(getActivity().getCacheDir(), 1024 * 1024); // 1MB cap
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
        // Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);
        // Start the queue
        requestQueue.start();
        System.out.println("entra");
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());
        //LocalHost donde esta guardado el archivo
        String url = "http://192.168.1.138/snntech/validar_usuario.php";
        URL direccionUrl = new URL(url);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                boolean resultado;
                    @Override
                    public void onResponse(String response) {
                        if (!response.isEmpty()) {
                            System.out.println("entra22");
                            Toast.makeText(getActivity(), "Login", Toast.LENGTH_LONG).show();
                            // System.out.println("navegate");
                            //System.out.println(response);

                            Intent intent = new Intent(getContext(), HomeActivity.class);
                            startActivity(intent);

                        } else {
                            System.out.println("error");
                            Toast.makeText(getActivity(), "El correo o la contraseña es incorrecta", Toast.LENGTH_LONG).show();
                            resultado= false;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error3333");
                Toast.makeText(getActivity(), "fallo en la conexion", Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //System.out.println("parametros");
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("email", binding.etEmail.getText().toString());
                parametros.put("password", binding.etPassword.getText().toString());
                //parametros.put("email","dani@gmail.com");
                //parametros.put("email","kjk");
                return parametros;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}