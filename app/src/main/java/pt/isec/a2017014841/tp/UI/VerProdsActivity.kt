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


class VerProdsActivity : AppCompatActivitySaveFile() {
    val GET_ITEM = 1
    lateinit var lista_items: Lista_items
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("DEBUG", "MyClass.getView() — get item number")
        setContentView(R.layout.activity_ver_prods)
        //this.title = getString(R.string.Product)
        if (intent.extras != null) {
            try{
                loadSave()
                lista_items = this.listas!![intent.extras!!.getInt("position")]
            }catch(e : Throwable){
                e.printStackTrace()
                listas = null
                finish()
            }

        }


        this.title = lista_items.get_nome()
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentToGO = Intent(this, NovoProdActivity::class.java)
        val b = Bundle()
        b.putInt("position", intent.extras!!.getInt("position"))
        intentToGO.putExtras(b)
        this.startActivityForResult(intentToGO, GET_ITEM)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 1) {
                loadSave()
                lista_items = this.listas!![intent.extras!!.getInt("position")]
            }
        }
    }
}