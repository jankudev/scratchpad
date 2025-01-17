package dev.janku.learning.algorithms

import dev.janku.learning.basics.BinaryTreeNode

/**
 * Implementation of binary tree traversal algorithms in Kotlin
 * - BFS - breadth-first search
 * - DFS - depth-first search
 *
 * For the DFS we have 3 types based on when the node is processed in relation to its children:
 * - in-order = left, node, right
 * - pre-order = node, left, right
 * - post-order = left, right, node
 *
 * Although recursion can be used we implement the iterative approach using a stack/queue.
 *
 * Practical applications:
 * - BFS - shortest paths, level-order tree operations, nearest neighbour
 * - DFS (in-order) - binary search trees, expression trees, backtracking
 * - DFS (pre-order) - copying tree, serializing, prefix expression evaluation (printing dir structure)
 * - DFS (post-order) - deleting tree, postfix expression evaluation (garbage collection, calc directory sizes (calc child before parent))
 */
class BinaryTreeTraversal {

  companion object {
    /**
     * Breadth-first search (BFS) algorithm
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> bfs(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {

      val queue = mutableListOf(root)
      val result = mutableListOf<Pair<T, S>>()

      while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        val opResult = operation(node.value)
        result.add(Pair(node.value, opResult))

        if (node.left != null) queue.add(node.left!!)
        if (node.right != null) queue.add(node.right!!)
      }

      return result
    }
  }

}