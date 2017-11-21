/**
 * @author shisj
 */
package runner;

import data.datafactory.DataFactory;
import rmi.RemoteHelper;

public class ServerRunner {

	
	
	public ServerRunner() {
		// TODO Auto-generated constructor stub
		new RemoteHelper();
		new DataFactory();
	}
	

	
	public static void main(String[] args) {
		new ServerRunner();
	}
	
	
}
