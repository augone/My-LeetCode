public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> row = null;
    private Iterator<Integer> col = null;
    public Vector2D(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
        if(row.hasNext())
        {

            col = row.next().iterator();
            
        }
    }

    @Override
    public Integer next() {
        return col.next();
    }

    @Override
    public boolean hasNext() {

        if(col!=null&&col.hasNext())
            return true;
        while(row.hasNext())
        {
            col = row.next().iterator();
            if(col.hasNext())
                return true;
        }
        return false;
    }
}

// The following method works but sucks too.
/** 
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

/* 
public class Vector2D implements Iterator<Integer> {
    ArrayList<Integer> list = new ArrayList<>();
    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer> l:vec2d)
        {
            if(l != null&&l.size()>0)
            {
                list.addAll(l);
            }
        }
        //Collections.sort(list);
    }

    @Override
    public Integer next() {
        int res = list.get(0);
        list.remove(0);
        return res;
    }

    @Override
    public boolean hasNext() {
        return list.size()>0;
    }
} */

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */