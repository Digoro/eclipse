//--------------------------------------------------------------------------------------
//shapes�� connections�� view�� �ִ´�.
//--------------------------------------------------------------------------------------
package gef;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

public class View extends ViewPart {
	public static final String ID = "GEFTutorial.view";
	private Graph graph;

	static class NewGraphNode extends GraphNode {
		public NewGraphNode(Graph graph, int none, String string) {
			super(graph, none, string);
			setSize(100, 60);
		}

	}
	@Override
	public void createPartControl(Composite parent) {

		graph = new Graph(parent, SWT.NONE);
		GraphNode node1 = new NewGraphNode(graph, SWT.NONE, "Node 1");
		GraphNode node2 = new NewGraphNode(graph, SWT.NONE, "Node 2");
		GraphNode node3 = new NewGraphNode(graph, SWT.NONE, "Node 3");
		GraphNode node4 = new NewGraphNode(graph, SWT.NONE, "Node 4");
		GraphNode node5 = new NewGraphNode(graph, SWT.NONE, "Node 5");

		Figure figure = new Figure();
		Figure figure2 = new Figure();
		
		PolylineConnection c = new PolylineConnection();
		ChopboxAnchor sourceAnchor = new ChopboxAnchor(figure);
		ChopboxAnchor targetAnchor = new ChopboxAnchor(figure2);
		c.setSourceAnchor(sourceAnchor);
		c.setTargetAnchor(targetAnchor);
		
		new GraphConnection(graph, ZestStyles.CONNECTIONS_SOLID, node2, node3);
		new GraphConnection(graph, ZestStyles.CONNECTIONS_SOLID, node2, node4);
		new GraphConnection(graph, ZestStyles.CONNECTIONS_SOLID, node3, node5);
		new GraphConnection(graph, ZestStyles.CONNECTIONS_SOLID, node4, node5);
		
		
		graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	}

	@Override
	public void setFocus() {
	}
}