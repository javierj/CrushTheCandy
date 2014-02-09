package unit.factory;

import static org.junit.Assert.fail;

import org.iwt2.crushthecady.model.Candy;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;

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

	public static void assertCandyIsDeleted(Candy c1) {
		AlphaAction aa;
		for(Action a: c1.getActions()) {
			if (a instanceof AlphaAction) {
				aa = (AlphaAction)a;
				if (aa.getAlpha() == 0f) {
					return;
				}
			}
		}
		fail("No axtion to decrease alpha of candy found");
	}
	
	public static void assertCandyIsNotDeleted(Candy candy) {
		AlphaAction aa;
		for(Action a: candy.getActions()) {
			if (a instanceof AlphaAction) {
				aa = (AlphaAction)a;
				if (aa.getAlpha() == 0f) {
					fail("Action to decrease alpha of candy found");;
				}
			}
		}
	}

}
