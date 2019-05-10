package kr.ac.sunmoon.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

import kr.ac.sunmoon.shared.Customer;

public class CustomerItem extends TreeItem
{
	public CustomerItem(Customer customer)
	{
		String name = customer.getFirstName() + " " + customer.getLastName();
		name = name.trim();
		this.setWidget(getWidget(name, "image/customer.png"));
		
		addInfo(customer);
	}
	
	private void addInfo(Customer customer)
	{
		addChild("First name: " + customer.getFirstName(), "image/firstName.png");
		addChild("Last name: " + customer.getLastName(), "image/lastName.png");
		addChild("Company name: " + customer.getCompanyName(), "image/companyName.png");
		addChild("Address: " + customer.getAddress(), "image/address.png");
		addChild("Phone: " + customer.getPhone(), "image/phone.png");
		addChild("Email: " + customer.getEmail(), "image/email.png");
		addChild("Web: " + customer.getWeb(), "image/web.png");
	}
	
	private void addChild(String text, String imgUrl)
	{
		TreeItem child = new TreeItem(getWidget(text, imgUrl));
		this.addItem(child);
	}
	
	private HorizontalPanel getWidget(String text, String imgUrl)
	{
		HorizontalPanel hp = new HorizontalPanel();
		hp.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
		Image img = new Image();
		hp.add(img);
		img.setUrl(imgUrl);
		Label lbl = new Label();
		lbl.setText(text);
		lbl.getElement().getStyle().setMarginLeft(5, Unit.PX);
		hp.add(lbl);
		
		return hp;
	}
}


