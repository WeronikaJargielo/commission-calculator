package weronikajargielo.io.data

import java.math.BigDecimal


class CommissionPercentageProvider() {
    private val feeWagesCsvPath: String = "src/main/resources/data/fee_wages.csv"
    private val commissionPercentages: List<CommissionPercentage> = loadCommissionPercentagesFromFile(feeWagesCsvPath)

    fun findFeePercentage(totalTransactionAmount: BigDecimal): BigDecimal {
        val threshold = commissionPercentages.firstOrNull{totalTransactionAmount < it.transactionValueThreshold}
        return threshold?.feePercentage ?: CommissionPercentage().feePercentage
    }

}