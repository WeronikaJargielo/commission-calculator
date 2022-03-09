package weronikajargielo.io

import weronikajargielo.io.customer.CustomerProvider

data class Customer(val id: Int)

fun main() {
    val path: String = "/Users/werka/Desktop/commision-calculator/src/main/resources/transactions.csv"

    val cp: CustomerProvider = CustomerProvider(path)
    println(cp.getAllCustomers())
//    val c: Customer = Customer(1, "lala")
//    println(cp.customers.size)
//    var schema2: CsvSchema = csvMapper
//        .typedSchemaFor(TransactionWrapper::class.java)
//        .withHeader().withColumnReordering(false)
//
//    println(schema)
//        val schema: CsvSchema = CsvSchema.builder()
//        .addColumn("transactionId")
//        .addColumn("transactionAmount")
//        .addColumn("customerName")
//        .addColumn("customerId")
//        .addColumn("customerSurname")
//        .addColumn("transactionDate")
//        .build()
//    println(schema)

//    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
//        configureRouting()
//        configureSerialization()
//        configureSecurity()
//    }.start(wait = true)
}



//val schema:CsvSchema = CsvSchema.builder()
//                                .addColumn("id")
////                                .addColumn("y")
////                                .addColumn("visible")
//                                .build()
//


