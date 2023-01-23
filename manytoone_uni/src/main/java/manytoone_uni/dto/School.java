package manytoone_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School {
	@Id
	private int id;
	private String nameString;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", nameString=" + nameString + "]";
	}
	

}
