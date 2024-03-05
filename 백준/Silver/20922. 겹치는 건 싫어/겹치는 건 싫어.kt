fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val nums = br.readLine().split(" ").map { it.toInt() }

    var start = 0
    var end = 0

    val map = hashMapOf<Int, Int>()
    var answer = 0

    while (end < nums.size) {
        // 더 해준거 개수 올려주고
        val add = nums[end++]
        map[add] = map.getOrDefault(add, 0) + 1
        // k 초과했안했으면 max 최장길이 갱신 후 계속 반복
        if (map[add]!! <= k) {
            answer = maxOf(answer, end - start)
            continue
        }

        // k초과 없어질때 까지 start 증가해서 remove
        while (true) {
            val remove = nums[start++]
            map[remove] = map[remove]!! - 1
            if (map[remove]!! <= 0) map.remove(remove)
            if (add == remove) break
        }
    }
    println(answer)
}