package tool2;

import java.util.ArrayList;
import java.util.List;

public class Tool2 {

	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();
		Node start = new Node("start", -50.0, -50.0, "Start");
		Node n0 = new Node("n0", 0.0, 0.0, "type_name_firstname");
		Node n1 = new Node("n1", 50.0, 50.0, "type_name_lastname");
		//Node n2 = new Node("n2", 100.0, 100.0, "click_with_id_sex-1");
		Node n3 = new Node("n3", 150.0, 150.0, "clickAndWait_id_submit");
		nodes.add(start);
		nodes.add(n0);
		nodes.add(n1);
		//nodes.add(n2);
		nodes.add(n3);
		
		
		List<Edge> edges = new ArrayList<Edge>();
		Edge e0 = new Edge("e0", start, n0, "start_n0");
		Edge e1 = new Edge("e1", n0, n1, "n0_n1");
		Edge e2 = new Edge("e2", n1, n3, "n1_n3");
		//Edge e3 = new Edge("e3", n3, n2, "n3_n1");
		Edge e4 = new Edge("e4", n1, n0, "n1_n0");
		edges.add(e0);
		edges.add(e1);
		edges.add(e2);
		//edges.add(e3);
		edges.add(e4);
		
		GraphMLCreator gc = new GraphMLCreator(nodes, edges);
		System.out.println(gc.getGraphML());
		
	}

}
