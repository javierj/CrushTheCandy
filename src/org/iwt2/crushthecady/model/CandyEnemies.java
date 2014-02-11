package org.iwt2.crushthecady.model;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.Constants;

import unit.factory.Candies;

public class CandyEnemies {

	private int numOfColumns;
	//private ArrayList<EnemyColumn> columns;
	ArrayList<CandyColumn> columns;
	protected CandyFactory factory;

	public CandyEnemies(int numOfColumns) {
		this.numOfColumns = numOfColumns;
		this.columns = new ArrayList<CandyColumn>();
		for (int i = 0; i < numOfColumns; i++) {
			columns.add( new CandyColumn() );
		}
	}

	public List<CandyColumn> columns() {
		return this.columns;
	}

	public void addCandy(int column, Candy candy) {
		this.columns.get(column).addCandy(candy);
		
	}

	/**
	 * Testing only.
	 */
	public int candies(int i) {
		return this.columns.get(i).candies();
	}

	/**
	 * Hay que moverlos todos abajo, no es tan fácil.
	 * Eso es reponsabilidad de cada columna
	 * @param factory
	 */
	public void addOneRow(/*CandyFactory factory*/) {
		CandyColumn ec;
		for (int column = 0; column < this.numOfColumns; column++) {
			ec = this.columns.get(column);
			//ec.setPosition(calculateX(column), 0f);
			Candy c = this.factory.createwithRandomColorId();
				//c.setY(/*calculateY(ec.candies())*/500);
				//c.setX(calculateX(column));
				
			ec.addCandy(c);
		}
	}

	public void addInitialRow(/*CandyFactory factory*/) {
		CandyColumn ec;
		for (int column = 0; column < this.numOfColumns; column++) {
			ec = this.columns.get(column);
			//ec.setPosition(calculateX(column), 0f);
			Candy c = this.factory.createwithRandomColorId();
				//c.setY(/*calculateY(ec.candies())*/500);
				//c.setX(calculateX(column));
				
			ec.addInitialCandy(c);
		}
	}

	public void setCandyFactory(CandyFactory factory) {
		this.factory = factory;
	}
/*
	private float calculateX(int i) {
		return Constants.STARTENEMIESX + (Constants.CANDYWIDHT * i) ;
	}
*/
	public Candy firstCandyInColumn(int i) {
		return this.columns.get(i).getCandy(0);
	}

	public void addShootedCandy(int i, Candy shooted) {
		this.columns.get(i).addShootedCandy(shooted);
		
	}

}
