package dev.janku.learning.designpatterns.creational

/**
 * Simplest form of Singleton pattern (thread-safe) (creational)
 * - ensures a single instance exists (on the JVM)
 * - use as alternative to global classes (configurations, logging, shared resource managers, ...)
 * - simple and preferred way using the 'object' keyword in Kotlin
 *
 * It gets transformed into the following Java code which is thread-safe by design
 * (static block is initialized as the class is loaded by the classloader and the INSTANCE is final):
 *
 * public final class Singleton {
 *     public static final Singleton INSTANCE;
 *
 *     private Singleton() { }  // private constructor
 *
 *     public String doSomething() {
 *         return "I'm a singleton!";
 *     }
 *
 *     static {
 *         INSTANCE = new Singleton();
 *     }
 * }
 */
object Singleton {
  fun doSomething() {
    println("Doing something")
  }
}

/**
 * Using a companion object and hiding constructor (thread-safe)
 */
class Singleton2 private constructor() {
  companion object {
    val instance: Singleton2 by lazy { Singleton2() }
  }

  fun doSomething() {
    println("Doing something")
  }
}

fun main() {
  Singleton.doSomething()
  Singleton2.instance.doSomething()
}

