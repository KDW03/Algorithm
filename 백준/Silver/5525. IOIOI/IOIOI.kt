fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine()

    var count = 0
    var i = 1 
    var patternCount = 0 

    while (i < m - 1) {
        if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
            patternCount++
            if (patternCount == n) {
                count++
                patternCount-- 
            }
            i++ 
        } else {
            patternCount = 0 
        }
        i++ 
    }
    println(count)
}
