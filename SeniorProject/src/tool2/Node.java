package tool2;

/**
 * 
 * @author Ugur Ozkan
 *
 */
public class Node {

	private String id, label;
	private double xPos, yPos;

	public Node(String id, double xPos, double yPos, String label) {
		this.id = id;
		this.xPos = xPos;
		this.yPos = yPos;
		setLabel(label);  //TODO Empty label ?
	}

	private void setLabel(String label) {
		if (label.toLowerCase().equals("Start".toLowerCase()))
			this.label = label;
		else
			this.label = "v_" + label;
	}
	
	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}

}
