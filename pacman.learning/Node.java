package pacman.learning;

import java.util.ArrayList;

public class Node {

	private String name;
	private int nodeID;
	private ArrayList<Node> branches;
	//private HashMap<String,Node>;
	private Attribute attribute;
	
	public Node (String name, int nodeID, ArrayList<Node>branches, Attribute attribute){
		this.name = name;
		this.nodeID = nodeID;
		this.branches = branches;
		this.attribute = attribute;
	}
	
	public Node (int nodeCount){
		this.nodeID = nodeCount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	public ArrayList<Node> getBranches() {
		return branches;
	}
	public void setBranches(ArrayList<Node> branches) {
		this.branches = branches;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
}
