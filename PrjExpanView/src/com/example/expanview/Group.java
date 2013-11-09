package com.example.expanview;

import java.util.ArrayList;
import java.util.List;


public class Group {
	public String string;
	public int backGroundColor;
	public int fontColor;
	public int drwLeft;
	public final List<Child> children = new ArrayList<Child>();
	public Group(String string, int backGroundColor, int fontColor, int drwLeft) {
		this.string = string;
		this.backGroundColor = backGroundColor;
		this.fontColor = fontColor;
		this.drwLeft = drwLeft;
	}
}