package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class CandyBullet extends VerticalGroup {

	public int candies() {
		return this.getChildren().size;
	}

	/**
	 * Firstcandy is the bottom one
	 * @param candy
	 */
	public void addCandy(Candy candy) {
		candy.setPosition(0f, (this.candies() * Constants.CANDYHEIDHT) );
		this.addActor(candy);
	}

	/**
	 * For testing only
	 * @return
	 */
	public Candy getFirstCandy() {
		return (Candy)this.getChildren().get(this.getChildren().size-1);
	}

	public Candy removeFirstCandy() {
		return (Candy)this.getChildren().removeIndex(this.getChildren().size-1);
	}

	public void moveDown() {
		Candy c;
		for (int i = 0; i < this.getChildren().size ; i++) {
			c = (Candy) getChildren().get(i);
			c.moveTo(this.getX(), c.getY() - Constants.CANDYHEIDHT);
		}
		
	}

}
