package org.iwt2.crushthecady.model.logic;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.presenter.ShootCandyEvent;
import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class ShootCandy implements ShootCandyEvent 
{

	private Room room;
	private Player player;

	public ShootCandy(Room room) {
		this.room = room;
		this.player = this.room.getPlayer();
	}

	public void shootCandy() {
		int column = this.player.columnIndex();
		Candy candy = this.player.deleteCandy();
		candy.setPosition(this.player.getX(), this.player.getY());
		float y = getDestinyY(column);
		this.room.getCandyEnemies().addShootedCandy(column, candy);
		
		MoveToAction move = new MoveToAction();
		move.setPosition(this.player.getX(), y - Constants.CANDYHEIDHT);
		move.setDuration(1f);
		
		candy.addAction(move);
	}

	private float getDestinyY(int columnIndex) {
		Candy top = this.room.getCandyEnemies().firstCandyInColumn(columnIndex);
		return top.getY();
	}

}
