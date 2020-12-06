package pt.isec.a2017014841.tp.UI

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.data.classes.Lista_items
import pt.isec.a2017014841.tp.other.ItemAdapter

class VerProdsActivity : AppCompatActivity() {
    lateinit var lista_items :Lista_items
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DEBUG", "MyClass.getView() — get item number")
        setContentView(R.layout.activity_ver_prods)
        this.setTitle("Produtos")
        if(savedInstanceState == null){
            if (intent.extras != null) {
                lista_items = intent.extras!!.getSerializable("ARRAYLIST") as Lista_items
            }
        }else{
            lista_items = intent.extras!!.getSerializable("ARRAYLIST") as Lista_items
        }
        val rvlista = findViewById<View>(R.id.rvItems) as RecyclerView
        val adapter = ItemAdapter(lista_items.get_items())
        rvlista.adapter = adapter

        //var lista: ArrayList<Item> = ArrayList()
        //val mPrefs = getPreferences(MODE_PRIVATE)
        /*Gson gson = new Gson()
        val json = mPrefs.getString("Lista_items", "")
        if (gson.fromJson(json, lista::class.java) != null) {
            lista = gson.fromJson(json, lista::class.java)
        }*/


        rvlista.layoutManager = LinearLayoutManager(this)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putSerializable("lista_items", lista_items)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentToGO = Intent(this, NovoProdActivity::class.java)
        val b = Bundle()
        b.putSerializable("ARRAYLIST", lista_items)
        intent.putExtras(b)
        this.startActivity(intentToGO)
        return true
    }
}