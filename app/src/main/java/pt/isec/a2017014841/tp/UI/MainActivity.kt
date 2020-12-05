package pt.isec.a2017014841.tp.UI

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ListAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.data.db.DB
import pt.isec.a2017014841.tp.data.repositorios.ProdRepositorio
import pt.isec.a2017014841.tp.other.ListaAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var database = DB(this)
        var repositorio = ProdRepositorio(database)
        this.setTitle("ListMaker")

       // contacts = Contact.createContactsList(20)


    }

    override fun onResume() {
        super.onResume()
        val cars = ArrayList<String>()
        cars.add("um")
        cars.add("dois")
        cars.add("tres")
        cars.add("quatro")
        val rvlista = findViewById<View>(R.id.rvListas) as RecyclerView
        //val factory
        //val viewModel = ViewModelProvider(this, factory).get(ProdViewModel())
        val adapter = ListaAdapter(cars)
        rvlista.adapter = adapter
        rvlista.layoutManager = LinearLayoutManager(this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu1NL) {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.nomelista_layout, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.nomelista)

            with(builder) {
                setTitle("Indique o nome da lista")
                setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                    val intent = Intent(
                        this.context,
                        VerListaActivity::class.java
                    ).also{
                        val nome = editText.text.toString()
                        it.putExtra("NOME_LISTA", nome)
                        startActivity(it)
                    }

                }
                setNegativeButton("Cancelar"){ dialog, which->
                    Log.d("Main", "Negative button clicked")
                }
                setView(dialogLayout)
                setCancelable(true)
                show()
            }
        }
        if (item.itemId == R.id.menu1VP) {
            val intent = Intent(this, VerProdsActivity::class.java)
            this.startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}