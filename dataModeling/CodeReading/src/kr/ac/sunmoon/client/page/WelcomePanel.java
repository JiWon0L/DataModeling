package kr.ac.sunmoon.client.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import kr.ac.sunmoon.client.service.LoginService;
import kr.ac.sunmoon.client.service.LoginServiceAsync;

public class WelcomePanel extends VerticalPanel 
{
	private Label lblMsg;
	private TextBox txtId;
	private PasswordTextBox txtPw;
	
	public WelcomePanel()
	{
		super();
		this.addStyleName("welcomPanel");
		
		Label lblWelcome = new Label("Welcome to XXX Laboratory.");
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
		txtId.getElement().setPropertyString("placeholder", "enter your ID");
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
	
	private void createBtnPart()
	{
		Grid grid = new Grid(1, 2);
		grid.getElement().getStyle().setMarginTop(10, Unit.PX);
		this.add(grid);
		this.setCellHorizontalAlignment(grid, HorizontalPanel.ALIGN_CENTER);
		
		Button btnLogin = new Button("Login");
		btnLogin.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				lblMsg.setText("");
				
				String id = txtId.getText().trim();
				txtId.setText(id);
				String pw = txtPw.getText().trim();
				
				if(id.equals("") ||  pw.equals(""))
				{
					lblMsg.setText("ID and Password are required.");
					return;
				}
				
				LoginServiceAsync service = GWT.create(LoginService.class);
				service.login(id, pw, new AsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						if(result)
						{
							RootPanel.get("main").remove(0);
							HTML html = new HTML("<div><font size=\"3\"><b>Good to see you, " + txtId.getText().trim() + "!</b></font></div>");
							RootPanel.get("main").add(html);
						}
						else
							lblMsg.setText("ID and/or Password are invalid.");
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						lblMsg.setText("Service is not working. Please try again.");
					}
				});
			}
		});
		btnLogin.setWidth("100px");
		grid.setWidget(0, 0, btnLogin);
		
		Button btnReg = new Button("Register");
		btnReg.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("main").remove(0);
				RootPanel.get("main").add(new RegisterPanel());
			}
		});
		btnReg.setWidth("100px");
		grid.setWidget(0, 1, btnReg);
	}
}
