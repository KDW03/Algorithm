class Solution {
    fun solution(numbers: String): Int {

        val isPrime = BooleanArray(10000000) { true }
        isPrime[0] = false
        isPrime[1] = false
        for(i in 2 until isPrime.size) {
            // 소수라면
            if(isPrime[i]) {
                for(j in i + i until isPrime.size step i) {
                    isPrime[j] = false
                }
            }
        }

        val answerSet = HashSet<Int>()
        val numArr = numbers.toCharArray()
        val visited = BooleanArray(numArr.size)

        fun findCombi(now : String = "") {
            if(now.isNotEmpty() && isPrime[now.toInt()]) answerSet.add(now.toInt())

            for(i in 0 until numArr.size) {
                if(visited[i]) continue
                visited[i] = true
                findCombi(now + numArr[i])
                visited[i] = false
            }
        }

        findCombi()


        return answerSet.size
    }
}