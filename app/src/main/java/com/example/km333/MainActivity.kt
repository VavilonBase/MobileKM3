package com.example.km333

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var countChildTextEdit: EditText
    private lateinit var countAdultTextEdit: EditText
    private lateinit var lastnameTextEdit: EditText
    private lateinit var nameTextEdit: EditText
    private lateinit var nameFlightEdit: EditText
    private lateinit var priceEdit: EditText
    private val tickets: ArrayList<Ticket> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countChildTextEdit = findViewById(R.id.editTextNumber)
        countAdultTextEdit = findViewById(R.id.editTextNumber2)
        lastnameTextEdit = findViewById(R.id.editTextText)
        nameTextEdit = findViewById(R.id.editTextText2)
        priceEdit = findViewById(R.id.editTextNumberDecimal)
        nameFlightEdit = findViewById(R.id.editTextText3)
    }

    fun registerButtonClick(view: View) {
        val ticket = Ticket(
            countChildTextEdit.text.toString().toInt(),
            countAdultTextEdit.text.toString().toInt(),
            nameFlightEdit.text.toString(),
            nameTextEdit.text.toString(),
            lastnameTextEdit.text.toString(),
            priceEdit.text.toString().toDouble()
        )

        tickets.add(ticket)
        val toast = Toast.makeText(this, "Билет зарегистрирован", Toast.LENGTH_LONG)
        toast.show()
        countChildTextEdit.text.clear()
        countAdultTextEdit.text.clear()
        lastnameTextEdit.text.clear()
        nameTextEdit.text.clear()
        priceEdit.text.clear()
        nameFlightEdit.text.clear()
    }

    fun reportButtonClick(view: View) {
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        var total = 0.0
        var countChild = 0
        var countAdult = 0

        for (ticket in tickets) {
            total += ticket.price
            countChild += ticket.countChild
            countAdult += ticket.countAdult
        }


        intent.putExtra("TOTAL", total)
        intent.putExtra("COUNT_CHILD", countChild)
        intent.putExtra("COUNT_ADULT", countAdult)
        startActivity(intent)
    }
}