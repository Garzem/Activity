package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
///
    companion object {

        const val MAIN_ACTIVITY = "MainActivity"
        const val NUMBER_KEY = "number"
    }

    // объявляет изменяемую перемунную, которую потому будем складывать

    private var number = 0

    private var numberView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // находит textview и привязывает её к переменной

        numberView = findViewById<TextView>(R.id.numberView)

        // проверяем, есть ли сохранённые состояния со значениями

        if (savedInstanceState != null) {

            // если есть сохр. знач., тогда присваиваем их number

            number = savedInstanceState.getInt(NUMBER_KEY)
        }

        // связывает значение и textview

        numberView?.text = number.toString()

        // делает лог create цикла

        Log.d(MAIN_ACTIVITY, "onCreate")

        // переключение на новую активити через кнопку

        val button = findViewById<Button>(R.id.button_for_activity)

        // задаём, что необходимо сделать при нажатии

        button.setOnClickListener {

            // создаём и запускаем интент

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(NUMBER_KEY, number)
            startActivity(intent)
        }
    }

    override fun onRestoreInstanceState(state: Bundle) {
        super.onRestoreInstanceState(state)
        number = state.getInt(NUMBER_KEY)
        numberView?.text = number.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        number++
        outState.putInt(NUMBER_KEY, number)
    }

    // логируем каждый жизненный цикл

    override fun onStart() {
        super.onStart() // делается видимой
        Log.d(MAIN_ACTIVITY, "onStart")
    }

    override fun onResume() {
        super.onResume() // делается кликабельной
        Log.d(MAIN_ACTIVITY, "onResume")
    }

    override fun onPause() {
        super.onPause() // делается некликабельной
        Log.d(MAIN_ACTIVITY, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MAIN_ACTIVITY, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MAIN_ACTIVITY, "onDestroy")
    }
}
