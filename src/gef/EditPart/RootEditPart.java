//--------------------------------------------------------------------------------------
//이 예제에서는 3가지 type의 EditPart가 있다.
//첫번째는 모델의 root element를 갖는 root EditPart이다.
//나머지 두 EditPart는 NodeModel과 ConnectionModel의 controlling에 반응하는 controller EditPart이다.
//--------------------------------------------------------------------------------------

package gef.EditPart;

import gef.Model.Model;
import gef.Model.NodeModel;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class RootEditPart extends AbstractGraphicalEditPart {
	protected IFigure createFigure() {

		Figure f = new FreeformLayer();
		f.setLayoutManager(new FreeformLayout());

		f.setBorder(new MarginBorder(1));
		// Create a layout for the graphical screen
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.horizontalSpacing = 40;
		gridLayout.verticalSpacing = 40;
		gridLayout.marginHeight = 20;
		gridLayout.marginWidth = 20;
		f.setLayoutManager(gridLayout);
		f.setOpaque(true);
		return f;
	}

	protected void createEditPolicies() {

	}

	// 생성된 EditPart들은 RootEditPart에서 설정된다.
	/*
	 * 초기화를 하는 동안 컨텐츠 EditPart 는 자신의 getModelChildren()메서드를 호출해서 얻은 리스트에 따라서
	 * children 을 생성한다. EditPart 는 반드시 이 메소드를 오버라이드 해서 모델에 있는 객체의 리스트를 받아 child
	 * EditPart 를 생성하도록 해야한다. EditPart 들은 기본적으로 뷰어의 Factory 에서 자신의 child 를 생성하도록
	 * 한다.
	 */
	protected List<NodeModel> getModelChildren() {
		List<NodeModel> children = ((Model) getModel()).getNodes();
		return children;
	}
}