package com.example.quiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.quiz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0
    var isClickCheating = arrayOf(false, false, false, false, false, false, false, false, false
        , false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        game()

    }


    fun game() {
        var textOfQuestion: String = questions[counter].first
        var answerOfTheQuestion: Boolean = questions[counter].second
        question_text_view.text = textOfQuestion

        previous_button.isEnabled = false

        true_button.setOnClickListener {
            if (!isClickCheating[counter]) {
                if (answerOfTheQuestion) trueToast()
                else if (!answerOfTheQuestion) falseToast()
                counter++
                false_button.isEnabled = false
                true_button.isEnabled = false
            } else Toast.makeText(this, "cheating is wrong", Toast.LENGTH_SHORT).show()
        }

        false_button.setOnClickListener {
            if (!isClickCheating[counter]) {
                if (answerOfTheQuestion) falseToast()
                else if (!answerOfTheQuestion) trueToast()
                counter++
                false_button.isEnabled = false
                true_button.isEnabled = false
            } else Toast.makeText(this, "cheating is wrong", Toast.LENGTH_SHORT).show()
        }

        next_button.setOnClickListener {
            Log.d("TAG", "$isClickCheating in main")
            false_button.isEnabled = true
            true_button.isEnabled = true
            counter++
            if (counter == 9) next_button.isEnabled = false
            if (counter >= 1) previous_button.isEnabled = true
            textOfQuestion = questions[counter].first
            answerOfTheQuestion = questions[counter].second
            Log.d("TAG", "first $answerOfTheQuestion")
            question_text_view.text = textOfQuestion
        }

        previous_button.setOnClickListener {
            false_button.isEnabled = true
            true_button.isEnabled = true
            counter--
            if (counter >= 8) next_button.isEnabled = true
            if (counter == 0) previous_button.isEnabled = false
            textOfQuestion = questions[counter].first
            answerOfTheQuestion = questions[counter].second
            question_text_view.text = textOfQuestion
        }
        
        cheat_button.setOnClickListener {
            val intent = Intent(this, Cheating::class.java)
            intent.putExtra("answer", answerOfTheQuestion)
            startActivityForResult(intent , 1)
        }
    }

    fun trueToast() {
        Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
    }

    fun falseToast() {
        Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
            isClickCheating[counter] = data.getBooleanExtra("result", false)
        }
    }
}