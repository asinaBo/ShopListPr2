package com.example.shoplistpr2.db

import androidx.lifecycle.*
import androidx.room.Database
import com.example.shoplistpr2.entities.NoteItem
import kotlinx.coroutines.launch

class MainViewModel(database: MainDataBase) : ViewModel() {
    val dao = database.getDao()
    val allNotes: LiveData<List<NoteItem>> = dao.getAllNotes().asLiveData()
    fun insertNote(note: NoteItem) = viewModelScope.launch {
        dao.insertNote(note)
    }

    fun updateNote(note: NoteItem)= viewModelScope.launch {
        dao.updateNote(note)
    }
    fun deleteNote(id:Int) = viewModelScope.launch {
        dao.deleteNote(id)
    }

    class MainViewModelFactory(val database: MainDataBase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

                @Suppress("unchecked_cast")
                return MainViewModel(database) as T
            }
            throw java.lang.IllegalArgumentException("unknow viewModelClass")
        }
    }
}