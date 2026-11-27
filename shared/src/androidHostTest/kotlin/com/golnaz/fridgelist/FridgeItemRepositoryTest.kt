package com.golnaz.fridgelist

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.golnaz.fridgelist.data.FridgeItemRepository
import com.golnaz.fridgelist.db.ThymeDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class FridgeItemRepositoryTest {

    private lateinit var repository: FridgeItemRepository

    @BeforeTest
    fun setup() {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        ThymeDatabase.Schema.create(driver)
        repository = FridgeItemRepository(ThymeDatabase(driver))
    }

    @Test
    fun `insert then selectAll returns the item`() = runTest {
        repository.insert(
            name = "Milch",
            quantityValue = 1.0,
            quantityUnit = "L",
            expiryDate = "2026-12-01",
            calories = 64.0,
            protein = 3.3,
            carbs = 4.8,
            fat = 3.5,
            barcode = null
        )

        val items = repository.selectAll().first()
        assertEquals(1, items.size)
        assertEquals("Milch", items[0].name)
        assertEquals("2026-12-01", items[0].expiryDate)
    }

    @Test
    fun `selectById returns correct item`() = runTest {
        repository.insert("Butter", 250.0, "g", null, null, null, null, null, null)
        repository.insert("Käse", 200.0, "g", "2026-11-30", null, null, null, null, null)

        val items = repository.selectAll().first()
        val cheese = items.first { it.name == "Käse" }
        val found = repository.selectById(cheese.id)

        assertEquals("Käse", found?.name)
        assertEquals("2026-11-30", found?.expiryDate)
    }

    @Test
    fun `update changes item fields`() = runTest {
        repository.insert("Joghurt", 1.0, "Stück", "2026-12-05", null, null, null, null, null)
        val item = repository.selectAll().first().first()

        repository.update(item.id, "Joghurt", 2.0, "Stück", "2026-12-10", 59.0, 10.0, 3.6, 0.1)

        val updated = repository.selectById(item.id)
        assertEquals(2.0, updated?.quantityValue)
        assertEquals("2026-12-10", updated?.expiryDate)
        assertEquals(59.0, updated?.calories)
    }

    @Test
    fun `delete removes the item`() = runTest {
        repository.insert("Eier", 6.0, "Stück", null, null, null, null, null, null)
        val item = repository.selectAll().first().first()

        repository.delete(item.id)

        val items = repository.selectAll().first()
        assertTrue(items.isEmpty())
    }

    @Test
    fun `selectAll orders items with expiry date before null`() = runTest {
        repository.insert("Ohne Datum", 1.0, "Stück", null, null, null, null, null, null)
        repository.insert("Früh ablaufend", 1.0, "Stück", "2026-11-28", null, null, null, null, null)
        repository.insert("Spät ablaufend", 1.0, "Stück", "2026-12-31", null, null, null, null, null)

        val items = repository.selectAll().first()
        assertEquals("Früh ablaufend", items[0].name)
        assertEquals("Spät ablaufend", items[1].name)
        assertEquals("Ohne Datum", items[2].name)
    }

    @Test
    fun `selectById returns null for unknown id`() = runTest {
        assertNull(repository.selectById(999L))
    }
}