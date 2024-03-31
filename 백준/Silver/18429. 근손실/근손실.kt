fun main() {
    val br = System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }

    val nums = br.readLine().split(" ").map { it.toInt() - k }
    val visited = BooleanArray(nums.size)
    var count = 0

    fun dfs(nowCanWeight : Int = 500) {

        if (nowCanWeight < 500) return

        if (visited.all { it }) {
            count++
            return
        }

        // 오늘 할 운동 키트 선택
        for (i in nums.indices) {
            if (visited[i]) continue
            visited[i] = true
            dfs(nowCanWeight + nums[i])
            visited[i] = false
        }


    }

    dfs()

    println(count)
}