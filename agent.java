import java.rmi.*;
public class agent{
	public native BEACON C_getLocalTime(BEACON toPass);
	static{
			System.loadLibrary("agent");
	}
	public void beaconSender(){
		System.out.println("outside main?");
		try {
			String registry = "localhost"; // the registry server’s IP
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
	public static void main(String[] args) throws java.rmi.RemoteException{
		BEACON B = new BEACON(10,100,"a");
		agent aa = new agent();
		aa.beaconSender();
		BEACON C = aa.C_getLocalTime(B);
		System.out.println(C.ID);
		System.out.println(C.StartUpTime);
		System.out.println(C.CmdAgentID);
	}
}
