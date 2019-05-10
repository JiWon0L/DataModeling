package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WoorungMainPanel extends VerticalPanel{
	public WoorungMainPanel() {
		super();
		this.addStyleName("welcomePanel");

		HorizontalPanel hpTop = new HorizontalPanel();
		hpTop.addStyleName("hpTop");
		this.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
		this.add(hpTop);
		
		WoorungMenu menuPanel = new WoorungMenu();
		this.add(menuPanel);
		
		Image imgurung = new Image();
		imgurung.setUrl("image/urung.png");
		imgurung.setPixelSize(50, 50);
		hpTop.add(imgurung);
		hpTop.setCellHorizontalAlignment(imgurung, HorizontalPanel.ALIGN_CENTER);
		
		HorizontalPanel hpSearch = new HorizontalPanel();
		hpSearch.addStyleName("hpSearch");
		hpTop.add(hpSearch);
		hpTop.setCellHorizontalAlignment(hpSearch, HorizontalPanel.ALIGN_CENTER);
		
		TextBox txtSearch = new TextBox();
		txtSearch.setStyleName("txtSearch");
		hpSearch.add(txtSearch);
		hpTop.setCellHorizontalAlignment(txtSearch, HorizontalPanel.ALIGN_CENTER);
		
		Image imgSearch = new Image();
		imgSearch.setUrl("image/mg.png");
		imgSearch.setPixelSize(35, 35);
		hpSearch.add(imgSearch);

		HTML htmlLine = new HTML("<hr width=\"650px\" height=\"1px\" color=\"#EEEEEE\">");
		this.add(htmlLine);
		
		WoorungHome homePanel = new WoorungHome();
		this.add(homePanel);
	}
}
