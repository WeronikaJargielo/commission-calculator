package weronikajargielo.io.comission.calculation

import java.math.BigDecimal
import java.math.BigInteger

class CommissionPercentage (
        val transactionValueThreshold: BigDecimal = BigDecimal(0),
        val feePercentage: BigDecimal = BigDecimal(0)
    ): Comparable<CommissionPercentage> {

    override fun compareTo(commissionPercentage: CommissionPercentage): Int {
        return transactionValueThreshold.compareTo(commissionPercentage.transactionValueThreshold)
    }
}