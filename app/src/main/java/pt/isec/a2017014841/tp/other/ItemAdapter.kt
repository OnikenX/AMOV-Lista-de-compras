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
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.data.classes.Lista_items
import pt.isec.a2017014841.tp.data.db.entidades.Lista


class ItemAdapter(private val listas: ArrayList<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val name = itemView.findViewById<TextView>(R.id.nome_item)

    }//representa cada um dos itens que vai ser visualizado dentro da RV


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {    //
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val view_lista = inflater.inflate(R.layout.items_ver, parent, false)



        return ItemViewHolder(view_lista)
    }

    override fun getItemCount(): Int {
        return listas.size
    }

    override fun onBindViewHolder(@NonNull viewHolder: ItemAdapter.ItemViewHolder, position: Int) {

        /* val nome= "hello"
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
                listas.add(Lista_items(listas.get(position).get_nome()+"-Copia",mylist))
            }

            notifyDataSetChanged();
        }*/

        // button.isEnabled = false
        // button.text = "dildo_baggins"
        //button.isEnabled = contact.isOnline
/*
        viewHolder.itemView.apply{
            rvtextView.text = listas[position].nome
        }*/
    }
}