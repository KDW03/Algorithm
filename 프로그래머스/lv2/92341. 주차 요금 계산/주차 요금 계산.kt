data class Car(val carNum: String, val inTimeMinute: Int)

val lastTimeMinte = 23 * 60 + 59

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carList: MutableList<Car> = mutableListOf()
        val map: HashMap<String, Int> = hashMapOf()
        records.forEach {
            val t = it.split(" ")
            var time = 0
            time = t[0].split(":").map { it.toInt() }.let { it[0] * 60 + it[1] }
            val carNum = t[1]
            // 들어온차
            if (t[2] == "IN") {
                val car = Car(carNum, time)
                carList.add(car)
            } else {
                val removeCar = carList.first {
                    it.carNum == carNum
                }
                if (map[carNum] == null) map[carNum] = 0
                map[carNum] = map[carNum]!! + (time - removeCar.inTimeMinute)
                carList.remove(removeCar)
            }
        }

        carList.forEach {
            if (map[it.carNum] == null) map[it.carNum] = 0
            map[it.carNum] = map[it.carNum]!! + (lastTimeMinte - it.inTimeMinute)
        }

        return map.toSortedMap().map {
            val payTime = it.value - fees[0]
            val pay = if (payTime > 0) {
                val t = if(payTime % fees[2] == 0) payTime / fees[2]  else (payTime / fees[2] + 1) 
                t * fees[3] + fees[1]
            } else {
                fees[1]
            }
            pay
        }.toIntArray()

    }
}