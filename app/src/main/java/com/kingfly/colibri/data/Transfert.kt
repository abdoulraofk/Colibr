package com.kingfly.colibri.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transfert(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "montant") val montant: Float?,
    @ColumnInfo(name = "message") val message: String?
)