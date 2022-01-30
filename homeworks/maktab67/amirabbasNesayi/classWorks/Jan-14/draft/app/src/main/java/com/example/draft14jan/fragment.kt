package com.example.draft14jan

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.draft14jan.databinding.FragmentLayourBinding


class MyFragment:Fragment(R.layout.fragment_layour){

    interface onViewClicked {
        fun clickView(view: View)
    }
    var viewClicked:onViewClicked? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLayourBinding.inflate(layoutInflater)
        binding.myview.setOnClickListener {
            viewClicked?.clickView(it as TextView)
        }
    }
}