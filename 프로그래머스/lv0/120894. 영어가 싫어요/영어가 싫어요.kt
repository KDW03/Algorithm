class Solution {
    fun solution(numbers: String): Long {
        var tmp = numbers
        val array = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        for(i in 0 until array.size){
            tmp = tmp.replace(array[i],i.toString())
        }
        
        return tmp.toLong()
    }
}