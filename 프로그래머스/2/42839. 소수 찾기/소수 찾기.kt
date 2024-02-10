class Solution {
    fun solution(numbers: String): Int {
        val permutations = mutableSetOf<Int>()
        val prime = BooleanArray(10000000) { true }
        prime[0] = false
        prime[1] = false

        for(i in 2 until prime.size) {
            // 소수라면
            if(prime[i]) {
                for(j in i * 2 until prime.size step i) {
                    prime[j] = false
                }
            }
        }

        val nums = numbers.toCharArray()

        fun generatePermutations(combination: String, used: BooleanArray) {

            if (combination.isNotEmpty()) {
                permutations.add(combination.toInt())
            }

            if (combination.length == numbers.length) return

            for (i in nums.indices) {
                if (!used[i]) {
                    used[i] = true
                    generatePermutations(combination + nums[i], used)
                    used[i] = false
                }
            }
        }

        generatePermutations("", BooleanArray(numbers.length))
        return permutations.count { prime[it] }
    }
}