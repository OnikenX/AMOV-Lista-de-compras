package pt.isec.a2017014841.tp.data.classes

import java.io.Serializable

class Lista_items(private var nome: String, private var lista: ArrayList<Item>) : Serializable{
    fun get_nome(): String {return nome;}
    fun get_items(): ArrayList<Item> {return lista}
}