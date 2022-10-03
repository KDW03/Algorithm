fun main() {
    //2원짜리와 5원짜리 거스름돈
    // 최소의 동전 개수
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() //거스름돈

    var tmp = (n / 5) * 5 //5원짜리로 최대 거슬러 줄 수 있는 거스름돈
    while (true) {
        if ((n - tmp) % 2 == 0) { //그게 2원짜리로 나누어지면 즉 거슬러줄 수 있다면 통과
            print(tmp / 5 + (n - tmp) / 2)
            break
        } else { // 아니라면 5원 거스름돈을 하나 취소하고 다시 검사
            if (tmp < 2){ // 거슬러 줄 수 없는 상황이라면 
                print("-1")
                break
            }
            tmp -= 5
        }
    }
}




