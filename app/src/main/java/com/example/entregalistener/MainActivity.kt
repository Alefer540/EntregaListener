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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b1.setOnClickListener {

            binding.tv1.text= numeroAleatorio().toString()
        }

        binding.b2.setOnClickListener {

            binding.tv1.text=letraAleatoria()
        }
        var npalabra= ""
        binding.b3.setOnClickListener {
            npalabra=palabraAleatoria()
            binding.tv1.text=npalabra
        }

        binding.tv1.doOnTextChanged { text, start, before, count ->
            if (count == 5) {
                binding.b4.visibility = View.VISIBLE
            }else{
                binding.b4.visibility=View.GONE
            }
        }
        binding.b4.setOnClickListener{
            var l1=npalabra.toCharArray()
            var resultado=""
            var posicion=(Random.nextInt(4))
            var letraale= Random.nextInt(99, 122).toChar()
            Toast.makeText(this,"cambio la letra ${l1[posicion]} por la letra aleatoria $letraale" +binding.tv1.text, Toast.LENGTH_LONG).show()
            npalabra.replace(l1[posicion],letraale)
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
