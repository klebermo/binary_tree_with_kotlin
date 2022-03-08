package binary_tree

class Tree<T: Comparable<T>>(var root: Node<T>? = null) {
    fun insert(value: T) {
        if(root == null) {
            root = Node(value)
        } else {
            var aux = root
            var auxParent: Node<T>? = null

            while (aux != null) {
                if(aux.data == value) {
                    break
                }

                if(aux.data ?: value > value) {
                    auxParent = aux
                    aux = aux.left
                } else {
                    auxParent = aux
                    aux = aux.right
                }
            }

            if(aux == null) {
                aux = Node(value)
                if(auxParent?.data ?: value > value) {
                    auxParent?.left = aux
                } else {
                    auxParent?.right = aux
                }
            }
        }
    }

    fun update(old_value: T, new_value: T) {
        if(root == null) {
            return
        } else {
            var aux = root

            while (aux != null) {
                if(aux.data == old_value) {
                    aux.data = new_value
                    break
                }

                if(aux.data > old_value) {
                    aux = aux.left
                } else {
                    aux = aux.right
                }
            }
        }
    }

    fun delete(value: T) {
        if(root == null) {
            return
        } else {
            var aux = root
            var auxParent: Node<T>? = null

            while (aux != null) {
                if(aux.data == value) {
                    break
                }

                if(aux.data > value) {
                    auxParent = aux
                    aux = aux.left
                } else {
                    auxParent = aux
                    aux = aux.right
                }
            }

            if(aux?.left == null && aux?.right == null) {
                if(auxParent?.left != null && auxParent.left?.data == value) {
                    auxParent.left = null
                }

                if(auxParent?.right != null && auxParent.right?.data == value) {
                    auxParent.right = null
                }
            } else if(aux.left == null && aux.right != null) {
                if(auxParent?.left != null && auxParent.left?.data == value) {
                    auxParent.left = aux.right
                }

                if(auxParent?.right != null && auxParent.right?.data == value) {
                    auxParent.right = aux.right
                }
            } else if(aux.left != null && aux.right == null) {
                if(auxParent?.left != null && auxParent.left?.data == value) {
                    auxParent.left = aux.left
                }

                if(auxParent?.right != null && auxParent.right?.data == value) {
                    auxParent.right = aux.left
                }
            } else {
                val list = this.inOrder()
                val index = list.find(value) ?: 0
                val node = list.get(index - 1) as T
                val toDelete = list.get(index - 1) as T
                this.delete(toDelete)
                aux.data = node
            }
        }
    }

    fun preOrder(): List<T> {
        val list = List<T>()

        if(root != null) {
            list.insert(root?.data as T)
            preOrder(root?.left, list)
            preOrder(root?.right, list)
        }

        return list
    }

    fun preOrder(node: Node<T>?, list: List<T>): List<T> {
        if(node != null) {
            list.insert(node.data)
            preOrder(node.left, list)
            preOrder(node.right, list)
        }

        return list
    }

    fun inOrder(): List<T> {
        val list = List<T>()

        if(root != null) {
            inOrder(root?.left, list)
            list.insert(root?.data as T)
            inOrder(root?.right, list)
        }

        return list
    }

    fun inOrder(node: Node<T>?, list: List<T>): List<T> {
        if(node != null) {
            inOrder(node.left, list)
            list.insert(node.data)
            inOrder(node.right, list)
        }

        return list
    }

    fun postOrder(): List<T> {
        val list = List<T>()

        if(root != null) {
            postOrder(root?.left, list)
            postOrder(root?.right, list)
            list.insert(root?.data as T)
        }

        return list
    }

    fun postOrder(node: Node<T>?, list: List<T>): List<T> {
        if(node != null) {
            postOrder(node.left, list)
            postOrder(node.right, list)
            list.insert(node.data)
        }

        return list
    }
}
