package com.Restaurant.entities;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "F_id")
	 int fid;
	@Column(name = "F_name", nullable = false, length = 50)
	 String foodname;

	@Column(name = "F_type", nullable = false, length = 50)
	 String type;

	@Column(name = "F_description", columnDefinition = "TEXT")
	 String description;

	@Column(name = "F_price", nullable = false)
	 int price;

	@Column(name = "F_Quantity", nullable = false)
	 int quantity;

	@Column(name = "Image")
	 String FoodImage;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Admin_id")
	public User admin;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "food")
	public Set<OrderItems> orderItems = new HashSet<>();
	

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFoodImage() {
		return FoodImage;
	}

	public void setFoodImage(String foodImage) {
		FoodImage = foodImage;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
}
