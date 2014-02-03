package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Array;

public class CandyColumn extends Actor {

	Array<Candy> candies;

	public CandyColumn() {
		candies = new Array<Candy>();
	}
	
	/**
	 * Adds Candy at the top of the column. All other candies gows down one cell
	 * @param c
	 */
	public void addCandy(Candy c) {
		moveDownCandies();
		c.setPosition(this.getX(),  Constants.HEIGHT - Constants.CANDYHEIDHT);
		this.candies.add(c);
		
	}
	
	public void addShootedCandy(Candy c) {
		this.candies.insert(0, c);
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		//for (Candy c: this.candies) {
		Candy c;
		for (int i= this.candies.size-1; i >= 0; i-- ) {
			c = this.candies.get(i);
			c.draw(batch, parentAlpha);
		}
	}
	
	@Override
	public void act(float deltaTime) {
		for (Candy c: this.candies) {
			c.act(deltaTime);
		}
		
	}
	
	/**
	 * ToDo: Refactoriza esto y mételo dentro de Candy.
	 */
	private void moveDownCandies() {
		for (Candy c: this.candies) {
			MoveToAction move = new MoveToAction();
			move.setDuration(1f);
			move.setPosition(c.getX(), c.getY() - Constants.CANDYHEIDHT);
			//c.setY(c.getY() - Constants.CANDYHEIDHT);
			c.addAction(move);
		}
		
	}

	/*
	private float calculateY(int i) {
		return Constants.HEIGHT - (Constants.CANDYHEIDHT * (i+1) );
	}*/

	public int candies() {
		return this.candies.size;
	}
	
	/**
	 * For testing
	 */
	public Candy getCandy(int index) {
		return this.candies.get(index);
	}
}
