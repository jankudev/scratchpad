package dev.janku.learning.designpatterns

/**
 * Showcase of the Factory design pattern
 * - the factory should be a Singleton, that's why we use object
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