package kr.ac.sunmoon.ac.kr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OnlineKeyboard implements EntryPoint 
{
	public void onModuleLoad() 
	{
		VerticalPanel vpMain = new VerticalPanel();
		RootPanel.get("main").add(vpMain);
		
		final TextBox txt = new TextBox();
		vpMain.add(txt);
		
		Grid grid = new Grid(2, 13);
		vpMain.add(grid);
		
		int ascii = 65;
		for(int i=0; i<grid.getRowCount(); i++)
		{
			for(int j=0; j<grid.getColumnCount(); j++)
			{
				final Button btn = new Button(Character.toString ((char) ascii++));
				btn.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						String text = txt.getText();
						text += btn.getText();
						txt.setText(text);
					}
				});
				btn.addStyleName("btn");
				grid.setWidget(i, j, btn);
			}
		}
		txt.setWidth(grid.getOffsetWidth()-10+"px");
	}
}