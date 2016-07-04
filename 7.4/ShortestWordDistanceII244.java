public class WordDistance {

    HashMap<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++)
        {
            List<Integer> temp;
            if(map.containsKey(words[i]))
            {
                temp = map.get(words[i]);
                temp.add(i);
            }
            else
            {
                temp = new ArrayList<>();
                temp.add(i);
            }
            map.put(words[i],temp);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> pos1 = map.get(word1);
        List<Integer> pos2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < pos1.size()&&j < pos2.size(); )
        {
            int index1 = pos1.get(i);
            int index2 = pos2.get(j);
            if(index1>index2)
            {
                res = Math.min(res,index1-index2);
                j++;
            }
            else if(index1<index2)
            {
                res = Math.min(res,index2-index1);
                i++;
            }
        }
        return res;
        
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");