Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.
```
Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
```
```
Sort the array nums, purpose of sorting is to make sure that all divisors of an element appear before it.
For each element in nums, find the length of largest subset and save in count[]
Pick the index of the largest element in count.
From nums[maxIndex] to 0, add every element belongs to the largest subset.
```
```java
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums.length==0) return result;
        int[] count=new int[nums.length];
        int maxInt=0;
        Arrays.fill(count,1);
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    count[i]=Math.max(count[i],count[j]+1);
                }
            }
        }
        int countMax=count[0];
        for(int i=1;i<count.length;i++){
            if(count[i]>countMax){
                countMax=count[i];
                maxInt=i;
            }
        }
        int temp=nums[maxInt];
        int currentCount=count[maxInt];
        for(int i=maxInt;i>=0;i--){
            if(temp%nums[i]==0 && count[i]==currentCount){
                result.add(nums[i]);
                temp=nums[i];
                currentCount--;
            }
        }
        return result;
    }
}
```
