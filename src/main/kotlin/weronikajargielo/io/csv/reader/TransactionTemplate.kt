package weronikajargielo.io.csv.reader

import com.fasterxml.jackson.dataformat.csv.CsvSchema
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*


data class TransactionWrapper(val transactionId: Int,
                              val transactionAmount: String,
                              val customerName: String,
                              val customerId: Int,
                              val customerSurname: String,
                              val transactionDate: String) {
    companion object {
        val csvSchema: CsvSchema = CsvSchema.builder()
                                            .addColumn("transactionId")
                                            .addColumn("transactionAmount")
                                            .addColumn("customerName")
                                            .addColumn("customerId")
                                            .addColumn("customerSurname")
                                            .addColumn("transactionDate")
                                            .build()
        val DATE_FORMAT = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")

    }

    fun getTransactionAmount(): BigDecimal = BigDecimal(transactionAmount.replace(",", "."))

    fun getTransactionDate(): Date {
        return DATE_FORMAT.parse(transactionDate)
    }

}