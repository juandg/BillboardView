package me.juandg.billboardview.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Page {

    @Expose
    private int total;
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();
    @Expose
    private PageLinks links;
    @SerializedName("link_template")
    @Expose
    private String linkTemplate;

    /**
     * @return The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return The links
     */
    public PageLinks getLinks() {
        return links;
    }

    /**
     * @param links The links
     */
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    /**
     * @return The linkTemplate
     */
    public String getLinkTemplate() {
        return linkTemplate;
    }

    /**
     * @param linkTemplate The link_template
     */
    public void setLinkTemplate(String linkTemplate) {
        this.linkTemplate = linkTemplate;
    }

}
