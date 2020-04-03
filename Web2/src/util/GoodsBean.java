package util;

public class GoodsBean {
	private String picture;
	private String id;
	private String name;
	private String factory;
	private String category;
	private String model;
	private String place;
	private String describe;
	
	//构造方法
	public GoodsBean(String picture,String id,String name,String factory,String category,String model,String place,String describe) {
		this.picture=picture;
		this.id=id;
		this.name=name;
		this.factory=factory;
		this.category=category;
		this.model=model;
		this.place=place;
		this.describe=describe;
	}
	
	//get方法
	public String getPicture() {
		return picture;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFactory() {
		return factory;
	}
	public String getCategory() {
		return category;
	}
	public String getModel() {
		return model;
	}
	public String getPlace() {
		return place;
	}
	public String getDescribe() {
		return describe;
	}
	
	//set方法
	public void setPicture(String s) {
		picture=s;
	}
	public void setId(String s) {
		id=s;
	}
	public void setName(String s) {
		name=s;
	}
	public void setFactory(String s) {
		factory=s;
	}
	public void setCategory(String s) {
		category=s;
	}
	public void setModel(String s) {
		model=s;
	}
	public void setPlace(String s) {
		place=s;
	}
	public void setDescribe(String s) {
		describe=s;
	}
}
