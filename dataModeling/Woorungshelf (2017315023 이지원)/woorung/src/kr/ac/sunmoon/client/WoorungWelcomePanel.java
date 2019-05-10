package kr.ac.sunmoon.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WoorungWelcomePanel extends VerticalPanel {
	private Label lblMsg;
	private TextBox txtId;
	private PasswordTextBox txtPw;
	
	public WoorungWelcomePanel()
	{
		super();
		this.addStyleName("welcomePanel");
		
		Image imgurung = new Image();
		imgurung.setUrl("image/urung.png");
		this.add(imgurung);
		this.setCellHorizontalAlignment(imgurung, HorizontalPanel.ALIGN_CENTER);
		
		Label lblWelcome = new Label("우렁책장에 오신 것을 환영합니다.");
		lblWelcome.addStyleName("lblWelcome");
		this.add(lblWelcome);
		this.setCellHorizontalAlignment(lblWelcome, HorizontalPanel.ALIGN_CENTER);
		
		lblMsg = new Label("");
		lblMsg.addStyleName("lblMsg");
		lblMsg.getElement().getStyle().setMarginTop(10, Unit.PX);
		this.add(lblMsg);
		this.setCellHorizontalAlignment(lblMsg, HorizontalPanel.ALIGN_CENTER);
		
		createIdPart();
		createPwPart();
		createBtnPart();
	}
	
	private void createIdPart()
	{
		txtId = new TextBox();
		txtId.getElement().setPropertyString("placeholder", "enter yout ID");
		txtId.setWidth("300px");
		txtId.getElement().getStyle().setMarginTop(5, Unit.PX);
		this.add(txtId);
		this.setCellHorizontalAlignment(txtId, HorizontalPanel.ALIGN_CENTER);
	}
	
	private void createPwPart()
	{
		txtPw = new PasswordTextBox();
		txtPw.getElement().setPropertyString("placeholder", "enter your Password");
		txtPw.setWidth("300px");
		txtPw.getElement().getStyle().setMarginTop(5, Unit.PX);
		this.add(txtPw);
		this.setCellHorizontalAlignment(txtPw, HorizontalPanel.ALIGN_CENTER);
	}
	
	private void createBtnPart(){
		Button btnLogin = new Button("Login");
		btnLogin.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("main").remove(0);
				RootPanel.get("main").add(new WoorungMainPanel());
			}
		});
		btnLogin.setWidth("100px");
		this.add(btnLogin);
		this.setCellHorizontalAlignment(btnLogin, HorizontalPanel.ALIGN_CENTER);
	}
}
