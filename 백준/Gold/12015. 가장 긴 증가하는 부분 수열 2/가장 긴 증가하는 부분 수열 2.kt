fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val lis = ArrayList<Int>()
    for (num in nums) {
        if (lis.isEmpty() || num > lis.last()) {
            lis.add(num)
        } else {
            val index = lis.binarySearch(num)
            if (index < 0) lis[-index - 1] = num
        }
    }
    println(lis.size)
}
