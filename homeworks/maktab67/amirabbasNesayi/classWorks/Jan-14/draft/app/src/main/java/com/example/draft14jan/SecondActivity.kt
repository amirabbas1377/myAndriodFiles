package com.example.draft14jan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.draft14jan.databinding.ActivitySecondBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        textView2.text = intent.getStringExtra("message")
        returnButton()
    }

    fun returnButton(){
        button_2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", "this is ok")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}