package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class CandyBullet extends VerticalGroup {

	public int candies() {
		return this.getChildren().size;
	}

	public void addCandy(Candy candy) {
		candy.setPosition(0f, (this.candies() * Constants.CANDYHEIDHT) );
		this.addActor(candy);
	}

}
