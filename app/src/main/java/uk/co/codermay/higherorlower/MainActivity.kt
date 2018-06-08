package uk.co.codermay.higherorlower

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNumber()
        createListenerForButton()
    }

    fun generateRandomNumber(): Int {
        var random = Random()
        var min = 1
        var max = 10
        randomNumber = random.nextInt(max + 1 - min) + min
        return randomNumber
    }

    fun assignRandomNumber() {
        randomNumber = generateRandomNumber()
    }

    fun guessNumber() {
        var numberToGuess = randomNumber
        var userGuess: Int = Integer.parseInt(guessTextView.getText().toString())
        checkUserGuess(userGuess, numberToGuess)
    }

    fun checkUserGuess(userGuess: Int, numberToGuess: Int) {
        if (userGuess > numberToGuess) {
            feedbackTextView.setText("Lower")
        } else if (userGuess < numberToGuess) {
            feedbackTextView.setText("Higher")
        } else {
            feedbackTextView.setText("Correct!")
            presentCorrectGuessScreen()
        }
    }

    fun createListenerForButton() {
        guessButton.setOnClickListener {
            if (guessTextView.getText().toString().equals("")) {
                toast("Please enter a number")
            } else {
                guessNumber()
            }
        }
    }

    fun presentCorrectGuessScreen() {
        startActivity(intentFor<CorrectGuestActivity>())
    }
}
