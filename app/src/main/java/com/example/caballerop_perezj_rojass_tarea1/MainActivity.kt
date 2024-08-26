package com.example.caballerop_perezj_rojass_tarea1
// Priscila Caballero 8-1000-2151
// Sergio Rojas
// Jose Perez

//para las clases inciar con mayuscula ejemplo Close
//para las funciones iniciar con minuscula y despues se contnua con palabra mayuscula ejemplo: funcionCalcular
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

    //todo el contenido de la funcion override Oncrete debe quedar en todas las nuevas aactividades que hagamos
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
        //btn_ran.setOnClickListener(this)
        //btn_kelv.setOnClickListener(this)
        //btn_fah.setOnClickListener(this)

        //intent es para pasar de una actividad a otra actividad es decir a otro formulario desde otro
        //val intent = Intent(packageContext:this, OtraActividad::class.java))
        //OtraActividad es el backend y despues se realiza el front end de esa actividad o fomrulario o pantalla
        //startActivity(intent)

        //cuando se crea un fragmento es cambios ne la misma actividad, es decir no se crea otra actividad para hacer display de ese fragmento de esa actividad
        //el fragment container sirve para abrir diferentes fragmentos en la misma view
        //los fragmentos son un archivo aparte de la main activity o la actividad a la que se accede
        

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
