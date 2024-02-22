class Solution {
    fun solution(n: Int): Array<IntArray> {
        
        val answer = ArrayList<IntArray>()
        
        fun hanoi(n : Int, a : Int , b : Int, c : Int) {
            
            if(n == 0) return
            // n - 1개 a에 있던거 b로 옮기고
            hanoi(n - 1 , a, c, b)
            
            // n번째 a에서 c로 옮기고
            answer.add(intArrayOf(a,c))
            
            // n -1개 b에서 c로 옮기고
            hanoi(n - 1 , b, a, c)
        }
        
        // n개 1에서 3까지 옮기기
        hanoi(n,1,2,3)
        return answer.toTypedArray()
    }
}