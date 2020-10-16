package InterFaceDefaultAndStaticMethods;

public class Main {

	
	public static void main(String[] args) {
		String producer = Vehicle.producer();
		
		Vehicle vehicle = new VehicleImpl();
		String overview = vehicle.getOverview();
		
	}
}
