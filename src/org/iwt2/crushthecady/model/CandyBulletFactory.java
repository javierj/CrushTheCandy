package org.iwt2.crushthecady.model;


import org.iwt2.crushthecady.presenter.CandyFactory;

/**
 * Deprecated. Now CandyBullet can initialice by its own using the factory
 * for creating candies.
 * @author Javier
 *
 */
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
		CandyBullet cb = new CandyBullet(null);
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
