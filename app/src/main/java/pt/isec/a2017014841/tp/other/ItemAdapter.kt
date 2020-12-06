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



class ItemAdapter(private val listas: ArrayList<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val name = itemView.findViewById<TextView>(R.id.nome_item)
        val quantidade = itemView.findViewById<TextView>(R.id.quantidade)
        val marca = itemView.findViewById<TextView>(R.id.marca_item)
        val preco = itemView.findViewById<TextView>(R.id.preco)

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
        viewHolder.name.text=listas.get(position).get_nome()
        viewHolder.marca.text=listas.get(position).get_marca()
        viewHolder.preco.text=listas.get(position).get_preco()
        viewHolder.quantidade.text=listas.get(position).get_quant()

    }
}