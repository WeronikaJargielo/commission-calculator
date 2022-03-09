package weronikajargielo.io.comission.calculation

import weronikajargielo.io.csv.reader.FeeWagesWrapper
import weronikajargielo.io.csv.reader.readCsvFile
import java.math.BigDecimal

class ComissionPercentageProvider(feeWagesCSVPath: String) {
    private val commissionPercentages: MutableList<CommissionPercentage> = mutableListOf()

    init {
        loadCommissionPercentagesFromFile(feeWagesCSVPath)
    }

//    fun findFeePercentage(totalTransactionAmount: BigDecimal): BigDecimal {
//
//    }

    private fun loadCommissionPercentagesFromFile(feeWagesCSVPath: String) {
        val feeWages: List<FeeWagesWrapper> = readCsvFile(feeWagesCSVPath,
                                                          FeeWagesWrapper.csvSchema)

        feeWages.forEach {
            commissionPercentages.add(
                CommissionPercentage(BigDecimal(it.transactionValueThreshold),
                                     BigDecimal(it.feePercentage))
            )
        }
        feeWages.sortedBy { it.transactionValueThreshold }
    }

}