package com.example.app.db

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.*
import com.example.app.db.table.Posts

object DBConnection: DB {
    val db = Database.connect(
            url = "jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;",
            driver = "org.h2.Driver",
            user = "root",
            password = ""
    )

    init {
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Posts)
        }
    }
}