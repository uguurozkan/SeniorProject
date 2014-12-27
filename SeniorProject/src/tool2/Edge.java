package tool2;

/**
 * @author Ugur Ozkan
 * 
 */
public class Edge {

	private static int uniqueId = 0;
	private String id, label;
	private Node source, target;

	public Edge(String id, Node source, Node target, String label) {
		setId(id);
		setSource(source);
		setTarget(target);
		setLabel(label);
	}

	private void setId(String id) {
		if (id.isEmpty() || id == null)
			this.id = "e" + (uniqueId++);
		else
			this.id = id;
	}

	private void setSource(Node source) {
		if (source == null)
			this.source = new Node("TempSource" + getId(), -272.0, -124.0,
					"tempSource" + getId());
		else
			this.source = source;
	}

	private void setTarget(Node target) {
		if (target == null)
			this.target = new Node("TempTarget" + getId(), -312.0, -124.0,
					"tempTarget" + getId());
		else
			this.target = target;
	}

	private void setLabel(String label) {
		if (label.isEmpty() || label == null)
			this.label = "e_" + getId();
		else
			this.label = "e_" + label;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Node getSource() {
		return source;
	}

	public Node getTarget() {
		return target;
	}

}
