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
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.data.classes.Lista_items
import pt.isec.a2017014841.tp.other.ListaAdapter

class MainActivity : AppCompatActivity() {
  private  var listas = ArrayList<Lista_items>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edit = getSharedPreferences("list", 0).edit()
        this.title = getString(R.string.ListMaker)
        //val factory
        //val viewModel = ViewModelProvider(this, factory).get(ProdViewModel())
        val adapter = ListaAdapter(listas)
        rvListas.adapter = adapter
        rvListas.layoutManager = LinearLayoutManager(this)
       // contacts = Contact.createContactsList(20)
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
                setTitle(getString(R.string.select_list_name))
                setPositiveButton(getString(R.string.ok)) { dialogInterface: DialogInterface, i: Int ->
                   if(editText.text.toString()!="")
                   {
                       var mylist: ArrayList<Item> = ArrayList()
                       listas.add(Lista_items(editText.text.toString(), mylist))
                   }
                }
                setNegativeButton(getString(R.string.cancel)){ dialog, which->
                    Log.d("Main", "Negative button clicked")
                }
                setView(dialogLayout)
                setCancelable(true)
                show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}