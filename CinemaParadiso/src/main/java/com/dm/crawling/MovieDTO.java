package com.dm.crawling;

public class MovieDTO {
	private String title;
    private String poster;
    private String rank;
    private String audience;
    private int pg;
    private int running_time;
    private String date;
    private String director;
    private String cast;
    private String synopsis;
    private String movie_code;
    private String stillcut;
    private String genre;
	
	public MovieDTO(String rank, String title, String poster, String movie_code) {
    	this.rank=rank;
    	this.title=title;
    	this.poster=poster;
    	this.movie_code=movie_code;
    }
	public MovieDTO(String title, String poster, String audience, int pg, int running_time, String date, String director, String cast, String synopsis, String movie_code, String stillcut, String genre) {
    	this.title=title;
    	this.poster=poster;
    	this.audience=audience;
    	this.pg=pg;
    	this.date=date;
    	this.running_time=running_time;
    	this.director = director;
    	this.cast=cast;
    	this.synopsis=synopsis;
    	this.movie_code=movie_code;
    	this.stillcut=stillcut;
    	this.genre=genre;
    }
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
    
    public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public Integer getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public Integer getRunning_time() {
		return running_time;
	}
	public void setRunning_time(int running_time) {
		this.running_time = running_time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getMovie_code() {
		return movie_code;
	}
	public void setMovie_code(String movie_code) {
		this.movie_code = movie_code;
	}
	public String getStillcut() {
		return stillcut;
	}
	public void setStillcut(String stillcut) {
		this.stillcut = stillcut;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
