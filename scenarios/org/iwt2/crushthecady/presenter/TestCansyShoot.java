package org.iwt2.crushthecady.presenter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.model.logic.ShootCandy;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;
import unit.factory.CandyEnemiesFactory;
import unit.factory.PlayerFactory;
import unit.factory.RoomFactory;

public class TestCansyShoot {

	private CandyEnemies ce;
	private CandyColumn cc;
	private int x;

	@Before
	public void setUp() throws Exception {
		this.ce = CandyEnemiesFactory.oneColumnWithOneCandy(Candies.red());
		this.cc = ce.columns().get(0);
		this.x = 125;
	}
	
	/**
	scenario shoot candy to row starting with different candy
	given a red candy to shot and a column that ends with a yellow candy
	when I shoot the candy
	then the candy goes up until it collides with the yellow candy
	and the candy is stuccked with the yellow candy
	*/
	@Test
	public void testShootACandyToAColumnWithDiferentColor() {

		Player p = PlayerFactory.create(x, Candies.yellow());
		Room r = RoomFactory.create(ce, p);
		PlayerMovement movement = new PlayerMovement(r);
		movement.setShootCandy(new ShootCandy(r));
		
		movement.touchDown(x+1, 0, -1, -1);
		p.act(10f);
		
		assertThat(cc.candies(), is(2));
		assertThat(cc.getCandy(0).getColorId(), is("Yellow"));
		assertThat(cc.getCandy(1).getColorId(), is("Red"));
		
		// no candies to delete
		assertFalse(cc.getCandy(0).deleted());
		assertFalse(cc.getCandy(1).deleted());
		

	}

	/**
		scenario shoot candy to a row starting wirh the same candy
		given a red candy to shot and a column that ends in 3 red candies
		when I shoot the candy
		then The candy goes up until it collides wirh the red candies
		and The four red candies disapear
	*/
	@Test
	public void testShootACandyToAColumnWithSameColor() {
		Player p = PlayerFactory.create(x, Candies.red());
		Room r = RoomFactory.create(ce, p);
		PlayerMovement movement = new PlayerMovement(r);
		movement.setShootCandy(new ShootCandy(r));
		
		movement.touchDown(x+1, 0, -1, -1);
		p.act(10f);
		
		assertThat(cc.candies(), is(0));
	}

}
