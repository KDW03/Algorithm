class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var count = 0
        val wantSize = number.sumOf { it }
        // 세일 받아 살 수 있는 것 개수
        val canDiscountBuyMap = discount.take(minOf(10, discount.size)).groupingBy { it }.eachCount().toMutableMap()

        outer@ for (day in discount.indices) {
            if (wantSize > discount.size - day) break
            
            if(day != 0) {
                // 오늘 가입으로 인해 추가되는거
                if (day + 9 in discount.indices) canDiscountBuyMap[discount[day + 9]] =
                    canDiscountBuyMap.getOrDefault(discount[day + 9], 0) + 1
                // 어제꺼 빼기
                if (day - 1 in discount.indices) canDiscountBuyMap[discount[day - 1]] =
                    canDiscountBuyMap.getOrDefault(discount[day - 1], 0) - 1
            }

            for (idx in want.indices) {
                val canBuySize = canDiscountBuyMap[want[idx]]
                if (canBuySize == null || canBuySize < number[idx]) continue@outer
            }
            count++
        }
        return count
    }
}