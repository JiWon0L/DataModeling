package kr.ac.sunmoon.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WoorungHome extends VerticalPanel {
	public WoorungHome() {
		super();
		this.addStyleName("homePanel");

		Label lblGenre = new Label("이지원님이 재밌게 읽은 장르 '소설'");
		lblGenre.addStyleName("lblGenre");
		this.add(lblGenre);
		HTML htmlLine = new HTML("<hr width=\"650px\" height=\"1px\" color=\"#EEEEEE\">");
		Label lblempty = new Label("　　　　　　　　　　　　　　　　　　　　　　");
		this.add(lblempty);
		HorizontalPanel hpBook = new HorizontalPanel();
		this.add(hpBook);
		Image imgharry = new Image();
		imgharry.setUrl("image/harry.png");
		imgharry.setPixelSize(150, 200);
		hpBook.add(imgharry);

		VerticalPanel vpBook = new VerticalPanel();
		this.add(htmlLine);
		hpBook.add(vpBook);
		Label lblempty0 = new Label("　　　　　　　　　　　　　　　　　　　　　　");
		vpBook.add(lblempty0);
		final Label lblHarry = new Label("　　　제　　목 : 해리포터와 마법사의 돌1");
		lblHarry.addStyleName("lblHarry");
		vpBook.add(lblHarry);
		Label lblempty1 = new Label("　　　　　　　　　　　　　　　　　　　　　　");
		Label lblempty2 = new Label("　　　　　　　　　　　　　　　　　　　　　　");
		Label lblempty3 = new Label("　　　　　　　　　　　　　　　　　　　　　　");
		Label lblempty4 = new Label("　　　　　　　　　　　　　　　　　　　　　　");
		vpBook.add(lblempty1);
		final Label lblHarry1 = new Label("　　　작　　가 : J.K. 롤링");
		lblHarry1.addStyleName("lblHarry");
		vpBook.add(lblHarry1);
		vpBook.add(lblempty2);
		final Label lblHarry2 = new Label("　　　출판연도 : 1999년 09월");
		lblHarry2.addStyleName("lblHarry");
		vpBook.add(lblHarry2);
		vpBook.add(lblempty3);
		final Label lblHarry3 = new Label("　　　등록번호 : 7");
		lblHarry3.addStyleName("lblHarry");
		vpBook.add(lblHarry3);
		vpBook.add(lblempty4);
		final Label lblHarry4 = new Label("　　　평　　점 : 4.0");
		lblHarry4.addStyleName("lblHarry");
		vpBook.add(lblHarry4);

		createBtnPart();
	}

	private void createBtnPart() {
		final Button btnShelf = new Button("MyPage >>");
		btnShelf.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("main").remove(0);
				RootPanel.get("main").add(new WoorungMyPage());
				
			}
		});
		btnShelf.setWidth("100px");
		btnShelf.addStyleName("btn");
		this.add(btnShelf);
		this.setCellHorizontalAlignment(btnShelf, HorizontalPanel.ALIGN_RIGHT);
	}
}
