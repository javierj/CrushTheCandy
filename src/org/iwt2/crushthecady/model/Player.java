package org.iwt2.crushthecady.model;



import org.iwt2.crushthecady.model.logic.CandyListener;
import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Player extends Group implements CandyListener {

	Candy candy;

	public void setCandy(Candy candy) {
		this.candy = candy;
		this.candy.setPosition(0f, 0f);
		this.addActor(candy);
	}

	public Candy getCandy() {
		return this.candy;
	}

	public void moveLeft() {
		if ((this.getActions().size > 0) || (candy == null)) {
			return;
		}
		if (this.getX() == Constants.STARTENEMIESX) {
			return;
		}
		this.addAction(moveToX(this.getX() - Constants.CANDYWIDHT));
		
	}


	public void moveRight() {
		if ((this.getActions().size > 0)|| (candy == null)) {
			return;
		}
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
		Candy c = this.candy;
		this.candy = null;
		this.removeActor(c);
		return c;
	}

	/**
	 * event received when a candy arraives to the player pos.
	 * Player adds the candy.
	 */
	@Override
	public void candyEvent(Candy c) {
		this.setCandy(c);
		
	}

}
