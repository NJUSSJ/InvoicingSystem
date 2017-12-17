
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
			String addressName="rmi://localhost:8889/BulbManagement";
			Naming.bind(addressName, dataRemoteObject);
			
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (AlreadyBoundException e) {
			e.printStackTrace();
		}catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Registration Failed-->"+"Port in use");
		}
		
	}
}
