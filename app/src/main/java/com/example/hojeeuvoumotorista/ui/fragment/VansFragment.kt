package com.example.hojeeuvoumotorista.ui.fragment

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hojeeuvoumotorista.R
import com.example.hojeeuvoumotorista.databinding.FragmentVansBinding
import com.example.hojeeuvoumotorista.model.ItemListaHome
import com.example.hojeeuvoumotorista.ui.adapter.AdapterListaHome
import com.example.hojeeuvoumotorista.ui.viewmodel.VansViewModel

class VansFragment : Fragment() {

    private lateinit var viewModel: VansViewModel
    private lateinit var binding: FragmentVansBinding
    private lateinit var adapter: AdapterListaHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVansBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(VansViewModel::class.java)
        setupContentView()

        viewModel.atualizarListaPassageiros(criaLista())
    }

    private fun setupContentView(){
        setupRecyclerViewPassageiros()
    }

    private fun criaLista(): List<ItemListaHome> {
        val novaListaHome = listOf(
            ItemListaHome("Van Uniso - Noturno", "18:00", "19", "12 aguardando"),
            ItemListaHome("Van Uniso - Matutino", "09:00", "16", "15 aguardando"),
            ItemListaHome("Van Facens - Noturno", "18:00", "18", "17 aguardando"),
        )
        return novaListaHome
    }

    private fun setupRecyclerViewPassageiros(){
        // Configurar RecyclerView e Adapter
        adapter = AdapterListaHome()
        binding.recyclerVans.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerVans.adapter = adapter

        // Observar os dados do ViewModel e atualizar o Adapter quando necessário
        viewModel.listaPassageiros.observe(viewLifecycleOwner) { listaPassageiros ->
            adapter.setData(listaPassageiros)
        }

    }
}