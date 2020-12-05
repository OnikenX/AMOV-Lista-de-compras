package pt.isec.a2017014841.tp.other

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.show_listas.view.*
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.data.db.entidades.Lista


class ListaAdapter(private val listas: ArrayList<String>): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {
    inner class ListaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val nameTextView = itemView.findViewById<TextView>(R.id.nome_lista)//texto da lista
        val messageButton = itemView.findViewById<Button>(R.id.message_button)
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

    override fun onBindViewHolder(@NonNull viewHolder: ListaAdapter.ListaViewHolder, position: Int) {

       val nome= "hello"
        //val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.text = "dildo"
        val button = viewHolder.messageButton
       // button.isEnabled = false
       // button.text = "dildo_baggins"
        //button.isEnabled = contact.isOnline
/*
        viewHolder.itemView.apply{
            rvtextView.text = listas[position].nome
        }*/
    }
}