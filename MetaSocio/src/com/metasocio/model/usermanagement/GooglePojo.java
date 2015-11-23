package com.metasocio.model.usermanagement;


import lombok.Data;

@Data
public class GooglePojo {
    String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified_email() {
		return verified_email;
	}

	public void setVerified_email(boolean verified_email) {
		this.verified_email = verified_email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	String email;
    boolean verified_email;
    String name;
    String given_name;
    String family_name;
    String picture;
    String hd = "gmail.com";

    @Override
    public String toString() {
        return "GooglePojo [id=" + id + ", email=" + email
                +",shd="+hd+ ", verified_email=" + verified_email +",picture="+picture+", name=" + name
                + ", given_name=" + given_name + ", family_name=" + family_name
                + "]";
    }
}