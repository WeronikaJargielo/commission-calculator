package weronikajargielo.io.model

import java.math.BigDecimal
import java.util.*


data class RequestLog(
    val customerId: Int,
    val calculatedCommission: BigDecimal,
    val commissionCalculationDate: Date
)
