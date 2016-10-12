package pacman.learning;

import java.util.ArrayList;
import dataRecording.DataTuple;

public class Table {

	private DataTuple data;
	private ArrayList<Attribute> targetAttributes;
	private ArrayList<Attribute> attributes;
	
	public Table (DataTuple examples, ArrayList<Attribute> targetAttributes, ArrayList<Attribute> attributes) {
		this.data = examples;
		this.targetAttributes = targetAttributes;
		this.attributes = attributes;
	}

	public DataTuple getData() {
		return data;
	}


	public void setData(DataTuple data) {
		this.data = data;
	}


	public ArrayList<Attribute> getTargetAttributes() {
		return targetAttributes;
	}


	public void setTargetAttributes(ArrayList<Attribute> targetAttributes) {
		this.targetAttributes = targetAttributes;
	}


	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}


	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
}
