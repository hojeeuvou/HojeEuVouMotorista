package com.example.hojeeuvoumotorista.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hojeeuvoumotorista.model.ItemListaHome

class VansViewModel : ViewModel() {

    // Declare uma variável LiveData para os dados que você deseja exibir no RecyclerView
    private val _listaVans = MutableLiveData<List<ItemListaHome>>()

    // Exponha a variável LiveData como somente leitura para o fragmento
    val listaPassageiros: LiveData<List<ItemListaHome>> = _listaVans

    // Método para atualizar os dados da lista quando necessário
    fun atualizarListaPassageiros(novaLista: List<ItemListaHome>) {
        _listaVans.value = novaLista
    }
}