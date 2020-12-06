package pt.isec.a2017014841.tp.other

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.UI.AppCompatActivitySaveFile
import pt.isec.a2017014841.tp.UI.NovoProdActivity
import pt.isec.a2017014841.tp.UI.VerProdsActivity
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.data.classes.Lista_items
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


class ListaAdapter(
    private val listas: ArrayList<Lista_items>,
    private val activity: AppCompatActivitySaveFile
) :
    RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {
    inner class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var context: Context? = itemView.context
        val n: TextView? = itemView.findViewById<TextView>(R.id.rvListas)
        val nameTextView: TextView? =
            itemView.findViewById<TextView>(R.id.nome_lista)//texto da lista
        val deleteButton: Button? = itemView.findViewById<Button>(R.id.delete_button)
        val addButton: Button? = itemView.findViewById<Button>(R.id.add_items)
        val copyButton: Button? = itemView.findViewById<Button>(R.id.copy_button)
    }//representa cada um dos itens que vai ser visualizado dentro da RV


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaAdapter.ListaViewHolder {    //
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val view_lista = inflater.inflate(R.layout.lista_ver, parent, false)



        return ListaViewHolder(view_lista)
    }

    override fun getItemCount(): Int {
        return listas.size
    }

    override fun onBindViewHolder(
        @NonNull viewHolder: ListaAdapter.ListaViewHolder,
        position: Int
    ) {

        // val nome= "hello"
        //val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView!!.text = listas[position].get_nome()
        val deletebutton = viewHolder.deleteButton
        val copybutton = viewHolder.copyButton
        val addbutton = viewHolder.addButton
        textView.setOnClickListener()
        {
            val intent =
                Intent(viewHolder.context!!.applicationContext, VerProdsActivity::class.java)
            val b = Bundle()
            b.putInt("position", position)
            intent.putExtras(b)
            viewHolder.context!!.startActivity(intent)
        }
        deletebutton!!.setOnClickListener() {

            listas[position].get_items().forEach {
                activity.openFileInput()
            }

            listas.removeAt(position)
            activity.saveSave()
            notifyDataSetChanged()
        }
        copybutton!!.setOnClickListener() {
            if ((listas[position].get_nome() + "-Copia").length < 16) {
                var mylist: ArrayList<Item> = ArrayList()
                listas.add(
                    Lista_items(
                        listas.get(position).get_nome() + "-Copia",
                        listas.get(position).get_items()
                    )
                )
                activity.saveSave()
            }

            addbutton!!.setOnClickListener() {
                val intent = Intent(viewHolder.context, NovoProdActivity::class.java)
                val b = Bundle()
                b.putInt("position", position)
                intent.putExtras(b)
                viewHolder.context!!.startActivity(intent)
            }
            activity.saveSave()
            notifyDataSetChanged();
        }
    }
}