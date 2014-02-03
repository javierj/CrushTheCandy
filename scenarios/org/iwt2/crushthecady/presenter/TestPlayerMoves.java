package org.iwt2.crushthecady.presenter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.junit.Before;
import org.junit.Test;

import unit.factory.PlayerFactory;
import unit.factory.RoomFactory;

public class TestPlayerMoves {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPlayerMovesRight() {
		int x = 300;
		Player p = PlayerFactory.create();
		p.setPosition(x, 0);
		Room r = RoomFactory.createRoom();
		r.setPlayer(p);
		
		PlayerMovement movement = new PlayerMovement(r);
		
		movement.touchDown(x-1, 0, -1, -1);
		p.act(10f);
		
		assertThat(p.getX(), is(x-75f));
		
		
	}

}
