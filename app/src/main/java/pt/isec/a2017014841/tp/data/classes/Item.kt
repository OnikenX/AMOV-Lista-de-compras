package pt.isec.a2017014841.tp.data.classes

import android.graphics.Bitmap
import java.util.*



class Item(private var nome:String, private var marca:String, private var categoria:String, private var validade:Date, private var quantidade :String, private var bitmap : Bitmap)  {
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
    fun get_val():Date
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
    fun set_marca(marca:String)
    {
        this.marca=marca
    }
    fun set_quantidade(quantidade:String)
    {
        this.quantidade=quantidade
    }
    fun set_validade(vali:Date)
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
}