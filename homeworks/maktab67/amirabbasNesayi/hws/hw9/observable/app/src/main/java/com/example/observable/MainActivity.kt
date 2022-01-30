package com.example.observable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log

class MainActivity : AppCompatActivity() {
    lateinit var countDownTimer:CountDownTimer
    var observable = Observable()
    var semaphore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addObservable()
        observer(100)
    }

    fun observer(numbers:Long){
        Log.d("TAG", observable.list.size.toString())
        Log.d("TAG", observable.observers.size.toString())
        countDownTimer = object : CountDownTimer(numbers * 3000, 3000){
            override fun onTick(millisUntilFinished: Long) {
                var number = observable.list.first()
                observable.list.removeFirst()
                observable.logResult(number)
            }

            override fun onFinish() {
                this.cancel()
            }
        }
        countDownTimer.start()
    }
    fun addObservable(){
        var firstObserver = Observer(1)
        var secondObserver = Observer(2)
        var thirdObserver = Observer(3)
        observable.register(firstObserver)
        observable.register(secondObserver)
        observable.register(thirdObserver)
    }

    override fun onPause() {
        super.onPause()
        if (semaphore == 0){
            countDownTimer.cancel()
            semaphore = 1
        }
    }
    override fun onResume() {
        super.onResume()
        if (semaphore == 1){
            observer(observable.list.size.toLong())
            semaphore = 0
        }
    }
}