public class agent{
	public native BEACON C_getLocalTime(BEACON toPass);
	static{
			System.loadLibrary("agent");
	}
	public static void main(String[] args) {
		BEACON B = new BEACON(10,100,"a");
		agent A = new agent();
		BEACON C = A.C_getLocalTime(B);
		System.out.println(C.ID);
		System.out.println(C.StartUpTime);
		System.out.println(C.CmdAgentID);
	}
}

class BEACON{
	public int ID;
	public int StartUpTime;
	String CmdAgentID;
	public BEACON(int ID,int StartUpTime, String CmdAgentID){
		this.ID = ID;
		this.StartUpTime = StartUpTime;
		this.CmdAgentID = CmdAgentID;
	}
}
