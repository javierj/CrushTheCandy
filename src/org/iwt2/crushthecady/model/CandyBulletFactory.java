package org.iwt2.crushthecady.model;

import java.util.Random;

import org.iwt2.crushthecady.presenter.CandyFactory;

public class CandyBulletFactory {

	private String[] colors;
	private CandyFactory factory;
	

	public CandyBulletFactory(CandyFactory createCandyFactory) {
		this.factory = createCandyFactory;
	}
/*
	public void setColors(String[] colors) {
		this.colors = colors;
		
	}
*/
	public CandyBullet create(int numOfCandies) {
		CandyBullet cb = new CandyBullet();
		//Random random = new Random();
		Candy c;
		for (int i = 0; i < numOfCandies; i++ ) {
			//String colorId = this.colors[random.nextInt(this.colors.length)];
			//Candy 
			c = this.factory.createwithRandomColorId();
			cb.addCandy(c);
		}
		
		return cb;
	}


}
