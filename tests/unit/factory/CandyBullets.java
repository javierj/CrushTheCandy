package unit.factory;

import org.iwt2.crushthecady.model.CandyBullet;

public class CandyBullets {
	public static CandyBullet withYellowAndRed() {
		CandyBullet cb = new CandyBullet();
		cb.addCandy(Candies.yellow());
		cb.addCandy(Candies.red());
		return cb;
	}
}
