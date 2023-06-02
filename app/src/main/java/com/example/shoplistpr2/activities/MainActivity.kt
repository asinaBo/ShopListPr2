package com.example.shoplistpr2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shoplistpr2.R
import com.example.shoplistpr2.databinding.ActivityMainBinding
import com.example.shoplistpr2.fragments.FragmentManager
import com.example.shoplistpr2.fragments.NoteFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottonNavListener()
    }

    private fun setBottonNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("The","settings")
                }
                R.id.notes-> {
                 FragmentManager.setFragment(NoteFragment.newInstance(),this)
                }
                R.id.shop_list -> {
                    Log.d("The","list")
                }
                R.id.new_item -> {
                    FragmentManager.currentFrag?.onClickNew()
                }

            }
            true

        }

    }

}