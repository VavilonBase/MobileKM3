package com.example.km333

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var totalText: TextView
    private lateinit var countAdultText: TextView
    private lateinit var countChildText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        totalText = findViewById(R.id.textView3)
        countAdultText = findViewById(R.id.textView5)
        countChildText = findViewById(R.id.textView4)

        var total = intent.getDoubleExtra("TOTAL", 0.0)
        var countAdult = intent.getIntExtra("COUNT_ADULT", 0)
        var countChild = intent.getIntExtra("COUNT_CHILD", 0)

        totalText.text = "Общая стоимость: $total"
        countAdultText.text = "Количество взрослых: $countAdult"
        countChildText.text = "Количество детей: $countChild"
    }
}