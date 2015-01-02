package tool2;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates the necessary .graphml code.
 * 
 * @author Ugur Ozkan
 * 
 */
public class GraphMLCreator {
	
	private List<Node> nodes;
	private List<Edge> edges;
	private String graphML;
	
	public GraphMLCreator() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		this.graphML = "";
	}
	
	public GraphMLCreator(List<Node> nodes) {
		this();
		this.nodes = nodes;
	}
	
	public GraphMLCreator(List<Node> nodes, List<Edge> edges){
		this(nodes);
		this.edges = edges;
	}

	public String getGraphML() {
		constructGraphML();
		return graphML;
	}
	
	private void constructGraphML() {
		graphML += addHeader();
		graphML += addStartNode();
		
		for (Node node : nodes) 
			graphML += addNode(node);
		
		for (Edge edge : edges) 
			graphML += addEdge(edge);
		
		graphML += addFooter();
	}

	private String addHeader() {
		return "" +
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n" + 
			"<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:y=\"http://www.yworks.com/xml/graphml\" xmlns:yed=\"http://www.yworks.com/xml/yed/3\" xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd\">\r\n" + 
			"  <!--Created by yEd 3.13-->\r\n" + 
			"  <key attr.name=\"Description\" attr.type=\"string\" for=\"graph\" id=\"d0\"/>\r\n" + 
			"  <key for=\"port\" id=\"d1\" yfiles.type=\"portgraphics\"/>\r\n" + 
			"  <key for=\"port\" id=\"d2\" yfiles.type=\"portgeometry\"/>\r\n" + 
			"  <key for=\"port\" id=\"d3\" yfiles.type=\"portuserdata\"/>\r\n" + 
			"  <key attr.name=\"url\" attr.type=\"string\" for=\"node\" id=\"d4\"/>\r\n" + 
			"  <key attr.name=\"description\" attr.type=\"string\" for=\"node\" id=\"d5\"/>\r\n" + 
			"  <key for=\"node\" id=\"d6\" yfiles.type=\"nodegraphics\"/>\r\n" + 
			"  <key for=\"graphml\" id=\"d7\" yfiles.type=\"resources\"/>\r\n" + 
			"  <key attr.name=\"url\" attr.type=\"string\" for=\"edge\" id=\"d8\"/>\r\n" + 
			"  <key attr.name=\"description\" attr.type=\"string\" for=\"edge\" id=\"d9\"/>\r\n" + 
			"  <key for=\"edge\" id=\"d10\" yfiles.type=\"edgegraphics\"/>\r\n" + 
			"  <graph edgedefault=\"directed\" id=\"G\">\r\n" + 
			"    <data key=\"d0\"/>\r\n";
	}
	
	private String addStartNode() {
		return "\r\n" +
				"    <node id=\"start1\">\r\n" + 
				"      <data key=\"d5\"/>\r\n" + 
				"      <data key=\"d6\">\r\n" + 
				"        <y:ShapeNode>\r\n" + 
				"          <y:Geometry height=\"20.0\" width=\"180.0\" x=\"-50\" y=\"-50\"/>\r\n" + 
				"          <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\r\n" + 
				"          <y:BorderStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
				"          <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" textColor=\"#000000\" visible=\"true\" width=\"120.384765625\" x=\"29.8076171875\" y=\"5.6494140625\">Start<y:LabelModel>\r\n" + 
				"              <y:SmartNodeLabelModel distance=\"4.0\"/>\r\n" + 
				"            </y:LabelModel>\r\n" + 
				"            <y:ModelParameter>\r\n" + 
				"              <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\r\n" + 
				"            </y:ModelParameter>\r\n" + 
				"          </y:NodeLabel>\r\n" + 
				"          <y:Shape type=\"roundrectangle\"/>\r\n" + 
				"        </y:ShapeNode>\r\n" + 
				"      </data>\r\n" + 
				"    </node>\r\n" +
				"\r\n" +
				"    <node id=\"start2\">\r\n" + 
				"      <data key=\"d5\"/>\r\n" + 
				"      <data key=\"d6\">\r\n" + 
				"        <y:ShapeNode>\r\n" + 
				"          <y:Geometry height=\"20.0\" width=\"180.0\" x=\"200\" y=\"-50\"/>\r\n" + 
				"          <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\r\n" + 
				"          <y:BorderStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
				"          <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" textColor=\"#000000\" visible=\"true\" width=\"120.384765625\" x=\"29.8076171875\" y=\"5.6494140625\">StartLink<y:LabelModel>\r\n" + 
				"              <y:SmartNodeLabelModel distance=\"4.0\"/>\r\n" + 
				"            </y:LabelModel>\r\n" + 
				"            <y:ModelParameter>\r\n" + 
				"              <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\r\n" + 
				"            </y:ModelParameter>\r\n" + 
				"          </y:NodeLabel>\r\n" + 
				"          <y:Shape type=\"roundrectangle\"/>\r\n" + 
				"        </y:ShapeNode>\r\n" + 
				"      </data>\r\n" + 
				"    </node>\r\n" +
				"\r\n" +
			    "    <edge id=\"startEdge\" source=\"start1\" target=\"start2\">\r\n" + 
				"      <data key=\"d9\"/>\r\n" + 
				"      <data key=\"d10\">\r\n" + 
				"        <y:PolyLineEdge>\r\n" + 
				"          <y:Path sx=\"0\" sy=\"0\" tx=\"0\" ty=\"0\"/>\r\n" + 
				"          <y:LineStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
				"          <y:Arrows source=\"none\" target=\"standard\"/>\r\n" + 
				"          <y:EdgeLabel alignment=\"center\" configuration=\"AutoFlippingLabel\" distance=\"2.0\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" preferredPlacement=\"anywhere\" ratio=\"0.5\" textColor=\"#000000\" visible=\"true\" width=\"24.021484375\" x=\"17.98925724231036\" y=\"-24.3408203125\">e_Start<y:LabelModel>\r\n" + 
				"              <y:SmartEdgeLabelModel autoRotationEnabled=\"false\" defaultAngle=\"0.0\" defaultDistance=\"10.0\"/>\r\n" + 
				"            </y:LabelModel>\r\n" + 
				"            <y:ModelParameter>\r\n" + 
				"              <y:SmartEdgeLabelModelParameter angle=\"0.0\" distance=\"30.0\" distanceToCenter=\"true\" position=\"right\" ratio=\"0.5\" segment=\"0\"/>\r\n" + 
				"            </y:ModelParameter>\r\n" + 
				"            <y:PreferredPlacementDescriptor angle=\"0.0\" angleOffsetOnRightSide=\"0\" angleReference=\"absolute\" angleRotationOnRightSide=\"co\" distance=\"-1.0\" frozen=\"true\" placement=\"anywhere\" side=\"anywhere\" sideReference=\"relative_to_edge_flow\"/>\r\n" + 
				"          </y:EdgeLabel>\r\n" +
				"          <y:BendStyle smoothed=\"false\"/>\r\n" + 
				"        </y:PolyLineEdge>\r\n" + 
				"      </data>\r\n" + 
				"    </edge>\r\n";

	}
	
	private String addNode(Node node) {
		return "\r\n" +
			"    <node id=\"" + node.getId() + "1\">\r\n" + 
			"      <data key=\"d5\"/>\r\n" + 
			"      <data key=\"d6\">\r\n" + 
			"        <y:ShapeNode>\r\n" + 
			"          <y:Geometry height=\"20.0\" width=\"180.0\" x=\"" + node.getxPos() + "\" y=\"" + node.getyPos() + "\"/>\r\n" + 
			"          <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\r\n" + 
			"          <y:BorderStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
			"          <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" textColor=\"#000000\" visible=\"true\" width=\"120.384765625\" x=\"29.8076171875\" y=\"5.6494140625\">" + node.getLabel() + "<y:LabelModel>\r\n" + 
			"              <y:SmartNodeLabelModel distance=\"4.0\"/>\r\n" + 
			"            </y:LabelModel>\r\n" + 
			"            <y:ModelParameter>\r\n" + 
			"              <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\r\n" + 
			"            </y:ModelParameter>\r\n" + 
			"          </y:NodeLabel>\r\n" + 
			"          <y:Shape type=\"roundrectangle\"/>\r\n" + 
			"        </y:ShapeNode>\r\n" + 
			"      </data>\r\n" + 
			"    </node>\r\n" +
			"\r\n" +
			"    <node id=\"" + node.getId() + "2\">\r\n" + 
			"      <data key=\"d5\"/>\r\n" + 
			"      <data key=\"d6\">\r\n" + 
			"        <y:ShapeNode>\r\n" + 
			"          <y:Geometry height=\"20.0\" width=\"180.0\" x=\"" + (node.getxPos() + 250) + "\" y=\"" + node.getyPos() + "\"/>\r\n" + 
			"          <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\r\n" + 
			"          <y:BorderStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
			"          <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" textColor=\"#000000\" visible=\"true\" width=\"120.384765625\" x=\"29.8076171875\" y=\"5.6494140625\">" + node.getLabel() + "Link<y:LabelModel>\r\n" + 
			"              <y:SmartNodeLabelModel distance=\"4.0\"/>\r\n" + 
			"            </y:LabelModel>\r\n" + 
			"            <y:ModelParameter>\r\n" + 
			"              <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\r\n" + 
			"            </y:ModelParameter>\r\n" + 
			"          </y:NodeLabel>\r\n" + 
			"          <y:Shape type=\"roundrectangle\"/>\r\n" + 
			"        </y:ShapeNode>\r\n" + 
			"      </data>\r\n" + 
			"    </node>\r\n" +
			"\r\n" +
		    "    <edge id=\"e_" + node.getId() + "\" source=\"" + node.getId() + "1\" target=\"" + node.getId() + "2\">\r\n" + 
			"      <data key=\"d9\"/>\r\n" + 
			"      <data key=\"d10\">\r\n" + 
			"        <y:PolyLineEdge>\r\n" + 
			"          <y:Path sx=\"0\" sy=\"0\" tx=\"0\" ty=\"0\"/>\r\n" + 
			"          <y:LineStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
			"          <y:Arrows source=\"none\" target=\"standard\"/>\r\n" + 
			"          <y:EdgeLabel alignment=\"center\" configuration=\"AutoFlippingLabel\" distance=\"2.0\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" preferredPlacement=\"anywhere\" ratio=\"0.5\" textColor=\"#000000\" visible=\"true\" width=\"24.021484375\" x=\"17.98925724231036\" y=\"-24.3408203125\">e_" + node.getLabel() + "<y:LabelModel>\r\n" + 
			"              <y:SmartEdgeLabelModel autoRotationEnabled=\"false\" defaultAngle=\"0.0\" defaultDistance=\"10.0\"/>\r\n" + 
			"            </y:LabelModel>\r\n" + 
			"            <y:ModelParameter>\r\n" + 
			"              <y:SmartEdgeLabelModelParameter angle=\"0.0\" distance=\"30.0\" distanceToCenter=\"true\" position=\"right\" ratio=\"0.5\" segment=\"0\"/>\r\n" + 
			"            </y:ModelParameter>\r\n" + 
			"            <y:PreferredPlacementDescriptor angle=\"0.0\" angleOffsetOnRightSide=\"0\" angleReference=\"absolute\" angleRotationOnRightSide=\"co\" distance=\"-1.0\" frozen=\"true\" placement=\"anywhere\" side=\"anywhere\" sideReference=\"relative_to_edge_flow\"/>\r\n" + 
			"          </y:EdgeLabel>\r\n" +
			"          <y:BendStyle smoothed=\"false\"/>\r\n" + 
			"        </y:PolyLineEdge>\r\n" + 
			"      </data>\r\n" + 
			"    </edge>\r\n";
	}
	
	private String addEdge(Edge edge) {
		return "\r\n" +
		    "    <edge id=\"" + edge.getId() + "\" source=\"" + edge.getSource().getId() + "\" target=\"" + edge.getTarget().getId() + "\">\r\n" + 
			"      <data key=\"d9\"/>\r\n" + 
			"      <data key=\"d10\">\r\n" + 
			"        <y:PolyLineEdge>\r\n" + 
			"          <y:Path sx=\"" + (10 * (edge.getSource().getxPos() - edge.getTarget().getxPos()) / (edge.getSource().getxPos() + edge.getTarget().getxPos())) + "\" sy=\"" + ((edge.getSource().getyPos() - edge.getTarget().getyPos()) / (edge.getSource().getyPos() + edge.getTarget().getyPos())) + "\" tx=\"" + 0 + "\" ty=\"" + 0 + "\"/>\r\n" + 
			"          <y:LineStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\r\n" + 
			"          <y:Arrows source=\"none\" target=\"standard\"/>\r\n" + 
			"          <y:EdgeLabel alignment=\"center\" configuration=\"AutoFlippingLabel\" distance=\"2.0\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" modelName=\"custom\" preferredPlacement=\"anywhere\" ratio=\"0.5\" textColor=\"#000000\" visible=\"true\" width=\"24.021484375\" x=\"17.98925724231036\" y=\"-24.3408203125\">" + edge.getLabel() + "<y:LabelModel>\r\n" + 
			"              <y:SmartEdgeLabelModel autoRotationEnabled=\"false\" defaultAngle=\"0.0\" defaultDistance=\"10.0\"/>\r\n" + 
			"            </y:LabelModel>\r\n" + 
			"            <y:ModelParameter>\r\n" + 
			"              <y:SmartEdgeLabelModelParameter angle=\"0.0\" distance=\"30.0\" distanceToCenter=\"true\" position=\"right\" ratio=\"0.5\" segment=\"0\"/>\r\n" + 
			"            </y:ModelParameter>\r\n" + 
			"            <y:PreferredPlacementDescriptor angle=\"0.0\" angleOffsetOnRightSide=\"0\" angleReference=\"absolute\" angleRotationOnRightSide=\"co\" distance=\"-1.0\" frozen=\"true\" placement=\"anywhere\" side=\"anywhere\" sideReference=\"relative_to_edge_flow\"/>\r\n" + 
			"          </y:EdgeLabel>\r\n" +
			"          <y:BendStyle smoothed=\"false\"/>\r\n" + 
			"        </y:PolyLineEdge>\r\n" + 
			"      </data>\r\n" + 
			"    </edge>\r\n";
	}
	
	private String addFooter() { 
		return "\r\n" +
			"  </graph>\r\n" + 
			"  <data key=\"d7\">\r\n" + 
			"    <y:Resources/>\r\n" + 
			"  </data>\r\n" + 
			"</graphml>\r\n";
	}
	
}
