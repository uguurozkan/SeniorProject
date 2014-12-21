package tool2;

/**
 * 
 * @author Ugur Ozkan
 *
 */
public class Edge {

	private String id, label;
	private Node source, target;

	public Edge(String id, Node source, Node target, String label) {
		this.id = id;
		this.source = source;
		this.target = target;
		this.label = "e_" + label; //TODO empty label ?
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
