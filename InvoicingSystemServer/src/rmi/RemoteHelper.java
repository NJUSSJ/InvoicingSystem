
package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 
 * @author shisj
 *
 */

public class RemoteHelper {

	public RemoteHelper() {
		// TODO Auto-generated constructor stub
		initServer();
	}
	/*
	 * 初始化服务器
	 */
	public void initServer() {
		DataRemoteObject dataRemoteObject;
		try {
			dataRemoteObject=new DataRemoteObject();
			LocateRegistry.createRegistry(8889);
			String addressName="rmi://localhost:8889/BuldManagement";
			Naming.bind(addressName, dataRemoteObject);
			
		}catch (MalformedURLException e) {
			// TODO: handle exception
		}catch (AlreadyBoundException e) {
			// TODO: handle exception
		}catch (RemoteException e) {
			// TODO: handle exception
			System.out.println("Registration Failed-->"+"Port in use");
		}
		
	}
}
