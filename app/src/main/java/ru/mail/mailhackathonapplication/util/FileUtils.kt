package ru.mail.mailhackathonapplication.util

import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import java.io.File

object FileUtils {

    fun getPhotosNameList(): Array<out String>? = File(Environment.getExternalStorageDirectory().absolutePath)
            .list { _, name -> name?.matches("re_[0-9]+.jpg".toRegex()) ?: false }

    fun getVideosNameList(): Array<out String>? = File(Environment.getExternalStorageDirectory().absolutePath)
            .list { _, name ->  name?.matches("re_[0-9]+.mp4".toRegex()) ?: false }

    fun deleteFile(fileName: String) = File("${Environment.getExternalStorageDirectory().absolutePath}/$fileName").delete()

    fun getFile(fileName: String) = File("${Environment.getExternalStorageDirectory().absolutePath}/$fileName")

    fun getFilePathInString(fileName: String) = "${Environment.getExternalStorageDirectory().absolutePath}/$fileName"




}