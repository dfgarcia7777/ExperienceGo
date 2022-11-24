package com.dfgarcia.experiencego.Vista.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dfgarcia.experiencego.R;
import com.dfgarcia.experiencego.Vista.Interfaces.BackKeyPresseListener;
import com.dfgarcia.experiencego.databinding.FragmentWebExpericenGoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link webExpericenGoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class webExpericenGoFragment extends Fragment implements BackKeyPresseListener {

    private FragmentWebExpericenGoBinding binding;
    private WebView myWebView ;
    private WebSettings myWebSettings;
    private BackKeyPresseListener backKeyPresseListener;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public webExpericenGoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment webExpericenGoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static webExpericenGoFragment newInstance(String param1, String param2) {
        webExpericenGoFragment fragment = new webExpericenGoFragment();
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
    public void onPause() {
        backKeyPresseListener = null;
        super.onPause();
    }

    @Override
    public void onResume() {

        super.onResume();
         backKeyPresseListener = this;
    }
    @Override
    public void onBackPressed() {
        //this method will be executed when someone trigger the listener
        if(myWebView.canGoBack()){
          myWebView.goBack();
        }else{

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWebExpericenGoBinding.inflate(inflater,container,false);

        myWebView = binding.getRoot().findViewById(R.id.webViewExpericenGo);
        myWebSettings = myWebView.getSettings();
        myWebSettings.setJavaScriptEnabled(true);
        myWebSettings.setDomStorageEnabled(true);
        String url ="http://travorium.com/931511";
        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new WebViewClient());

        return binding.getRoot();
    }

}