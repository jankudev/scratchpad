package dev.janku.learning.algorithms

import dev.janku.learning.basics.BinaryTreeNode

/**
 * Implementation of binary tree traversal algorithms in Kotlin
 * - BFS - breadth-first search
 * - DFS - depth-first search
 *
 * For the DFS we have 3 types based on when the node is processed in relation to its children:
 * - in-order = left, node, right (easy recursively, harder iteratively - additional current pointer)
 * - pre-order = node, left, right (easy recursively and iteratively)
 * - post-order = left, right, node (easy recursively, hard to do iteratively - additional current and lastVisited pointers)
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

    /**
     * DFS in-order traversal algorithm (left, node, right) using recursion (implicit stack)
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> dfsInOrderRecursive(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {
      val result = mutableListOf<Pair<T, S>>()

      fun dfsInOrderRecursive_internal(node: BinaryTreeNode<T>, op: (T)->S, res: MutableList<Pair<T, S>>) {
        if (node.left != null) dfsInOrderRecursive_internal(node.left!!, op, res)
        result.add(Pair(node.value, operation(node.value)))
        if (node.right != null) dfsInOrderRecursive_internal(node.right!!, op, res)
      }

      dfsInOrderRecursive_internal(root, operation, result)
      return result
    }

    /**
     * DFS in-order traversal algorithm (left, node, right) using stack
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> dfsInOrder(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {

      val result = mutableListOf<Pair<T, S>>()

      // stack to keep track of the nodes
      val stack = mutableListOf<BinaryTreeNode<T>>()
      // additional pointer to the current processed node so we know where we're in the processing
      // (always going as deep left as possible with current being the node processed and if no more left then go 1-step right of current)
      var current: BinaryTreeNode<T>? = root

      // loop until we've processed all nodes
      while (current != null || stack.isNotEmpty()) {

        // traverse to the leftmost node filling the stack
        while (current != null) {
          stack.add(current)
          current = current.left
        }

        // nothing left of current node, process current node and check right side
        current = stack.removeLast()
        result.add(Pair(current.value, operation(current.value)))
        current = current.right
      }

      return result
    }

    /**
     * DFS pre-order traversal algorithm (node, left, right) using recursion (implicit stack)
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> dfsPreOrderRecursive(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {
      val result = mutableListOf<Pair<T, S>>()

      fun dfsPreOrderRecursive_internal(node: BinaryTreeNode<T>, op: (T)->S, res: MutableList<Pair<T, S>>) {
        result.add(Pair(node.value, operation(node.value)))
        if (node.left != null) dfsPreOrderRecursive_internal(node.left!!, op, res)
        if (node.right != null) dfsPreOrderRecursive_internal(node.right!!, op, res)
      }

      dfsPreOrderRecursive_internal(root, operation, result)
      return result
    }

    /**
     * DFS pre-order traversal algorithm (node, left, right) using stack
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> dfsPreOrder(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {

      val result = mutableListOf<Pair<T, S>>()

      // stack to keep track of the nodes
      val stack = mutableListOf<BinaryTreeNode<T>>()

      // loop until we've processed all nodes
      stack.add(root)
      while (stack.isNotEmpty()) {

        val current = stack.removeLast()

        // nothing left of current node, process current node and check right side
        result.add(Pair(current.value, operation(current.value)))
        current.right?.let { stack.add(it) }
        current.left?.let { stack.add(it) }
      }

      return result
    }

    /**
     * DFS pre-order traversal algorithm (left, right, node) using recursion (implicit stack)
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> dfsPostOrderRecursive(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {
      val result = mutableListOf<Pair<T, S>>()

      fun dfsPostOrderRecursive_internal(node: BinaryTreeNode<T>, op: (T)->S, res: MutableList<Pair<T, S>>) {
        if (node.left != null) dfsPostOrderRecursive_internal(node.left!!, op, res)
        if (node.right != null) dfsPostOrderRecursive_internal(node.right!!, op, res)
        result.add(Pair(node.value, operation(node.value)))
      }

      dfsPostOrderRecursive_internal(root, operation, result)
      return result
    }

    /**
     * DFS post-order traversal algorithm (left, right, node) using stack
     * @param T         generic type of the value in the tree node
     * @param S         generic type of the return value of the applied operation
     * @param root      the root of the binary tree
     * @param operation the operation to be applied to the value of each node, aggregating the results
     * @return list of pairs of the node value and the result of the operation applied
     */
    fun <T, S> dfsPostOrder(root: BinaryTreeNode<T>, operation: (T)->S): List<Pair<T, S>> {

      val result = mutableListOf<Pair<T, S>>()

      // stack to keep track of the nodes
      val stack = mutableListOf<BinaryTreeNode<T>>()
      // additional pointer to the current processed node so we know where we're in the processing
      // (always going as deep left as possible with current being the node processed and if no more left then go 1-step right of current)
      var current: BinaryTreeNode<T>? = root
      // additional pointer tracking the last visited node to know when to process the current node (when returning from right side)
      var lastVisited: BinaryTreeNode<T>? = null

      // loop until we've processed all nodes
      while (current != null || stack.isNotEmpty()) {
        // traverse to the leftmost node filling the stack
        while (current != null) {
          stack.add(current)
          current = current.left
        }

        // peek at the top of the stack
        val topOfStack = stack.last()

        // if right child exists move to right side and iterate on right subtree, otherwise process the current node
        if (topOfStack.right != null && topOfStack.right != lastVisited) {
          current = topOfStack.right
        } else {
          result.add(Pair(topOfStack.value, operation(topOfStack.value)))
          lastVisited = stack.removeLast()
        }
      }

      return result
    }
  }

}