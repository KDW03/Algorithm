import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val deque: Deque<Int> = LinkedList()
    //덱 크기 n
    //m 은 뽑을 개수
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //고유한 인덱스를 저장한다고 생각
    for (i in 1 .. n){
        deque.addLast(i)
    }
    // 횟수
    var count = 0
    // 뽑을 거
    val choiceList = br.readLine().split(" ").map { it.toInt() }
    // 뽑을거 하나 정해서
    for (choice in choiceList){
        val first = deque.indexOfFirst { it == choice }
        val last = deque.size - first
        // 최단 거리로
        count += if (first >= last){
            repeat(last){
                val tmp = deque.removeLast()
                deque.addFirst(tmp)
            }
            deque.removeFirst()
            last
        }else{
            repeat(first) {
                val tmp = deque.removeFirst()
                deque.addLast(tmp)
            }
            deque.removeFirst()
            first
        }
    }
    println(count)
}