package weronikajargielo.io.database


import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import weronikajargielo.io.model.RequestLog

class RequestLogger {

    private val client = KMongo.createClient("mongodb://localhost:27017")
    private val database = client.getDatabase("request_logs")
    private val collection = database.getCollection<RequestLog>()

    fun logRequests(requestLogs: List<RequestLog>) {
        collection.insertMany(requestLogs)
    }
}