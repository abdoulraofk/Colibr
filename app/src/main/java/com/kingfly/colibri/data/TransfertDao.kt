package com.kingfly.colibri.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Dao
interface TransfertDao {
    @Query("SELECT * FROM Transfert")
    fun getAll(): List<Transfert>

    @Query("SELECT * FROM Transfert WHERE uid IN (:transfertIds)")
    fun loadAllByIds(transfertIds: IntArray): List<Transfert>

    @Insert
    fun insertAll(vararg transferts: Transfert)

    @Delete
    fun delete(transfert: Transfert)
}

@Database(entities = [Transfert::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transfertDao(): TransfertDao
}