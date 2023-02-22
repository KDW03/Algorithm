class Solution {
    fun solution(array: IntArray, n: Int): Int {
        val list = (array.toList() + n).sorted()
        list.indexOf(n).let{
            // 마지막이 아니라면
            return if(it == list.size-1){
                list[it-1]
            } else if(it == 0) {
                list[it+1]
            } else{
                val first = n - list[it-1]
                val two = list[it+1] - n
                if(first == two) list[it-1]
                else if(first > two) list[it+1]
                else list[it-1]
            }
        }
    }
}