package com.example.saveinfo

import android.content.Context
import android.content.SharedPreferences
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.saveinfo.databinding.SaveDataBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.save_data.*

class SaveData : Fragment(R.layout.save_data) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = getData()
        save_data_button.setOnClickListener {
            this.activity?.let { it1 -> setPrefValues(data, it1) }
        }
    }

    fun getData(): Map<String, String?> {
        val fullName = requireArguments().getString("FullName")
        val username = requireArguments().getString("Username")
        val email = requireArguments().getString("Email")
        val password = requireArguments().getString("Password")
        val gender = requireArguments().getString("Gender")

        full_name_info.text = fullName
        user_name_info.text = password
        email_info.text = email
        password_info.text = password
        gender_info.text = gender

        return mapOf(
            "FullName" to fullName, "Username" to username, "Email" to email,
            "Password" to password, "Gender" to gender
        )
    }

    fun setPrefValues(info: Map<String, String?>, activity: Context) {
        val prefs = activity.getSharedPreferences("information", AppCompatActivity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        for (i in info) {
            editor.putString(i.key, i.value)
            editor.apply()
        }
    }

}