/**
 * @author shisj
 */
package runner;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.RemoteHelper;

public class ClientRunner {

	public static RemoteHelper remoteHelper;
	
	public ClientRunner() {
		linkToServer();
	}
	
	public void linkToServer() {
		String localhost=null;
		try {
			localhost=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		try {
			remoteHelper=RemoteHelper.getInstance();
			//ÉèÖÃ¶Ë¿Ú
			remoteHelper.setRemote(Naming.lookup("rmi://"+"192.168.1.103"+":8889/BulbManagement"));
			System.out.println("linked");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
