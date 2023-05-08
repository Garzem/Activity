package com.example.activity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // объявляет изменяемую перемунную, которую потому будем складывать

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // находит textview и привязывает её к переменной

        val numberView = findViewById<TextView>(R.id.numberView)

        // проверяем, есть ли сохранённые состояния со значениями

        if (savedInstanceState != null) {

            // если есть сохр. знач., тогда присваиваем их number

            number = savedInstanceState.getInt("number")
        }

        // связывает значение и textview

        numberView.text = number.toString()

        // делает лог create цикла

        Log.d("MainActivity", "onCreate")

        // переключение на новую активити через кнопку

        val button = findViewById<Button>(R.id.button_for_activity)

        // задаём, что необходимо сделать при нажатии

        button.setOnClickListener {

            // создаём и запускаем интент

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("number", number)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("number", number)
    }

    // создаём функцию для фиксации изменений конфигурации

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // прибавляем 1, если меняется конфигурация

        number++

        // обновляем значение number в textview

        val numberView = findViewById<TextView>(R.id.numberView)
        numberView.text = number.toString()
    }

    // логируем каждый жизненный цикл

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }


}
