package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.Constants;

public class CandyEnemiesFactory {

	private CandyFactory factory;
	private int columns;

	public CandyEnemiesFactory(CandyFactory factory) {
		this.factory = factory;
	}

	public CandyEnemies create(int columns) {
		this.columns = columns;
		CandyEnemies ce = new CandyEnemies(columns);
		ce.setCandyFactory(this.factory);
		createCandies(ce);
		return ce;
	}

	private void createCandies(CandyEnemies ce) {
		for (int column = 0; column < this.columns; column++) {
			EnemyColumn ec = ce.columns().get(column);
			ec.setPosition(calculateX(column), Constants.HEIGHT);
			//Candy c;
			//*/
		}
			for (int i = 0; i < Constants.INITIALCANDIES; i++) {
				/*c = this.factory.createwithRandomColorId();
				c.setY(calculateY(i));
				c.setX(calculateX(column));
				
				ec.addCandy(c);*/
				ce.addOneRow();
			}
			
		//}
		
	}

	private float calculateX(int i) {
		return Constants.STARTENEMIESX + (Constants.CANDYWIDHT * i) ;
	}

	private float calculateY(int i) {
		return Constants.HEIGHT - (Constants.CANDYHEIDHT * (i+1) );
	}



}
