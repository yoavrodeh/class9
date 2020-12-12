import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoadMap {
	private Set<String> cities = new HashSet<>();
	private Set<Road> roads = new HashSet<>();

	private class Road {
		private String city1, city2;

		public Road(String city1, String city2)
				throws NoSuchCityException {
			if (!cities.contains(city1)
					|| !cities.contains(city2))
				throw new NoSuchCityException();
			this.city1 = city1;
			this.city2 = city2;
			roads.add(this);
		}

		@Override
		public boolean equals(Object obj) {
			Road road = (Road) obj;
			return (city1.equals(road.city1)
					&& city2.equals(road.city2))
					|| (city1.equals(road.city2)
							&& city2.equals(road.city1));
		}
		@Override
		public int hashCode() {
			return city1.hashCode() + city2.hashCode();
		}
	}

	public void addCity(String city) {
		cities.add(city);
	}

	public void addRoad(String city1, String city2)
			throws NoSuchCityException {
		new Road(city1, city2);
	}

	public List<String> neighbours(String city) {
		List<String> res = new ArrayList<>();
		for (Road r : roads)
			if (city.equals(r.city1))
				res.add(r.city2);
			else if (city.equals(r.city2))
				res.add(r.city1);
		return res;
	}
}

class NoSuchCityException extends Exception {
}
