package com.example.caballerop_perezj_rojass_tarea1

class ConvertirTemp {
    //funcion para convertir de celsius a farenheit
    fun fahrenheit (celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    //funcion para convertir de celsius a kelvin
    fun kelvin (celsius: Double): Double {
        return  celsius +273.15
    }

    //funcion para convertir de celsius a rankine
    fun rankine (celsius: Double): Double {
        return (celsius + 273.15) * 9 / 5
    }
}