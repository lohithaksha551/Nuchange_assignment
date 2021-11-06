package com.nuchange.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class UrlEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="url",unique=true)
	private String url;
	
	@Column(name="short_url")
	private String shortUrl;
	
	@Column(name="count")
	private Integer count;
	
	
	public UrlEntity() {
		super();
	}

	public UrlEntity(Integer id, String url, Integer count) {
		super();
		this.id = id;
		this.url = url;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "UrlEntity [id=" + id + ", url=" + url + ", count=" + count + "]";
	}
	
	

}
