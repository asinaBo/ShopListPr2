package com.example.shoplistpr2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoplistpr2.entities.LibraryItem
import com.example.shoplistpr2.entities.NoteItem
import com.example.shoplistpr2.entities.ShoppingListItem
import com.example.shoplistpr2.entities.ShoppingListNames


@Database (entities = [LibraryItem::class,NoteItem::class,ShoppingListItem::class,ShoppingListNames::class], version = 1)
abstract class MainDataBase: RoomDatabase() {

    abstract fun getDao(): Dao
    companion object {

        @Volatile //
        private var INSTANCE : MainDataBase? = null //instansia nashego data base

        fun getDataBase (context: Context): MainDataBase{
             return INSTANCE ?: synchronized(this){       //blokiruet esli uje potok ispolziet. drugih blokiruet
               val instance = Room.databaseBuilder(
                   context.applicationContext,
               MainDataBase::class.java,
               "shopping_list.db"
               ).build()
                 instance
             }
        }
    }

}