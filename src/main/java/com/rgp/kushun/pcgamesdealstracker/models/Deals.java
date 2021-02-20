package com.rgp.kushun.pcgamesdealstracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deals {

    @SerializedName("internalName")
    @Expose
    private String internalName;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("metacriticLink")
    @Expose
    private String metacriticLink;
    @SerializedName("dealID")
    @Expose
    private String dealID;
    @SerializedName("storeID")
    @Expose
    private String storeID;
    @SerializedName("gameID")
    @Expose
    private String gameID;
    @SerializedName("salePrice")
    @Expose
    private String salePrice;
    @SerializedName("normalPrice")
    @Expose
    private String normalPrice;
    @SerializedName("isOnSale")
    @Expose
    private String isOnSale;
    @SerializedName("savings")
    @Expose
    private String savings;
    @SerializedName("metacriticScore")
    @Expose
    private String metacriticScore;
    @SerializedName("steamRatingText")
    @Expose
    private String steamRatingText;
    @SerializedName("steamRatingPercent")
    @Expose
    private String steamRatingPercent;
    @SerializedName("steamRatingCount")
    @Expose
    private String steamRatingCount;
    @SerializedName("steamAppID")
    @Expose
    private String steamAppID;
    @SerializedName("releaseDate")
    @Expose
    private Integer releaseDate;
    @SerializedName("lastChange")
    @Expose
    private Integer lastChange;
    @SerializedName("dealRating")
    @Expose
    private String dealRating;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetacriticLink() {
        return metacriticLink;
    }

    public void setMetacriticLink(String metacriticLink) {
        this.metacriticLink = metacriticLink;
    }

    public String getDealID() {
        return dealID;
    }

    public void setDealID(String dealID) {
        this.dealID = dealID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    public String getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(String isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        this.savings = savings;
    }

    public String getMetacriticScore() {
        return metacriticScore;
    }

    public void setMetacriticScore(String metacriticScore) {
        this.metacriticScore = metacriticScore;
    }

    public String getSteamRatingText() {
        return steamRatingText;
    }

    public void setSteamRatingText(String steamRatingText) {
        this.steamRatingText = steamRatingText;
    }

    public String getSteamRatingPercent() {
        return steamRatingPercent;
    }

    public void setSteamRatingPercent(String steamRatingPercent) {
        this.steamRatingPercent = steamRatingPercent;
    }

    public String getSteamRatingCount() {
        return steamRatingCount;
    }

    public void setSteamRatingCount(String steamRatingCount) {
        this.steamRatingCount = steamRatingCount;
    }

    public String getSteamAppID() {
        return steamAppID;
    }

    public void setSteamAppID(String steamAppID) {
        this.steamAppID = steamAppID;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getLastChange() {
        return lastChange;
    }

    public void setLastChange(Integer lastChange) {
        this.lastChange = lastChange;
    }

    public String getDealRating() {
        return dealRating;
    }

    public void setDealRating(String dealRating) {
        this.dealRating = dealRating;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "Deals{" +
                "internalName='" + internalName + '\'' +
                ", title='" + title + '\'' +
                ", metacriticLink='" + metacriticLink + '\'' +
                ", dealID='" + dealID + '\'' +
                ", storeID='" + storeID + '\'' +
                ", gameID='" + gameID + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", normalPrice='" + normalPrice + '\'' +
                ", isOnSale='" + isOnSale + '\'' +
                ", savings='" + savings + '\'' +
                ", metacriticScore='" + metacriticScore + '\'' +
                ", steamRatingText='" + steamRatingText + '\'' +
                ", steamRatingPercent='" + steamRatingPercent + '\'' +
                ", steamRatingCount='" + steamRatingCount + '\'' +
                ", steamAppID='" + steamAppID + '\'' +
                ", releaseDate=" + releaseDate +
                ", lastChange=" + lastChange +
                ", dealRating='" + dealRating + '\'' +
                ", thumb='" + thumb + '\'' +
                '}';
    }
}