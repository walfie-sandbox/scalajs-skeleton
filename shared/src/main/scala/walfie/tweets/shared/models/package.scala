import derive.key

package walfie.tweets.shared.models {
  /** data/js/tweet_index.js */
  case class TweetsFile(
    fileName: String,
    varName: String,
    tweetCount: Int,
    year: Int,
    month: Int
  )

  /** data/js/user_details.js */
  case class UserDetails(
    id: String,
    screenName: String,
    fullName: String,
    bio: String,
    createdAt: String
  ) extends HasCreatedAt

  /** data/js/payload_details.js */
  case class PayloadDetails(
    tweets: Int,
    createdAt: String,
    lang: String
  ) extends HasCreatedAt

  /** data/js/tweets/yyyy_mm.js */
  // TODO: Missing geo
  case class Tweet(
    source: String,
    @key("id_str") id: String,
    text: String,
    createdAt: String,
    user: User,
    @key("in_reply_to_status_id_str") inReplyToStatusId: Option[String],
    @key("in_reply_to_user_id_str") inReplyToUserId: String,
    entities: Entities
  ) extends HasCreatedAt

  /** data/js/tweets/yyyy_mm.js */
  case class User(
    @key("id_str") id: String,
    name: String,
    screenName: String,
    @key("protected") isProtected: Boolean,
    @key("profile_image_url_https") profileImageUrl: String,
    verified: Boolean
  )

  /** data/js/tweets/yyyy_mm.js */
  case class Entities(
    userMentions: Seq[UserMention],
    media: Seq[Media],
    hashtags: Seq[Hashtag],
    urls: Seq[Url]
  )

  /** data/js/tweets/yyyy_mm.js */
  case class Hashtag(
    text: String,
    indices: Seq[Int]
  ) extends HasIndices

  /** data/js/tweets/yyyy_mm.js */
  case class UserMention(
    name: String,
    screenName: String,
    indices: Seq[Int],
    @key("id_str") id: String
  ) extends HasIndices

  /** data/js/tweets/yyyy_mm.js */
  case class Media(
    expandedUrl: String,
    indices: Seq[Int],
    url: String,
    @key("media_url_https") mediaUrl: String,
    @key("id_str") id: String,
    sizes: Seq[Size],
    displayUrl: String
  ) extends HasIndices

  /** data/js/tweets/yyyy_mm.js */
  case class Size(
    @key("w") width: Int,
    @key("h") height: Int,
    resize: String
  )

  /** data/js/tweets/yyyy_mm.js */
  case class Url(
    indices: Seq[Int],
    url: String,
    expandedUrl: String,
    displayUrl: String
  ) extends HasIndices

  /** Convenience trait for accessing start/end indices */
  trait HasIndices {
    def indices: Seq[Int]

    def startIndex(): Int = indices(0)
    def endIndex(): Int = indices(1)
  }

  trait HasCreatedAt {
    def createdAt: String
  }
}

