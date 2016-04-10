/**
 * Created by gazolla on 10/04/16.
 */
class TreeNode<T>(value:T){
    var value:T = value

    var parent:TreeNode<T>? = null

    var children:MutableList<TreeNode<T>> = mutableListOf()


    fun addChild(node:TreeNode<T>){
        children.add(node)
        node.parent = this
    }

    override fun toString(): String {
        var s = "${value}"
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }
}

fun main(args: Array<String>) {

    val tree = TreeNode<String>( "beverages")

    val hotNode = TreeNode<String>( "hot")
    val coldNode = TreeNode<String>( "cold")

    val teaNode = TreeNode<String>( "tea")
    val coffeeNode = TreeNode<String>( "coffee")
    val chocolateNode = TreeNode<String>( "cocoa")

    val blackTeaNode = TreeNode<String>( "black")
    val greenTeaNode = TreeNode<String>( "green")
    val chaiTeaNode = TreeNode<String>( "chai")

    val sodaNode = TreeNode<String>( "soda")
    val milkNode = TreeNode<String>( "milk")

    val gingerAleNode = TreeNode<String>( "ginger ale")
    val bitterLemonNode = TreeNode<String>( "bitter lemon")

    tree.addChild(hotNode)
    tree.addChild(coldNode)

    hotNode.addChild(teaNode)
    hotNode.addChild(coffeeNode)
    hotNode.addChild(chocolateNode)

    coldNode.addChild(sodaNode)
    coldNode.addChild(milkNode)

    teaNode.addChild(blackTeaNode)
    teaNode.addChild(greenTeaNode)
    teaNode.addChild(chaiTeaNode)

    sodaNode.addChild(gingerAleNode)
    sodaNode.addChild(bitterLemonNode)

    println(tree)
}