import java.rmi.*;
public class agentClient{
	public static void main(String[] args) {
		System.out.println("outside main?");
		try {
			String registry = "localhost"; // the registry server’s IP
			if (args.length >=1) {
				registry = args[0]; 
			}
			String registration = "rmi://" + registry + "/BeaconListener";
			Remote remoteService = Naming.lookup ( registration );
			BeaconListener agentService = (BeaconListener) remoteService;
			agentService.on();
			System.out.println("ran here");
			System.out.println(agentService.isOn());
			agentService.off();
			System.out.println(agentService.isOn());
		} catch (NotBoundException nbe) {
			System.out.println ("No light bulb service available in registry!");
		} catch (RemoteException re) {
			System.out.println ("RMI - " + re);
		} catch (Exception e) {
			System.out.println ("Error - " + e);
		}
	}
}
