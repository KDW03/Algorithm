data class Country(val number: Int, val gold: Int, val silver: Int, val bronze: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val countries = ArrayList<Country>()

    repeat(n) {
        val (num, gold, silver, bronze) = br.readLine().split(" ").map { it.toInt() }
        countries.add(Country(num, gold, silver, bronze))
    }
    val find = countries.find { it.number == k }
    countries.sortWith(compareByDescending<Country> { it.gold }.thenByDescending { it.silver }
        .thenByDescending { it.bronze })

    val rank =
        countries.indexOfFirst { it.gold == find?.gold && it.silver == find.silver && it.bronze == find.bronze } + 1
    println(rank)
}