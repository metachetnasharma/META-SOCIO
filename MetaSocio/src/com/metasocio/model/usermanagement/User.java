package com.metasocio.model.usermanagement;




import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
    
public class User {

int user_id;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getImage_url() {
	return image_url;
}
public void setImage_url(String image_url) {
	this.image_url = image_url;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getProject_name() {
	return project_name;
}
public void setProject_name(String project_name) {
	this.project_name = project_name;
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
public String getPhone_No() {
	return phone_No;
}
public void setPhone_No(String phone_No) {
	this.phone_No = phone_No;
}
String name;
String email_id;
String image_url;
String role;
String department;
String project_name;
Date created_at;
Timestamp updated_at;
String created_by;
String updated_by;
int isdelete;
String phone_No;
}
