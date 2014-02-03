package org.iwt2.crushthecady.presenter;

import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.model.logic.ShootCandy;
import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.InputProcessor;

public class PlayerMovement implements InputProcessor {

	private Room room;
	private Player player;
	private ShootCandyEvent shootCandyEvent;

	public PlayerMovement(Room r) {
		this.room = r;
		this.player = r.getPlayer();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		int x = (int)this.player.getX();
		if (screenX < x) {
			this.player.moveLeft();
			return false;
		}
		if (screenX > (x + Constants.CANDYWIDHT)) {
			this.player.moveRight();
			return false;
		}
		this.shootCandyEvent.shootCandy();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setShootCandy(ShootCandyEvent mockEvent) {
		this.shootCandyEvent = mockEvent;
		
	}

}
