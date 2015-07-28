package me.juandg.billboardview.models;

import com.google.gson.annotations.Expose;


public class ReleaseDates {

    @Expose
    private String theater;
    @Expose
    private String dvd;

    /**
     * @return The theater
     */
    public String getTheater() {
        return theater;
    }

    /**
     * @param theater The theater
     */
    public void setTheater(String theater) {
        this.theater = theater;
    }

    /**
     * @return The dvd
     */
    public String getDvd() {
        return dvd;
    }

    /**
     * @param dvd The dvd
     */
    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

}
