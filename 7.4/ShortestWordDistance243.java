public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int dis = words.length;
        int pos1 = dis;
        int pos2 = dis;
        for(int i = 0; i < words.length;i++)
        {
            if(word1.equals(words[i]))
            {
                pos1 = i;
                dis = Math.min(dis, Math.abs(i - pos2));
            }
            else if(word2.equals(words[i]))
            {
                pos2 = i;
                dis = Math.min(dis, Math.abs(i - pos1));
            }
        }
        return dis;
        
    }
}