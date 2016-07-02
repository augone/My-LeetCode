public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n<=0)
            return true;
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        if(edges.length < n-1 ||((edges.length == 0||edges[0].length == 0)&&n>1))
            return false;
        for(int i = 0 ; i < n; i++)
        {
            if(!visited[i])
                if(containsLoop(visited,edges,i,visiting,-1))
                    return false;
        }
        return true;
        
    }
    public boolean containsLoop(boolean[] visited, int[][] edges, int i,boolean[] visiting, int pre)
    {
        for(int element : getConnected(i,pre,edges))
        {
            if(visiting[element])
                return true;
            visiting[element] = true;
            if(containsLoop(visited,edges,element,visiting,i))
                return true;
            visiting[element] = false;
            visited[element] = true;
        }
        visited[i] = true;
        return false;
    }
    public List<Integer> getConnected(int i, int pre, int[][] edges)
    {
        List<Integer> list = new ArrayList<>();
        for(int[] pair:edges)
        {
            if(pair[0] == i)
            {
                if(pair[1] != pre)
                {
                    list.add(pair[1]);
                }
            }
            else if(pair[1] == i)
            {
                if(pair[0] != pre)
                {
                    list.add(pair[0]);
                }
            }
        }
        return list;
    }
}