package weronikajargielo.io.data

import com.opencsv.bean.CsvToBeanBuilder
import weronikajargielo.io.model.Customer
import weronikajargielo.io.model.Transaction
import java.io.BufferedReader
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths


fun loadCustomersFromFile(transactionsCsvPath: String): MutableMap<Int, Customer> {
    val customers: MutableMap<Int, Customer> = HashMap()
    val transactions: List<TransactionRecord> = readCsvFile(transactionsCsvPath)

    transactions.forEach{ transaction ->
        val customerId: Int = transaction.customerId!!
        val signeTransaction: Transaction = Transaction(transaction.transactionId!!,
                                                        transaction.transactionAmount!!,
                                                        transaction.transactionDate!!)
        if (customerId !in customers.keys) {
            val customer: Customer = Customer(customerId,
                                              transaction.customerName!!,
                                              transaction.customerSurname!!,
                                              mutableListOf())
            customer.addTransaction(signeTransaction)
            customers[customerId] = customer
        } else {
            customers[customerId]!!.addTransaction(signeTransaction)
        }
    }
    return customers
}

fun loadCommissionPercentagesFromFile(feeWagesCSVPath: String): List<CommissionPercentage> {
    val commissionPercentages: List<CommissionPercentage> = readCsvFile(feeWagesCSVPath)
    commissionPercentages.sortedBy { it.transactionValueThreshold }

    return commissionPercentages
}

 private inline fun <reified T> readCsvFile(path: String): List<T> {
    val fileReader: BufferedReader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8)
    fileReader.use {
        return CsvToBeanBuilder<T>(fileReader)
            .withType(T::class.java)
            .withSeparator(',')
            .withIgnoreQuotations(false)
            .build()
            .parse()
    }
}
