import java.util.*;

/** 
그냥 푼다면 ? 
첫번째 꺼 확인 -> 뒤로 쭉 보면서 더 작은 것 나올 때까지 세기 
두번째 꺼 확인 -> // 

prices 길이는 최대 10^5 로 

prices 의 모든 값이 같으면 매번 끝까지 순회한다. 
(10^5) + (10^5-1) + (10^5 -2) + ... 
크게 보면 
10^5 * 10^5 형태로  10^10 형태이므로 이 풀이는 X

시간복잡도를 줄여아 하는데 .. 


Stock(price, index)

prices 순회
스택peek 해서 비교 
prices[i] 가 더 작을 경우 가격이 떨어짐 -> answer 에 기간 (인덱스 계산) 해서 넣기 

마지막에는 내려간 적 없는 애들의 값을 계산해서 answer 에 넣어줘야 한다 

prices 는 10^5 
10^5 + 10^5 형태다 
for 안의 while 은 매 for loop 마다 10^5를 반복하는게 아닌 
모든 for loop 에서 while 을 도는 횟수를 합쳐야 최대 10^5가 나온다. 


**/

class Solution {
    public int[] solution(int[] prices) {
        
        Stack<Stock> s = new Stack<>();
        int length = prices.length;
        int[] answer = new int[length];
        
        for (int i=0; i<prices.length; i++){
            
            int price = prices[i];
            
            while (!s.empty()){
                Stock stock = s.peek();
                int stockPrice = stock.price;
                if (stockPrice>price){
                    stock = s.pop();
                    answer[stock.index] = i-stock.index;
                } else {
                    break;
                }
            }
            s.push(new Stock(price,i));
        }
        
        while (!s.empty()){
            Stock stock = s.pop();
            answer[stock.index] = (length-1)-stock.index;
        }
        
        return answer;
    }
    
    public static class Stock{
        int price;
        int index; 
        
        public Stock(int price, int index){
            this.price = price;
            this.index = index; 
        }
    }
}