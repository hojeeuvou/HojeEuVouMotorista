package com.example.hojeeuvoumotorista.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hojeeuvoumotorista.R
import com.example.hojeeuvoumotorista.databinding.AdapterListaHomeBinding
import com.example.hojeeuvoumotorista.databinding.AdapterListaPassageirosBinding
import com.example.hojeeuvoumotorista.model.ItemListaHome
import com.example.hojeeuvoumotorista.model.ItemListaPassageiro
import com.example.hojeeuvoumotorista.ui.activitys.MainActivity
import com.example.hojeeuvoumotorista.ui.activitys.PassageirosActivity

class AdapterListaPassageiro : RecyclerView.Adapter<AdapterListaPassageiro.ListaVansViewHolder>() {

    private var listaVans = emptyList<ItemListaPassageiro>()

    inner class ListaVansViewHolder(private val binding: AdapterListaPassageirosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemListaPassageiro) {
            binding.tvHora.text = item.horario
            binding.tvNomePassageiro.text = item.nome
            binding.tvEndereco.text = item.endereco

            if (item.status == "Hoje eu vou" || item.status == "Hoje só vou" || item.status == "Hoje só volto"){
                binding.ivStatusPassageiro.setImageResource(R.drawable.ic_confirmado)
            } else if (item.status == "Hoje não vou"){
                binding.ivStatusPassageiro.setImageResource(R.drawable.ic_ausente)
            } else {
                binding.ivStatusPassageiro.setImageResource(R.drawable.ic_pendente)
            }


            itemView.setOnClickListener { view ->
                val intent = Intent(view.context, PassageirosActivity::class.java)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaVansViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterListaPassageirosBinding.inflate(inflater, parent, false)
        return ListaVansViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaVansViewHolder, position: Int) {
        holder.bind(listaVans[position])
    }

    override fun getItemCount(): Int {
        return listaVans.size
    }

    fun setData(data: List<ItemListaPassageiro>) {
        listaVans = data
        notifyDataSetChanged()
    }

}
