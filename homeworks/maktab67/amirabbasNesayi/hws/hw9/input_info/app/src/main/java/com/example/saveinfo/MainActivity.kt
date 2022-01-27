package com.example.saveinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val fragment = GetData()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment1, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}