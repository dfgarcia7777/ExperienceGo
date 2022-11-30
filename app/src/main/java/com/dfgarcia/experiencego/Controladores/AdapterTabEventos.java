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

public class AdapterTabEventos  extends RecyclerView.Adapter<AdapterTabEventos.ViewHolderTabEventos>{
//Vista que tengo dentro del fragmento cesta
public static class ViewHolderTabEventos extends RecyclerView.ViewHolder{

    private ImageView imagen;
    private TextView textViewImagen;

    public ViewHolderTabEventos(@NonNull View itemView) {
        super(itemView);
        //declaro la imagen
        imagen = itemView.findViewById(R.id.mi_item);
        textViewImagen = itemView.findViewById(R.id.TextViewImagen);
    }
}

    public List<Eventos> listaEventos;

    public AdapterTabEventos(List<Eventos> listaEventos) {
        this.listaEventos = listaEventos;
    }

    @NonNull
    @Override
    public ViewHolderTabEventos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate item cesta que es donde esta nuestra vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagen, parent, false);
        ViewHolderTabEventos viewHolder = new ViewHolderTabEventos(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTabEventos holder, int position) {
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