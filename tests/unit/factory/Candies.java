package unit.factory;

import org.iwt2.crushthecady.model.Candy;

public class Candies {
	public static Candy red() {
		return new Candy("Red");
	}

	public static Candy yellow() {
		return yellow(0f, 0f);
	}

	public static Candy yellow(float f, float g) {
		Candy c = new Candy("Yellow");
		c.setPosition(f, g);
		return c;
	}

}
