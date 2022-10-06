lateinit var visit: Array<Boolean>

fun main() {
    
    val br = System.`in`.bufferedReader()
    val count = br.readLine().toInt()
    val n = br.readLine().toInt()
    visit = Array(count + 1) { false }
    val arr = Array(count+1) { ArrayList<Int>() }
    repeat(n) {
        val (n,m) = br.readLine().split(' ').map(String::toInt)
        arr[n].add(m)
        arr[m].add(n)
    }
    
    dfs(arr, 1)
    println(visit.count { it } - 1)

}

fun dfs(arr: Array<ArrayList<Int>>, idx: Int) {
    visit[idx] = true
    //해당 노드에 연결된거 하나씩 탐색
    for (i in arr[idx]) {
        //방문하지 않은 노드라면
        if (!visit[i]) {
            visit[i] = true
            dfs(arr, i)
        }
    }
}