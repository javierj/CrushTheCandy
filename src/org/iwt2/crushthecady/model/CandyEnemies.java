package org.iwt2.crushthecady.model;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.Constants;

import unit.factory.Candies;

public class CandyEnemies {

	private int numOfColumns;
	private ArrayList<EnemyColumn> columns;
	protected CandyFactory factory;

	public CandyEnemies(int numOfColumns) {
		this.numOfColumns = numOfColumns;
		this.columns = new ArrayList<EnemyColumn>();
		for (int i = 0; i < numOfColumns; i++) {
			columns.add( new EnemyColumn() );
		}
	}

	public List<EnemyColumn> columns() {
		return this.columns;
	}

	public void addCandy(int column, Candy candy) {
		this.columns.get(column).addCandy(candy);
		
	}

	public int candies(int i) {
		return this.columns.get(i).candies();
	}

	/**
	 * Hay que moverlos todos abajo, no es tan fácil.
	 * Eso es reponsabilidad de cada columna
	 * @param factory
	 */
	public void addOneRow(/*CandyFactory factory*/) {
		for (int column = 0; column < this.columns.size(); column++) {
			EnemyColumn ec = this.columns.get(column);
			ec.allCandiesDown();
			//ec.setPosition(calculateX(column), 0f);
			Candy c = this.factory.createwithRandomColorId();
			//Candy c = Candies.red();
				c.setY(/*calculateY(ec.candies())*/450);
				c.setX(calculateX(column));
				
				ec.addCandy(c);
			
		}
	
	}
	
	public void setCandyFactory(CandyFactory factory) {
		this.factory = factory;
	}

	private float calculateX(int i) {
		return Constants.STARTENEMIESX + (Constants.CANDYWIDHT * i) ;
	}

	private float calculateY(int i) {
		return Constants.HEIGHT - (Constants.CANDYHEIDHT * (i+1) );
	}


}
