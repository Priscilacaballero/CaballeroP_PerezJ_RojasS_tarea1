package com.example.caballerop_perezj_rojass_tarea1
// Priscila Caballero 8-1000-2151
// Sergio Rojas 8-0
// Jose Perez 8-0


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var txt_resultado: TextView
    private lateinit var grad_cel: EditText
    private lateinit var btn_fah: Button
    private lateinit var btn_kelv: Button
    private lateinit var btn_ran: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Asignar los elementos de la vista a las variables
        txt_resultado = findViewById(R.id.txt_resultado)
        grad_cel = findViewById(R.id.grad_cel)
        btn_fah = findViewById(R.id.btn_fah)
        btn_kelv = findViewById(R.id.btn_kelv)
        btn_ran = findViewById(R.id.btn_ran)

        // Asignar eventos de clic a los botones
        btn_fah.setOnClickListener { convertirTemp() }
        btn_kelv.setOnClickListener { convertirTemp() }
        btn_ran.setOnClickListener { convertirTemp() }
    }

    private fun convertirTemp() {
        val tempString = grad_cel.text.toString()
        if (tempString.isNotEmpty()) {
            val temp = tempString.toDouble()
            val convertidor = ConvertirTemp()
            if (btn_fah.isPressed) {
                txt_resultado.text = convertidor.fahrenheit(temp).toString()+" °F"
            }
            else if (btn_kelv.isPressed) {
                txt_resultado.text = convertidor.kelvin(temp).toString()+" °K"
            }
            else if (btn_ran.isPressed) {
                txt_resultado.text = convertidor.rankine(temp).toString()+" °R"
            }
            else{
                txt_resultado.text = "Seleccione una opción"
            }

        } else {
            txt_resultado.text = "Ingrese un valor en Celsius"
        }
    }
}
