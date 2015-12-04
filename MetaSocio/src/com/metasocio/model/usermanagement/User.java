package com.metasocio.model.usermanagement;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

public class User {

	private	int userId;
	private	String name;
	private	String emailId;
	private	String address;
	private	String phoneNo;
	private	String city;
	private	String department;
	private	String role;
	private	String college;
	private	String course;
	private String highSchool;
	private	String stream;
	private	Date dateOfBirth;
	private	String gender;
	private	String imageURL;
	private	String about;
	private	String nickName;
	private	String relationshipStatus;
	private	Date createdAt;
	private	Timestamp updatedAt;
	private	String createdBy;
	private	String updatedBy;
	private	int isDelete;
	private Set<User> users = new HashSet<User>(0);
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId="
				+ emailId + ", address=" + address + ", phoneNo=" + phoneNo
				+ ", city=" + city + ", department=" + department + ", role="
				+ role + ", college=" + college + ", course=" + course
				+ ", highSchool=" + highSchool + ", stream=" + stream
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", imageURL=" + imageURL + ", about=" + about + ", nickName="
				+ nickName + ", relationshipStatus=" + relationshipStatus
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", isDelete=" + isDelete  + "]";
	}

	

	


}
