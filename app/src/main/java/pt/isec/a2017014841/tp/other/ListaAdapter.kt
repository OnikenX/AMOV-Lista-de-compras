package pt.isec.a2017014841.tp.other

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.UI.MainActivity
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.data.classes.Lista_items


class ListaAdapter(private val listas: ArrayList<Lista_items>): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {
    inner class ListaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val nameTextView = itemView.findViewById<TextView>(R.id.nome_lista)//texto da lista
        val deleteButton = itemView.findViewById<Button>(R.id.delete_button)
        val addButton = itemView.findViewById<Button>(R.id.add_items)
        val copyButton=  itemView.findViewById<Button>(R.id.copy_button)
    }//representa cada um dos itens que vai ser visualizado dentro da RV


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAdapter.ListaViewHolder {    //
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val view_lista = inflater.inflate(R.layout.lista_ver, parent, false)



        return ListaViewHolder(view_lista)
    }

    override fun getItemCount(): Int {
        return listas.size
    }

    @Override fun onClick(view: View?) {
        val intent = Intent(view!!.context, MainActivity::class.java)
        //intent.putExtras(b)
        //startActivity(intent)
    }
    override fun onBindViewHolder(@NonNull viewHolder: ListaAdapter.ListaViewHolder, position: Int) {

      // val nome= "hello"
        //val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.text = listas.get(position).get_nome()
        val deletebutton = viewHolder.deleteButton
        val copybutton=viewHolder.copyButton
        val addbutton =viewHolder.addButton
        deletebutton.setOnClickListener() {
            listas.removeAt(position)
            notifyDataSetChanged();
        }
        copybutton.setOnClickListener() {
            if((listas.get(position).get_nome()+"-Copia").length<16)
            {
                var mylist: ArrayList<Item> = ArrayList()
                listas.add(Lista_items(listas.get(position).get_nome() + "-Copia", mylist))
            }

            notifyDataSetChanged();
        }

       // button.isEnabled = false
       // button.text = "dildo_baggins"
        //button.isEnabled = contact.isOnline
/*
        viewHolder.itemView.apply{
            rvtextView.text = listas[position].nome
        }*/
    }
}