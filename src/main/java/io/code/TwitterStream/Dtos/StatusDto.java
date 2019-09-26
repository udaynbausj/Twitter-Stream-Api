package io.code.TwitterStream.Dtos;

import com.google.gson.Gson;
import twitter4j.*;

import java.util.Date;

public class StatusDto {
    private Date createdAt;
    private long id;
    private String text;
    private int displayTextRangeStart = -1;
    private int displayTextRangeEnd = -1;
    private String source;
    private boolean isTruncated;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isRetweeted;
    private int favoriteCount;
    private String inReplyToScreenName;
    private GeoLocation geoLocation = null;
    private Place place = null;
    private long retweetCount;
    private boolean isPossiblySensitive;
    private String lang;
    private long[] contributorsIDs;
    private twitter4j.Status retweetedStatus;
    private UserMentionEntity[] userMentionEntities;
    private URLEntity[] urlEntities;
    private HashtagEntity[] hashtagEntities;
    private MediaEntity[] mediaEntities;
    private SymbolEntity[] symbolEntities;
    private long currentUserRetweetId = -1L;
    private Scopes scopes;
    private User user = null;
    private String[] withheldInCountries = null;
    private twitter4j.Status quotedStatus;
    private long quotedStatusId = -1L;
    private URLEntity quotedStatusPermalink;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDisplayTextRangeStart() {
        return displayTextRangeStart;
    }

    public void setDisplayTextRangeStart(int displayTextRangeStart) {
        this.displayTextRangeStart = displayTextRangeStart;
    }

    public int getDisplayTextRangeEnd() {
        return displayTextRangeEnd;
    }

    public void setDisplayTextRangeEnd(int displayTextRangeEnd) {
        this.displayTextRangeEnd = displayTextRangeEnd;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isTruncated() {
        return isTruncated;
    }

    public void setTruncated(boolean truncated) {
        isTruncated = truncated;
    }

    public long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public boolean isRetweeted() {
        return isRetweeted;
    }

    public void setRetweeted(boolean retweeted) {
        isRetweeted = retweeted;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public boolean isPossiblySensitive() {
        return isPossiblySensitive;
    }

    public void setPossiblySensitive(boolean possiblySensitive) {
        isPossiblySensitive = possiblySensitive;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long[] getContributorsIDs() {
        return contributorsIDs;
    }

    public void setContributorsIDs(long[] contributorsIDs) {
        this.contributorsIDs = contributorsIDs;
    }

    public twitter4j.Status getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(twitter4j.Status retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    public UserMentionEntity[] getUserMentionEntities() {
        return userMentionEntities;
    }

    public void setUserMentionEntities(UserMentionEntity[] userMentionEntities) {
        this.userMentionEntities = userMentionEntities;
    }

    public URLEntity[] getUrlEntities() {
        return urlEntities;
    }

    public void setUrlEntities(URLEntity[] urlEntities) {
        this.urlEntities = urlEntities;
    }

    public HashtagEntity[] getHashtagEntities() {
        return hashtagEntities;
    }

    public void setHashtagEntities(HashtagEntity[] hashtagEntities) {
        this.hashtagEntities = hashtagEntities;
    }

    public MediaEntity[] getMediaEntities() {
        return mediaEntities;
    }

    public void setMediaEntities(MediaEntity[] mediaEntities) {
        this.mediaEntities = mediaEntities;
    }

    public SymbolEntity[] getSymbolEntities() {
        return symbolEntities;
    }

    public void setSymbolEntities(SymbolEntity[] symbolEntities) {
        this.symbolEntities = symbolEntities;
    }

    public long getCurrentUserRetweetId() {
        return currentUserRetweetId;
    }

    public void setCurrentUserRetweetId(long currentUserRetweetId) {
        this.currentUserRetweetId = currentUserRetweetId;
    }

    public Scopes getScopes() {
        return scopes;
    }

    public void setScopes(Scopes scopes) {
        this.scopes = scopes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getWithheldInCountries() {
        return withheldInCountries;
    }

    public void setWithheldInCountries(String[] withheldInCountries) {
        this.withheldInCountries = withheldInCountries;
    }

    public twitter4j.Status getQuotedStatus() {
        return quotedStatus;
    }

    public void setQuotedStatus(twitter4j.Status quotedStatus) {
        this.quotedStatus = quotedStatus;
    }

    public long getQuotedStatusId() {
        return quotedStatusId;
    }

    public void setQuotedStatusId(long quotedStatusId) {
        this.quotedStatusId = quotedStatusId;
    }

    public URLEntity getQuotedStatusPermalink() {
        return quotedStatusPermalink;
    }

    public void setQuotedStatusPermalink(URLEntity quotedStatusPermalink) {
        this.quotedStatusPermalink = quotedStatusPermalink;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
