package com.example.intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object Constantes {
        const val PARAMETRO_EXTRA = "PARAMETRO_EXTRA"
        const val PARAMETRO_REQUEST_CODE = 0 // token
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(amb.root)

        amb.entrarParametroBt.setOnClickListener {
            val parametroIntent = Intent(this, ParametroActivity::class.java) // criar intent
            parametroIntent.putExtra(PARAMETRO_EXTRA, amb.parametroTv.text.toString()) // chave parametro e o conteúdo
            startActivityForResult(parametroIntent, PARAMETRO_REQUEST_CODE) // chama a start com a intent e o token

            // ABAIXO, O CÓDIGO MAIS NO JEITO KOTLIN.
            // Intent(this, ParametroActivity::class.java).apply {
            //     amb.parametroTv.text.toString().let {
            //         putExtra(PARAMETRO_EXTRA, it)
            //     }
            //     startActivityForResult(this, PARAMETRO_REQUEST_CODE)
            // }
        }
    }
}
