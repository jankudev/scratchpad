package algorithms

import dev.janku.learning.algorithms.BinaryTreeTraversal
import dev.janku.learning.basics.BinaryTreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SampleTrees {
  companion object {
    val SINGLE_NODE_INT_TREE = BinaryTreeNode(1, null, null)

    val SIMPLE_INT_TREE = BinaryTreeNode(1, BinaryTreeNode(2, null, null), BinaryTreeNode(3, null, null))
    val SIMPLE_STRING_TREE = BinaryTreeNode("hello", BinaryTreeNode("Peter", null, null), BinaryTreeNode("world", null, null))

    val TREE_INT = BinaryTreeNode(1,
      BinaryTreeNode(2,
        BinaryTreeNode(4, null, null),
        BinaryTreeNode(5, null, null)
      ),
      BinaryTreeNode(3,
        BinaryTreeNode(6, null, null),
        null)
    )
  }
}

class BinaryTreeTraversalTest_BFS {

  @Test
  fun `BFS - single node tree - 10x the number op`() {
    val result = BinaryTreeTraversal.bfs(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })

    assertEquals(1, result.size)
    assertEquals(1, result[0].first)
    assertEquals(10, result[0].second)
  }

  @Test
  fun `BFS - full tree - no op`() {
    val result = BinaryTreeTraversal.bfs(SampleTrees.SIMPLE_INT_TREE, {})

    assertEquals(3, result.size)
    assertEquals(1, result[0].first)
    assertEquals(2, result[1].first)
    assertEquals(3, result[2].first)
  }

  @Test
  fun `BFS - full tree - count chars in words`() {
    val result = BinaryTreeTraversal.bfs(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size })

    assertEquals(3, result.size)
    assertEquals(listOf("hello", "Peter", "world"), result.map { it.first })
    assertTrue(result.all { it.second == it.first.length })
  }

  @Test
  fun `BFS - partial tree - 10x the number`() {
    val result = BinaryTreeTraversal.bfs(SampleTrees.TREE_INT, { it * 10 })

    assertEquals(6, result.size)
    assertContentEquals(listOf(1, 2, 3, 4, 5, 6), result.map { it.first })
    assertContentEquals(listOf(10, 20, 30, 40, 50, 60), result.map { it.second })
  }
}

class BinaryTreeTraversalTest_DFS_inOrder {

}

class BinaryTreeTraversalTest_DFS_preOrder {

}

class BinaryTreeTraversalTest_DFS_postOrder {

}
