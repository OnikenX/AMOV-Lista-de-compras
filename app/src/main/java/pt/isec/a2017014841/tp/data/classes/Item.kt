package pt.isec.a2017014841.tp.data.classes

import android.graphics.Bitmap
import java.io.Serializable
import java.util.*



class Item(private var nome:String, private var marca:String, private var categoria:String, private var validade:String?, private var quantidade: String,private var preco: String, private var notas: String, private var bitmap: Bitmap?) : Serializable {
    fun get_marca():String
    {
        return marca
    }
    fun get_bitmap():Bitmap?{
        return bitmap
    }
    fun get_cat():String
    {
        return categoria
    }
    fun get_val():String?
    {
        return validade
    }
    fun get_quant():String
    {
        return quantidade
    }
    fun get_nome():String
    {
        return nome
    }
    fun get_preco():String
    {
        return preco;
    }
    fun get_notas():String
    {
        return notas
    }
    fun set_marca(marca:String)
    {
        this.marca=marca
    }
    fun set_quantidade(quantidade:String)
    {
        this.quantidade=quantidade
    }
    fun set_validade(vali:String)
    {
        this.validade=vali
    }
    fun set_nome(nome:String)
    {
        this.nome=nome
    }
    fun set_categoria(cat:String)
    {
        this.categoria=cat
    }
    fun set_preco(preco:String)
    {
        this.preco=preco
    }
    fun set_notas(notas: String){
        this.notas=notas
    }
    override fun toString(): String {
        return "Item(nome='$nome', marca='$marca', categoria='$categoria', validade='$validade', quantidade='$quantidade', bitmap=$bitmap)"
    }

}