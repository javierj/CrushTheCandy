package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.scenes.scene2d.Actor;

import unit.factory.Candies;
import unit.factory.CandyBullets;
import unit.factory.CandyFactoryFactory;

public class TestCandyBullet {

	private CandyBullet cb;
	private Candy c02;
	private Candy firstCandy;

	@Before
	public void setUp() throws Exception {
		this.cb = CandyBullets.empty();
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
/*
	@Test
	public void removeFirstBullet() {
		int candies = cb.candies();
		Candy c = cb.removeFirstCandy();
		
		assertNotNull(c);
		assertThat(cb.candies(), is(candies-1));
	}
	*/
	
	
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

	@Test
	public void testAddNewCandy_movesCnddiesDown() {
		int candies = this.cb.candies(); 
		
		this.cb.addNewCandy();
		
		assertThat(this.cb.candies(), is(candies + 1));
		for (Candy c: getallCandies(this.cb)) {
			assertThat(c.getActions().size, is(1));
		}
	}

	
	//-------------------------------------------------
	
	private List<Candy> getallCandies(CandyBullet cb2) {
		List<Candy> candies = new ArrayList<Candy>();
		for (Actor a: cb2.getChildren()) {
			candies.add((Candy)a);
		}
		return candies;
	}

	
	
	//--------------------------------------------------
	// Test creation
	

	private String[] colors = { "Red" };


	@Test
	public void testCreateACadyBullen_OneBall() {
		CandyFactory cf = new CandyFactoryFactory().create(colors);
		CandyBullet cb = new CandyBullet(cf); 
		cb.createCandies(1);
		
		assertThat(cb.candies(), is(1));		
	}

	

}
