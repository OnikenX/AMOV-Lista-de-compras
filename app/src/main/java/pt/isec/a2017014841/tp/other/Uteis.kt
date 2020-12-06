package pt.isec.a2017014841.tp.other

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.min


fun hasReadPermission(context : Context) : Boolean{
    return ActivityCompat.checkSelfPermission(
            context,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
}
const val REQUEST_READ_PERMISSION = 3;
fun askForPermission(activity : Activity){
    ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE) , REQUEST_READ_PERMISSION);
}





/**
 * Vai buscar uma imagem de forma que nao ocupe muito espaço na memoria
 */
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
    val bitmap = BitmapFactory.decodeFile(path, bmpOptions)
    when {
        view is ImageView -> (view as ImageView).setImageBitmap(bitmap)
//else -> view.background = bitmap.toDrawable(view.resources)
        else -> view.background = BitmapDrawable(view.resources,bitmap)
    }
}

//@SuppressLint("SimpleDateFormat")
//@Throws(IOException::class)
//private fun createImageFile(context: Context, currentPhotoPath: String): File {
//    // Create an image file name
//    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//    val storageDir: File = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
//    return File.createTempFile(
//        "JPEG_${timeStamp}_", /* prefix */
//        ".jpg", /* suffix */
//        storageDir /* directory */
//    ).apply {
//        // Save a file: path for use with ACTION_VIEW intents
//        //currentPhotoPath = absolutePath
//    }
//}


fun objectToBytes(`object`: Any): ByteArray? {
    val bStream = ByteArrayOutputStream()
    val oo: ObjectOutput
    try {
        oo = ObjectOutputStream(bStream)
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
    try {
        oo.writeObject(`object`)
        oo.flush()
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
    try {
        oo.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    val resposta: ByteArray = bStream.toByteArray()
    try {
        bStream.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return resposta
}

fun bytesToObject(bytes: ByteArray): Any? {
    val iStream: ObjectInputStream
    try {
        iStream = ObjectInputStream(ByteArrayInputStream(bytes))
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
    val `object`: Any
    `object` = try {
        iStream.readObject()
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    } catch (e: ClassNotFoundException) {
        e.printStackTrace()
        return null
    }
    try {
        iStream.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return `object`
}
