public class Twitter{
  Map<Integer, Set<Integer>> follow = new HashMap();
  Map<Integer, LinkedList<Tweet>> tweets = new HashMap();
  int cnt = 0;
  
  public void postTweet(int userId, int tweetId){
    if(!follow.cantainsKey(userId)) follow.put(userId, new HashMap());
    follow.get(userId).add(userId); //to receive tweet of his own
    if(!tweets.containsKey(userId)) tweets.put(userId, new LinekedList());
    tweets.get(userId).addFirst(new Tweet(cnt++, tweetId));
  }
  public List<Integer> getNewsFeed(int userId){
    if(!follow.cantainsKey(userId)) return new LinkedList();
    PriorityQueue<Tweet> feed = new PriorityQueue((t1, t2)->t2.time - t1.time);
    follow.get(userId).stream()
      .filter(f->tweets.containsKey(f))
      .forEach(f->tweets.get(f).forEach(feed::add));
    List<Integer> res = new LinkedList();
    while(feed.size()>0&&res.size<10) res.add(feed.poll().id);
    return res;
  }
  public void follow(int followId, int followeeId){
    if(!follow.containsKey(followerId)) follow.put(followerId, new HashSet());
    follow.get(followerId).add(followeeId);
  }
  public void unfollow(int followerId, int followeeId){
    if(follow.conationsKey(followeeId)&&followeeId!=followerId) 
      follow.get(followeeId).remove(followeeId);
  }
  class Tweet{
    int time;
    int id;
    Tweet(int time, int id){
      this.time = time;
      this.id = id;
    }
  }
}
