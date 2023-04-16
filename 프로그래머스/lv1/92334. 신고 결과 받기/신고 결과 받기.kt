import java.util.*
import kotlin.collections.HashMap

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val userReport : HashMap<String,HashSet<String>> = hashMapOf()
        val sendCount = IntArray(id_list.size)

        for(r in report){
            val tmp = r.split(" ")
            val a = tmp[0]
            val b = tmp[1]
            if(userReport[b] == null) userReport[b] = hashSetOf()
            userReport[b]!!.add(a)
        }

        userReport.forEach {
            if (it.value.size >= k){
                for (i in it.value){
                    sendCount[id_list.indexOf(i)]++
                }
            }
        }

        return sendCount
    }
}