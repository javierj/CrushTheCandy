package org.iwt2.crushthecady.model;

import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class CandyBullet /*extends VerticalGroup*/ extends Group {

	private CandyFactory cf;
	private int numOfCandies;

	public CandyBullet(CandyFactory cf) {
		super();
		this.cf = cf;
	}

	public int candies() {
		return this.getChildren().size;
	}

	/**
	 * @param candy
	 */
	public void addCandy(Candy candy) {
		Candy tmp;
		if (this.candies() > 0) {
			tmp = this.getLastCandy();
			candy.setPosition(0f, tmp.getY() + Constants.CANDYHEIDHT );
		} else {
			candy.setPosition(0f, 0f );
		}
		this.addActor(candy);
		//this.getChildren().insert(0, candy);
	}

	public void addNewCandy() {
		this.addCandy(this.cf.createwithRandomColorId());
		this.moveDown();
	}

	/**
	 * For testing only
	 * @return
	 */
	public Candy getFirstCandy() {
		//return (Candy)this.getChildren().get(this.getChildren().size-1);
		return (Candy)this.getChildren().get(0);
	}

	public Candy getLastCandy() {
		return (Candy)this.getChildren().get(this.getChildren().size-1);
		//return (Candy)this.getChildren().get(0);
	}

	/*
	public Candy removeFirstCandy() {
		return (Candy)this.getChildren().removeIndex(this.getChildren().size-1);
	}*/

	
	public void moveDown() {
		Candy c;
		for (int i = 0; i < this.getChildren().size ; i++) {
			c = (Candy) getChildren().get(i);
			c.moveTo(this.getX(), c.getY() - Constants.CANDYHEIDHT);
		}
		
	}

	/**
	 * Adds numOfCandies to this bullet
	 * @param numOfCandies
	 */
	public void createCandies(int numOfCandies) {
		this.numOfCandies = numOfCandies;
		for (int i = 0; i < numOfCandies; i++ ) {
			createCandy();
		}
		
	}

	private void createCandy() {
		this.addCandy(this.cf.createwithRandomColorId());
	}
	
	/**
	 * No me gusta tener que comprobar esto en cada frame.
	 * Es mejor sobreescrbir el método childrenChanged
	 */
	@Override
	public void act(float delta) {
		super.act(delta);
		if (this.candies() < this.numOfCandies) {
			this.addNewCandy();
		}
	}

}
