package com.safety.aiassistant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checklist_items")
data class ChecklistItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val status: String = "PENDING", // PENDING, DONE
    val createdDate: Long = System.currentTimeMillis()
)
