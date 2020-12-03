package pt.isec.a2017014841.tp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pt.isec.a2017014841.tp.data.db.entidades.Lista
import pt.isec.a2017014841.tp.data.db.entidades.Produto

@Database(
    entities = arrayOf(Produto::class,Lista::class),
    version = 1
)
abstract class DB : RoomDatabase(){
    abstract fun ListaDao():ListaDao
    abstract fun ProdDao():ProdDao

    companion object{
        @Volatile
        private var instance: DB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance
                    ?: createDatabase(
                        context
                    )
                        .also{ instance =it}
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                DB::class.java, "DB.db").build()
    }
}

/*
@Database(
    entities = [Produto::class],
    version = 1
)
abstract class ProdDB: RoomDatabase() {
    abstract fun getProdDao(): ProdDao

    companion object{
        @Volatile
        private var instance: ProdDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance
                    ?: createDatabase(
                        context
                    )
                        .also{ instance =it}
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ProdDB::class.java, "ProdDB.db").build()
    }
}*/