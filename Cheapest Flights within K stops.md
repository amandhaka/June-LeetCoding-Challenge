There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
```
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:
```

The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
```
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:
```

The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 
Constraints:
```
The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
```
 ```java
 class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        //Here we are making the graph as Src-> Map= dest->price
        for(int[] f:flights){
            if(!map.containsKey(f[0])) map.put(f[0],new HashMap<>());
            map.get(f[0]).put(f[1],f[2]);
        }
        /* we will use Priority queue to sort the cities according to its distance. We will visit each node connected to current node then add the price of that node and priority queue will kep sorting it in ascending order of prices so we when we visit current node's adjaecent nodes then in next iteration we will have the lowest price node on the top and we will visit that */
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src,K+1});
        
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            int price=curr[0],city=curr[1],stops=curr[2];
            if(city==dst) return price;
            if(stops>0){
                Map<Integer,Integer> adj=map.getOrDefault(city,new HashMap<>());
                for(int a:adj.keySet()){
                    pq.add(new int[]{price+adj.get(a),a,stops-1});
                }
            }   
        }
        return -1;
    }
}
 ```
