package unit.org.iwt2.crushthecandy.presenter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.presenter.PlayerMovement;
import org.iwt2.crushthecady.presenter.ShootCandyEvent;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import unit.factory.RoomFactory;

public class TestPlayerMovement {

	private Room room;
	private MockPlayer mockPlayer;
	private PlayerMovement movement;
	private int x;

	@Before
	public void setUp() throws Exception {
		this.x = 275;
		this.room = RoomFactory.createRoom();
		this.mockPlayer = new MockPlayer();
		this.mockPlayer.setPosition(x, 0f);
		this.room.setPlayer(mockPlayer);
		
		this.movement = new PlayerMovement(this.room);
	}

	@Test
	public void whenTouchingLeftPlayer_PlayerIsRequestedToMoveLeft() {
		
		this.movement.touchDown(x-1, 0, 0, 0);
		
		assertTrue(mockPlayer.left);
	}

	@Test
	public void whenTouchingRightPlayer_PlayerIsRequestedToMoveRight() {
		this.movement.touchDown(x + Constants.CANDYWIDHT  +1, 0, 0, 0);
		
		assertTrue(mockPlayer.right);
	}

	@Test
	public void whenTouchingInPlayer_PlayerDontMove() {
		ShootCandyEvent mockEvent = mock(ShootCandyEvent.class);
		this.movement.setShootCandy(mockEvent);
		
		this.movement.touchDown(x + 1, 0, 0, 0);
		this.movement.touchDown(x + Constants.CANDYWIDHT, 0, 0, 0);
		
		assertFalse(mockPlayer.left);
		assertFalse(mockPlayer.right);
	}

	//------------------------------------------
	
	class MockPlayer extends Player {
		boolean left = false;
		boolean right = false;
		
		@Override
		public void moveLeft() {
			this.left = true;
		}

		@Override
		public void moveRight() {
			this.right = true;
		}
	}

}
