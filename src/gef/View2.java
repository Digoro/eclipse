//--------------------------------------------------------------------------------------
//shapes�� connections�� view�� �ִ´�.
//--------------------------------------------------------------------------------------
package gef;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

public class View2 extends ViewPart {
	public static final String ID = "GEFTutorial.view";
	private Graph graph;
	
	static class NewGraphNode extends GraphNode{
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

		new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1, node2);
		new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node2, node3);
		new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node3, node1);

		graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	}

	@Override
	public void setFocus() {
	}
}