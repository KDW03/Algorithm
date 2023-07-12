import java.util.*

class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk: ArrayList<Int> = arrayListOf()
        var i = 0
        while(i != arr.size){
            if(stk.isEmpty()) stk.add(arr[i++])
            else{
                val last = stk.last()
                if(last < arr[i]) stk.add(arr[i++])
                else stk.removeLast()
            }
        }
        return stk.toIntArray()
    }
}