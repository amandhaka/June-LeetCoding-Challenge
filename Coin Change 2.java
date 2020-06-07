/*You are given coins of different denominations and a total amount of money. 
Write a function to compute the number of combinations that make up that amount. 
You may assume that you have infinite number of each kind of coin.
Example 1:
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 

Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

*/

```java
/*
So what we are doing here is just take an dp array of size amount+1 and store '1' at its 0 position. 
This dp array will tell us that how many combinations can be formed of ith amount. So we are just iterating over
coins and if that coin is greater than current amount than we will subtract the coin from amount which will give 
the combinations that can be formed from rest of the amount. For example:
if we have 1,2 coins and we need to make 3 ruppes
then our dp would look like after 1 coin
1 1 1 1 
And for second iteration when we react '2' amount in dp array we will subtract coin value that is 2 from our amount so we get 0 and at 0 position there is 1 way so we add it to exisiting dp array and same for amount 3.when we reach '3' amount we will subtract the coin value that is 2 from it and we will get '1' and we know 
how many ways are there for '1' combinations so we add that to our dp array.
*/
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}
```
