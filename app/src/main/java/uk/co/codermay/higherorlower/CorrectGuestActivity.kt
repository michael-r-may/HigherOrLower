package uk.co.codermay.higherorlower

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_correct_guest.*
import org.jetbrains.anko.intentFor

class CorrectGuestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correct_guest)
        bindUserInterfaceActions()
    }

    private fun bindUserInterfaceActions() {
        quitButton.setOnClickListener {
            this.finishAffinity()
        }

        tryAgainButton.setOnClickListener {
            startActivity(intentFor<MainActivity>())
        }
    }
}
