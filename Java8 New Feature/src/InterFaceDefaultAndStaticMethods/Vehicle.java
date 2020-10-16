package InterFaceDefaultAndStaticMethods;

public interface Vehicle {
	
	public static String producer () {
		return "N&F Vehicles";
	}
	
	default String getOverview() {
		return "ATV made by " + producer();
	}

}
