package pt.isec.a2017014841.tp.UI

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_novo_prod.*
import pt.isec.a2017014841.tp.R
import pt.isec.a2017014841.tp.data.classes.Item
import pt.isec.a2017014841.tp.other.askForPermission
import pt.isec.a2017014841.tp.other.hasReadPermission
import java.io.Serializable
import kotlin.math.min


class NovoProdActivity : AppCompatActivity() {
    var bitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_prod)
        if (bitmap == null) {
            if (savedInstanceState != null)
                bitmap = savedInstanceState.getParcelable("photo")
            else {
                Toast.makeText(this, "estava null lol", Toast.LENGTH_SHORT).show();
                val conf = Bitmap.Config.ARGB_8888 // see other conf types
                bitmap = Bitmap.createBitmap(20, 20, conf) // this creates a MUTABLE bitmap
            }
        }
        photo.setImageBitmap(bitmap)
        // ready to draw on that bitmap through that canvas
        add_photo.setOnClickListener() {
            selectImage(this)
        }

        adicionaprod.setOnClickListener(){
            val item = Item(nomeprod.toString(), marcaprod.toString(), categoryprod.toString(), validprod, , , n_items.toString(), bitmap!!  )
            val intent = intent
            intent.putExtra("new_item",  Serializable.item)
        }
    }

    private fun selectImage(context: Context) {
        val options = arrayOf<CharSequence>(
            getString(R.string.take_photo),
            getString(R.string.choose_from_gallery),
            getString(R.string.cancel)
        )
        val builder = AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.how_to_photo))
        builder.setItems(options) { dialog, item ->
            if (options[item] == getString(R.string.take_photo)) {
                val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePicture, 0)
            } else if (options[item] == getString(R.string.choose_from_gallery)) {
                if (hasReadPermission(this)) {
                    val pickPhoto = Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                    startActivityForResult(pickPhoto, 1)
                } else {
                    askForPermission(this);
                    if (hasReadPermission(this)) {
                        AlertDialog.Builder(this)
                            .setTitle(getString(R.string.cant_access_gallery))
                            .setCancelable(true)
                            .show()
                    }

                }
            } else if (options[item] == getString(R.string.cancel)) {
                dialog.dismiss()
            }
        }
        builder.show()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
            when (requestCode) {
                //get from camera
                0 -> if (resultCode == RESULT_OK && data != null) {
                    val selectedImage = data.extras!!["data"] as Bitmap?
                    bitmap = selectedImage
                    photo.setImageBitmap(bitmap)
                }
                //get from gallery
                1 -> if (resultCode == RESULT_OK && data != null) {
                    val selectedImage: Uri? = data.data
                    val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                    if (selectedImage != null) {
                        val cursor: Cursor? = contentResolver.query(
                            selectedImage,
                            filePathColumn, null, null, null
                        )
                        if (cursor != null) {
                            cursor.moveToFirst()
                            val columnIndex: Int = cursor.getColumnIndex(filePathColumn[0])
                            val picturePath: String = cursor.getString(columnIndex)
                            setPic(photo, picturePath)
                            //photo.setImageBitmap(BitmapFactory.decodeFile(picturePath))
                            cursor.close()
                        }
                    }
                }
            }
        }
    }

    fun setPic(view: View, path: String) {
        val targetW = view.width
        val targetH = view.height
        if (targetH < 1 || targetW < 1)
            return
        val bmpOptions = BitmapFactory.Options()
        bmpOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(path, bmpOptions)
        val photoW = bmpOptions.outWidth
        val photoH = bmpOptions.outHeight
        val scale = min(photoW / targetW, photoH / targetH)
        bmpOptions.inSampleSize = scale
        bmpOptions.inJustDecodeBounds = false
        bitmap = BitmapFactory.decodeFile(path, bmpOptions)
        when {
            view is ImageView -> (view as ImageView).setImageBitmap(bitmap)
            //else -> view.background = bitmap.toDrawable(view.resources)
            else -> view.background = BitmapDrawable(view.resources, bitmap)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //salvar a imagem
        outState.putParcelable("photo", bitmap)
    }

}