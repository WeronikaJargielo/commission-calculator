package weronikajargielo.io.csv.reader

import com.fasterxml.jackson.dataformat.csv.CsvSchema


data class FeeWagesWrapper(val transactionValueThreshold: String,
                           val feePercentage: String) {
    companion object {
        val csvSchema: CsvSchema = CsvSchema.builder()
                                                    .addColumn("transactionValueThreshold")
                                                    .addColumn("feePercentage")
                                                    .build()
    }

    fun formatTransactionValueThreshold() = transactionValueThreshold.replace(",", ".")

    fun formatFeePercentage() = feePercentage.replace(",", ".")
}

