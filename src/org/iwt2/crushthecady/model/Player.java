package org.iwt2.crushthecady.model;



import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Player extends Group {

	private Candy candy;

	public void setCandy(Candy candy) {
		this.candy = candy;
		this.addActor(candy);
	}

	public Candy getCandy() {
		return this.candy;
	}

	public void moveLeft() {
		if (this.getActions().size > 0)
			return;
		if (this.getX() == Constants.STARTENEMIESX) {
			return;
		}
		this.addAction(moveToX(this.getX() - Constants.CANDYWIDHT));
		
	}


	public void moveRight() {
		if (this.getActions().size > 0)
			return;
		if (this.getX() == (Constants.WIDTH - Constants.CANDYWIDHT)) {
			return;
		}
		this.addAction(moveToX(this.getX() + Constants.CANDYWIDHT));
		
	}
	

	private Action moveToX(float x) {
		MoveToAction action = new MoveToAction();
		action.setDuration(0.2f);
		action.setPosition(x, 0f);
		return action;
	}

	public int columnIndex() {
		int index = (int)(this.getX() - Constants.STARTENEMIESX) / Constants.CANDYWIDHT;
		return index;
	}

	public Candy deleteCandy() {
		Candy candy = this.candy;
		this.candy = null;
		this.removeActor(candy);
		return candy;
	}

}
