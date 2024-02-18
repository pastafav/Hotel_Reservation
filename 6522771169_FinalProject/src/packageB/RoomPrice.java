package packageB;

public class RoomPrice extends RoomType {
	private double roomprice;
	
	public RoomPrice(String room, double roomprice) {
		super(room);
		this.roomprice = roomprice;
	}
	
	public double getRoomprice() {
		return roomprice;
	}


}
