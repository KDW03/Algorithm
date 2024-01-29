fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val sum = br.readLine().toInt()

    var start = 0
    var end = nums.max()

    while (start <= end) {
        val mid = (start + end) / 2
        var midSum = 0
        for (num in nums) {
            midSum += if (num > mid) {
                mid
            } else {
                num
            }

            if (midSum > sum) {
                break
            }
        }

        if (midSum > sum) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    
    println(end)
}