package kr.ac.sunmoon.client.page;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import kr.ac.sunmoon.client.service.RegistrationService;
import kr.ac.sunmoon.client.service.RegistrationServiceAsync;
import kr.ac.sunmoon.shared.User;

public class RegisterPanel extends VerticalPanel
{
	private TextBox txtId;
	private PasswordTextBox txtPw;
	private PasswordTextBox txtPwConf;
	private TextBox txtEmail;
	
	public RegisterPanel()
	{
		super();
		this.addStyleName("registerPanel");
		
		Label lblRegist = new Label("Be a member of XXX Laboratory.");
		lblRegist.addStyleName("lblRegist");
		this.add(lblRegist);
		this.setCellHorizontalAlignment(lblRegist, HorizontalPanel.ALIGN_CENTER);
		
		Grid grid = new Grid(9, 1);
		grid.getElement().getStyle().setMarginTop(10, Unit.PX);
		this.add(grid);
		this.setCellHorizontalAlignment(grid, HorizontalPanel.ALIGN_CENTER);
		
		Label lblId = new Label("ID");
		grid.setWidget(0, 0, lblId);
		txtId = new TextBox();
		addFocusListener(txtId);
		txtId.setWidth("300px");
		grid.setWidget(1, 0, txtId);
		
		Label lblPw = new Label("Password");
		lblPw.getElement().getStyle().setMarginTop(10, Unit.PX);
		grid.setWidget(2, 0, lblPw);
		txtPw = new PasswordTextBox();
		addFocusListener(txtPw);
		txtPw.setWidth("300px");
		grid.setWidget(3, 0, txtPw);
		
		
		Label lblPwConf = new Label("Password confirmation");
		lblPwConf.getElement().getStyle().setMarginTop(10, Unit.PX);
		grid.setWidget(4, 0, lblPwConf);
		txtPwConf = new PasswordTextBox();
		addFocusListener(txtPwConf);
		txtPwConf.setWidth("300px");
		grid.setWidget(5, 0, txtPwConf);
		
		Label lblEmail = new Label("Email");
		lblEmail.getElement().getStyle().setMarginTop(10, Unit.PX);
		grid.setWidget(6, 0, lblEmail);
		txtEmail = new TextBox();
		txtEmail.setWidth("300px");
		grid.setWidget(7, 0, txtEmail);
		
		Button btnReg = new Button("Register");
		btnReg.getElement().getStyle().setMarginTop(10, Unit.PX);
		grid.setWidget(8, 0, btnReg);
		HTMLTable.CellFormatter formatter = grid.getCellFormatter();
		formatter.setHorizontalAlignment(8, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		btnReg.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String id = txtId.getText().trim();
				String pw = txtPw.getText().trim();
				
				if(id.equals(""))
				{
					txtId.getElement().setPropertyString("placeholder", "enter your ID");
					txtId.addStyleName("notice");
					return;
				}
				
				if(pw.equals(""))
				{
					txtPw.getElement().setPropertyString("placeholder", "enter your Password");
					txtPw.addStyleName("notice");
					return;
				}
				
				String pwConf = txtPwConf.getText().trim();
				if(!pw.equals(pwConf))
				{
					txtPwConf.setText("");
					txtPwConf.getElement().setPropertyString("placeholder", "check your Password agin");
					txtPwConf.addStyleName("notice");
					return;
				}
				
				String email = txtEmail.getText().trim();
				if(email.equals(""))
					email = null;
				
				User user = new User();
				user.setId(id);
				user.setPw(pwConf);
				user.setEmail(email);
				
				RegistrationServiceAsync service = GWT.create(RegistrationService.class);
				service.registerUser(user, new AsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						
						if(result.booleanValue())
						{
							Window.alert("Congratulation! You are a member of XXX Laboratory.");
							RootPanel.get("main").remove(0);
							RootPanel.get("main").add(new WelcomePanel());
						}
						else
						{
							String message = "'" + txtId.getText().trim() + "' is already in use.";
							Window.alert(message);
							txtId.setText("");
							txtId.getElement().setPropertyString("placeholder", "enter another ID");
							txtId.addStyleName("notice");
							return;
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Service is not working. Please try again.");
					}
				});
			}
		});
	}
	
	private void addFocusListener(final TextBox txt)
	{
		txt.addFocusHandler(new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				// TODO Auto-generated method stub
				txt.removeStyleName("notice");
			}
		});
	}
}
