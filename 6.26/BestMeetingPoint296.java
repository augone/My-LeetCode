public class Solution {
    int height;
    int width;
    public int minTotalDistance(int[][] grid) {
        if(grid == null||grid.length == 0||grid[0].length==0)
            return 0;
        height = grid.length;
        width = grid[0].length;
        ArrayList<Integer> vertical = new ArrayList<>();
        ArrayList<Integer> horizontal = new ArrayList<>();
        for(int i = 0 ; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(grid[i][j] == 1)
                    vertical.add(i);
            }
        }
        for(int i = 0 ; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                if(grid[j][i] == 1)
                    horizontal.add(i);
            }
        }
        return getDis(vertical)+getDis(horizontal);
    }
    public int getDis(ArrayList<Integer> list)
    {
        if(list.size() == 0)
            return 0;
        int sum = 0;
        int i = 0, j = list.size() -1;
        while(i<j)
        {
            sum += list.get(j--)  - list.get(i++);
        }
        return sum;
    }
}