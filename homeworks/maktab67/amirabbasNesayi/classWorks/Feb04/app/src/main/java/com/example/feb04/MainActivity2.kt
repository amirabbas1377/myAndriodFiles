package com.example.feb04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv2.text = intent.getStringExtra("text")
        button2.setOnClickListener {
            var i = Intent()
            i.putExtra("key", "this is ok")
            setResult(RESULT_OK, i)
            finish()
        }
    }
}