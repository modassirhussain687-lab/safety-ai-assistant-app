package com.safety.aiassistant.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.safety.aiassistant.data.dao.ChecklistDao
import com.safety.aiassistant.data.entity.ChecklistItem

@Database(
    entities = [ChecklistItem::class],
    version = 1,
    exportSchema = false
)
abstract class SafetyDatabase : RoomDatabase() {
    
    abstract fun checklistDao(): ChecklistDao
    
    companion object {
        @Volatile
        private var INSTANCE: SafetyDatabase? = null
        
        fun getDatabase(context: Context): SafetyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SafetyDatabase::class.java,
                    "safety_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
