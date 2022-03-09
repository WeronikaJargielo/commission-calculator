package weronikajargielo.io.customer

import java.math.BigDecimal
import java.util.*

data class Customer(val id: Int,
                    val name: String,
                    val surname: String,
                    val transactions: MutableList<Transaction>
) {
    private var totalTransactionsAmount:BigDecimal = BigDecimal.ZERO
    private var lastTransactionDate: Date = Date(0)

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
        totalTransactionsAmount = totalTransactionsAmount.add(transaction.amount)
        if (lastTransactionDate < transaction.date) {
            lastTransactionDate = transaction.date
        }
    }

    fun getTransactionsCount(): Int = transactions.size
    fun getLastTransactionDate(): Date = lastTransactionDate
    fun getTotalTransactionAmunt(): BigDecimal = totalTransactionsAmount
}