import java.util.*;
class Twitter {
	private Map<Integer,User> userMap = new HashMap<>();
	private List<Integer> tweetList = new ArrayList<>();
	
    /** Initialize your data structure here. */
    public Twitter() {
        this.userMap.clear(); 
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!this.userMap.containsKey(userId))
		{
			User user = new UserImpl(userId);
			this.userMap.put(userId,user);
		}
		this.userMap.get(userId).postTweet(tweetId);
		this.tweetList.add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
		if(this.userMap.containsKey(userId))
		{
			result.addAll(this.userMap.get(userId).getTweets());
			List<User> Followed = this.userMap.get(userId).getFollowed();
			Followed.stream().forEach(follower->{
				result.addAll(follower.getTweets());
			});
		}
		else return result;
		
		List<Integer> toReturn = new ArrayList<>();
		for(int count = tweetList.size()-1; count >=0; count--)
		{
			if(result.contains(this.tweetList.get(count)))
			{
				toReturn.add(this.tweetList.get(count));
				
			}
			if(toReturn.size() == 10)
				return toReturn;
		}
		return toReturn;
		
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!this.userMap.containsKey(followerId))
		{
			User user = new UserImpl(followerId);
			this.userMap.put(followerId,user);
		}
		if(!this.userMap.containsKey(followeeId))
		{
			User user = new UserImpl(followeeId);
			this.userMap.put(followeeId,user);
		}
		this.userMap.get(followerId).follow(this.userMap.get(followeeId));
		
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (this.userMap.containsKey(followerId)) {
            this.userMap.get(followerId).unfollow(this.userMap.get(followeeId));
        }
    }
	interface User 
	{
		public void postTweet(int tweetId);
		
		public List<User> getFollowed();
		
		public void follow(User followed);
		
		public void unfollow(User followed);
		
		public List<Integer> getTweets();
	}
	
	private static class UserImpl implements User
	{
		private List<Integer> myTweets = new ArrayList<>();
		private List<User> Ifollowed = new ArrayList<>();
		private int userId;
		
		public int hashCoce()
		{
			final int prime = 33;
			int result = 2;
			result = prime*result+ userId;
			return result;
		}
		
		
		public boolean equals(Object obj)
		{
			if(this == obj)
				return true;
			if(obj == null)
				return false;
			if(getClass() != obj.getClass())
				return false;
			UserImpl other = (UserImpl) obj;
			if(userId != other.userId)
				return false;
			return true;
			
		}
		
		public int getUserId()
		{
			return this.userId;
		}
		
		public UserImpl (int UserId)
		{
			this.userId = UserId;
		}
		
		public void postTweet(int tweetId)
		{
			this.myTweets.add(tweetId);
		}
		
		public List<User> getFollowed()
		{
			return new ArrayList<>(this.Ifollowed);
		}
		
		public void follow(User followed){
			if(followed != null)
				this.Ifollowed.add(followed);
		}
		
		public void unfollow(User followed)
		{
			if(this.Ifollowed.contains(followed))
				this.Ifollowed.remove(followed);
		}
		
		public List<Integer> getTweets()
		{
			return new ArrayList<Integer>(this.myTweets);
		}
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */