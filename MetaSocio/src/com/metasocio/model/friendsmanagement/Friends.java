package com.metasocio.model.friendsmanagement;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;
@Data
public class Friends {
	int id;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFriend_one() {
		return friend_one;
	}
	public void setFriend_one(int friend_one) {
		this.friend_one = friend_one;
	}
	public int getFriend_two() {
		return friend_two;
	}
	public void setFriend_two(int friend_two) {
		this.friend_two = friend_two;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	int friend_one ;
	int friend_two;
	Date created_at;
	Timestamp updated_at;
	String created_by;
	String updated_by;
	int isdelete;
}
