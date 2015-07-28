package me.juandg.billboardview.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Ratings {

    @SerializedName("critics_rating")
    @Expose
    private String criticsRating;
    @SerializedName("critics_score")
    @Expose
    private String criticsScore;
    @SerializedName("audience_rating")
    @Expose
    private String audienceRating;
    @SerializedName("audience_score")
    @Expose
    private String audienceScore;

    /**
     * @return The criticsRating
     */
    public String getCriticsRating() {
        return criticsRating;
    }

    /**
     * @param criticsRating The critics_rating
     */
    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    /**
     * @return The criticsScore
     */
    public String getCriticsScore() {
        return criticsScore;
    }

    /**
     * @param criticsScore The critics_score
     */
    public void setCriticsScore(String criticsScore) {
        this.criticsScore = criticsScore;
    }

    /**
     * @return The audienceRating
     */
    public String getAudienceRating() {
        return audienceRating;
    }

    /**
     * @param audienceRating The audience_rating
     */
    public void setAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
    }

    /**
     * @return The audienceScore
     */
    public String getAudienceScore() {
        return audienceScore;
    }

    /**
     * @param audienceScore The audience_score
     */
    public void setAudienceScore(String audienceScore) {
        this.audienceScore = audienceScore;
    }

}
