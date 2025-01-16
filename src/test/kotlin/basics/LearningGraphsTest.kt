package basics

import dev.janku.learning.basics.AdjacencyGraph
import dev.janku.learning.basics.Graph
import dev.janku.learning.basics.NonOrientedAdjacencyGraph
import dev.janku.learning.basics.OrientedAdjacencyGraph
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LearningGraphsTest {
  @Test
  fun `graph - creating adjacency graph - oriented`() {
    val graph = OrientedAdjacencyGraph<Int>()

    graph.addVertex(1)
    graph.addVertex(2)
    graph.addVertex(3)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 1)
    graph.addEdge(3, 3)

    assertEquals(3, graph.getVertices().size)
    assertEquals(4, graph.getVertices().sumOf { graph.getVertexNeighbours(it).size })
    assertEquals(2, graph.getVertexNeighbours(1).size)
    assertEquals(1, graph.getVertexNeighbours(3).size)
  }

  @Test
  fun `graph - creating adjacency graph - non-oriented`() {
    val graph = NonOrientedAdjacencyGraph<Int>()

    graph.addVertex(1)
    graph.addVertex(2)
    graph.addVertex(3)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)
    graph.addEdge(3, 1)

    assertEquals(3, graph.getVertices().size)
    assertEquals(3, graph.getVertices().sumOf { graph.getVertexNeighbours(it).size } / 2)
    assertEquals(2, graph.getVertexNeighbours(1).size)
    assertEquals(2, graph.getVertexNeighbours(1).size)
    assertEquals(2, graph.getVertexNeighbours(3).size)
  }

  @Test
  fun `graph - creating a graph using the vertices and Edge representation`() {
    val graph = Graph<String>()
    graph.addVertex("Tomas")
    graph.addVertex("Jane")
    graph.addVertex("Peter")
    graph.addEdge("Tomas", "Jane", 10)
    graph.addEdge("Tomas", "Peter", 20)

    assertEquals(3, graph.getVertices().size)
    assertEquals(2, graph.getOutgoingEdgex("Tomas").size)
    assertTrue(graph.getOutgoingEdgex("Jane").isEmpty())
    assertTrue(graph.getOutgoingEdgex("Peter").isEmpty())
    assertEquals(30, graph.getOutgoingEdgex("Tomas").sumOf { it.weight })
  }
}