package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;

public class TestCandyBullet {

	private CandyBullet cb;
	private Candy c02;
	private Candy firstCandy;

	@Before
	public void setUp() throws Exception {
		this.cb = new CandyBullet();
		this.firstCandy = Candies.yellow();
		this.c02 = Candies.red();
		firstCandy.setPosition(-1f, -1f);
		c02.setPosition(-1f, -1f);
		
		cb.addCandy(firstCandy);
		cb.addCandy(c02);
	}

	@Test
	public void whenAddigANewCady_Xis0() {
		assertThat(firstCandy.getX(), is(0f));
		assertThat(c02.getX(), is(0f));

	}

	@Test
	public void whenAddigANewCady_Yis50perEachCandy() {
		Candy c03 = new Candy("Red");
		
		cb.addCandy(c03);

		assertThat(firstCandy.getY(), is(0f));
		assertThat(c02.getY(), is((float)Constants.CANDYHEIDHT));
		assertThat(c03.getY(), is((float)Constants.CANDYHEIDHT * 2));
	}
	
	@Test
	public void getFirstBullet() {
		Candy c = cb.getFirstCandy();
		
		assertThat(c, is(this.firstCandy));
	}

	@Test
	public void removeFirstBullet() {
		int candies = cb.candies();
		Candy c = cb.removeFirstCandy();
		
		assertNotNull(c);
		assertThat(cb.candies(), is(candies-1));
	}
	
	@Test
	public void moveDown() {
		cb.moveDown();
		Candy c;
		
		assertThat(cb.getChildren().size, is (2));
		
		for (int i = 0; i < cb.getChildren().size ; i++) {
			c = (Candy) cb.getChildren().get(i);
			assertThat(c.getActions().size, is(1));
		}
	}

}
