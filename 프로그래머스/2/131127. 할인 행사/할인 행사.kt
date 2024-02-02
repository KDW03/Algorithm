class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var count = 0
        val wantMap = hashMapOf<String,Int>()
        for (i in want.indices) wantMap[want[i]] = wantMap.getOrDefault(want[i],0) + number[i]

        val windowSize = 10
        val discountWindow = mutableMapOf<String, Int>()

        // 초기 윈도우 설정
        for (i in 0 until minOf(windowSize, discount.size)) {
            discountWindow[discount[i]] = discountWindow.getOrDefault(discount[i], 0) + 1
        }

        for (i in discount.indices) {
            if (wantMap.all { (key, value) -> discountWindow.getOrDefault(key, 0) >= value }) {
                count++
            }

            // 윈도우 업데이트: 현재 시작 상품 제거, 다음 상품 추가
            if (i + windowSize < discount.size) {
                discountWindow[discount[i]] = discountWindow.getOrDefault(discount[i], 0) - 1
                discountWindow[discount[i + windowSize]] = discountWindow.getOrDefault(discount[i + windowSize], 0) + 1
            }else{
                break
            }
        }

        return count
    }
}
