package com.example.shoplistpr2.activities

import android.app.Application
import com.example.shoplistpr2.db.MainDataBase

class MainApp : Application() {
    val database by lazy  { MainDataBase.getDataBase(this)}

}