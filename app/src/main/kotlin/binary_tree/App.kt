package binary_tree

fun main() {
    val tree = Tree<Int>()

    tree.insert(25)
    tree.insert(32)
    tree.insert(12)
    tree.insert(17)
    tree.insert(44)
    tree.insert(107)
    tree.insert(440)
    tree.insert(23)
    tree.insert(33)
    tree.insert(10)

    tree.preOrder().print()

    tree.inOrder().print()

    tree.postOrder().print()

    println("---")

    tree.update(17, 22)
    tree.update(440, 386)

    tree.preOrder().print()

    tree.inOrder().print()

    tree.postOrder().print()

    println("---")

    tree.delete(23)
    tree.delete(32)
    tree.delete(12)

    tree.preOrder().print()

    tree.inOrder().print()

    tree.postOrder().print()
}
