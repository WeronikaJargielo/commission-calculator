package weronikajargielo.io.model

import java.math.BigDecimal
import java.util.Date
import kotlinx.serialization.Serializable

@Serializable
data class ResponseEntry(
    val firstName: String,
    val lastName: String,
    val customerId: Int,
    val numberOfPerformedTransactions: Int,
    val totalTransactionAmount: BigDecimal,
    val calculatedCommission: BigDecimal,
    val lastTransactionDate: Date
)