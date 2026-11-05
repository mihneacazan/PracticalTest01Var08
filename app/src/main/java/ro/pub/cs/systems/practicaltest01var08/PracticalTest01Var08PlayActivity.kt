package ro.pub.cs.systems.practicaltest01var08

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var08PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var08_play)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val riddleTextView = findViewById<TextView>(R.id.textView)
        val answerHere = findViewById<EditText>(R.id.editTextText)
        val checkButton = findViewById<Button>(R.id.button)

        val riddle = intent.getStringExtra("riddle")
        val expectedAnswer = intent.getStringExtra("answer")

        if (!riddle.isNullOrEmpty()) {
            riddleTextView.text = riddle
        }

        checkButton.setOnClickListener {
            val answerPlay = answerHere.text.toString()
            if (answerPlay == expectedAnswer) {
                Toast.makeText(this, "Yes!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}