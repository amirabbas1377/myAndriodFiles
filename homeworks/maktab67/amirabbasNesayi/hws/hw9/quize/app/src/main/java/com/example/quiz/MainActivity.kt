package com.example.quiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.quiz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter = 0
    var isCheating = false
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
            if (isClickCheating < 1) {
                if (answerOfTheQuestion) trueToast()
                else if (!answerOfTheQuestion) falseToast()
                counter++
                false_button.isEnabled = false
                true_button.isEnabled = false
            } else {
                Toast.makeText(this, "cheating is wrong", Toast.LENGTH_SHORT).show()
                isClickCheating = 0
            }
        }

        false_button.setOnClickListener {
            if (isClickCheating < 1) {
                if (answerOfTheQuestion) falseToast()
                else if (!answerOfTheQuestion) trueToast()
                counter++
                false_button.isEnabled = false
                true_button.isEnabled = false
            } else {
                Toast.makeText(this, "cheating is wrong", Toast.LENGTH_SHORT).show()
                isClickCheating = 0
            }
        }

        next_button.setOnClickListener {
            isClickCheating = 0
            Log.d("TAG", "$isClickCheating in main")
            false_button.isEnabled = true
            true_button.isEnabled = true
            counter++
            if (counter == 9) next_button.isEnabled = false
            if (counter >= 1) previous_button.isEnabled = true
            textOfQuestion = questions[counter].first
            answerOfTheQuestion = questions[counter].second
            question_text_view.text = textOfQuestion
        }

        previous_button.setOnClickListener {
            isClickCheating = 0
            false_button.isEnabled = true
            true_button.isEnabled = true
            counter--
            if (counter >= 8) next_button.isEnabled = true
            if (counter == 0) previous_button.isEnabled = false
            textOfQuestion = questions[counter].first
            answerOfTheQuestion = questions[counter].second
            question_text_view.text = textOfQuestion
        }
        cheatGame(answerOfTheQuestion)
    }

    fun trueToast() {
        Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
    }

    fun falseToast() {
        Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
    }

    fun cheatGame(answer: Boolean) {
        cheat_button.setOnClickListener {
            var boolAns = if (answer) "true" else "false"

            val intent = Intent(this, Cheating::class.java)
            intent.putExtra("answer", boolAns)
            startActivity(intent)


//            Log.d("TAG", "avaal")
//            var contract = object : ActivityResultContract<String?, Boolean?>(){
//                override fun createIntent(context: Context, input: String?): Intent {
//                    return Intent(this@MainActivity, Cheating::class.java)
//                }
//                override fun parseResult(resultCode: Int, intent: Intent?):Boolean? = intent?.
//                getBooleanExtra("result", false)
//            }
//            Log.d("TAG", "avaal")
//            var callBack = ActivityResultCallback<Boolean?> {
//                Log.d("TAG", "result is : $it")
//            }
//            Log.d("TAG", "avaal")
//            var activityResultLauncher = registerForActivityResult(contract, callBack)
//
//            activityResultLauncher.launch(null)
        }
    }



}