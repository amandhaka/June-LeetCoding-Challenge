Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
```
Input: [2,2,3,2]
Output: 3
```
Example 2:
```
Input: [0,1,0,1,0,1,99]
Output: 99
```
```java
/*
What we will do here is that we have a variable lets say ans which will be initalised to 0 in start we are going to use to calculate number of set bit at particular position. Lets say we have 2 2 3 2
so Binary representation will be
0010
0010
0011
0010
So here we hve 1 set bit at first poisiton so we will modulo it with 3 as each elemnt is occuring thrice so number of set bit will also be multiple of three and at ith position there is set bit of our result so we will get that set bit and repeat same for other. We can do it for any number occurences
*/
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++){
            int sum=0;
            for(int n:nums){
                if(((n>>i)&1)==1){ //we are shifting n to left by so that we will see if that bit is zero or not
                    sum++;
                }     
                sum=sum%3;
            }
            if(sum!=0){
                result|=sum<<i;
            }
        }
        return result;
    }
}
```
