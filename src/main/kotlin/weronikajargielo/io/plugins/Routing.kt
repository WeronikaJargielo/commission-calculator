package weronikajargielo.io.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import weronikajargielo.io.domain.CustomerService

fun Application.configureRouting() {

    routing {
        val customerService: CustomerService = CustomerService()

        get("/") {
            val ids: String  = call.request.queryParameters["id"] ?: "ALL"
            call.respond(customerService.parseUserRequest(ids))
        }
    }
}
