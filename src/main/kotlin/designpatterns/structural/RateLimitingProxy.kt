package dev.janku.learning.designpatterns.structural

import kotlin.math.absoluteValue
import kotlin.random.Random

/** Showcase of the Proxy pattern (structural)
 * - use to control access to an object
 * - use to add additional functionality to an object
 *
 * In practice the proxy is like a decorator only it's used typically for controlling access to the object.
 *
 * Example:
 * We have a service providing a costly functionality (infrastructure costs).
 * We want to protect the service against overuse by a rate-limit and returning a cached response once the per-second.
 * limit is reached.
 */

/** The interface for the costly service */
interface CostlyService {
  fun call(): String
}

/** A dummy implementation of the costly service */
class CostlyServiceImpl : CostlyService {
  override fun call(): String {
    val result = Random.nextLong().absoluteValue
    Thread.sleep(result % 500)
    return "The result is ${result}"
  }
}

/** The rate-limiting and caching proxy */
class CachingHttpClientProxy(private val costlyService: CostlyService) : CostlyService {
  companion object {
    const val RATE_LIMIT = 750
  }

  private var lastCall: Long = 0
  private var cachedResponse: String? = null

  override fun call(): String {
    val now = System.currentTimeMillis()
    if (now - lastCall < RATE_LIMIT) {
      return "Cached: $cachedResponse"
    }

    lastCall = now
    cachedResponse = costlyService.call()
    return cachedResponse!!
  }
}

fun main() {
  val service: CostlyService = CachingHttpClientProxy(CostlyServiceImpl())

  repeat(10) {
    println(service.call())
    Thread.sleep(100L)
  }
}