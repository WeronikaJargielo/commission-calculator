package weronikajargielo.io.data

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import java.math.BigDecimal
import java.util.*


data class TransactionRecord(
    @CsvBindByName(column = "transaction_id")
    var transactionId: Int? = null,

    @CsvBindByName(column = "transaction_amount", locale = "pl-PL")
    var transactionAmount: BigDecimal? = null,

    @CsvBindByName(column = "customer_first_name")
    var customerName: String? = null,

    @CsvBindByName(column = "customer_id")
    var customerId: Int? = null,

    @CsvBindByName(column = "customer_last_name")
    var customerSurname: String? = null,

    @CsvBindByName(column = "transaction_date")
    @CsvDate("dd.MM.yyyy HH:mm:ss")
    var transactionDate: Date? = null
)


data class CommissionPercentage(
    @CsvBindByName(column = "transaction_value_less_than", locale = "pl-PL")
    var transactionValueThreshold: BigDecimal = BigDecimal(0),

    @CsvBindByName(column = "fee_percentage_of_transaction_value", locale = "pl-PL")
    var feePercentage: BigDecimal = BigDecimal(0)
)