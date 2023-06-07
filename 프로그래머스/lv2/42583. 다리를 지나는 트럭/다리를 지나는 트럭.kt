import java.util.LinkedList
import java.util.Queue

data class Tr(var weight: Int, var exitTime: Int)

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var nowTime = 0
        val inWait: Queue<Tr> = LinkedList(truck_weights.map { Tr(it, bridge_length) })
        val inBridge: Queue<Tr> = LinkedList()
        val isEnter = BooleanArray(1000000000)

        fun canEnter(): Boolean = inBridge.size < bridge_length && !inWait.isEmpty() && (weight - inBridge.sumOf { it.weight }) >= inWait.peek().weight

        fun enterTruck() {
            nowTime++
            while (isEnter[nowTime]){
                nowTime++
            }
            val enterTruck = inWait.poll().apply {
                this.exitTime += nowTime
            }
            inBridge.offer(enterTruck)
            isEnter[nowTime] = true
        }

        while (true) {
            if (inWait.isEmpty() && inBridge.isEmpty()) break
            while (canEnter()) {
                enterTruck()
            }
            val exitTruck = inBridge.poll()
            nowTime = (exitTruck.exitTime - 1)
        }
        return nowTime + 1
    }
}

