package pt.isec.a2017014841.tp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.other.ItemAdapter
import pt.isec.a2017014841.tp.other.ListaAdapter

class VerProdsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_prods)
        this.setTitle("Produtos")
        val rvlista = findViewById<View>(R.id.rvItems) as RecyclerView
       // val adapter = ItemAdapter(listas)
       // rvlista.adapter = adapter
        rvlista.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, NovoProdActivity::class.java)
        this.startActivity(intent)
        return true
    }
}