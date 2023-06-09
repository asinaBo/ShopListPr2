package com.example.shoplistpr2.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity (tableName = "shop_list")

data class ShoppingListNames(
    @PrimaryKey (autoGenerate = true)
    val id : Int?,
    @ColumnInfo (name = "name")
    val name : String,
    @ColumnInfo (name="time")
    val time : String,
    @ColumnInfo (name = "allItemCounter")
    val allItemCounter : Int,
    @ColumnInfo (name = "checkedItemCounter")
    val checkedItemCounter : Int,
    @ColumnInfo (name = "itemsIds")
    val itemsIds : Int

) : Serializable
