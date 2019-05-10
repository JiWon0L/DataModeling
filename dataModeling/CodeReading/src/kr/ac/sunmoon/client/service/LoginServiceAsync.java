package kr.ac.sunmoon.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void login(String id, String pw, AsyncCallback<Boolean> callback);

}
