package weronikajargielo.io.comission.calculation

import java.math.BigDecimal

data class CommissionCalculator(val feeWagesCsvPath: String) {
    private val commissionPercentageProvider: ComissionPercentageProvider = ComissionPercentageProvider(feeWagesCsvPath)


}