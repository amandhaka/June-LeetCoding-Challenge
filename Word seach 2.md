Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:
```
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
```
```java
class TrieNode{
    TrieNode[] children;
    String word;
    public TrieNode(){
        children=new TrieNode[26];
        word=null;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        buildTrie(root,words);
        List<String> list= new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch = board[i][j];
                if(root.children[ch-'a']!=null){
                    dfs(root,board,i,j,list);
                }
            }
        }
        return list;
    }
    private void dfs(TrieNode root,char[][] board,int i ,int j ,List<String> list){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(board[i][j]=='#') return;
        char ch=board[i][j];
        if(root.children[ch-'a']==null) return;
        board[i][j]='#';
        TrieNode curr=root.children[ch-'a'];
        if(curr.word!=null){
            list.add(curr.word);
            curr.word=null;
        }
        //System.out.println(curr.word);
        dfs(curr,board,i+1,j,list);
        dfs(curr,board,i-1,j,list);
        dfs(curr,board,i,j+1,list);
        dfs(curr,board,i,j-1,list);
        board[i][j]=ch;
    }
    private void buildTrie(TrieNode root,String[] words){
        for(String s:words){
            TrieNode curr=root;
            for(char ch:s.toCharArray()){
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new TrieNode();
                }
                curr=curr.children[ch-'a'];
            }
            curr.word=s;
///System.out.println("Added "+curr.word);
        }
    }
}
```
