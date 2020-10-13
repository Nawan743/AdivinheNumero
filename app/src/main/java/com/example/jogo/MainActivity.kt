package com.example.jogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var number = (1..101).random()
    private var attempts = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkNumber(view: View) {
        val numberGuess: Int = number_guess.text.toString().toInt();

        when {
            numberGuess==number -> {
                text_result.text = "Acertou com $attempts tentativas! Vamos novamente? Em que número estou pensando?"
                this.number = (1..101).random()
                this.attempts = 0;
                attempts_number.text = "Quantidade de tentativas: $attempts"
            }
            numberGuess>number -> {
                text_result.text = "Errou! O número que estou pensando está abaixo do palpite!"
                this.attempts++
                attempts_number.text = "Quantidade de tentativas: $attempts"
                number_guess.setText("")
            }
            else -> {
                text_result.text = "Errou! O número que estou pensando está acima do palpite!"
                this.attempts++
                attempts_number.text = "Quantidade de tentativas: $attempts"
                number_guess.setText("")
            }
        }
    }
}