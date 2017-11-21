/**
 * @author shisj
 */
package runner;

import java.net.MalformedURLException;
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
		try {
			remoteHelper=RemoteHelper.getInstance();
			//ÉèÖÃ¶Ë¿Ú
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8889/BuldManagement"));
			System.out.println("linked");
			
		} catch (RemoteException e) {
			// TODO: handle exception
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
