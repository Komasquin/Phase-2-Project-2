package com.pojo;
import javax.persistence.*;

@Entity
@Table(name = "products")
public class AddProduct {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "count")
	private int count;
	
	public AddProduct() {
		super();
	}
	public AddProduct(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public AddProduct(int id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AddProduct [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
}
