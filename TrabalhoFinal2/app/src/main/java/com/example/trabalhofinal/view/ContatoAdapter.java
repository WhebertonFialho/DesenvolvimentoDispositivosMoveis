package com.example.trabalhofinal.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import  java.util.List;

import com.example.trabalhofinal.R;
import com.example.trabalhofinal.model.Contato;
public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder> {
    private Context context;
    private List<Contato> contatos;
    public ContatoAdapter(Context context, List<Contato> contatos){
        this.context = context;
        this.contatos = contatos;
    }
    @NonNull
    @Override
    public ContatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_contato, parent, false);
        return new ContatoViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ContatoViewHolder holder,int position) {
        holder.card_id.setText("Nº Identificação: " + contatos.get(position).getId());
        holder.card_emal.setText("E-mail: " + contatos.get(position).getEmail());
        holder.card_nome.setText("Nome: " + contatos.get(position).getNome());
    }
    @Override
    public int getItemCount() {
        return contatos.size();
    }
    public class ContatoViewHolder extends RecyclerView.ViewHolder{TextView card_nome, card_emal, card_id;
        public ContatoViewHolder(@NonNull View itemView) {
            super(itemView);
            card_id = itemView.findViewById(R.id.card_id);
            card_nome = itemView.findViewById(R.id.card_nome);
            card_emal = itemView.findViewById(R.id.card_email);
        }
    }

}
