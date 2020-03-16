import java.rmi.*;
import java.rmi.server.*;
public class agentServer{
	public static void main(String[] args){
		try{
			agent1 agentService = new agent1();
			RemoteRef location = agentService.getRef();
			System.out.println(location.remoteToString());
			String registry = "localhost";
			if (args.length >= 1){
				registry = args[0];
			}
			String registration = "rmi://" + registry + "/BeaconListener";
			Naming.rebind(registration,agentService);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
