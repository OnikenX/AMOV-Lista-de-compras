package pt.isec.a2017014841.tp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pt.isec.a2017014841.tp.data.db.entidades.Lista

@Dao
interface ListaDao {
    @Insert()
    fun insert(lista: Lista)

    @Query("select * from Lista")
    fun getAllListas():List<Lista>
}