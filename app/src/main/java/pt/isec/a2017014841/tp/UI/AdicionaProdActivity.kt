package pt.isec.a2017014841.tp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.isec.a2017014841.tp.R

class AdicionaProdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiciona_prod)

        this.setTitle("Produtos")
    }

}