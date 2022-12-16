package com.dfgarcia.experiencego.Controladores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dfgarcia.experiencego.Model.Eventos;
import com.dfgarcia.experiencego.Model.MisRecuerdos;
import com.dfgarcia.experiencego.R;

import java.util.List;

public class AdapterRecyclerMisRecuerdos extends RecyclerView.Adapter<AdapterRecyclerMisRecuerdos.ViewHolderMisRecuerdos>{
    //Vista que tengo dentro del fragmento cesta
    public static class ViewHolderMisRecuerdos extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView tituloImagen;
        private TextView fechaMisExperiencias;
        public ViewHolderMisRecuerdos(@NonNull View itemView) {
            super(itemView);
            //declaro la imagen
            imagen = itemView.findViewById(R.id.imageViewMisRecuerdos);
            tituloImagen = itemView.findViewById(R.id.textViewtituloMisExperiencias);
            fechaMisExperiencias = itemView.findViewById(R.id.textViewFechaMisRecuerdos);
        }
    }

    public List<MisRecuerdos> listaMisRecuerdos;

    public AdapterRecyclerMisRecuerdos(List<MisRecuerdos> listaMisRecuerdos) {
        this.listaMisRecuerdos = listaMisRecuerdos;
    }

    @NonNull
    @Override
    public AdapterRecyclerMisRecuerdos.ViewHolderMisRecuerdos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate item cesta que es donde esta nuestra vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mis_recuerdos, parent, false);
        AdapterRecyclerMisRecuerdos.ViewHolderMisRecuerdos viewHolder = new AdapterRecyclerMisRecuerdos.ViewHolderMisRecuerdos(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerMisRecuerdos.ViewHolderMisRecuerdos holder, int position) {
        //poisicon de la imagen
        // holder.imagen.setImageResource(listaCategorias.get(position).getImagen());
        holder.imagen.setImageResource(listaMisRecuerdos.get(position).getImagen());
        holder.tituloImagen.setText(listaMisRecuerdos.get(position).getTitulo());
        holder.fechaMisExperiencias.setText(listaMisRecuerdos.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return listaMisRecuerdos.size();
    }//retorna el tamaño de mi lista


}