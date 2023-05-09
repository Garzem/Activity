package com.example.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    companion object {

        const val SECOND_ACTIVITY = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // передаёт информацию о number с 1 активити,
        // задавая 0, как значение, если у "number" не будет value

        val number = intent.getIntExtra("number", 0)

        // возводим в квадрат полученную переменную

        val mulNumber = number * number

        // привязываем textview к activity с возведением

        val multiplication = findViewById<TextView>(R.id.multiplication)

        // присваиваем textview нужное значение

        multiplication.text = mulNumber.toString()

        Log.d(SECOND_ACTIVITY, "onCreate")
    }

        // логируем каждый жизненный цикл

        override fun onStart() {
            super.onStart()
            Log.d(SECOND_ACTIVITY,"onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.d(SECOND_ACTIVITY,"onResume")
        }

        override fun onPause() {
            super.onPause()
            Log.d(SECOND_ACTIVITY,"onPause")
        }

        override fun onStop() {
            super.onStop()
            Log.d(SECOND_ACTIVITY,"onStop")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d(SECOND_ACTIVITY,"onDestroy")
    }
}