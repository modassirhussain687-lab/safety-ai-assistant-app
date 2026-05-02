package com.safety.aiassistant.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.safety.aiassistant.data.entity.ChecklistItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ChecklistDao {
    
    @Insert
    suspend fun insertChecklistItem(item: ChecklistItem)
    
    @Update
    suspend fun updateChecklistItem(item: ChecklistItem)
    
    @Delete
    suspend fun deleteChecklistItem(item: ChecklistItem)
    
    @Query("SELECT * FROM checklist_items ORDER BY createdDate DESC")
    fun getAllChecklistItems(): Flow<List<ChecklistItem>>
    
    @Query("SELECT * FROM checklist_items WHERE id = :id")
    suspend fun getChecklistItemById(id: Int): ChecklistItem?
    
    @Query("DELETE FROM checklist_items WHERE id = :id")
    suspend fun deleteChecklistItemById(id: Int)
    
    @Query("UPDATE checklist_items SET status = :status WHERE id = :id")
    suspend fun updateChecklistItemStatus(id: Int, status: String)
}
