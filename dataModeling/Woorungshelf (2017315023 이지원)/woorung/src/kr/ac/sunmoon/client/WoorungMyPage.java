package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WoorungMyPage extends VerticalPanel{
	public WoorungMyPage() {
		super(); 
		this.addStyleName("myPagePanel");
		
		final Label lblMyPage = new Label("MyPage");
		lblMyPage.addStyleName("lblHarry");
		this.add(lblMyPage);
		HTML htmlLine = new HTML("<hr width=\"650px\" height=\"1px\" color=\"#EEEEEE\">");
		this.add(htmlLine);
		this.setCellHorizontalAlignment(lblMyPage, HorizontalPanel.ALIGN_LEFT);
		
		HorizontalPanel hpBook = new HorizontalPanel();
		this.add(hpBook);
		Image imgkukga = new Image();
		imgkukga.setUrl("image/kukga.png");
		imgkukga.setPixelSize(50, 70);
		VerticalPanel vpBook = new VerticalPanel();
		Label lblempty = new Label("　[인문]");
		Label lblbook1 = new Label("　국가란 무엇인가");
		Label lblbook2 = new Label("　유시민　|　2017.01　|　별점 : 4.5");
		lblbook1.addStyleName("imgkukga");
		lblbook2.addStyleName("imgkukga");
		hpBook.add(imgkukga);
		hpBook.add(vpBook);
		vpBook.add(lblempty);
		vpBook.add(lblbook1);
		vpBook.add(lblbook2);
		
		HorizontalPanel hpBook2 = new HorizontalPanel();
		this.add(hpBook2);
		Image imgtara = new Image();
		imgtara.setUrl("image/tara.png");
		imgtara.setPixelSize(50, 70);
		VerticalPanel vpBook2 = new VerticalPanel();
		Label lblempty2 = new Label("　[소설]");
		Label lblbook12 = new Label("　타라덩컨1 : 아더월드와 마법사들");
		Label lblbook22 = new Label("　소피 오두인 마미코니안　|　2005.07　|　별점 : 4.5");
		lblbook1.addStyleName("imgkukga");
		lblbook2.addStyleName("imgkukga");
		hpBook2.add(imgtara);
		hpBook2.add(vpBook2);
		vpBook2.add(lblempty2);
		vpBook2.add(lblbook12);
		vpBook2.add(lblbook22);
		
		HorizontalPanel hpBook3 = new HorizontalPanel();
		this.add(hpBook3);
		Image imgtyl = new Image();
		imgtyl.setUrl("image/tyl.png");
		imgtyl.setPixelSize(50, 70);
		VerticalPanel vpBook3 = new VerticalPanel();
		Label lblempty3 = new Label("　[소설]");
		Label lblbook13 = new Label("　트와일라잇");
		Label lblbook23 = new Label("　스테프니 메이어　|　2008.07　|　별점 : 3.5");
		lblbook13.addStyleName("imgkukga");
		lblbook23.addStyleName("imgkukga");
		hpBook3.add(imgtyl);
		hpBook3.add(vpBook3);
		vpBook3.add(lblempty3);
		vpBook3.add(lblbook13);
		vpBook3.add(lblbook23);
		
		HorizontalPanel hpBook4 = new HorizontalPanel();
		this.add(hpBook4);
		Image imghobit = new Image();
		imghobit.setUrl("image/hobit.jpg");
		imghobit.setPixelSize(50, 70);
		VerticalPanel vpBook4 = new VerticalPanel();
		Label lblempty4 = new Label("　[소설]");
		Label lblbook14 = new Label("　호빗");
		Label lblbook24 = new Label("　J.R.R. 톨킨　|　2011.02　|　별점 : 4.0");
		lblbook14.addStyleName("imgkukga");
		lblbook24.addStyleName("imgkukga");
		hpBook4.add(imghobit);
		hpBook4.add(vpBook4);
		vpBook4.add(lblempty4);
		vpBook4.add(lblbook14);
		vpBook4.add(lblbook24);
		
		HorizontalPanel hpBook5 = new HorizontalPanel();
		this.add(hpBook5);
		Image imgharry2 = new Image();
		imgharry2.setUrl("image/harry2.jpg");
		imgharry2.setPixelSize(50, 70);
		VerticalPanel vpBook5 = new VerticalPanel();
		Label lblempty5 = new Label("　[소설]");
		Label lblbook15 = new Label("　 해리포터와 혼혈왕자");
		Label lblbook25 = new Label("　J.K. 롤링　|　2005.07　|　별점 : 4.5");
		lblbook15.addStyleName("imgkukga");
		lblbook25.addStyleName("imgkukga");
		hpBook5.add(imgharry2);
		hpBook5.add(vpBook5);
		vpBook5.add(lblempty5);
		vpBook5.add(lblbook15);
		vpBook5.add(lblbook25);
		
		HorizontalPanel hpBook6 = new HorizontalPanel();
		this.add(hpBook6);
		Image imghow = new Image();
		imghow.setUrl("image/how.png");
		imghow.setPixelSize(50, 70);
		VerticalPanel vpBook6 = new VerticalPanel();
		Label lblempty6 = new Label("　[인문]");
		Label lblbook16 = new Label("　어떻게 살 것인가");
		Label lblbook26 = new Label("　유시민　|　2013.03　|　별점 : 4.3");
		lblbook16.addStyleName("imgkukga");
		lblbook26.addStyleName("imgkukga");
		hpBook6.add(imghow);
		hpBook6.add(vpBook6);
		vpBook6.add(lblempty6);
		vpBook6.add(lblbook16);
		vpBook6.add(lblbook26);
	}
}
