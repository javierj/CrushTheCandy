package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.crushthecady.model.Candy;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.scenes.scene2d.actions.AfterAction;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;

import unit.factory.Candies;

public class TestCandy {

	private Candy c;

	@Before
	public void setUp() throws Exception {
		this.c = Candies.red();
	}

	@Test
	public void testANewCandy_HasAColor() {
		Candy c = new Candy("Red");
		
		assertThat(c.getColorId(), is("Red"));
	}

	
	@Test
	public void whenMovingACandy_ThenACallBackIsAlsoAdded() {
		
		
		c.moveTo(10f, 10f, null);
		
		assertThat(c.getActions().size, is(2));
		assertTrue(c.getActions().get(1) instanceof AfterAction);
	}
	
	@Test
	public void whenErasingACandy_AFadeOutActionIsAdded() {
		
		c.delete(null);

		assertTrue(c.getActions().get(0) instanceof AlphaAction);
	}

/* - No callsbacks	
	@Test
	public void whenErasingACandy_ACallBackIsAlsoAdded() {
		
		c.delete(null);

		assertTrue(c.getActions().get(1) instanceof AfterAction);
	}
*/
}
