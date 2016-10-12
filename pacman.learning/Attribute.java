package pacman.learning;

import java.util.ArrayList;

public class Attribute {
	
	private String name;
	private ArrayList<Object> value;
	private int position;

	public Attribute(String name, ArrayList<Object> value, int position) {
		this.name = name;
		this.value = value;
		this.position = position;
	}
	
	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Object> getValue() {
		return value;
	}

	public void setValue(ArrayList<Object> value) {
		this.value = value;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
