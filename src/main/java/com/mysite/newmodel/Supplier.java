package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier {
@Id
private String supplierid;

@Length(min=10,message= "suppliername min length is 10")
private String suppliername;

@Length(min=10,message= "supplierdescription min length is 10")
private String supplierdescription;

private boolean isavaliable;
@Transient
private MultipartFile imageFile;

public MultipartFile getImageFile() {
	return imageFile;
}
public void setImageFile(MultipartFile imageFile) {
	this.imageFile = imageFile;
}
public String getSupplierid() {
	return supplierid;
}
public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public String getSupplierdescription() {
	return supplierdescription;
}
public void setSupplierdescription(String supplierdescription) {
	this.supplierdescription = supplierdescription;
}
public boolean getIsavaliable() {
	return isavaliable;
}
public void setIsavaliable(boolean isavaliable) {
	this.isavaliable = isavaliable;
}
	
}



