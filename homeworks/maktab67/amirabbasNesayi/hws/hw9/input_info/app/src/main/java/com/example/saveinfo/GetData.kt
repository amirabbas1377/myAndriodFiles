package com.example.saveinfo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.saveinfo.databinding.GetDataBinding
import com.example.saveinfo.databinding.SaveDataBinding
import kotlinx.android.synthetic.main.get_data.*

class GetData : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingGetData = GetDataBinding.inflate(inflater,
            container, false)
        return bindingGetData.root
    }

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

            var selectGender = radio_group.checkedRadioButtonId
            val gender = if (selectGender == 2131230911) "Male" else "Female"

            if (fullName == "") Toast.makeText(activity, "enter your name", Toast.LENGTH_SHORT).show()
            else if(username == "") Toast.makeText(activity, "enter your username", Toast.LENGTH_SHORT).show()
            else if(email == "") Toast.makeText(activity, "enter your email", Toast.LENGTH_SHORT).show()
            else if(password == "") Toast.makeText(activity, "enter password", Toast.LENGTH_SHORT).show()
            else if(password != rePassword) Toast.makeText(activity, "password doesn't match", Toast.LENGTH_SHORT).show()
            else {
                val bundle = bundleOf("FullName" to fullName, "Username" to username
                    , "Email" to email, "Password" to password, "Gender" to gender)

                val fragment = SaveData()
                fragment.arguments = bundle
                parentFragmentManager.popBackStack()
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment1, fragment).commit()
            }
        }
    }

}