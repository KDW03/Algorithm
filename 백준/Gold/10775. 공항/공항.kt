lateinit var parentArr : IntArray
fun main() {
    val br = System.`in`.bufferedReader()
    val G = br.readLine().toInt()
    val P = br.readLine().toInt()

    parentArr = IntArray(G + 1) { it }
    var count = 0
    repeat(P){
        // 현재 오는 비행기 1 .. x
        val x = br.readLine().toInt()
        val px = findParent(x)
        if (px == 0){
            println(count)
            return
        }else{
            count++
            parentArr[px] = findParent(px - 1)
        }
    }
    println(count)
}

fun findParent(x : Int) : Int {
    if (parentArr[x] == x) return x
    parentArr[x] = findParent(parentArr[x])
    return parentArr[x]
}

