package manytoone_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
@Id
private int id;
private String ifsc;
private String name;
private String manager;
private long phone;
@ManyToOne
private Bank bank;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public Bank getBank() {
	return bank;
}
public void setBank(Bank bank) {
	this.bank = bank;
}
@Override
public String toString() {
	return "Branch [id=" + id + ", ifsc=" + ifsc + ", name=" + name + ", manager=" + manager + ", phone=" + phone
			+ ", bank=" + bank + "]";
}

}
