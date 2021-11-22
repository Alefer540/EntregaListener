package com.example.entregalistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

import com.example.entregalistener.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.b1.setOnClickListener {

            binding.tv1.text = numeroAleatorio().toString()
            binding.b4.visibility = View.GONE
        }

        binding.b2.setOnClickListener {

            binding.tv1.text = letraAleatoria()
            binding.b4.visibility = View.GONE
        }
        var npalabra = ""
        binding.b3.setOnClickListener {
            npalabra = palabraAleatoria()
            binding.tv1.text = npalabra
            binding.b4.visibility = View.VISIBLE


        }


        binding.b4.setOnClickListener {
            var cadena = binding.tv1.text
            var tamanio = Random.nextInt(1, cadena.length)
            var posletra=cadena[tamanio]
            var letraaleatoria: Char = Random.nextInt(97, 122).toChar()
            cadena= cadena.replaceRange(tamanio, tamanio + 1, letraaleatoria.toString())
            binding.tv1.text = cadena
            Toast.makeText(this,"cambio la letra "+ posletra+ " por la letra " +letraaleatoria+ " siendo "+posletra+ " la letra que se quita ,e "+letraaleatoria+ " la que se añade",Toast.LENGTH_LONG).show()

        }


    }


    fun numeroAleatorio(): Int {
        var numero = 0
        numero += (Random.nextInt(100))
        return numero
    }

    fun letraAleatoria(): String {
        var letra = ""
        letra += Random.nextInt(99, 122).toChar()
        return letra
    }

    fun palabraAleatoria(): String {
        var palabra = " "
        for (i in 1..5) {
            palabra += (Random.nextInt(99, 122).toChar())
        }
        return palabra
    }
}



