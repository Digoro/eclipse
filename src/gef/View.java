//--------------------------------------------------------------------------------------
//shapes와 connections을 view에 넣는다.
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

	// ScrollingGraphicalViewer는 Draw2d의 FigureCanvas를 사용한 뷰어 구현
	// 스크롤바가 필요없거나 다른 이유가 없는한 대부분의 어플리케이션은 이 뷰어를 사용
	private ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();

	/*
	 * 어떤 root EditPart를 사용할지 결정한다. 이 EditPart는 모델과 연관되지 않으며 이것의 역할은 뷰어를 결정하고
	 * '실제' EditPart 기능을 하는(?)곳에 일관된 컨텍스트를 제공하는 것이다.
	 * ScalableRootEditPart - 기본 레이어 집합과 줌 기능을 제공하며, 이것들을 사용자에게 어떻게 나타낼 것인지 어플리케이션에서 결정해야 한다 
	 * ScalableFreeformRootEditPart - 위의 것과 거의 동일하지만, 모든 레이어가 FreeForm 인터페이스를 구현하고 있어서, 
	 * 다이어그램이 자동으로 음수 좌표로(왼쪽과 위쪽으로) 확장할 수 있게한다.
	 * 가장 유연한 RootEditPart 이며 일반적으로 사용된다
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
		//계층구조를 따라가다 보면 GraphicalPartFactory의 createEditPart실행
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