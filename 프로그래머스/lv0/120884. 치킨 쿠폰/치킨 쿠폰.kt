class Solution {
    fun solution(chicken: Int): Int {
        var serviceChicken = chicken / 10
        var remainCoupone = chicken
        remainCoupone -= (10*serviceChicken)
        remainCoupone += serviceChicken
        while(remainCoupone >= 10){
            val addChicken = remainCoupone / 10 // 쿠폰으로 시킨 추가 쿠폰 
            serviceChicken += addChicken // 총 서비스 치킨에 더 해주고
            remainCoupone -= (10*addChicken) // 쿠폰을 빼주고 
            remainCoupone += addChicken //
        }
        return serviceChicken
    }
}