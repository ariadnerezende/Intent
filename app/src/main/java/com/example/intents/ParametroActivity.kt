package com.example.intents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intents.MainActivity.Constantes.PARAMETRO_EXTRA
import com.example.intents.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {
    private val apb: ActivityParametroBinding by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root) //startActivityforResult envia uma intent,  SetResult devolve uma intent para quem chamou!
        intent.getStringExtra(PARAMETRO_EXTRA)?.also { //recupera a intent que causou a abertura da tela, recupera o parametro pela chave
            parametro -> apb.parametroEt.setText(parametro) //preenche o editText com o valor recebido
        }
    }
}
