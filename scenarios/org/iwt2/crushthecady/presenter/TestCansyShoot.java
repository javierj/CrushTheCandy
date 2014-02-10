package org.iwt2.crushthecady.presenter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.model.logic.ShootCandy;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;
import unit.factory.CandyBullets;
import unit.factory.CandyEnemiesFactory;
import unit.factory.PlayerFactory;
import unit.factory.RoomFactory;
import unit.factory.mocks.Batchs;

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
		PlayerMovement movement = createMovement(r);
		
		shoot(movement, r);
		
		assertThat(cc.candies(), is(2));
		assertThat(cc.getCandy(0).getColorId(), is("Yellow"));
		assertThat(cc.getCandy(1).getColorId(), is("Red"));
		
		// no candies to delete
		Candies.assertCandyIsNotDeleted(cc.getCandy(0));
		Candies.assertCandyIsNotDeleted(cc.getCandy(1));
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
		PlayerMovement movement = createMovement(r);
		
		shoot(movement, r);
		
		assertThat(cc.candies(), is(0));
	}
	


	/**
	 * 	scenario reload the player
		given a game with a candy and the bottom candy is red
		when I shoot the candy
		then the bottom candy is the new candy for the player
		
	*/
	@Test
	public void reloadPlayer() {
		CandyBullet cb = CandyBullets.empty();
		Candy neeBullet = Candies.red();
		cb.addCandy(neeBullet);
		cb.addCandy(Candies.yellow());
		cb.addCandy(Candies.yellow());
		
	
		Player p = PlayerFactory.create(x, Candies.yellow());
		Room r = RoomFactory.create(ce, p);
		r.setCandyBullet(cb);
		PlayerMovement movement = createMovement(r);
		
		shoot(movement, r);
		
		assertThat(p.getCandy(), is(neeBullet));
	}
	
	//-------------------------
	
	private void shoot(PlayerMovement movement, Room r) {
		movement.touchDown(x+1, 0, -1, -1);
		r.act(10f);
		cc.draw(Batchs.dummy(), 0f);
		
	}

	private PlayerMovement createMovement(Room r) {
		PlayerMovement pm = new PlayerMovement(r);
		pm.setShootCandy(new ShootCandy(r));
		return pm;
	}

}
