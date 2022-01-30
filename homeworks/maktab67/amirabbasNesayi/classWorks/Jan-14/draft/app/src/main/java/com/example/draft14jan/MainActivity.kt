package com.example.draft14jan

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintProperties
import androidx.constraintlayout.widget.ConstraintProperties.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
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

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<MyFragment>(R.id.my)
        }

        val fragment = supportFragmentManager.findFragmentById(R.id.my) as MyFragment?
        fragment?.viewClicked = object : MyFragment.onViewClicked {
            override fun clickView(view: View) {
                textView.text = "this is changing"
            }
        }

    }
    fun clickedButton(binding:ActivityMainBinding){
        binding.button.setOnClickListener {
            val text = binding.editTextView.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            //intent.putExtra("message", text)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 12 && resultCode == RESULT_OK){
//            val result = data!!.getStringExtra("result")
//            textView.text = result
//        }
//    }

}