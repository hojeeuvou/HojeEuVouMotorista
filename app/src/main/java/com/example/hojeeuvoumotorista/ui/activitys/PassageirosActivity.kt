package com.example.hojeeuvoumotorista.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hojeeuvoumotorista.databinding.ActivityPassageirosBinding
import com.example.hojeeuvoumotorista.model.ItemListaPassageiro
import com.example.hojeeuvoumotorista.ui.adapter.AdapterListaPassageiro
import com.example.hojeeuvoumotorista.ui.viewmodel.PassageirosViewModel

class PassageirosActivity : AppCompatActivity() {

    private lateinit var viewModel: PassageirosViewModel
    private lateinit var binding: ActivityPassageirosBinding
    private lateinit var adapter: AdapterListaPassageiro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPassageirosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(PassageirosViewModel::class.java)
        setupContentView()

        binding.ivVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupContentView() {
        setupRecyclerViewPassageiros()
        viewModel.atualizarListaPassageiros(criaLista())
    }

    private fun criaLista(): List<ItemListaPassageiro> {
        return listOf(
            ItemListaPassageiro("Victor Pacheco", "18:00", "Hoje eu vou", "Rua Benedito Antônio de Campos, 479"),
            ItemListaPassageiro("Manuela Mathias", "09:00", "Hoje não vou", "Rua Jardim das Américas, 145"),
            ItemListaPassageiro("Ryan Tonto", "18:00", "18", "Rua Tietê, 31"),
            ItemListaPassageiro("Lucas Pacheco", "18:00", "18", "Rua Tietê, 31"),
            ItemListaPassageiro("Ryan Tonto", "18:00", "18", "Rua Tietê, 31")
        )
    }

    private fun setupRecyclerViewPassageiros() {
        adapter = AdapterListaPassageiro()
        binding.recyclerPassageiros.layoutManager = LinearLayoutManager(this)
        binding.recyclerPassageiros.adapter = adapter

        viewModel.listaPassageiros.observe(this) { listaPassageiros ->
            adapter.setData(listaPassageiros)
        }
    }
}