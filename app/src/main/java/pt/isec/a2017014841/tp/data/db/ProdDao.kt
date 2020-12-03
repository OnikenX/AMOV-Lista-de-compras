package pt.isec.a2017014841.tp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import pt.isec.a2017014841.tp.data.db.entidades.Produto

@Dao
interface ProdDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Produto)

    @Delete
    suspend fun delete(item: Produto)

    @Query("SELECT * FROM produto")
    fun getAllProducts(): LiveData<List<Produto>>

}