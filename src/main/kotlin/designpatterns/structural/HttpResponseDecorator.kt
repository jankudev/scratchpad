package dev.janku.learning.designpatterns.structural

import java.io.ByteArrayOutputStream
import java.util.zip.GZIPOutputStream

/**
 * Showcase of the Decorator pattern (structural)
 * - use to add new functionality to an existing object and it's methods without altering its structure, via composition
 * - altering the default behavior of an object
 *
 * Example:
 * We have a simple HTTP response object which contains the response code and message.
 * We create additional decorator adding headers to the response for:
 * a) caching
 * b) compression
 */

/** The base interface for HTTP response */
interface HttpResponse {
  fun code(): Int
  fun body(): String
  fun headers(): Map<String, String>
}

/** The base implementation */
class SimpleHttpResponse(private val code: Int, private val body: String, private val headers: Map<String, String>) : HttpResponse {
  override fun code(): Int = code
  override fun body(): String = body
  override fun headers(): Map<String, String> = headers
}

/**
 * The decorator base for all HttpResponse decorators
 * @param decoratedResponse - the response to decorate
 *
 * Practically wrap a base object and delegate the calls to it.
 * Every decorator will extend this class and override the methods it needs to change typically adding some functionality
 * and calling / using the original method.
 */
abstract class HttpResponseDecorator(private val decoratedResponse: HttpResponse) : HttpResponse {
  override fun code(): Int = decoratedResponse.code()
  override fun body(): String = decoratedResponse.body()
  override fun headers(): Map<String, String> = decoratedResponse.headers()
}

/** The caching decorator - adding default Cache-Control and ETag base on content */
class CachingHttpResponseDecorator(httpResponse: HttpResponse) : HttpResponseDecorator(httpResponse) {
  private fun generateETag(content: String): String {
    return "W/\"${content.hashCode()}\""  // weak ETag with has of the body as identifier
  }

  override fun headers(): Map<String, String> {
    return super.headers() + mapOf("Cache-Control" to "max-age=3600", "ETag" to generateETag(super.body()))
  }
}

/** The compression decorator - compressing the response body and setting the correct headers */
class CompressionHttpResponseDecorator(httpResponse: HttpResponse) : HttpResponseDecorator(httpResponse) {
  private fun String.compress(): String {
    val bos = ByteArrayOutputStream()
    GZIPOutputStream(bos).use { gzip ->
      gzip.write(this.toByteArray(Charsets.UTF_8))
    }
    return String(bos.toByteArray())
  }

  override fun body(): String {
    return super.body().compress()
  }

  override fun headers(): Map<String, String> {
    return super.headers() + mapOf("Content-Encoding" to "gzip")
  }
}

fun main() {
  val response = SimpleHttpResponse(200, "Hello, world!", mapOf("Content-Type" to "text/plain"))

  // apply the decorators
  val decoratedResponse = CompressionHttpResponseDecorator(
    CachingHttpResponseDecorator(response)
  )

  // print the final response
  println("HTTP Status Code ${decoratedResponse.code()}")
  println("Headers:\n${decoratedResponse.headers()}")
  println("Body:\n${decoratedResponse.body()}")
}