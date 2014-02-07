package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.model.logic.CandyListener;
import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Array;

public class CandyColumn extends Actor implements CandyListener {

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
		//for (int i= this.candies.size-1; i >= 0; i-- ) {
		for (int i= 0; i < this.candies.size; i++ ) {
			c = this.candies.get(i);
			c.draw(batch, this.getColor().a);
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
			c.moveTo(c.getX(), c.getY() - Constants.CANDYHEIDHT);
		}
		
	}


	public int candies() {
		return this.candies.size;
	}
	
	/**
	 * For testing
	 */
	public Candy getCandy(int index) {
		return this.candies.get(index);
	}

	/**
	 * Called when a candy must be deleted
	 */
	@Override
	public void candyEvent(Candy c) {
		boolean b = this.candies.removeValue(c, true);
		if (!b){
			System.err.println("CandyColumn - No Candy to delete.");
		}
 		
	}
}
