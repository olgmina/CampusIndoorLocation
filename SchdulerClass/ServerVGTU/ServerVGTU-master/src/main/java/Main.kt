import dataLayer.DatabaseUpdater
import dataLayer.DatabaseVGTU
import logger.Logger
import server.Server

const val TAG = "MAIN"

fun main(args: Array<String>) {
    try {
        Logger.log(TAG, "SERVER STARTING")
        DatabaseVGTU.createSchema()
        Logger.log(TAG, "DATABASE SCHEME CREATE/UPDATE")
        Server.start()
        Logger.log(TAG, "SERVER STARTED")
        DatabaseUpdater.start()
        Logger.log(TAG, "DATABASE UPDATE STARTED")
    } catch (e: Exception) {
        Logger.e(TAG, e)
        e.printStackTrace()
    }
}






