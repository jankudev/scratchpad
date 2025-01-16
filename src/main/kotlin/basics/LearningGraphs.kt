package dev.janku.learning.basics

/* Various graph representations */

/**
 * Representing a "Graph" structure by a list of nodes and their neighbours
 * - to transform into weighted graph use Pair<T, Int> instead of T
 * - for example use @see basics.LearningGraphsTest
 */
abstract class AdjacencyGraph<T> {
  protected val adjacencyMap = mutableMapOf<T, MutableList<T>>()

  fun addVertex(vertex: T) {
    adjacencyMap[vertex] = mutableListOf()
  }

  abstract fun addEdge(from: T, to: T)

  fun getVertices(): List<T> {
    return adjacencyMap.keys.toList()
  }

  fun getVertexNeighbours(node: T): List<T> {
    return adjacencyMap[node] ?: emptyList()
  }
}

class OrientedAdjacencyGraph<T> : AdjacencyGraph<T>() {
  override fun addEdge(from: T, to: T) {
    if (!adjacencyMap.containsKey(from)) throw NoSuchElementException("Node from: ${from} not found")
    if (!adjacencyMap.containsKey(to)) throw NoSuchElementException("Node to: ${to} not found")

    adjacencyMap[from]?.add(to)
  }
}

class NonOrientedAdjacencyGraph<T> : AdjacencyGraph<T>() {
  override fun addEdge(from: T, to: T) {
    if (!adjacencyMap.containsKey(from)) throw NoSuchElementException("Node from: ${from} not found")
    if (!adjacencyMap.containsKey(to)) throw NoSuchElementException("Node to: ${to} not found")

    adjacencyMap[from]?.add(to)
    adjacencyMap[to]?.add(from)
  }
}

/**
 * Representing a weighted "Edge" for a graph with vertices of generic type T
 */
class Edge<T> (
  val from: T,
  val to: T,
  val weight: Int
)

/**
 * A graph representation by vertices of type T and a list of edges between them
 * - for example use @see basics.LearningGraphsTest
 */
class Graph<T> {
  private val vertices = mutableSetOf<T>()
  private val edges = mutableListOf<Edge<T>>()

  fun addVertex(vertex: T) {
    vertices.add(vertex)
  }

  fun addEdge(from: T, to: T, weight: Int) {
    if (from !in vertices) throw IllegalArgumentException("Vertex from: ${from} not found")
    if (to !in vertices) throw IllegalArgumentException("Vertex to: ${to} not found")
    edges.add(Edge(from, to, weight))
  }

  fun getOutgoingEdgex(vertex: T) : List<Edge<T>> {
    return edges.filter { it.from == vertex }
  }

  fun getVertices(): Set<T> {
    return vertices.toSet()
  }
}

