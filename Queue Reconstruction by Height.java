/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

/*
Intuition: So if have 5,0 5,2 5,1 then we know all heights are same so we sort the array according to its kth value and output will be 5,0 5,1 5,2 and we add 7,0 to it then after the array will be 5,0 7,0 .. So we can see are sorting the array in desc order of height and if the height is equal then we will sort the element with kth position in asc order. Then we will take element from start of array and insert into the list at kth position. And as the array is in decreasing order of height then if we encounter a situation like 7,0 and 5,0 then 5,0 will come before 7,0 in resultant array as our sorted array is in desc height so 5,0 will be encountered after
7,0 and we will insert 5,0 at first and 7,0 will be shifted by one element.
*/
class Solution {
    private class SortQueue implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return b[0]>a[0]?b[0]-a[0]:b[0]==a[0]?a[1]-b[1]:b[0]-a[0];
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people.length<=1) return people;
        Collections.sort(Arrays.asList(people),new SortQueue());
        List<int[]> list=new ArrayList<>();
        for(int[] arr:people){
            list.add(arr[1],arr);
        }
        return list.toArray(people);
    }
}
