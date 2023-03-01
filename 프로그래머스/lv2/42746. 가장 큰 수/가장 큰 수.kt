class Solution {
    fun solution(numbers: IntArray): String {
        val answer = numbers.map{ it.toString() }.sortedWith(
            Comparator{
                o1,o2->
                (o2+o1).toInt() - (o1+o2).toInt() 
            }
        ).joinToString("")
        return if(answer.first() == '0') "0" else answer 
    }
}
