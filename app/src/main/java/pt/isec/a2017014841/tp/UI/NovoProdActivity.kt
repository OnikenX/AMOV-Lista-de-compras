package pt.isec.a2017014841.tp.UI

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_novo_prod.*
import pt.isec.a2017014841.tp.R
import java.io.File


class NovoProdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_prod)
        val intent = Intent(Intent.ACTION_PICK)
        intent.setType("image/*")
        startActivityForResult(intent, 10)
        //id -> id do pedido startActivityForREsult

        add_photo.setOnClickListener {

            val items = arrayOf<CharSequence>(
                getString(R.string.take_photo), getString(R.string.choose_from_gallery), getString(
                    R.string.cancel
                )
            )
            val REQUEST_CAMERA = 1
            val SELECT_FILE = 2
            var intentchoose : Intent
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)
                .setTitle(getString(R.string.how_to_photo))
                .setItems(items) { dialog, item ->
                    run {
                        if (items[item] == getString(R.string.take_photo)) {
                             intentchoose = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            startActivityForResult(intent, REQUEST_CAMERA)
                        } else if (items[item] == getString(R.string.choose_from_gallery)) {
                             intentchoose = Intent(
                                Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI

                            )
                            startActivityForResult(intent, SELECT_FILE)
                        } else if (items[item] == getString(R.string.cancel)) {
                            dialog.dismiss()
                        }
                    }
                }
                .show()
        }


    }

    //exemplo de onde guardar a photo ou buscar
    fun getPhoto() {
        val filePath = Environment.getExternalStorageDirectory().getPath()+"pic.img"
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            val fileUri = Uri.fromFile(File(filePath))
            putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        }
        startActivityForResult(intent, 20)
    }
}
