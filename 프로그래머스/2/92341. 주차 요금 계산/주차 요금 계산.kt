import kotlin.math.ceil

data class Car(var preInMinute : Int = 0, var totalMinute : Int = 0) {
    fun renewalPreInMinute(inTime : String) {
        val (hour,minute) = inTime.split(":").map{ it.toInt() }
        preInMinute = hour * 60 + minute
    } 
    
    fun renewalTotalMinuite(outTime : String) {
        val (hour,minute) = outTime.split(":").map{ it.toInt() }
        totalMinute += (hour * 60 + minute - preInMinute)
        preInMinute = -1
    }
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금 
        val basicTime = fees[0]
        val basicPay = fees[1]
        val unitTime = fees[2].toDouble()
        val unitPay = fees[3]
        
        // in이면 preInMinute 갱신
        // out이면 preInMinute 통해서 total 갱신
        val map : HashMap<String,Car> = hashMapOf()
        
        records.forEach {
            val (time, carNum, action) = it.split(" ")
            
            if(action == "IN") {
                val car = map.getOrDefault(carNum,Car())
                car.renewalPreInMinute(time)
                map[carNum] = car
            }else {
                val car = map.getOrDefault(carNum,Car())
                car.renewalTotalMinuite(time)
                map[carNum] = car
            }
        }
        
        map.values.forEach{
            if(it.preInMinute != -1) it.renewalTotalMinuite("23:59")
        }
        
        
        return map.toList().sortedBy {
            it.first
        }.map{
            val minute = it.second.totalMinute
            basicPay + if(minute - basicTime > 0) ceil((minute - basicTime) / unitTime).toInt() * unitPay else 0
        }.toIntArray()
    
    }
}