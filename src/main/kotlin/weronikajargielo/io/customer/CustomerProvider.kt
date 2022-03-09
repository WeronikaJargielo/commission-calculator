package weronikajargielo.io.customer


import weronikajargielo.io.csv.reader.TransactionWrapper
import weronikajargielo.io.csv.reader.readCsvFile

class CustomerProvider(transactionsCsvPath: String) {

    val customers: MutableMap<Int, Customer> = HashMap()
    init {
        loadCustomersFromFile(transactionsCsvPath)
    }

    fun findCustoomerById(id: Int): Customer? {
        return customers[id]
    }

    fun getAllCustomers(): List<Customer> {
        return customers.values
                        .toList()
    }

    private fun loadCustomersFromFile(transactionsCsvPath: String) {
        val transactions: List<TransactionWrapper> = readCsvFile(transactionsCsvPath,
                                                                 TransactionWrapper.csvSchema)

        transactions.forEach{ transactionW ->
            val transaction: Transaction = Transaction(transactionW.transactionId,
                                                       transactionW.getTransactionAmount(),
                                                       transactionW.getTransactionDate())
            val customerId: Int = transactionW.customerId
            if (customerId !in customers.keys) {
                val customer: Customer = Customer(customerId,
                                                  transactionW.customerName,
                                                  transactionW.customerSurname,
                                                  mutableListOf(transaction))
                customer.addTransaction(transaction)
                customers[customerId] = customer
            } else {
                customers[customerId]?.addTransaction(transaction)
            }
        }
    }
}

