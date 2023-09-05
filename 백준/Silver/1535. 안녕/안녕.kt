var max = 0
fun main() {
    val br = System.`in`.bufferedReader()
    // 사람의 번호는 1번부터 N번
    // i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨
    //  세준이의 체력은 100이고, 기쁨은 0
    //  얻을 수 있는 최대 기쁨


    // 체력은 무조건 0보다 커야함
    val n = br.readLine().toInt()
    val healthArr = br.readLine().split(" ").map { it.toInt() }
    val happyArr = br.readLine().split(" ").map { it.toInt() }
    val pairArr = happyArr.mapIndexed { i, v ->
        Pair(healthArr[i], v)
    }

    dfs(pairArr, 100)
    println(max)
}

fun dfs(pairArr: List<Pair<Int, Int>>, health: Int, idx: Int = 0, love: Int = 0) {

    if(idx == pairArr.size){
        max = maxOf(max,love)
        return
    }

    val tmp = pairArr[idx]
    val new = health - tmp.first
    // 보내는게 가능하다면
    if (new > 0) {
        dfs(pairArr, new, idx + 1, love + tmp.second)
    }
    // 보내는게 불가능하다면
    dfs(pairArr, health, idx + 1, love)
}