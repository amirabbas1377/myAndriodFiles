package com.example.feb04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var launcher:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register()
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("text", edit.text.toString())
            launcher.launch(intent)
        }

    }

    private fun register(){
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            tv1.text = it.data?.getStringExtra("key")
            Toast.makeText(this, it.data?.getStringExtra("key"),Toast.LENGTH_LONG).show()
        }
    }
}