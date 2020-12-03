package pt.isec.a2017014841.tp.data.repositorios

import pt.isec.a2017014841.tp.data.db.ProdDB
import pt.isec.a2017014841.tp.data.db.entidades.Produto

class ProdRepositorio(
    private val db: ProdDB
) {
    suspend fun upsert(item: Produto) = db.getProdDao().upsert(item)

    suspend fun delete(item: Produto) = db.getProdDao().delete(item)

    fun getAllProdutos() = db.getProdDao().getAllProducts()
}