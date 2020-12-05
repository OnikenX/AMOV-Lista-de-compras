package pt.isec.a2017014841.tp.UI

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_novo_prod.*
import pt.isec.a2017014841.tp.R


class NovoProdActivity : AppCompatActivity() {

    val RESULT_LOAD_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_prod)
        //val intent = Intent(Intent.ACTION_PICK)
        //intent.setType("image/*")
        //startActivityForResult(intent, 10)
        //id -> id do pedido startActivityForREsult
        add_photo.setOnClickListener() {
            selectImage(this);
        }

    }

    private fun selectImage(context: Context) {
        val options = arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose your profile picture")
        builder.setItems(options) { dialog, item ->
            if (options[item] == "Take Photo") {
                val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePicture, 0)
            } else if (options[item] == "Choose from Gallery") {
                val pickPhoto = Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                )
                startActivityForResult(pickPhoto, 1)
            } else if (options[item] == "Cancel") {
                dialog.dismiss()
            }
        }
        builder.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
            when (requestCode) {
                0 -> if (resultCode == RESULT_OK && data != null) {
                    val selectedImage = data.extras!!["data"] as Bitmap?
                    add_photo.setImageBitmap(selectedImage)
                }
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
                            add_photo.setImageBitmap(BitmapFactory.decodeFile(picturePath))
                            cursor.close()
                        }
                    }
                }
            }
        }
    }
}

//        add_photo.setOnClickListener {
//
//            val items = arrayOf<CharSequence>(
//                getString(R.string.take_photo), getString(R.string.choose_from_gallery), getString(
//                    R.string.cancel
//                )
//            )
//            val REQUEST_CAMERA = 1
//            val SELECT_FILE = 2
//            var intentchoose : Intent
//            // build alert dialog
//            val dialogBuilder = AlertDialog.Builder(this)
//                .setTitle(getString(R.string.how_to_photo))
//                .setItems(items) { dialog, item ->
//                    run{
//                        Log.wtf("WTF", "IS GOING ON")
//                        when {
//                            items[item] == getString(R.string.take_photo) -> {
//                                intentchoose = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                                startActivityForResult(intent, REQUEST_CAMERA)
//                            }
//                            items[item] == getString(R.string.choose_from_gallery) -> {
//                                try {
//                                    val i = Intent(
//                                        Intent.ACTION_PICK,
//                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//                                    )
//                                    startActivityForResult(i, RESULT_LOAD_IMAGE)
//                                } catch (exp: Exception) {
//                                    Log.i("Error", exp.toString())
//                                }
//                            }
//                            items[item] == getString(R.string.cancel) -> {
//                                dialog.dismiss()
//                            }
//                        }
//                    }
//                }
//                .show()
//
//        }
//
//
//    }
//
//    //exemplo de onde guardar a photo ou buscar
//    fun getPhoto() {
//        val filePath = Environment.getExternalStorageDirectory().getPath()+"pic.img"
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
//            val fileUri = Uri.fromFile(File(filePath))
//            putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
//        }
//        startActivityForResult(intent, 20)
//    }
//
//
//    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            val selectedImage = data.data
//            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
//            val cursor: Cursor? = getContentResolver().query(
//                selectedImage!!,
//                filePathColumn, null, null, null
//            )
//            cursor.moveToFirst()
//            val columnIndex: Int = cursor.getColumnIndex(filePathColumn[0])
//            val picturePath: String = cursor.getString(columnIndex)
//            cursor.close()
//            try {
//                bmp = getBitmapFromUri(selectedImage)
//            } catch (e: IOException) {
//                // TODO Auto-generated catch block
//                e.printStackTrace()
//            }
//            image_view.setImageBitmap(bmp)
//
//            //to know about the selected image width and height
//            Toast.makeText(
//                this@NovoProdActivity,
//                image_view.getDrawable().getIntrinsicWidth()
//                    .toString() + " & " + image_view.getDrawable().getIntrinsicHeight(),
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }


