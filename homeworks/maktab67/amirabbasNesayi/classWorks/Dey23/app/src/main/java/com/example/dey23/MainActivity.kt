package com.example.dey23

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleToast()


        val inflater = getLayoutInflater();
        val layout = inflater.inflate(R.layout.toast,
        findViewById(R.id.toast_layout_root));

        val image = findViewById(R.id.image);
        image.setImageResource(R.drawable.android);
        var text = findViewById(R.id.text);
        text.setText("Hello! This is a custom toast!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
    private fun handleToast(){
        val textBox:TextView = findViewById(R.id.text_view)
        val button:Button = findViewById(R.id.button)
        var count = 0
        var toast = Toast(applicationContext)
        button.setOnClickListener{
            count++
            textBox.text = "$count bar click shod!"
            toast.setText("$count bar click shod!")

            toast.setGravity(2, 40, 40);
            toast.duration = Toast.LENGTH_SHORT;

            toast.show()
        }
    }
}