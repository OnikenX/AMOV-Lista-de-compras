package pt.isec.a2017014841.tp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_ver_lista.*
import pt.isec.a2017014841.tp.R

class VerListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_lista)

        val nome=intent.getStringExtra("NOME_LISTA")
        this.setTitle(nome)
        nomelistaVL.text=nome
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu2AP) {
            val intent = Intent(this, AdicionaProdActivity::class.java)
            this.startActivity(intent)
        }
        return true
    }
}