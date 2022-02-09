package com.example.quiz

import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {

    val questions = mutableMapOf("""Tehran is the capital of England""" to Pair(false, false)
        ,"""water is the most important thing for surviving""" to Pair(true, false)
        ,"""fish need water for living""" to Pair(true, false)
        ,"""major part of Russia in Europe""" to Pair(false, false)
        ,"""there is eleven player in a line up of a football team""" to Pair(true, false)
        ,"""Germany is the champion of world cup 2014""" to Pair(true, false)
        ,"""The best player of 2021 is Salah""" to Pair(false, false)
        ,"""Iran won Asian cup 3 times""" to Pair(true, false)
        ,"""Perspolis won the Asian Champions league :)""" to Pair(false, false)
        ,"""I am a android app""" to Pair(true, false)
    )

    var counterGame = 0
}