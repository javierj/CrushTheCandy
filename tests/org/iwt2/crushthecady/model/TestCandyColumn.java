package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.g2d.Batch;

import unit.factory.Candies;

public class TestCandyColumn {

	private CandyColumn cc;
	private Candy c01;

	@Before
	public void setUp() throws Exception {
		this.cc = new CandyColumn();
		cc.setX(100);
		this.c01 = Candies.red();
		cc.addCandy(c01);
	}

	@Test
	public void testAddOneCandy() {
		assertThat(c01.getX(), is(100f));
		assertThat(c01.getY(), is((float)( Constants.HEIGHT - Constants.CANDYHEIDHT)) );
		assertThat(cc.candies(), is(1));
		
	}

	@Test
	public void testAddSecondCandy() {
		Candy c02 = Candies.red();
		
		cc.addCandy(c02);
		this.cc.act(10f);
		
		assertThat(c01.getY(), is((float)( Constants.HEIGHT - (2 * Constants.CANDYHEIDHT) ) ) );
		assertThat(c02.getY(), is((float)( Constants.HEIGHT - Constants.CANDYHEIDHT)) );
		assertThat(cc.candies(), is(2));
	}

	
	@Test
	public void testDrawAllCandies() {
		this.cc = new CandyColumn();
		MockCandy mock = new MockCandy();

		cc.addCandy(mock);
		cc.draw(null, 0f);
		
		assertTrue(mock.draw_called);
	}
	
	
	@Test
	public void whenReceivesACandyevent_thenDeletesTheCandyFromColumn() {
		Candy delete = Candies.red();
		this.cc.addCandy(delete);
		
		this.cc.candyEvent(delete);
		
		assertThat(this.cc.candies(), is(1));
		assertFalse(this.cc.candies.contains(delete, true));
	}
	
	@Test
	public void whenReceivesACandyevent_thenDeletesTheCandyFromColumn_2() {
		
		this.cc.candyEvent(this.c01);
		
		assertThat(this.cc.candies(), is(0));
	}
	
	
	//-------------------------------------------
	
	class MockCandy extends Candy {
		public boolean draw_called = false;
		public MockCandy() {
			super(null);
		}
		@Override
		public void draw(Batch batch, float parentAlpha) {
			this.draw_called  = true;
		}
	}
}
