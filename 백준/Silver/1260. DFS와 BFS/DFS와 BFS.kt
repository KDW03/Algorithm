import java.util.LinkedList
import java.util.Queue

//bfs
val sb1 = StringBuilder()
//dfs
val sb2 = StringBuilder()


fun main() {

    val br = System.`in`.bufferedReader()
    val (n, m, v) = br.readLine().split(' ').map { it.toInt() }

    val info = Array(n + 1) { ArrayList<Int>() }
    repeat(m){// 정보 입력
        br.readLine().split(' ').map { it.toInt() }.let {
            info[it[0]].add(it[1])
            info[it[1]].add(it[0])
        }
    }

    var visited = BooleanArray(n + 1) //방문 여부
    visited[v] = true
    sb2.append(v).append(" ")
    dfs(info,visited, v)
    visited = BooleanArray(n + 1) //방문 여부
    visited[v] = true
    sb1.append(v).append(" ")
    bfs(info, visited, v)
    println(sb2.toString())
    println(sb1.toString())
}

fun bfs(info: Array<ArrayList<Int>>, visited: BooleanArray, v: Int) {
    //v에 연결되어있는 것들을 전부 탐색하면서

    val q : Queue<Int> = LinkedList()
    q.add(v)

    while (q.isNotEmpty()){
        val tmp = q.poll()
        for (i in info[tmp].sorted()){
            // 아직 방문하지 않은 노드라면
            if (!visited[i]){
                visited[i] = true //방문처리해주고
                sb1.append(i).append(" ")
                q.add(i)
            }
        }
    }
}

fun dfs(info: Array<ArrayList<Int>>, visited: BooleanArray, v: Int){
    for (i in info[v].sorted()){
        //방문하지않은노드라면
        if (!visited[i]){
            //방문 처리해주고
            visited[i] = true
            sb2.append(i).append(" ")
            dfs(info,visited,i)
        }
    }
}





