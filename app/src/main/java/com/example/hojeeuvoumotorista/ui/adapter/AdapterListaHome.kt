package com.example.hojeeuvoumotorista.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hojeeuvoumotorista.databinding.AdapterListaHomeBinding
import com.example.hojeeuvoumotorista.model.ItemListaHome
import com.example.hojeeuvoumotorista.ui.activitys.MainActivity
import com.example.hojeeuvoumotorista.ui.activitys.PassageirosActivity

class AdapterListaHome : RecyclerView.Adapter<AdapterListaHome.ListaVansViewHolder>() {

    private var listaVans = emptyList<ItemListaHome>()

    inner class ListaVansViewHolder(private val binding: AdapterListaHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemListaHome) {
            binding.tvNomeVan.text = item.nome
            binding.tvHora.text = item.horario
            binding.tvQuantidadePassageiro.text = item.passageirosTotal
            binding.tvPassageirosAguardando.text = item.passageirosAguardando

            itemView.setOnClickListener { view ->
                val intent = Intent(view.context, PassageirosActivity::class.java)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaVansViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterListaHomeBinding.inflate(inflater, parent, false)
        return ListaVansViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaVansViewHolder, position: Int) {
        holder.bind(listaVans[position])
    }

    override fun getItemCount(): Int {
        return listaVans.size
    }

    fun setData(data: List<ItemListaHome>) {
        listaVans = data
        notifyDataSetChanged()
    }

}
