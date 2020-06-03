/*
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 
Note:
1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000
*/
class Solution {
    private class sortA implements Comparator<int[]>{
        /*
        The inituition here is that we want to minimize the cost. For example if we hava [100,10][10,100]
        then we can see that we will go to city B first which cost 10 and we will go to city A in second as it
        costs less. Differece between cost of A and B are [90][-90] so if we have to spend 90 extra if we travel
        with A rather than B. so we will sort the array in ascending order of there difference. So for first N 
        numbers cost of A will be minimum and for last N numbers cost of B will be minimum.
        */
        public int compare(int[] a,int[] b){
            return (a[0]-a[1])-(b[0]-b[1]);
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        Collections.sort(Arrays.asList(costs),new sortA());
        int min=0;
        for(int i=0;i<costs.length/2;i++){
            min+=costs[i][0];
        }
        for(int i=costs.length/2;i<costs.length;i++){
            min+=costs[i][1];
        }
        return min;
    }
}
