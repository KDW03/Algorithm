import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
  
        //총 (대기시간 + 처리시간) 
        var result = 0
        
        // 요청 시간, 처리 소요 시간
        //처리 시간으로 일단 정렬
        val pq = PriorityQueue<Pair<Int,Int>>(
            compareBy(
                {it.second}
            )
        )
        pq.addAll(jobs.map{ Pair(it[0],it[1]) })
        var count = 0
        var time = 0
        var waitList : ArrayList<Pair<Int,Int>> = arrayListOf()
        while(true){
            if(count == jobs.size) break
            val tmp = pq.poll()
            // 요청으로 부터 얼마를 기다렸는지
            val wait = time - tmp.first
            // 현재 처리할 수 있나
            // 처리 할 수 있다면 
            if(wait >= 0) {
                result += (tmp.second + wait)
                // 현재 시간에 처리 시간 더해줌
                time += tmp.second
                // 처리 된 작업 개수 증가
                pq.addAll(waitList)
                waitList.clear()
                count++
            }else{
                // 처리 할 수 없다면 다시 넣어줘야하는데
                // 바로 넣으면 다시 이게 나오니간
                // 일단 리스트에 저장
                waitList.add(tmp)
                // 처리 할 수 있는거 찾고
                // 현재 처리할 수 있는게 없다면 
                // 시간 하나 증가시키고 다시 pq구성
                if(pq.isEmpty()){
                    time++
                    pq.addAll(waitList)
                    waitList.clear()
                }
            }
        }
        return result/jobs.size
    }
}