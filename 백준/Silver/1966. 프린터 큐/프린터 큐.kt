import java.util.LinkedList

class Node(val priority: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val testCaseCount = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(testCaseCount) {
        // n 은 문서 개수, m은  출력 순서가 궁금한 문서의 현재 위치
        val (n, m) = br.readLine().split(' ').map { it.toInt() }
        val q = LinkedList<Node>()
        var count = 0
        br.readLine().split(' ').map { it.toInt() }.forEach {
            q.add(Node(it))
        }
        val targetNode = q[m]
        while (true) {
            var flag = true
            val curNode = q.removeFirst()
            for (node in q) {
                //현재노드보다 우선순위 큰게 큐에 있다면
                if (node.priority > curNode.priority) {
                    // 뒤로 보내기
                    q.addLast(curNode)
                    // 인쇄실패
                    flag = false
                    break
                }
            }
            
            //인쇄 성공 했다면
            if (flag) {
                count++
                //현재보다 큰게 없다면 그대로 출력 -> 삭제
                //만약 출려되는게 targetNode라면 순서 출력하고 while문 탈 
                if (curNode == targetNode){
                    sb.append(count).append("\n")
                    break
                }
            }
        }
    }
    println(sb.toString())
}

