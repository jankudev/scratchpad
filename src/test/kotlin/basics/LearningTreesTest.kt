package basics

import dev.janku.learning.basics.BinaryTreeNode
import dev.janku.learning.basics.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

/**
 * Testing the representation of a "Tree" structure
 * - assertion checking by post-order BFS traversal
 */
class LearningTreesTest {

  @Test
  fun `binary tree - testing the representation`() {
    /*
         1
        / \
       2   3
      / \  /
      4  5 6
    */
    val rootNode = BinaryTreeNode(
      1,
      BinaryTreeNode(
        2,
        BinaryTreeNode(4, null, null),
        BinaryTreeNode(5, null, null)
      ),
      BinaryTreeNode(
        3,
        BinaryTreeNode(6, null, null),
        null
      )
    )

    // assertion using BFS traverse
    val result = mutableListOf<Int>()
    val queue = mutableListOf<BinaryTreeNode<Int>>(rootNode)
    while (queue.isNotEmpty()) {
      val node = queue.removeFirst()
      result.add(node.value)
      node.left?.let { queue.add(it) }
      node.right?.let { queue.add(it) }
    }

    assertContentEquals(listOf(1, 2, 3, 4, 5, 6), result)
  }

  @Test
  fun `n-ary tree - testing the representation`() {
    /*

            1
          /   \
         2     3
       / | \   |
      4  5  6  7

     */
    val rootNode = TreeNode(
      1,
      mutableListOf(
        TreeNode(
          2,
          mutableListOf(
            TreeNode(4),
            TreeNode(5),
            TreeNode(6)
          )
        ),
        TreeNode(3, mutableListOf(TreeNode(7)))
      )
    )

    // assertion using BFS traverse
    val result = mutableListOf<Int>()
    val queue = mutableListOf<TreeNode<Int>>(rootNode)
    while (queue.isNotEmpty()) {
      val node = queue.removeFirst()
      result.add(node.value)
      queue.addAll(node.children)
    }

    assertContentEquals(listOf(1, 2, 3, 4, 5, 6, 7), result)
  }
}