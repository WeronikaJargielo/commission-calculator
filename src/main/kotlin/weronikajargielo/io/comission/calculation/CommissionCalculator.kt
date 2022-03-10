package weronikajargielo.io.comission.calculation


import weronikajargielo.io.data.CommissionPercentageProvider
import java.math.BigDecimal
import java.math.RoundingMode

class CommissionCalculator(
    private val commissionPercentageProvider: CommissionPercentageProvider = CommissionPercentageProvider()
) {

    fun calculateCommission(totalTransactionAmount: BigDecimal): BigDecimal {
        val percentageToRatioScaleFactor: Int = -2
        val decimalPlaces: Int = 2
        val feeRatio: BigDecimal = commissionPercentageProvider.findFeePercentage(totalTransactionAmount)
                                                               .scaleByPowerOfTen(percentageToRatioScaleFactor)
        return totalTransactionAmount.multiply(feeRatio).setScale(decimalPlaces, RoundingMode.HALF_UP)
    }
}

