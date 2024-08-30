package com.example.caballerop_perezj_rojass_tarea1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var txt_resultado: TextView
    private lateinit var grad_cel: EditText
    private lateinit var btn_fah: Button
    private lateinit var btn_kelv: Button
    private lateinit var btn_ran: Button
    private lateinit var ct: ConvertirTemp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar los objetos
        txt_resultado = findViewById(R.id.txt_resultado)
        grad_cel = findViewById(R.id.grad_cel)
        btn_fah = findViewById(R.id.btn_fah)
        btn_kelv = findViewById(R.id.btn_kelv)
        btn_ran = findViewById(R.id.btn_ran)

        // Asignar eventos de clic a los botones
        ct = ConvertirTemp()
        btn_fah.setOnClickListener(this)
        btn_kelv.setOnClickListener(this)
        btn_ran.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val temp = grad_cel.text.toString().toDouble()
        when (v?.id) {
            R.id.btn_fah -> txt_resultado.text = ct.fahrenheit(temp).toString() + " °F"
            R.id.btn_kelv -> txt_resultado.text = ct.kelvin(temp).toString() + " °K"
            R.id.btn_ran -> txt_resultado.text = ct.rankine(temp).toString() + " °R"
        }
    }



}
