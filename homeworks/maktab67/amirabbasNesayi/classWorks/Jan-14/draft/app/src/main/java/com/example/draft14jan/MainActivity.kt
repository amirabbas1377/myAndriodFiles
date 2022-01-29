package com.example.draft14jan

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintProperties
import androidx.constraintlayout.widget.ConstraintProperties.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import com.example.draft14jan.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickedButton(binding)

        }
    fun clickedButton(binding:ActivityMainBinding){
        binding.button.setOnClickListener {
            val text = binding.editTextView.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", text)
            startActivityForResult(intent, 12)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 12 && resultCode == RESULT_OK){
            val result = data!!.getStringExtra("result")
            textView.text = result
        }
    }

}