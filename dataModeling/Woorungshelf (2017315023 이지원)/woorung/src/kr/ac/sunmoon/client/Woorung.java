package kr.ac.sunmoon.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Woorung implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get("main").add(new WoorungWelcomePanel());
	}
}
