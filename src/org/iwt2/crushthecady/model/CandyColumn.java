package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
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

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (Candy c: this.candies) {
			c.draw(batch, parentAlpha);
		}
	}
	
	private void moveDownCandies() {
		for (Candy c: this.candies) {
			c.setY(c.getY() - Constants.CANDYHEIDHT);
		}
		
	}

	private float calculateY(int i) {
		return Constants.HEIGHT - (Constants.CANDYHEIDHT * (i+1) );
	}

	public int candies() {
		return this.candies.size;
	}
}
