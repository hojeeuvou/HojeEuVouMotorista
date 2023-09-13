package com.example.hojeeuvoumotorista.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hojeeuvoumotorista.model.ItemListaHome
import com.example.hojeeuvoumotorista.model.ItemListaPassageiro

class PassageirosViewModel : ViewModel() {

    // Declare uma variável LiveData para os dados que você deseja exibir no RecyclerView
    private val _listaPassageiros = MutableLiveData<List<ItemListaPassageiro>>()

    // Exponha a variável LiveData como somente leitura para o fragmento
    val listaPassageiros: LiveData<List<ItemListaPassageiro>> = _listaPassageiros

    // Método para atualizar os dados da lista quando necessário
    fun atualizarListaPassageiros(novaLista: List<ItemListaPassageiro>) {
        _listaPassageiros.value = novaLista
    }
}