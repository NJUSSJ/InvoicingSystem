/**
 * @author shisj
 */
package rmi;

import java.rmi.Remote;

import dataservice.userdataservice.UserDataService;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remotehelper=new RemoteHelper();
	
	public static RemoteHelper getInstance() {
		return remotehelper;
	}
	
	private RemoteHelper() {
		
	}
	
	public void setRemote(Remote remote) {
		this.remote=remote;
	}
	
	public UserDataService getUserDataService() {
		return (UserDataService)remote;
	}
}