public class MainForRoadMap {
	public static void main(String[] args)
			throws NoSuchCityException {
		RoadMap g = new RoadMap();
		g.addCity("Paris");
		g.addCity("Berlin");
		g.addCity("London");
		g.addCity("Vienna");
		g.addRoad("Paris", "London");
		g.addRoad("Berlin", "Vienna");
		g.addRoad("Berlin", "Paris");
		System.out.println(g.neighbours("Paris"));
		// [Berlin, London]
	}
}
