package com.golnaz.fridgelist.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.golnaz.fridgelist.db.FridgeItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FridgeItemViewModel : ViewModel() {

    private val repository = AppDependencies.repository

    val fridgeItems: StateFlow<List<FridgeItem>> = repository.selectAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun insert(
        name: String,
        quantityValue: Double = 1.0,
        quantityUnit: String = "Stück",
        expiryDate: String? = null,
        calories: Double? = null,
        protein: Double? = null,
        carbs: Double? = null,
        fat: Double? = null,
        barcode: String? = null
    ) = viewModelScope.launch {
        repository.insert(name, quantityValue, quantityUnit, expiryDate, calories, protein, carbs, fat, barcode)
    }

    fun update(
        id: Long,
        name: String,
        quantityValue: Double,
        quantityUnit: String,
        expiryDate: String?,
        calories: Double?,
        protein: Double?,
        carbs: Double?,
        fat: Double?
    ) = viewModelScope.launch {
        repository.update(id, name, quantityValue, quantityUnit, expiryDate, calories, protein, carbs, fat)
    }

    fun delete(id: Long) = viewModelScope.launch {
        repository.delete(id)
    }
}