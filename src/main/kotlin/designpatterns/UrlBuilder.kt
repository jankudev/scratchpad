package dev.janku.learning.designpatterns

import java.net.ProtocolFamily

/**
 * Showcase of the Builder pattern
 */
class Url (
  val protocol: Protocol,
  val username: String,
  val password: String,
  val host: String,
  val port: Int,
  val path: String,
) {

  enum class Protocol {
    HTTP, HTTPS
  }

  data class Builder(
    var protocol: Protocol = Protocol.HTTPS,
    var username: String = "",
    var password: String = "",
    var host: String = "",
    var port: Int = 80,
    var path: String = "",
  ) {
    fun protocol(protocol: Protocol) = apply { this.protocol = protocol }
    fun username(username: String) = apply { this.username = username }
    fun password(password: String) = apply { this.password = password }
    fun host(host: String) = apply { this.host = host }
    fun port(port: Int) = apply { this.port = port }
    fun path(path: String) = apply { this.path = path }

    fun build() : Url {
      require(host.isNotEmpty()) { "Host is required" }
      if (password.isNotEmpty()) {
        require(username.isNotEmpty() && password.isNotEmpty()) { "Both username and password are required" }
      }
      return Url(protocol, username, password, host, port, path)
    }
  }

  override fun toString(): String {
    val url = StringBuilder(protocol.name.lowercase())
    url.append("://")
    if (username.isNotEmpty()) {
      url.append(username)
      if (password.isNotEmpty()) {
        url.append(":").append(password)
      }
      url.append("@")
    }
    url.append(host).append(":").append(port).append("/").append(path)

    return url.toString()
  }
}

fun main() {
  val url = Url.Builder()
    .protocol(Url.Protocol.HTTP)
    .username("user")
    .password("pass")
    .host("example.com")
    .port(8080)
    .path("api/v1")
    .build()

  println(url)
}