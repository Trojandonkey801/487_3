public class agent1 extends java.rmi.server.UnicastRemoteObject implements BeaconListener{
	boolean lightOn = false;
	public agent1() throws java.rmi.RemoteException{
		setBulb(false);
	}
	public void setBulb(boolean t){
		lightOn = t;
	}
	public void on(){
		setBulb(true);
	}
	public void off(){
		setBulb(false);
	}
	public boolean isOn(){
		return lightOn;
	}
	public int desposit(BEACON b){
		 return 1;
	}
}
