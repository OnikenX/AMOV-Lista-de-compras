package pt.isec.a2017014841.tp.data.db.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produto")
data class Produto(
    var name: String,
    var marca: String,
    var preco: Int,
    var validade: String,
    var numItens: Int,
    var notas: String,
    var categoria: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

