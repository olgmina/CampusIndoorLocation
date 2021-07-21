package logger

import java.io.File
import java.lang.Exception
import java.util.*
import java.io.PrintWriter
import java.io.StringWriter



object Logger {
    private val logFile = File("LOG.txt")

    init {
        logFile.appendText("______________________START________________________\n")
    }

    fun log(tag: String, message: String) {
        logFile.appendText(
                "${Calendar.getInstance().time} $tag: $message \n"
        )
    }

    fun e(tag:String,exception: Exception){
        val sw = StringWriter()
        exception.printStackTrace(PrintWriter(sw))
        log(tag, " !!ERROR!!: $sw")
    }
}