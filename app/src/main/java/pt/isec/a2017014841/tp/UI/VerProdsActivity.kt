package pt.isec.a2017014841.tp.UI

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.other.ItemAdapter

class VerProdsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DEBUG", "MyClass.getView() — get item number")
        setContentView(R.layout.activity_ver_prods)
        this.setTitle("Produtos")
        val intent = intent
        var lista_items:ArrayList<Item>
        val bundle_main = intent.extras
        if (bundle_main!=null)
        {
            lista_items = bundle_main.getSerializable("ARRAYLIST") as ArrayList<Item>
        }
        val rvlista = findViewById<View>(R.id.rvItems) as RecyclerView
        //val adapter = ItemAdapter(lista_items)
        //rvlista.adapter = adapter
        rvlista.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, NovoProdActivity::class.java)
        this.startActivity(intent)
        var item : Item
        val bundle_main = intent.extras
        if (bundle_main!=null)
        {
            lista_items = bundle_main.getSerializable("ARRAYLIST") as ArrayList<Item>
        }
        val rvlista = findViewById<View>(R.id.rvItems) as RecyclerView
        return true
    }
}