package weronikajargielo.io.csv.reader

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.FileReader

val csvMapper = CsvMapper().apply { registerModule(KotlinModule()) }

inline fun <reified T> readCsvFile(fileName: String, schema: CsvSchema): List<T> {
    FileReader(fileName).use { reader ->
        return csvMapper.readerFor(T::class.java)
                        .with(schema.withHeader())
                        .readValues<T>(reader)
                        .readAll()
                        .toList()
    }
}
