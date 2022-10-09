fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    if (n < 100){
        print(n)
    }else{
        var count = 99
        for (i in 111 .. n){
            if (hansoo(i)) count++
        }
        print(count)
    }
}

fun hansoo(i: Int): Boolean {

    val one = i / 100
    val two = (i % 100) / 10
    val three = (i % 100) % 10

    return (two - one) == (three - two)
}
