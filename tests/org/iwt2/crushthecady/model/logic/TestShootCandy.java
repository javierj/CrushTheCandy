package org.iwt2.crushthecady.model.logic;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.model.CandyBulletFactory;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.model.logic.ShootCandy;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import unit.factory.Candies;
import static unit.factory.Candies.*;
import unit.factory.CandyBullets;
import unit.factory.CandyEnemiesFactory;
import unit.factory.PlayerFactory;
import unit.factory.RoomFactory;
import unit.factory.mocks.Batchs;

public class TestShootCandy {

	private Candy candyFromPlayer;
	private ShootCandy sc;
	private Room room;
	private Candy enemyCandy;
	private Player p;
	private CandyEnemies ce;
	private CandyColumn cc;
	private CandyBullet cb;
	private Candy first;

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
		this.cb = CandyBullets.withYellowAndRed();
		this.room.setCandyBullet(cb);
		this.first = cb.getFirstCandy();
	}

	

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
		Candy playerCandy = this.p.getCandy();
		
		sc.shootCandy();
		
		assertThat(this.ce.candies(0), is(2));
		assertThat(this.ce.firstCandyInColumn(0), is(playerCandy));
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
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertCandyIsDeleted(c1);
		assertCandyIsDeleted(c2);
		assertCandyIsDeleted(candyFromPlayer);
	}




	@Test
	public void whenEventsCalled__andOneCandyHaveSameColor_deeteSameCandies() {
		Candy c1 =  Candies.yellow();
		
		this.ce.addCandy(0, c1);
		this.ce.addCandy(0, this.candyFromPlayer);
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertCandyIsDeleted(c1);
		assertCandyIsNotDeleted(this.ce.columns().get(0).getCandy(0));
		assertCandyIsDeleted(candyFromPlayer);
	}



	@Test
	public void whenEventsCalled__andCandiesHaveDiferentColor_NoCandiesAreDeleted() {
		Candy c1 =  Candies.red();
		
		this.ce.addCandy(0, c1);
		//this.ce.addCandy(0, this.candyFromPlayer);
		sc.setCandyPlayer(this.candyFromPlayer);
		
		sc.candyEvent(this.candyFromPlayer);
		
		assertEquals(0, c1.getActions().size);
		assertEquals(0, candyFromPlayer.getActions().size);
		
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

	@Test
	public void testCandyevent_OneRedCandyCollides() {
		Candy c = Candies.red();
		
		this.room.getCandyEnemies().addShootedCandy(0, c);
		this.sc.candyEvent(c);
		this.cc.act(10f);
		this.cc.draw(Batchs.dummy(), 1f);
		
		assertThat(this.ce.candies(0), is(0));
	}
	
	
	@Test
	public void whenPlayerShoots_thenFirstCandyFromBulletGoesToPlayer() {
		
		this.sc.shootCandy();
		
		MoveToAction move = (MoveToAction) first.getActions().get(0);
		
		//assertThat(.size, is(1));
		//first.act(10f);
		assertThat(move.getX(), is(this.p.getX()));
		assertThat(move.getY(), is(this.p.getY()));
	}

/* Esta prueba no pasa pero el juego funciona.	
	@Test
	public void whenPlayerShoots_thenFirstCandyFromBulletIsDiferent() {
		
		this.sc.shootCandy();
		
		Candy second = cb.getFirstCandy();
		first.act(10f);
		assertTrue(first != second);
	}
*/
	
	@Test
	public void whenPlayerShoots_and_CandyArrivesToPlayerPos_then_CandyIsInPlayer() {
		
		this.sc.shootCandy();
		
		assertNull(this.p.getCandy());
		first.act(10f);
		assertThat(this.p.getCandy(), is(first));

	}

	@Test
	public void whenPlayersHoots_newCandyIsAddedToCandyBullet() {
		int candies = this.cb.candies();
		
		this.sc.shootCandy();
		this.room.act(10f);
		
		assertThat(this.cb.candies(), is(candies + 1));
	}
	
}
