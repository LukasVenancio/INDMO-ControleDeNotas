package br.senai.controledenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var nomeEditText: EditText
private lateinit var nota1EditText: EditText
private lateinit var nota2EditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener() {

            nomeEditText = findViewById(R.id.nome)
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)

            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if (validarCampos()) {

                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nome = nomeEditText.text.toString()

                val media = calcularMedia(nota1, nota2)

                resultadoTextView.text = situacaoAluno(media)
            }
        }

        sair.setOnClickListener() {
            finish()
        }
    }


}
//    private fun calcularMedia(nota1: Int, nota2: Int): Int {
//        return (nota1 + nota2) / 2
//    }

//Outras maneiras de criar funções

//    val calcularMedia ={nota1: Int, nota2: Int ->(nota1 + nota2) / 2
//    private fun calcularMedia(nota1: Int, nota2: Int): Int = (nota1 + nota2) / 2

private fun validarCampos(): Boolean {

    var noError = true

    if (nota1EditText.text.isBlank()) {
        nota1EditText.setError("Digite a nota 1!")
        noError = false
    }

    if ((nota2EditText.text.isBlank())) {
        nota2EditText.setError("Digite a nota 2!")
        noError = false
    }

    if (nomeEditText.text.isBlank()) {
        nomeEditText.setError("Digite o nome!")
        noError = false
    }

    return noError


}
