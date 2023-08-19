class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        var answer = listOf<Int>()

        flag.forEachIndexed { i , v ->
            answer = if(v){
                answer + IntArray(arr[i] * 2){ arr[i] }.toList()
            }else{
                answer.dropLast(arr[i])
            }
        }

        return answer.toIntArray()

    }
}