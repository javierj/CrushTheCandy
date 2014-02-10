package unit.factory;

import org.iwt2.crushthecady.model.CandyBullet;

import unit.factory.mocks.FakeCandyFactory;

public class CandyBullets {
	public static CandyBullet withYellowAndRed() {
		CandyBullet cb = new CandyBullet(new FakeCandyFactory());
		cb.addCandy(Candies.yellow());
		cb.addCandy(Candies.red());
		return cb;
	}

	public static CandyBullet empty() {
		CandyBullet cb = new CandyBullet(new FakeCandyFactory());
		return cb;
	}
	
	//----------------------------------
	
}
