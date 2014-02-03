package unit.factory;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.Player;

public class PlayerFactory {
	public static Player create() {
		return new Player();
	}

	public static Player create(int x, Candy candy) {
		Player p = create();
		p.setPosition(x, 0f);
		p.setCandy(candy);
		return p;
	}
}
