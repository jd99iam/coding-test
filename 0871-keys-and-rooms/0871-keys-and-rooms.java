/**
0 ~ n-1 까지 n 개의 방이 있음 
0 번 방을 제외하고는 모두 잠겨있음 

모든 방을 방문하는게 목적이다. 
key 가 없으면 방문할 수 없다. 

방을 방문하면 서로 다른 key 들을 얻는다. 
key 에는 어떤 방을 열 수 있는지 번호가 써있고. 한번에 모든 키를 가져갈 수 있다. 

rooms[i] 에는 방 i에서 얻을 수 있는 key 들의 목록이 있다. 

모든 방을 방문할 수 있으면 true 아니면 false 반환 

# 시간복잡도 
n <= 10^3 으로 방은 최대 10^3개라 O(n) 으로 풀어도 된다. 

# 어떻게 풀까 
그냥 bfs 나 dfs 조지고, 마지막에 다 방문했는지만 보면 될 것 같다. 
구현은 dfs 가 더 간단하니까 dfs로 하자. 

*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();

        dfs(0, rooms, visited);

        if (visited.size() == rooms.size())
            return true;

        return false;
    }

    public void dfs(Integer room, List<List<Integer>> rooms, HashSet<Integer> visited) {
        visited.add(room);

        List<Integer> keys = rooms.get(room);

        for (Integer key : keys) {
            if (!visited.contains(key)) {
                dfs(key, rooms, visited);
            }
        }
    }
}