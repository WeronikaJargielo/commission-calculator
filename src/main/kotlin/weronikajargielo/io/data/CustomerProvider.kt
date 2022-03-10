package weronikajargielo.io.data

import weronikajargielo.io.model.Customer

class CustomerProvider {
    private val transactionCsvPath: String = "src/main/resources/data/transactions.csv"
    private val customers: MutableMap<Int, Customer> = loadCustomersFromFile(transactionCsvPath)

    fun findCustomerById(customerId: Int): Customer? = customers[customerId]
    fun getAllCustomers(): MutableList<Customer> = customers.values.toMutableList()
}