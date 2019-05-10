package kr.ac.sunmoon.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CustomerManeger implements EntryPoint 
{
	public void onModuleLoad() 
	{
		// main panel
		VerticalPanel vpMain = new VerticalPanel();
		RootPanel.get("main").add(vpMain);
		vpMain.setStyleName("vpMain");
		
		// search panel
		HorizontalPanel hpSearch = new HorizontalPanel();
		vpMain.add(hpSearch);
		
		final ListBox lboxOption = new ListBox();
		hpSearch.add(lboxOption);
		lboxOption.addStyleName("lboxOption");
		lboxOption.addItem("First name");
		lboxOption.addItem("Last name");
		lboxOption.addItem("Company name");
		lboxOption.addItem("Address");
		lboxOption.addItem("Phone");
		lboxOption.addItem("Email");
		lboxOption.addItem("Website");
		
		final TextBox txtKeyword = new TextBox();
		hpSearch.add(txtKeyword);
		int mainWidth = vpMain.getOffsetWidth();
		int optionWidth = lboxOption.getOffsetWidth();
		txtKeyword.setWidth((mainWidth - optionWidth) + "px");
		lboxOption.setHeight(txtKeyword.getOffsetHeight() + "px");
		
		// separator panel
		HorizontalPanel hpSeparator = new HorizontalPanel();
		vpMain.add(hpSeparator);
		hpSeparator.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
		hpSeparator.addStyleName("hpSeparator");
		
		Image imgSearch = new Image();
		hpSeparator.add(imgSearch);
		imgSearch.setUrl("image/customers.png");
		
		Label lblMessage = new Label();
		hpSeparator.add(lblMessage);
		lblMessage.setText("Customers");
		lblMessage.addStyleName("lblMessage");
		
		HTML htmlLine = new HTML("<hr>");
		vpMain.add(htmlLine);
		
		// result panel
		ScrollPanel spResult = new ScrollPanel();
		vpMain.add(spResult);
		spResult.addStyleName("spResult");
		
		final Tree treeResult = new Tree();
		spResult.setWidget(treeResult);
		
		txtKeyword.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				int keyCode = event.getNativeKeyCode();
				if(keyCode == 13)
				{
					String keyword = txtKeyword.getText().trim();
					if(keyword.length() == 0)
						return;
					
					int option = lboxOption.getSelectedIndex();
					
					Window.alert("Do something here!");
				}
			}
		});
	}
}
