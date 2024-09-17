package com.example.intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object Constantes {
        const val PARAMETRO_EXTRA = "PARAMETRO_EXTRA"
    }

    private lateinit var parl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(amb.root)

        setSupportActionBar(amb.toolbarTb)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            subtitle = this@MainActivity.javaClass.simpleName
        }

        parl = registerForActivityResult( //obj, um para cada tela!
            ActivityResultContracts.StartActivityForResult(),
            object : ActivityResultCallback<ActivityResult> {
                override fun onActivityResult(result: ActivityResult) {
                    if (result.resultCode == RESULT_OK) {
                        result.data?.getStringExtra(PARAMETRO_EXTRA)?.let {
                            amb.parametroTv.text = it
                        }
                    }
                }
            }
        )

        amb.entrarParametroBt.setOnClickListener {
            val parametroIntent = Intent(this, ParametroActivity::class.java)
            parametroIntent.putExtra(PARAMETRO_EXTRA, amb.parametroTv.text.toString())
            parl.launch(parametroIntent)
        }
    }
}
