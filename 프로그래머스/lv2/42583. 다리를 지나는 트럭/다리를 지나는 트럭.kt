import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 1
        val truckOnBridge : Queue<Int> = LinkedList()
        for(i in 0 until bridge_length-1)
            truckOnBridge.add(0)
        var count = 0
        var idx = 0
        var curTruck = 0
        while(true){
            if(count == truck_weights.size) break
            if(idx < truck_weights.size 
               && weight - truckOnBridge.sum() >= truck_weights[idx] 
               && curTruck < bridge_length){
                truckOnBridge.add(truck_weights[idx])
                curTruck++
                idx++
            }else{ truckOnBridge.add(0) }
            val tmp = truckOnBridge.poll()
            if(tmp > 0) {
                curTruck --
                count++
            }
            answer++
        }
        return answer
    }
}