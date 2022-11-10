package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)
    @Update
    suspend fun update(item: Item)
    @Delete
    suspend fun delete(item: Item)
    @Query("select * from item where id =:id") // Because the return type is Flow, Rooms runs the fn
    fun getItem(id: Int): Flow<Item>          // in background Thread by default, no need of suspend
}