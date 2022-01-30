package com.example.saveinfo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import kotlinx.android.synthetic.main.get_data.*

class GetData : Fragment(R.layout.get_data){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.activity?.let { catchData(it) }
    }

    private fun catchData(activity: Context){

        register_button.setOnClickListener {

            val fullName = full_name_editor.text.toString()
            val username = user_name_editor.text.toString()
            val email = email_editor.text.toString()
            val password = password_editor.text.toString()
            val rePassword = re_password_editor.text.toString()

            //var selectGender = radio_group.checkedRadioButtonId
            val gender:String

            if (fullName == "") Toast.makeText(activity, "enter your name", Toast.LENGTH_SHORT).show()
            else if(username == "") Toast.makeText(activity, "enter your username", Toast.LENGTH_SHORT).show()
            else if(email == "") Toast.makeText(activity, "enter your email", Toast.LENGTH_SHORT).show()
            else if(password == "") Toast.makeText(activity, "enter password", Toast.LENGTH_SHORT).show()
            else if(password != rePassword) Toast.makeText(activity, "password doesn't match", Toast.LENGTH_SHORT).show()
            else if (!male_radio_button.isChecked && !female_radio_button.isChecked)
                Toast.makeText(activity, "select your gender", Toast.LENGTH_SHORT).show()
            else {
                gender = if (male_radio_button.isChecked) "Male" else "Female"
                val bundle = bundleOf("FullName" to fullName, "Username" to username
                    , "Email" to email, "Password" to password, "Gender" to gender)

                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<SaveData>(R.id.fragment_container_get , args = bundle)
                    addToBackStack("main")
                }
            }
        }
    }

}