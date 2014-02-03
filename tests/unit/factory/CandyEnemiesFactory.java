package unit.factory;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyEnemies;

public class CandyEnemiesFactory {
	public static CandyEnemies oneColumnWithOneCandy(Candy c) {
		CandyEnemies ce = new CandyEnemies(1);
		ce.addCandy(0, c);
		return ce;
	}
}
