import java.util.*


class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var time = 0
        val bridgeQueue: Queue<Int> = LinkedList(List(bridge_length) { 0 })
        var currentWeight = 0
        
        for (truck in truck_weights) {
            while (true) {
                currentWeight -= bridgeQueue.poll()

                if (currentWeight + truck <= weight) {
                    bridgeQueue.offer(truck)
                    currentWeight += truck
                    time++
                    break
                } else {
                    bridgeQueue.offer(0)
                    time++
                }

            }
        }
        
        return time + bridge_length
    }
}