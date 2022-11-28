package com.dfgarcia.experiencego.Controladores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dfgarcia.experiencego.Model.Eventos;
import com.dfgarcia.experiencego.R;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolderHome>{

    //Vista que tengo dentro del fragmento cesta
    public static class ViewHolderHome extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView textViewImagen;
        TextView textoImagen;

        public ViewHolderHome(@NonNull View itemView) {
            super(itemView);
            //declaro la imagen
            imagen = itemView.findViewById(R.id.mi_item);
            textViewImagen = itemView.findViewById(R.id.TextViewImagen);
        }
    }

    public List<Eventos> listaEventos;

    public AdapterHome(List<Eventos> listaEventos) {
        this.listaEventos = listaEventos;
    }

    @NonNull
    @Override
    public ViewHolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate item cesta que es donde esta nuestra vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagen, parent, false);
        ViewHolderHome viewHolder = new ViewHolderHome(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHome holder, int position) {
        //poisicon de la imagen
        // holder.imagen.setImageResource(listaCategorias.get(position).getImagen());
        holder.imagen.setImageResource(listaEventos.get(position).getImagen());
        holder.textViewImagen.setText(listaEventos.get(position).getTextoImagen());

    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }//retorna el tamaño de mi lista


}