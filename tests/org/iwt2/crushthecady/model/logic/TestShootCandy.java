package org.iwt2.crushthecady.model.logic;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.model.logic.ShootCandy;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import unit.factory.Candies;
import unit.factory.CandyEnemiesFactory;
import unit.factory.PlayerFactory;
import unit.factory.RoomFactory;

public class TestShootCandy {

	private Candy candyFromPlayer;
	private ShootCandy sc;
	private Room room;
	private Candy enemyCandy;
	private Player p;
	private CandyEnemies ce;
	private CandyColumn cc;

	@Before
	public void setUp() throws Exception {
		this.candyFromPlayer = Candies.yellow(10f, 10f);
		this.p = PlayerFactory.create(125, candyFromPlayer);
		this.room = RoomFactory.create(p);
		this.sc = new ShootCandy(room);
		this.enemyCandy = Candies.red();
		this.ce = CandyEnemiesFactory.oneColumnWithOneCandy(this.enemyCandy);
		this.cc = this.ce.columns().get(0);
		this.room.setCandyEnemies(ce);
	}

	
/* Obsolete
	@Test
	public void testStartMovementToTheEndOfColumn() {
		sc.shootCandy();
		
		assertThat(candyFromPlayer.getActions().size, is(1));
	}
*/
	@Test
	public void testMovementGoesToTheFirstCandyInColumn() {
		sc.shootCandy();
		
		MoveToAction move = (MoveToAction)candyFromPlayer.getActions().get(0);
		assertThat(move.getX(), is(this.p.getX()));
		assertThat(move.getY(), is(this.enemyCandy.getY() - Constants.CANDYHEIDHT));
	}

	@Test
	public void testEnemyCandyGetsOutOPlayer_And_EntersColumn() {
		assertThat(this.ce.candies(0), is(1));
		
		sc.shootCandy();
		
		assertNull(this.p.getCandy());
		assertThat(this.ce.candies(0), is(2));
	}
	
	@Test
	public void testShootedCandyStartsInSame_X_Than_Player() {
		sc.shootCandy();
		
		assertThat(this.candyFromPlayer.getX(), is(this.p.getX()));
	}
	
	@Test
	public void whenEventsCalled__andCandiesHaveSameColor_deeteSameCandies() {
		Candy c1 =  Candies.yellow();
		Candy c2 =  Candies.yellow();
		
		this.ce.addCandy(0, c1);
		this.ce.addCandy(0, c2);
		//this.ce.addCandy(0, this.candyFromPlayer);
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertTrue(c1.deleted);
		assertTrue(c2.deleted);
		assertTrue(this.candyFromPlayer.deleted);
		
	}

	@Test
	public void whenEventsCalled__andOneCandyHaveSameColor_deeteSameCandies() {
		Candy c1 =  Candies.yellow();
		
		this.ce.addCandy(0, c1);
		this.ce.addCandy(0, this.candyFromPlayer);
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertTrue(c1.deleted());
		assertFalse(this.ce.columns().get(0).getCandy(0).deleted);
		assertTrue(this.candyFromPlayer.deleted());
		
	}

	@Test
	public void whenEventsCalled__andCandiesHaveDiferentColor_NoCandiesAreDeleted() {
		Candy c1 =  Candies.red();
		
		this.ce.addCandy(0, c1);
		//this.ce.addCandy(0, this.candyFromPlayer);
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertFalse(c1.deleted);
		assertFalse(this.candyFromPlayer.deleted);
		
	}

/*	
	@Test
	public void whenEventsCalled__andCandiesHaveDiferentColor_PlayerCandyIsAdded() {
		Candy c1 =  Candies.red();
		
		this.ce.addCandy(0, c1);
		int candies = this.ce.columns().get(0).candies();
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertThat(this.ce.columns().get(0).candies(), is(candies + 1));
	}
*/
/*
	@Test
	public void testEnemyCandyExistInColumnAfterCollides() {
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertNull(this.p.getCandy());
	}
*/
	@Test
	public void testCandyevent_OneRedCandyCollides() {
		Candy c = Candies.red();
		
		this.room.getCandyEnemies().addShootedCandy(0, c);
		this.sc.candyEvent(c);
		c.act(10f);
		this.cc.act(10f);
		
		assertThat(this.ce.candies(0), is(0));
	}
/*
	@Test
	public void testCandyevent_OneRedCandyCollides() {
		Candy c = Candies.red();
		
		this.room.getCandyEnemies().addShootedCandy(0, c);
		this.sc.candyEvent(c);
		c.act(10f);
		this.cc.act(10f);
		
		assertThat(this.ce.candies(0), is(0));
	}
*/
}
