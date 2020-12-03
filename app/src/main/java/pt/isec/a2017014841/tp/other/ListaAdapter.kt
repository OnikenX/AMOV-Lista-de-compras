package pt.isec.a2017014841.tp.other

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.show_listas.view.*
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.data.db.entidades.Lista


class ListaAdapter(
    var listas: List<Lista>
): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {
    inner class ListaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  //representa cada um dos itens que vai ser visualizado dentro da RV

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {    //
        val view = LayoutInflater.from(parent.context).inflate(R.layout.show_listas,parent,false)
        return ListaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listas.size
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.itemView.apply{
            rvtextView.text = listas[position].nome
        }
    }
}