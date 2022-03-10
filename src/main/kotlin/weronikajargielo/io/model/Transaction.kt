package weronikajargielo.io.model

import java.math.BigDecimal
import java.util.*

data class Transaction(val id: Int,
                       val amount: BigDecimal,
                       val date: Date)