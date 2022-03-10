package weronikajargielo.io

import com.example.plugins.configureSerialization
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

import weronikajargielo.io.plugins.configureRouting

fun main(){

    embeddedServer(Netty, port = 8082, host = "0.0.0.0") {
        install(CallLogging)
        configureRouting()
        configureSerialization()
    }.start(wait = true)

}



