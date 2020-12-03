package pt.isec.a2017014841.tp.data.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lista")
data class Lista (
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name="nome")
    var nome: String
)