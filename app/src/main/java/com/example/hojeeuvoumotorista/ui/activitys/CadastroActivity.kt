package com.example.hojeeuvoumotorista.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.hojeeuvoumotorista.R
import com.example.hojeeuvoumotorista.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCriarConta.setOnClickListener{
            val intent = Intent(this, VerificacaoEmailActivity::class.java)
            startActivity(intent)
        }

        binding.tvLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked = view.isChecked
            when (view.id) {
                R.id.checkbox_concordo -> {
                    if (checked) {
                        Toast.makeText(this, "Concordei", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Não concordei", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


}