import java.util.*;
class Solution {
	public static void main(String[] args )
	{
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
    public static List<String> findWords(char[][] board, String[] words) {
		List<String> list = new ArrayList<>();
        if(board == null||board.length == 0 || board[0].length == 0||words == null||words.length == 0)
			return list;
		int height = board.length;
		int width = board[0].length;
		TrieNode root = constructTrie(words);
		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col < width; col++)
			{
				dfs(board,row,col,root,list);
			}
		}
		return list;
		
    }
	static private class TrieNode{
		TrieNode[] children = new TrieNode[26];
		String word;
	}
	static private TrieNode constructTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String s : words)
		{
			TrieNode cur = root;
			for(int i = 0; i < s.length(); i++)
			{
				char ch = s.charAt(i);
				if(cur.children[ch - 'a'] == null)
				{
					TrieNode child = new TrieNode();
					cur.children[ch - 'a'] = child;
					cur = child;
				}
				else
					cur = cur.children[ch - 'a'];
			}
			cur.word = s;
		}
		return root;
		
	}
	static private void dfs(char[][] board, int row, int col, TrieNode root, List<String> list)
	{
		if(board[row][col] == '#'||root.children[board[row][col] - 'a'] == null)
			return;
		TrieNode cur = root.children[board[row][col] - 'a'];
		if(cur.word != null)
		{
			list.add(cur.word);
			cur.word = null;
		}
		char ch = board[row][col];
		board[row][col] = '#';
		if(row > 0) dfs(board,row-1,col,cur,list);
		if(row < board.length - 1) dfs(board,row+1,col,cur,list);
		if(col > 0) dfs(board,row,col - 1,cur,list);
		if(col < board[0].length - 1) dfs(board,row,col + 1,cur,list);
		board[row][col] = ch;
	}
}