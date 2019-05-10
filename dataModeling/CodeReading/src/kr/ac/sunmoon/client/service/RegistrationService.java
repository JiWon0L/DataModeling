package kr.ac.sunmoon.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import kr.ac.sunmoon.shared.User;

@RemoteServiceRelativePath("registration")
public interface RegistrationService  extends RemoteService
{
	public Boolean registerUser(User user);
}
