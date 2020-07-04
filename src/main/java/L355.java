import java.util.*;
import java.util.stream.Collectors;

public class L355 {

  static class Twitter {

    private int order;
    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollowers;

    static class Tweet {

      private int id;
      private int order;

      public Tweet(int id, int order) {
        this.id = id;
        this.order = order;
      }

      public int getId() {
        return id;
      }

      public int getOrder() {
        return order;
      }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
      order = 0;
      userTweets = new HashMap<>();
      userFollowers = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
      if (!userTweets.containsKey(userId)) {
        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet(tweetId, order++));
        userTweets.put(userId, tweets);
        return;
      }
      List<Tweet> tweets = userTweets.get(userId);
      tweets.add(new Tweet(tweetId, order++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users
     * who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

      Set<Integer> followeeIds = userFollowers.getOrDefault(userId,new HashSet<>());
      List<Tweet> tweets = new ArrayList<>();
      for (int followeeId : followeeIds) {
        if (!userTweets.containsKey(followeeId)) {
          continue;
        }
        tweets.addAll(userTweets.get(followeeId));
      }
      if (userTweets.containsKey(userId)) {
        tweets.addAll(userTweets.get(userId));
      }

      return tweets.stream().sorted((o1, o2) -> {
        if (o1.getOrder() < o2.getOrder()) {
          return 1;
        }
        if (o1.getOrder() > o2.getOrder()) {
          return -1;
        }
        return 0;
      })
          .limit(10)
          .map(Tweet::getId)
          .collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      if (followerId == followeeId) {
        return;
      }
      if (!userFollowers.containsKey(followerId)) {
        Set<Integer> followees = new HashSet<>();
        followees.add(followeeId);
        userFollowers.put(followerId, followees);
        return;
      }
      Set<Integer> followees = userFollowers.get(followerId);
      followees.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
      if (followerId == followeeId) {
        return;
      }
      if (!userFollowers.containsKey(followerId)) {
        return;
      }
      Set<Integer> followeeIds = userFollowers.get(followerId);
      if (!followeeIds.contains(followeeId)) {
        return;
      }
      followeeIds.remove(followeeId);
    }
  }

  public static void main(String[] args) {
    Twitter twitter=new Twitter();
    twitter.postTweet(1,1);
    twitter.getNewsFeed(1);
    twitter.follow(2,1);
    twitter.getNewsFeed(2);
  }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
