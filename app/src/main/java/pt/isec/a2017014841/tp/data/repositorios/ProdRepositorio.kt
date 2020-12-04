package pt.isec.a2017014841.tp.data.repositorios
import pt.isec.a2017014841.tp.data.db.*
import pt.isec.a2017014841.tp.data.db.DB
import pt.isec.a2017014841.tp.data.db.entidades.Produto

class ProdRepositorio(
    private val db: DB
) {
    suspend fun upsert(item: Produto) = db.ProdDao().upsert(item)

    suspend fun delete(item: Produto) = db.ProdDao().delete(item)

    fun getAllProdutos() = db.ProdDao().getAllProducts()
}