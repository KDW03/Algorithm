import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val vertexes = Array(N - 1){br.readLine().split(' ').map{it.toInt()}}

    val links = Array(N + 1){ LinkedList<Int>() }
    val parents = IntArray(N + 1){-1}
    val visited = BooleanArray(N + 1){ false }
    parents[1] = 1
    visited[1] = true
    vertexes.forEach {
        links[it[0]].add(it[1])
        links[it[1]].add(it[0])
    }

    fun dfs(n: Int){
        for(num in links[n]){
            if(!visited[num]) {
                visited[num] = true
                parents[num] = n
                dfs(num)
            }
        }
    }

    dfs(1)

    val answer = StringBuilder()
    for(i in 2..N){
        answer.append("${parents[i]}\n")
    }
    print(answer.toString())
}

