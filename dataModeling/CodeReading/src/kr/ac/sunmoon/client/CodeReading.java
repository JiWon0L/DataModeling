package kr.ac.sunmoon.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import kr.ac.sunmoon.client.page.WelcomePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CodeReading implements EntryPoint 
{
	public void onModuleLoad() 
	{
		RootPanel.get("main").add(new WelcomePanel());
	}
}
