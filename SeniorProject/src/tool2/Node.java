package tool2;

/**
 * @author Ugur Ozkan
 * 
 */
public class Node {

	private static int uniqueId = 0;
	private String id, label;
	private double xPos, yPos;

	public Node(String id, double xPos, double yPos, String label) {
		setId(id);
		setXPos(xPos);
		setYPos(yPos);
		setLabel(label);
	}

	private void setId(String id) {
		if (id.isEmpty() || id == null)
			this.id = "v" + (uniqueId++);
		else
			this.id = id;
	}

	private void setXPos(double xPos) {
		if (xPos >= Double.MAX_VALUE || xPos <= Double.MIN_VALUE)
			this.xPos = 0.0;
		else
			this.xPos = xPos;
	}

	private void setYPos(double yPos) {
		if (yPos >= Double.MAX_VALUE || yPos <= Double.MIN_VALUE)
			this.yPos = 0.0;
		else
			this.yPos = yPos;
	}

	private void setLabel(String label) {
		if (label.toLowerCase().equals("Start".toLowerCase()))
			this.label = label;
		else if (label.isEmpty() || label == null)
			this.label = "v_" + getId();
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
