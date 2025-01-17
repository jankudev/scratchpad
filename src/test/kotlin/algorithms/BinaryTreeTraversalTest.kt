package algorithms

import dev.janku.learning.algorithms.BinaryTreeTraversal
import dev.janku.learning.basics.BinaryTreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SampleTrees {
  companion object {
    /** Single node tree with an integer value */
    val SINGLE_NODE_INT_TREE = BinaryTreeNode(1, null, null)

    /** Simple 3-node balanced tree with integers */
    val SIMPLE_INT_TREE = BinaryTreeNode(1, BinaryTreeNode(2, null, null), BinaryTreeNode(3, null, null))
    /** Simple 3-node balanced tree with strings */
    val SIMPLE_STRING_TREE = BinaryTreeNode("hello", BinaryTreeNode("Peter", null, null), BinaryTreeNode("world", null, null))

    /** A more complex tree with a right degraded and longer branch */
    val TREE_INT = BinaryTreeNode(1,
      BinaryTreeNode(2,
        BinaryTreeNode(4, null, null),
        BinaryTreeNode(5, null, null)
      ),
      BinaryTreeNode(3,
        null,
        BinaryTreeNode(6, null, BinaryTreeNode(7, null, null))
      )
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

    assertEquals(7, result.size)
    assertContentEquals(listOf(1, 2, 3, 4, 5, 6, 7), result.map { it.first })
    assertContentEquals(listOf(10, 20, 30, 40, 50, 60, 70), result.map { it.second })
  }

}

class BinaryTreeTraversalTest_DFS_inOrder {
  @Test
  fun `DFS in-order - single node tree - 10x the number op`() {
    val result = BinaryTreeTraversal.dfsInOrder(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })

    assertEquals(1, result.size)
    assertEquals(1, result[0].first)
    assertEquals(10, result[0].second)

    val resultRecursive = BinaryTreeTraversal.dfsInOrderRecursive(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS in-order - full tree - no op`() {
    val result = BinaryTreeTraversal.dfsInOrder(SampleTrees.SIMPLE_INT_TREE, {})

    assertEquals(3, result.size)
    assertEquals(2, result[0].first)
    assertEquals(1, result[1].first)
    assertEquals(3, result[2].first)

    val resultRecursive = BinaryTreeTraversal.dfsInOrderRecursive(SampleTrees.SIMPLE_INT_TREE, {} )
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS in-order - full tree - count chars in words`() {
    val result = BinaryTreeTraversal.dfsInOrder(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size })

    assertEquals(3, result.size)
    assertEquals(listOf("Peter", "hello", "world"), result.map { it.first })
    assertTrue(result.all { it.second == it.first.length })

    val resultRecursive = BinaryTreeTraversal.dfsInOrderRecursive(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size } )
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS in-order - partial tree - 10x the number`() {
    val result = BinaryTreeTraversal.dfsInOrder(SampleTrees.TREE_INT, { it * 10 })

    assertEquals(7, result.size)
    assertContentEquals(listOf(4, 2, 5, 1, 3, 6, 7), result.map { it.first })
    assertContentEquals(listOf(40,20, 50, 10, 30, 60, 70), result.map { it.second })

    val resultRecursive = BinaryTreeTraversal.dfsInOrderRecursive(SampleTrees.TREE_INT, { it * 10 } )
    assertContentEquals(result, resultRecursive)
  }
}

class BinaryTreeTraversalTest_DFS_preOrder {
  @Test
  fun `DFS pre-order - single node tree - 10x the number op`() {
    val result = BinaryTreeTraversal.dfsPreOrder(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })

    assertEquals(1, result.size)
    assertEquals(1, result[0].first)
    assertEquals(10, result[0].second)

    val resultRecursive = BinaryTreeTraversal.dfsPreOrderRecursive(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS pre-order - full tree - no op`() {
    val result = BinaryTreeTraversal.dfsPreOrder(SampleTrees.SIMPLE_INT_TREE, {})

    assertEquals(3, result.size)
    assertEquals(1, result[0].first)
    assertEquals(2, result[1].first)
    assertEquals(3, result[2].first)

    val resultRecursive = BinaryTreeTraversal.dfsPreOrderRecursive(SampleTrees.SIMPLE_INT_TREE, {} )
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS pre-order - full tree - count chars in words`() {
    val result = BinaryTreeTraversal.dfsPreOrder(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size })

    assertEquals(3, result.size)
    assertEquals(listOf("hello", "Peter", "world"), result.map { it.first })
    assertTrue(result.all { it.second == it.first.length })

    val resultRecursive = BinaryTreeTraversal.dfsPreOrderRecursive(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size } )
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS pre-order - partial tree - 10x the number`() {
    val result = BinaryTreeTraversal.dfsPreOrder(SampleTrees.TREE_INT, { it * 10 })

    assertEquals(7, result.size)
    assertContentEquals(listOf(1, 2, 4, 5, 3, 6, 7), result.map { it.first })
    assertContentEquals(listOf(10,20, 40, 50, 30, 60, 70), result.map { it.second })

    val resultRecursive = BinaryTreeTraversal.dfsPreOrderRecursive(SampleTrees.TREE_INT, { it * 10 } )
    assertContentEquals(result, resultRecursive)
  }
}

class BinaryTreeTraversalTest_DFS_postOrder {
  @Test
  fun `DFS post-order - single node tree - 10x the number op`() {
    val result = BinaryTreeTraversal.dfsPostOrder(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })

    assertEquals(1, result.size)
    assertEquals(1, result[0].first)
    assertEquals(10, result[0].second)

    val resultRecursive = BinaryTreeTraversal.dfsPostOrderRecursive(SampleTrees.SINGLE_NODE_INT_TREE, { it * 10 })
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS post-order - full tree - no op`() {
    val result = BinaryTreeTraversal.dfsPostOrder(SampleTrees.SIMPLE_INT_TREE, {})

    assertEquals(3, result.size)
    assertEquals(2, result[0].first)
    assertEquals(3, result[1].first)
    assertEquals(1, result[2].first)

    val resultRecursive = BinaryTreeTraversal.dfsPostOrderRecursive(SampleTrees.SIMPLE_INT_TREE, {} )
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS post-order - full tree - count chars in words`() {
    val result = BinaryTreeTraversal.dfsPostOrder(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size })

    assertEquals(3, result.size)
    assertEquals(listOf("Peter", "world", "hello"), result.map { it.first })
    assertTrue(result.all { it.second == it.first.length })

    val resultRecursive = BinaryTreeTraversal.dfsPostOrderRecursive(SampleTrees.SIMPLE_STRING_TREE, { it.toCharArray().size } )
    assertContentEquals(result, resultRecursive)
  }

  @Test
  fun `DFS post-order - partial tree - 10x the number`() {
    val result = BinaryTreeTraversal.dfsPostOrder(SampleTrees.TREE_INT, { it * 10 })

    assertEquals(7, result.size)
    assertContentEquals(listOf(4, 5, 2, 7, 6, 3, 1), result.map { it.first })
    assertContentEquals(listOf(40, 50, 20, 70, 60, 30, 10), result.map { it.second })

    val resultRecursive = BinaryTreeTraversal.dfsPostOrderRecursive(SampleTrees.TREE_INT, { it * 10 } )
    assertContentEquals(result, resultRecursive)
  }
}
