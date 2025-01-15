package dev.janku.learning.basics

/**
 * Representing a "Tree" structure (binary for simplicity)
 */
class BinaryTreeNode<T>(
  val value: T,
  var left: BinaryTreeNode<T>?,
  var right: BinaryTreeNode<T>?
)

class TreeNode<T>(
  val value: T,
  val children: MutableList<TreeNode<T>> = mutableListOf()
)

