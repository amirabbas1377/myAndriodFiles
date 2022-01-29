package com.example.quiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.quiz.databinding.CheatingLayoutBinding
import kotlinx.android.synthetic.main.cheating_layout.*


class Cheating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CheatingLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var answer = intent.getBooleanExtra("answer", false)
        if (answer != null) {
            cheating(answer.toString())
        }
    }


    fun cheating(answer:String){
        show_answer_button.setOnClickListener {
            show_answer_button.isEnabled = false
            show_answer_button.visibility = View.INVISIBLE
            textView.visibility = View.INVISIBLE
            textView.text = answer
            textView.visibility = View.VISIBLE
            val intent = Intent()
            intent.putExtra("result", true)
            setResult(RESULT_OK, intent)
            //finish()
        }
    }
}