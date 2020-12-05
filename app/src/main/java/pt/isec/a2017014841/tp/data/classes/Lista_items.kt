package pt.isec.a2017014841.tp.data.classes

class Lista_items (private var nome: String, private var lista :ArrayList<Item>){

    fun get_nome():String
{
    return nome;
}
    fun get_items():ArrayList<Item>
    {
        return lista
    }
}