package com.forcohen.imdb.cli.models;

import java.util.Date;

public class Review {
	int idTeacher;
	int idClass;
	int idUser;
	String review; 
	int stars;
	Date reviewDate;
	int month;
	int year;
	
	public Review() {
		super();
	}

	public Review(int idTeacher, int idClass, int idUser, String review, int stars, Date reviewDate, int month,
			int year) {
		super();
		this.idTeacher = idTeacher;
		this.idClass = idClass;
		this.idUser = idUser;
		this.review = review;
		this.stars = stars;
		this.reviewDate = reviewDate;
		this.month = month;
		this.year = year;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public int getIdClass() {
		return idClass;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
