package pt.isec.a2017014841.tp.UI

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import pt.isec.a2017014841.tp.data.classes.Lista_items
import pt.isec.a2017014841.tp.other.bytesToObject
import pt.isec.a2017014841.tp.other.objectToBytes
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList

open class AppCompatActivitySaveFile : AppCompatActivity() {
    protected var listas: ArrayList<Lista_items>? = null
    private val saveFileNome = "listas.save"
    open override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        loadSave()
    }

    public fun loadSave() {
        Log.i("DEBUG", "going through the sub class")
        if (listas == null) {
            try {
                val input: FileInputStream = openFileInput(saveFileNome)
                listas = bytesToObject(input.readBytes()) as ArrayList<Lista_items>
                input.close()
                Log.i("SaveFile", "File loaded")
            } catch (ex: FileNotFoundException) {
                listas = ArrayList()
                AlertDialog.Builder(this).setTitle("Save curronpido, a criar um novo...")
                saveSave()
                Log.i("SaveFile", "File could not be loaded")
            } catch (ex: TypeCastException) {//se der erro criar um novo
                listas = ArrayList()
                AlertDialog.Builder(this).setTitle("Save curronpido, a criar um novo...")
                saveSave()
                Log.i("SaveFile", "File could not be loaded")
            }
        }
    }

    fun saveSave() {

        try {
            val output: FileOutputStream = openFileOutput(saveFileNome, MODE_PRIVATE)
            if (listas != null)
                output.write(objectToBytes(listas!!))
            Log.i("SaveFile", "File saved")
        } catch (e: NullPointerException) {
            e.printStackTrace()
            listas = ArrayList()
            AlertDialog.Builder(this).setTitle("Save curronpido, a criar um novo...")
                .setCancelable(true)
                .show()
            saveSave()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        saveSave()
    }
}
