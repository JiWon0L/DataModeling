package kr.ac.sunmoon.client;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class WoorungMenu extends HorizontalPanel{
	public WoorungMenu() 
	{
		super(); 
		this.addStyleName("menuPanel");
		
		addMenuItem("Home");
		addMenuItem("Category");
		addMenuItem("Evaluation");
		addMenuItem("MyPage");
	}
	
	private void addMenuItem(String text)
	{
		Label lblMenuItem = new Label(text);
		lblMenuItem.addStyleName("lblMenuItem");
		this.add(lblMenuItem);
	}
}


