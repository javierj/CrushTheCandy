package unit;

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

	@Before
	public void setUp() throws Exception {
		this.candyFromPlayer = Candies.yellow();
		this.candyFromPlayer.setPosition(10f, 10f);
		this.p = PlayerFactory.create(125, candyFromPlayer);
		this.room = RoomFactory.create(p);
		this.sc = new ShootCandy(room);
		this.enemyCandy = Candies.red();
		this.ce = CandyEnemiesFactory.oneColumnWithOneCandy(this.enemyCandy);
	
		this.room.setCandyEnemies(ce);
	}

	

	@Test
	public void testStartMovementToTheEndOfColumn() {
		sc.shootCandy();
		
		assertThat(candyFromPlayer.getActions().size, is(1));
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
		sc.shootCandy();
		
		assertNull(this.p.getCandy());
		assertThat(this.ce.candies(0), is(2));
	}
	
	@Test
	public void testShootedCandyStartsInSame_X_Than_Player() {
		sc.shootCandy();
		
		assertThat(this.candyFromPlayer.getX(), is(this.p.getX()));
	}

}
