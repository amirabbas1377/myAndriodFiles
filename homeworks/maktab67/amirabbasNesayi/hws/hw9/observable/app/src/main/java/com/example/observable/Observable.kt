package com.example.observable

import android.util.Log

class Observable {
    var list:MutableList<Int> = mutableListOf()
    init {
        for (i in 1..100) list.add(i)
    }
    var observers:MutableList<Observer> = mutableListOf()
    fun register(observer: Observer){
        observers.add(observer)
    }

    fun unregister(observer: Observer){
        observers.remove(observer)
    }

    fun logResult(number:Int){
        if (observers.isNotEmpty()){
            for (item in observers){
                Log.d("Observe", "observer ${item.id} : $number")
            }
        }
    }
}