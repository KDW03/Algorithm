data class Position(val x : Int,val y : Int)

val moveX = arrayOf(0,1,0,-1)
val moveY = arrayOf(1,0,-1,0)

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map{ it.toInt() }
    val arr = Array(n) { BooleanArray(m) }
    var now = Position(0,0)
    var d = 0
    var flag = false
    var count = 0
    arr[0][0] = true
    while(true) {
        val nx = now.x + moveX[d]
        val ny = now.y + moveY[d]

        if(nx in arr.indices && ny in arr[0].indices && !arr[nx][ny]) {
            flag = false
            arr[nx][ny] = true
            now = Position(nx,ny)
        }else{
            if(flag) break
            count++
            d++
            d %= 4
            flag = true
        }
    }

    println(count - 1)
}