fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val nums = br.readLine().split(" ").map { it.toInt() }
    val countMap = nums.groupingBy { it }.eachCount().toMutableMap()
    var answer = 0

    // 2000
    outer@ for (i in nums.indices) {
        val now = nums[i]
        countMap[now] = countMap.getOrDefault(now,0) - 1
        // now 하나 빼주고
        // 2000
        for (j in nums.indices) {
            if (i == j) continue
            val a = nums[j]
            val b = now - a

            if (a == b) {
                if (countMap.getOrDefault(a, 0) >= 2) {
                    answer++
                    break
                }
            } else {
                val bCount = countMap.getOrDefault(b, 0)
                if (bCount >= 1) {
                    answer++
                    break
                }
            }
        }

        countMap[now] = countMap.getOrDefault(now,0) + 1
    }

    println(answer)
}

