package org.example;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@EntityListeners(Movie.AuditListener.class)
public class Movie {
    @Id
    private String imdbId;
    private String title;
    private String description;
    private BigDecimal rating;
    private String genre;
    private Integer year;
    @Column(insertable = true, updatable = true)
    private LocalDateTime lastModified;

    public Movie(String imdbId, String title, String description, BigDecimal rating, String genre, Integer year, LocalDateTime lastModified) {
        this.imdbId = imdbId;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.lastModified = lastModified;
    }

    public Movie() {

    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    // Optional: Override the toString method for easy debugging and logging
    @Override
    public String toString() {
        return "Movie{" +
                "imdbId='" + imdbId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", lastModified=" + lastModified +
                '}';
    }

    public static class AuditListener {
        @PrePersist
        @PreUpdate
        public void setLastModified(Movie movie) {
            movie.setLastModified(LocalDateTime.now());
        }
    }
}