class Solution {
    var max = 1
    var answer: IntArray = intArrayOf()

    fun solution(n: Int, info: IntArray): IntArray {
        // idx를 과녁판 점수로 보고 연산을 한 예정이므로 초기값 reversed
        dfs(info.reversedArray(),n)
        // 만약 answer이 빈 배열이라면 => 이기거나 비긴 경우 밖에 없으므로 -1 아니면 answer 리턴
        return if(answer.isEmpty()) intArrayOf(-1) else answer
    }

    //
    private fun dfs(info: IntArray, n: Int, idx: Int = 1, k: Int = 0, list: IntArray = IntArray(info.size)) {
        // n개의 화살보다 많이 필요로 하면 종료
        if (k > n) return
        // n 화살과 k 화살이 같거나 과녁판의 최대점수에 도달했다면
        if (k == n || idx == info.size) {
            // lion의 점수 합 > 해당 과녁판이 0이 아니라면 과녁판 점수를 더해줌 
            val lionsum = list.foldIndexed(0) { i, s, acc -> s + if (acc != 0) i else 0 }
            // apeach의 점수 합 > lion의 해당 점수 과녁에 쓴 화살이 0이고 자기 어피치는 현재 0이 아니라면  과녁팜 점수를 더해줌
            val apeachsum = info.foldIndexed(0) { i, s, acc -> s + if (list[i] == 0 && acc != 0) i else 0 }
            // 점수의 차가 이전 점수차 보다 크거나 같다면
            // 같은 것도 고려하는 이유는
            // 모든걸 뽑지 않는 경우 부터 시작해서 가장 높은 점수의 과녁부터 뽑는 경우가 차례대로 고려 되기 때문에
            // 같은 걸 고려해야 제일 마지막에
            if (lionsum - apeachsum > max) {
                max = lionsum - apeachsum
                // 남은 화살이 있는걸 제일 마지막에 넣어주고 리턴
                answer = list.reversedArray().apply { set(idx - 1, n - k) }
            }
            return
        }
        dfs(info, n, idx + 1, k + info[idx] + 1, list.copyOf().apply { set(idx, info[idx] + 1) })
        dfs(info, n, idx + 1, k, list)
    }

}

