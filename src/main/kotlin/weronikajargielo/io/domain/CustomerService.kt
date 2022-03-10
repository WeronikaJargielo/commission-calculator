package weronikajargielo.io.domain

import weronikajargielo.io.data.CustomerProvider
import weronikajargielo.io.comission.calculation.CommissionCalculator
import weronikajargielo.io.database.RequestLogger
import weronikajargielo.io.model.Customer
import weronikajargielo.io.model.RequestLog
import weronikajargielo.io.model.ResponseEntry
import java.math.BigDecimal
import java.util.*


class CustomerService(
    private val customerProvider: CustomerProvider = CustomerProvider(),
    private val commissionCalculator: CommissionCalculator = CommissionCalculator(),
    private val requestLogger: RequestLogger = RequestLogger()
) {

    fun parseUserRequest(requestedCustomerIds: String): List<ResponseEntry> {
        val response: List<ResponseEntry> = if (requestedCustomerIds == "ALL") {
            getResponseForAllCustomers()
        } else {
            getResponseForRequestedCustomers(requestedCustomerIds)
        }
        logRequests(response)
        return response
    }

    private fun getResponseForRequestedCustomers(requestedCustomerIds: String): List<ResponseEntry> {
        val customerIds: List<String> = requestedCustomerIds.split(",").map { it }
        val response: MutableList<ResponseEntry> = mutableListOf()

        for (id in customerIds) {
            try {
                val customerId: Int = id.toInt()
                val customer: Customer? = customerProvider.findCustomerById(customerId)
                customer?.let { response.add(createResponseEntryFromCustomer(customer)) }
            } catch (e: NumberFormatException) {
                continue
            }
        }
        return response.toList()
    }

    private fun getResponseForAllCustomers(): List<ResponseEntry> {
        val customers: MutableList<Customer> = customerProvider.getAllCustomers()
        return customers.map(::createResponseEntryFromCustomer)
    }

    private fun createResponseEntryFromCustomer(customer: Customer): ResponseEntry {
        val totalTransactionAmount: BigDecimal = customer.getTotalTransactionAmount()
        val commission: BigDecimal = commissionCalculator.calculateCommission(totalTransactionAmount)

        return ResponseEntry(customer.name,
                             customer.surname,
                             customer.id,
                             customer.getTransactionsCount(),
                             totalTransactionAmount,
                             commission,
                             customer.getLastTransactionDate())
    }

    private fun logRequests(response: List<ResponseEntry>) {
        if (response.isNotEmpty()) {
            val logs: List<RequestLog> = response.map(::createRequestLogFromResponseEntry)
            requestLogger.logRequests(logs)
        }
    }

    private fun createRequestLogFromResponseEntry(entry: ResponseEntry): RequestLog {
        return RequestLog(entry.customerId,
                          entry.calculatedCommission,
                          Date())
    }
}