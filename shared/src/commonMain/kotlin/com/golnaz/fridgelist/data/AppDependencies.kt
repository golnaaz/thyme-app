package com.golnaz.fridgelist.data

import com.golnaz.fridgelist.db.ThymeDatabase

object AppDependencies {
    private var _repository: FridgeItemRepository? = null

    val repository: FridgeItemRepository
        get() = _repository ?: error("AppDependencies not initialized. Call initialize() first.")

    fun initialize(driverFactory: DatabaseDriverFactory) {
        if (_repository == null) {
            _repository = FridgeItemRepository(ThymeDatabase(driverFactory.createDriver()))
        }
    }
}