import java.util.*;


/**
장르 별로 가장 많이 재생된 노래 2개씩 모아 베스트 앨범 출시 
노래는 고유 번호로 구분 

수록 기준 


- 장르별로 많이 재생된 순서를 알아야 함 
- 장르 내에서 가장 많이 재생된 두 곡을 알아야 함 

장르별로 많이 재생된 순서 ?

HashMap<String,Integer> 장르, 재생 수 

genres 순회하면서 넣기 

--------------------


HashMap<String, PriorityQueue<Song>>

Song (index, play)

genres 순회

play 가 높은 걸 먼저 poll 하는 우선순위 큐라면 ?
노래 최대 10^4
log10^4 
10000 
2 4 6 8 16 32 64 128 256 512 1024 2048 4096 8192 

13 14 사이의 값 
장르 최대 10^2개니까 10^3 

장르 최대 100 개 : n=100 
ArrayList<Genre> 를 만들고 
Genre (string , play)
play 내림차순으로 정렬    : nlogn 


sort



리스트에서 하나씩 꺼내서 맵에서 get -> poll 2번   o(1) -> logn 


**/

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        
        // 장르, 노래 우선순위 큐 
        HashMap<String, PriorityQueue<Song>> hm = new HashMap<>();
        
        // 장르, 재생 수 해시맵 
        HashMap<String, Integer> ghm = new HashMap<>();
        
        // 
        ArrayList<Genre> list = new ArrayList<>();
        
        for (int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            ghm.put(genre, ghm.getOrDefault(genre, 0)+play);
            
            PriorityQueue<Song> pq = hm.getOrDefault(genre, new PriorityQueue<Song>((s1,s2)->Integer.compare(s2.play,s1.play)));
            pq.offer(new Song(i, play));
            hm.put(genre,pq);
        }
        
        for (String  genre : ghm.keySet()){
            list.add(new Genre(genre, ghm.get(genre)));
        }
        
        list.sort((g1,g2)->Integer.compare(g2.play, g1.play));
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (Genre g : list){
            PriorityQueue<Song> pq = hm.get(g.genre);
            for (int i=1; i<=2; i++){
                Song s = pq.poll();
                if (s!=null) {
                    answer.add(s.index);
                }
            }
        }
        
        int[] a = new int[answer.size()];
        
        for (int i=0; i<answer.size(); i++){
            a[i] = answer.get(i);
        }
        
        return a;
    }
    
    static class Genre {
        String genre; 
        int play;
        
        public Genre(String g, int p){
            this.genre = g;
            this.play = p;
        }
        
    }
    
    static class Song {
        int index;
        int play;
        
        public Song(int i, int p){
            this.index = i;
            this.play = p;
        }
    }
}
