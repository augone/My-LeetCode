public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int len = words.length;
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();
        boolean same = word1.equals(word2);
        for(int i = 0; i < len ; i++)
        {
            if(words[i].equals(word1))
            {
                index1.add(i);
            }
            if(words[i].equals(word2))
            {
                index2.add(i);
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int i = 0 , j = same?1:0 ; i < index1.size()&& j < index2.size();)
        {
            
            int pos1 = index1.get(i);
            int pos2 = index2.get(j);
            if(pos1 > pos2)
            {
                diff = Math.min(diff, pos1 - pos2);
                j = j + (same?2:1);
            }
            else if(pos2 > pos1)
            {
                diff = Math.min(diff, pos2 - pos1);
                i = i + (same?2:1);
            }
            
        }
        return diff;
        
    }
}