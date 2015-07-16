//--------------------------------------------------------------------------------------
//shapes�� connections�� view�� �ִ´�.
//--------------------------------------------------------------------------------------
package gef;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import gef.EditPart.GraphicalPartFactory;
import gef.Model.Model;

public class View extends ViewPart {
	public static final String ID = "GEFTutorial.view";

	// ScrollingGraphicalViewer�� Draw2d�� FigureCanvas�� ����� ��� ����
	// ��ũ�ѹٰ� �ʿ���ų� �ٸ� ������ ������ ��κ��� ���ø����̼��� �� �� ���
	private ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();

	/*
	 * � root EditPart�� ������� �����Ѵ�. �� EditPart�� �𵨰� �������� ������ �̰��� ������ �� �����ϰ�
	 * '����' EditPart ����� �ϴ�(?)���� �ϰ��� ���ؽ�Ʈ�� �����ϴ� ���̴�.
	 * ScalableRootEditPart - �⺻ ���̾� ���հ� �� ����� �����ϸ�, �̰͵��� ����ڿ��� ��� ��Ÿ�� ������ ���ø����̼ǿ��� �����ؾ� �Ѵ� 
	 * ScalableFreeformRootEditPart - ���� �Ͱ� ���� ����������, ��� ���̾ FreeForm �������̽��� �����ϰ� �־, 
	 * ���̾�׷��� �ڵ����� ���� ��ǥ��(���ʰ� ��������) Ȯ���� �� �ְ��Ѵ�.
	 * ���� ������ RootEditPart �̸� �Ϲ������� ���ȴ�
	 */
	private RootEditPart rootEditPart = new FreeformGraphicalRootEditPart();

	// Custom made EditPartFactory, will automatically be called to create edit
	// parts for model elements
	private EditPartFactory editPartFactory = new GraphicalPartFactory();
	// The model
	private Model model;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		// Create a dummy model
		model = new Model();

		// Initialize the viewer, 'parent' is the
		// enclosing RCP windowframe
		viewer.createControl(parent);
		viewer.setRootEditPart(rootEditPart);
		//���������� ���󰡴� ���� GraphicalPartFactory�� createEditPart����
		viewer.setEditPartFactory(editPartFactory);

		// Inject the model into the viewer, the viewer will
		// traverse the model automatically
		viewer.setContents(model);

		// Set the view's background to white
		viewer.getControl().setBackground(new Color(null, 255, 255, 255));
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}