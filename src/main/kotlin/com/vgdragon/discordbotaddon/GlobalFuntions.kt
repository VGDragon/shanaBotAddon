package com.vgdragon.discordbot.discord

import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.*
import javax.imageio.ImageIO
import javax.net.ssl.HttpsURLConnection

fun waitUntil(time: Date){
    while (time.time > System.currentTimeMillis()){
        Thread.sleep(10)
    }
}
fun getImageStringURIFromURL(imageUrl: String, noImageLimit: Boolean = false): String{

    val image = try {
        val httpsURLConnection = URL(imageUrl).openConnection() as HttpsURLConnection
        httpsURLConnection.setRequestProperty("User-Agent", "DiscordBot/6.0")
        ImageIO.read(httpsURLConnection.inputStream)
    } catch (e: Exception){
        println("This is not a link.")
        return ""
    }

    val workImage =
            if ((image.height > 128 || image.width > 128) && !noImageLimit)
                image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH)
            else
                image
    val split = imageUrl.split("")
    val dataType = split[split.size - 1]
    val encodeToString = String(Base64.getEncoder().encode(toByteArray(workImage, dataType)))
    return "data:image/$dataType;base64,$encodeToString"
}
fun toByteArray(img: java.awt.Image, formatName: String): ByteArray {
    val bufferedImage =
            if (img is BufferedImage) {
                img
            } else {

                val bimage = BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_BGR)

                val bGr = bimage.createGraphics()
                bGr.drawImage(img, 0, 0, null)
                bGr.dispose()

                bimage
            }

    val byteArrayOutputStream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, formatName, byteArrayOutputStream)
    val input = ByteArrayInputStream(byteArrayOutputStream.toByteArray())

    return  input.readBytes()
}