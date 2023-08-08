class Solution {
    fun solution(numbers: IntArray): IntArray = pick2Plus(numbers)
}


fun pick2Plus(ll : IntArray) : IntArray{
    val size = ll.size
    val ml : MutableList<Int> = mutableListOf()
    for(i in 0 until size - 1) {
        for(j in i + 1 until size) {
            ml.add(ll[i]+ll[j])
        }
    }
    return ml.distinct().sorted().toIntArray()
}