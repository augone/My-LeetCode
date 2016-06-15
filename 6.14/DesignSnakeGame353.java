import java.util.*;
class SnakeGame {
/** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	private int width = 0; 
	private int height = 0;
	private int[][] food = null;
	private int len = 0;
	private LinkedList<position> snake = null;
	
	class position{
		int x = 0;
		int y = 0;
		position(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
		public boolean isEqual(position p)
		{
			if(this.x == p.x&&this.y == p.y)
				return true;
			else 
				return false;
		}
	} 
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
		this.height = height;
		this.food = food;
		this.len = 0;
		this.snake = new LinkedList<>();
		snake.add(new position(0,0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        //position cur = new position(snake.get(0).x,snake.get(0).y);
		//position cur = snake.getFirst();
		position cur = new position(snake.get(0).x,snake.get(0).y);

		position next = cur;
		switch (direction)
		{
			case "U": next.x--; break;
			case "D": next.x++; break;
			case "L": next.y--; break;
			case "R": next.y++; break;
		}
		if(next.x<0||next.y<0||next.x>=height||next.y>=width)
			return -1;
		for(int i = 1; i < snake.size()-1; i++)
		{
			position temp = snake.get(i);
			if(temp.isEqual(next))
				return -1;
			
		}
		snake.addFirst(next);
		if(len < food.length)
		{
			position foodPos = new position(food[len][0],food[len][1]);
			if(!next.isEqual(foodPos))
				snake.removeLast();
			else 
			    len++;
		}
		else
			snake.removeLast();
			
		

		return len;
        
    }
}
