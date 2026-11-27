package com.golnaz.fridgelist.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.golnaz.fridgelist.db.FridgeItem
import com.golnaz.fridgelist.db.ThymeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FridgeItemRepository(database: ThymeDatabase) {
    private val queries = database.fridgeItemQueries

    fun selectAll(): Flow<List<FridgeItem>> =
        queries.selectAll().asFlow().mapToList(Dispatchers.Default)

    fun selectById(id: Long): FridgeItem? =
        queries.selectById(id).executeAsOneOrNull()

    suspend fun insert(
        name: String,
        quantityValue: Double,
        quantityUnit: String,
        expiryDate: String?,
        calories: Double?,
        protein: Double?,
        carbs: Double?,
        fat: Double?,
        barcode: String?
    ) = withContext(Dispatchers.Default) {
        queries.insert(name, quantityValue, quantityUnit, expiryDate, calories, protein, carbs, fat, barcode)
    }

    suspend fun update(
        id: Long,
        name: String,
        quantityValue: Double,
        quantityUnit: String,
        expiryDate: String?,
        calories: Double?,
        protein: Double?,
        carbs: Double?,
        fat: Double?
    ) = withContext(Dispatchers.Default) {
        queries.update(name, quantityValue, quantityUnit, expiryDate, calories, protein, carbs, fat, id)
    }

    suspend fun delete(id: Long) = withContext(Dispatchers.Default) {
        queries.delete(id)
    }
}