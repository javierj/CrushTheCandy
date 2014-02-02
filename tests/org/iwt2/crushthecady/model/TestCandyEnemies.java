package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.CandyEnemies;

import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;
import unit.factory.CandyFactoryFactory;

public class TestCandyEnemies {

	private CandyEnemies ce;

	@Before
	public void setUp() throws Exception {
		this.ce = new CandyEnemies(8);
		this.ce.setCandyFactory(new CandyFactoryFactory().createCandyFactory());
	}

	@Test
	public void whenCreating_ItHas_8_EnemyColumns() {
		
		
		assertThat(ce.columns().size(), is(8));
		/*
		for (int i = 0; i < ce.columns().size(); i++) {
			assertTrue( (ce.columns().get(i) instanceof EnemyColumn ) );
		}
		*/
	}
	
	@Test
	public void addingOneCandy() {
		this.ce.addCandy(0, Candies.red());
		
		assertThat(ce.candies(0), is(1) );
		assertThat(ce.candies(1), is(0) );
	}
	
	@Test
	public void addOneRowOfCandies() {
		this.ce.addOneRow();
		
		for (CandyColumn ec: this.ce.columns()) {
			assertThat(ec.candies(), is(1));
		}
		
		this.ce.addOneRow();
		
		for (CandyColumn ec: this.ce.columns()) {
			assertThat(ec.candies(), is(2));
		}
		
		CandyColumn ce = this.ce.columns().get(0);
		assertThat(ce.candies.get(0).getY(), is(400f));
		assertThat(ce.candies.get(1).getY(), is(450f));
	}

}
