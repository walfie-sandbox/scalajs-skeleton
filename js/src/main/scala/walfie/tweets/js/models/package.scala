package walfie.tweets.js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

package models {
  /** data/js/tweet_index.js */
  @js.native
  class TweetsFile extends js.Object {
    @JSName("file_name") val fileName: String = js.native
    @JSName("var_name") val varName: String = js.native
    @JSName("tweet_count") val tweetCount: Int = js.native
    val year: Int = js.native
    val month: Int = js.native
  }

  /** data/js/user_details.js */
  @js.native
  class UserDetails extends js.Object with HasCreatedAt {
    val id: String = js.native
    @JSName("screen_name") val screenName: String = js.native
    @JSName("full_name") val fullName: String = js.native
    val bio: String = js.native
    @JSName("created_at") val createdAt: String = js.native
  }

  /** data/js/payload_details.js */
  @js.native
  class PayloadDetails extends js.Object with HasCreatedAt {
    val tweets: Int = js.native
    val lang: String = js.native
    @JSName("created_at") val createdAt: String = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  // TODO: Missing geo
  @js.native
  class Tweet extends js.Object with HasCreatedAt {
    val source: String = js.native
    val id: String = js.native
    val text: String = js.native
    @JSName("created_at") val createdAt: String = js.native
    val user: User = js.native
    @JSName("in_reply_to_status_id_str") val inReplyToStatusId: js.UndefOr[String] = js.native
    @JSName("in_reply_to_user_id_str") val inReplyToUserId: js.UndefOr[String] = js.native
    val entities: Entities = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class User extends js.Object {
    val id: String = js.native
    val name: String = js.native
    @JSName("screen_name") val screenName: String = js.native
    @JSName("protected") val isProtected: Boolean = js.native
    @JSName("profile_image_url") val profileImageUrl: String = js.native
    val verified: Boolean = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class Entities extends js.Object {
    @JSName("user_mentions") val userMentions: Seq[UserMention] = js.native
    val media: Seq[Media] = js.native
    val hashtags: Seq[Hashtag] = js.native
    val urls: Seq[Url] = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class Hashtag extends js.Object with HasIndices {
    val text: String = js.native
    val indices: Seq[Int] = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class UserMention extends js.Object with HasIndices {
    val name: String = js.native
    @JSName("screen_name") val screenName: String = js.native
    val indices: Seq[Int] = js.native
    val id: String = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class Media extends js.Object with HasIndices {
    @JSName("expanded_url") val expandedUrl: String = js.native
    val indices: Seq[Int] = js.native
    val url: String = js.native
    @JSName("media_url") val mediaUrl: String = js.native
    val id: String = js.native
    val sizes: Seq[Size] = js.native
    @JSName("display_url") val displayUrl: String = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class Size extends js.Object {
    val width: Int = js.native
    val height: Int = js.native
    val resize: String = js.native
  }

  /** data/js/tweets/yyyy_mm.js */
  @js.native
  class Url extends js.Object with HasIndices {
    val indices: Seq[Int] = js.native
    val url: String = js.native
    @JSName("expanded_url") val expandedUrl: String = js.native
    @JSName("display_url") val displayUrl: String = js.native
  }
}

package object models {
  /** Convenience trait for accessing start/end indices */
  @js.native
  trait HasIndices extends js.Object {
    def indices: Seq[Int]
  }

  @js.native
  trait HasCreatedAt extends js.Object {
    def createdAt: String
  }

  implicit class HasIndicesOps(obj: HasIndices) {
    def startIndex: Int = obj.indices(0)
    def endIndex: Int = obj.indices(1)
  }

  implicit class HasCreatedAtOps(obj: HasCreatedAt) {
    def createdAtDate: js.Date = new js.Date(obj.createdAt)
  }
}

