class Solution {
    
    val combinationOfProduct : MutableList<List<Int>> = mutableListOf()
    
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        
        
        // 모든 이모티콘을 10 20 30 40 으로 할인했을 때로 배열
        val percentArray = arrayOf(10f,20f,30f,40f)
        
        val disCountArray = emoticons.map{ price -> 
            IntArray(percentArray.size) { 
                val percent = percentArray[it] / 100
                (price * (1 - percent)).toInt()
            } 
        }

        combinationProduct(emoticons.size)
                
        var maxPlusCount = -1
        var maxPay = -1
        for(combination in combinationOfProduct) { 
            var plusCount = 0
            var pay = 0
            for(user in users){
                val userMinDiscount = ( (user[0] + 9) / 10 ) -1
                val userMaxPay = user[1]
                var sum = 0
                var row = 0
                for(idx in combination){
                    if(idx >= userMinDiscount) {
                        sum += disCountArray[row][idx]
                    }
                    row++
                }
                if(sum >= userMaxPay) plusCount++
                else pay += sum 
            }
            
            if(maxPlusCount < plusCount) {
                maxPlusCount = plusCount
                maxPay = pay
            }
            
            if(maxPlusCount == plusCount && maxPay < pay) {
                maxPlusCount = plusCount
                maxPay = pay
            }
            
            
        }
         
        return intArrayOf(maxPlusCount,maxPay)
    }
    
    
    fun combinationProduct(emoticonSize : Int , list : List<Int> = listOf(), row : Int = 0) {
        if(row == emoticonSize) {
            combinationOfProduct.add(list)
            return
        }
        
        for (i in 0 until 4) {
            combinationProduct(emoticonSize, list + i , row + 1)
        }
        
    }
    
}