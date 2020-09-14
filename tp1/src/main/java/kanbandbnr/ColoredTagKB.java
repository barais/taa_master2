package kanbandbnr;

import javax.persistence.Entity;

@Entity
public class ColoredTagKB extends TagKB {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
