# Kotlin learning

This repository (branch in scratchpad repository) is a collection of Kotlin code snippets and exercises I'm using to
prepare for my coding interview at Splunk AppDynamics and possibly any other job interview as I'm transitioning back
from a managerial role to software engineering to regain hands-on team delivery (in order to later focus on technical
excellence and delivery coaching based on [LeSS](https://less.works/) and DX/SDLC based
on [DORA research](https://dora.dev/)).

I'm publishing this repository as it might serve someone else in a similar situation or someone who wants to learn
Kotlin.

## Resources

Listing my favorite resources to learn Kotlin in order of preference:

1. [Kotlin Primer](https://www.kotlinprimer.com/) - A free online transition guide from Java to Kotlin created by the
   Kotlin Server Squad community based on their practical experience of moving from Java to Kotlin in their enterprises.
   Real step-by-step guide focussing not only on syntax but also on the language design aspects and considering
   practical aspects of such migrations. Best of the best!
2. [From Objectsr to Functions](https://pragprog.com/titles/uboop/from-objects-to-functions/) - A great book with code
   in Kotlin explaining the approach to writing real applications in functional ways (declarative) rather than the
   classical object-oriented and procedural ways (imperative). The power of data transformations, immutability,
   pipelines and more is explained step-by-step with practical examples and exercises to embrace the power of this
   approach. Avoid errors and complexity by choosing an alternative approach.
3. [Kotlin Reference](https://kotlinlang.org/) - The language official documentation and reference guide.
4. [Grokking Algorithms, 2nd edition](https://www.manning.com/books/grokking-algorithms-second-edition) - Refreshing
   algorithms and basic data structures with Big-O complexity analysis.

## Learning themes (my personal approach in this repository)

I'm using the full advantage of JetBrains IntelliJ IDEA IDE to learn Kotlin (great support, created by the company
behind the language).

In addition I'm taking full advantage of Github CoPilot in the IDE (including Github CoPilot Chat to have contextual
conversations) and Anthropic Claude AI (with a custom-setup Kotlin language and computer-science mentor).

The list of themes I'm learning in Kotlin are:

### The basic data structures

- [x] [Arrays](src/main/kotlin/basics/LearningArrays.kt) and [Lists](src/main/kotlin/basics/LearningLists.kt)
- [x] [Hashmaps and Sets](src/main/kotlin/basics/LearningHashtables.kt)
- [x] representing [Trees](src/main/kotlin/basics/LearningTrees.kt) and [Graphs](src/main/kotlin/basics/LearningGraphs.kt)
- [x] representing [Stacks and Queues](src/main/kotlin/basics/LearningStackQueues.kt)
- [ ] representing Heaps

### Algorithmic patterns and techniques

- [x] [Binary Search](src/main/kotlin/algorithms/BinarySearch.kt)
- [ ] Sliding Window
- [x] Two Pointers (f.e. with Binary Search, Bubble Sort, ...)
- [ ] Fast and Slow pointers
- [ ] Merge Intervals
- [ ] Cyclic Sort
- [ ] In-place Reversal of Linked List
- [x] [Tree Breadth First Search](src/main/kotlin/algorithms/BinaryTreeTraversal.kt)
- [x] [Tree Depth First Search](src/main/kotlin/algorithms/BinaryTreeTraversal.kt) - pre-order, in-order, post-order both iterative and recursive
- [ ] Subsets
- [x] [Modified Binary Search](src/main/kotlin/problems/binarysearch)
- [ ] Bitwise XOR
- [ ] Top 'K' Elements
- [ ] K-way merge
- [ ] 0/1 Knapsack
- [ ] Topological Sort
- [ ] Two Heaps
- [ ] Graph Traversal and Shortest Path
- [ ] Matrix Island
- [ ] Greedy Algorithms
- [ ] Dynamic Programming
- [ ] Recursion and Backtracking

### Design patterns

#### Creational patterns
- [x] [Singleton](src/main/kotlin/designpatterns/creational/Singleton.kt) - requiring single instance (alternative to global)
- [x] [Factory](src/main/kotlin/designpatterns/creational/DbFactory.kt) - creation based on type determined at runtime (hiding creation logic)
- [x] [Builder](src/main/kotlin/designpatterns/creational/UrlBuilder.kt) - creation of complex objects with multiple steps (optional/required/default parameters)

#### Structural patterns
- [x] [Adapter](src/main/kotlin/designpatterns/structural/PaymentAdapter.kt) - adapting an interface to another interface for compatibility
- [x] [Decorator](src/main/kotlin/designpatterns/structural/PaymentAdapter.kt) - adding behavior to objects dynamically or modifying the original behavior
- [x] [Proxy]() - controlling access to object functionality

#### Behavioral patterns
- 

### Sorting algorithms

- [ ] Bubble Sort
- [x] [Merge Sort](src/main/kotlin/algorithms/SortingAlgorithms.kt) - basic and in-place implementations
- [ ] Quick Sort

### Concurrency and Thread-safety
TBD