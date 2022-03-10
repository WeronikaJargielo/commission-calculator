package weronikajargielo.io

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import weronikajargielo.io.domain.CustomerService

fun Route.customerRouting() {

    val customerService: CustomerService = CustomerService()

    get("/") {
        val ids: String  = call.request.queryParameters["id"] ?: "ALL"
        call.respond(customerService.parseUserRequest(ids))
    }
}