package walfie.tweets.shared.models

import utest._
import utest.ExecutionContext.RunNow
import walfie.tweets.shared.util.SnakePickle

object ModelPicklingSuite extends TestSuite {
  def tests = TestSuite {
    "TweetsFile" - {
      val actual = SnakePickle.read[TweetsFile] {
        """
        {
          "file_name" : "data\/js\/tweets\/2016_02.js",
          "year" : 2016,
          "var_name" : "tweets_2016_02",
          "tweet_count" : 230,
          "month" : 2
        }
        """
      }

      val expected = TweetsFile(
        fileName = "data/js/tweets/2016_02.js",
        year = 2016,
        varName = "tweets_2016_02",
        tweetCount = 230,
        month = 2
      )

      assert(actual == expected)
    }

    "Tweet" - {
      val actual = SnakePickle.read[Tweet] {
        """
        {
          "source" : "Some Awesome Client",
          "entities" : {
            "user_mentions" : [ {
              "name" : "Walf",
              "screen_name" : "walfieee",
              "indices" : [ 0, 9 ],
              "id_str" : "2955297975"
            } ],
            "media" : [ ],
            "hashtags" : [ ],
            "urls" : [ ]
          },
          "in_reply_to_status_id_str" : "539258739485048832",
          "geo" : { },
          "id_str" : "539259137482555393",
          "in_reply_to_user_id" : 288586382,
          "text" : "@_Chenna_ ok it is up at the usual",
          "id" : 539259137482555393,
          "in_reply_to_status_id" : 539258739485048832,
          "created_at" : "2014-12-01 03:26:11 +0000",
          "in_reply_to_screen_name" : "_Chenna_",
          "in_reply_to_user_id_str" : "288586382",
          "user" : {
            "name" : "Tresifina",
            "screen_name" : "Tresifina",
            "protected" : true,
            "id_str" : "422235993",
            "profile_image_url_https" : "https:\/\/pbs.twimg.com\/profile_images\/457980040043458560\/Vqa6hlDJ_normal.png",
            "id" : 422235993,
            "verified" : false
          }
        }
        """
      }

      assert(actual == 3)
    }
  }
}

