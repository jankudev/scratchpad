package dev.janku.learning.designpatterns.creational

/**
 * Showcase of the Factory design pattern (creational)
 * - the factory should be a Singleton, that's why we use object
 * - basic principle: delegate the creation of objects to a factory, which is responsible for creating objects of a specific type
 *   (enum of types, conditional logic based on input type in the factory method)
 * - use when hiding the creation logic from the client
 * - use when the concrete type of object we need is determined at runtime (so we can conditionally delegate the creation)
 */
object DbFactory {

  enum class DbType {
    MYSQL, POSTGRESQL, ORACLE
  }

  interface DbConnection

  class MySqlConnection : DbConnection {
    init {
      println("MySQL connection created")
    }
  }

  class PostgreSqlConnection : DbConnection {
    init {
      println("PostgreSQL connection created")
    }
  }

  class OracleConnection : DbConnection {
    init {
      println("Oracle connection created")
    }
  }

  fun createDbConnection(dbType: DbType): DbConnection {
    return when (dbType) {
      DbType.MYSQL -> MySqlConnection()
      DbType.POSTGRESQL -> PostgreSqlConnection()
      DbType.ORACLE -> OracleConnection()
    }
  }
}

fun main() {
  val dbConnection = DbFactory.createDbConnection(DbFactory.DbType.MYSQL)
}