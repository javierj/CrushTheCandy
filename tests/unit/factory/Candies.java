package unit.factory;

import org.iwt2.crushthecady.model.Candy;

public class Candies {
	public static Candy red() {
		return new Candy("Red");
	}

	public static Candy yellow() {
		return new Candy("Yellow");
	}
}
