package kr.ac.sunmoon.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import kr.ac.sunmoon.shared.User;

public interface RegistrationServiceAsync {

	void registerUser(User user, AsyncCallback<Boolean> callback);

}
