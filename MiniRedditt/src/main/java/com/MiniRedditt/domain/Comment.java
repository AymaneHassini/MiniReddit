package com.MiniRedditt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Comment{
private CommentId pk;
@EmbeddedId
public CommentId getPk() {
	return pk;
}
public void setPk(CommentId pk) {
	this.pk = pk;
}
@Column(length=5000)
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
private String text;
}