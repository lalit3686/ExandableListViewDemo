package com.example.exandablelistviewdemo;

import java.util.ArrayList;

public class ExpandListGroup {
	 
	private String Name;
	private ArrayList<ExpandListChild> childItems;
	
	public ArrayList<ExpandListChild> getChildItems() {
		return childItems;
	}
	public void setChildItems(ArrayList<ExpandListChild> childItems) {
		this.childItems = childItems;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
}