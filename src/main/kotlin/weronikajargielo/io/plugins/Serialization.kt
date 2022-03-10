package weronikajargielo.io.plugins

import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.jackson.*
import com.fasterxml.jackson.databind.*
import io.ktor.application.*


fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
            }
        jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
    }
}
