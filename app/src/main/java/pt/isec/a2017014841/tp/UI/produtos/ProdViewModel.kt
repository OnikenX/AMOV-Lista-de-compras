package pt.isec.a2017014841.tp.UI.produtos

import android.view.KeyEvent
import androidx.lifecycle.ViewModel
import pt.isec.a2017014841.tp.data.db.entidades.Produto
import pt.isec.a2017014841.tp.data.repositorios.ProdRepositorio
import kotlin.coroutines.CoroutineScope
import kotlin.coroutines.Dispatchers
import kotlin.coroutines.launch

class ProdViewModel(
    private val repositorio: ProdRepositorio
): ViewModel(){
    fun upsert(item: Produto) = CoroutineScope(Dispatchers.Main).launch{
        repositorio.upsert(item)
    }

    fun delete(item: Produto) = CoroutineScope(Dispatchers.Main).launch{
        repositorio.delete(item)
    }

    fun getAllProdutos() = repositorio.getAllProdutos()
}