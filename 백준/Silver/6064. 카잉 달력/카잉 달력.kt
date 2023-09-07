fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    
    repeat(t) {
        val (M, N, x, y) = br.readLine().split(" ").map { it.toInt() }
        
        var year = x
        var currentY = x % N
        if (currentY == 0) {
            currentY = N  // 나머지가 0인 경우, N으로 설정
        }
        
        val maxYear = M * N
        while (year <= maxYear) {
            if (currentY == y) {
                sb.append(year).append("\n")  // 결과에 추가
                break  // 루프 종료
            }
            
            // 다음 가능한 해로 이동
            year += M
            
            // y 값 업데이트
            currentY = (currentY + M) % N
            if (currentY == 0) {
                currentY = N  // 나머지가 0인 경우, N으로 설정
            }
        }
        
        // 만약 해를 찾지 못했다면 -1을 결과에 추가
        if (year > maxYear) {
            sb.append(-1).append("\n")
        }
    }

    // 모든 결과를 출력
    print(sb.toString())
}
