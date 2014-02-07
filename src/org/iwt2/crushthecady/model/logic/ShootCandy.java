package org.iwt2.crushthecady.model.logic;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.presenter.ShootCandyEvent;
import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class ShootCandy 
	implements ShootCandyEvent, CandyListener 
{

	private Room room;
	private Player player;
	Candy candyPlayer;

	public ShootCandy(Room room) {
		this.room = room;
		this.player = this.room.getPlayer();
	}

	public void shootCandy() {
		int column = this.player.columnIndex();
		
		setCandyPlayer(this.player.deleteCandy());
		
		//setCandyPlayer(this.player.getCandy());
		candyPlayer.setPosition(this.player.getX(), this.player.getY());
		float y = getDestinyY(column);
		this.room.getCandyEnemies().addShootedCandy(column, candyPlayer);
		
		candyPlayer.moveTo(this.player.getX(), y - Constants.CANDYHEIDHT, this);
	}

	/**
	 * Testing only
	 * @param deleteCandy
	 */
	void setCandyPlayer(Candy deleteCandy) {
		this.candyPlayer = deleteCandy;
		
	}

	private float getDestinyY(int columnIndex) {
		Candy top = this.room.getCandyEnemies().firstCandyInColumn(columnIndex);
		return top.getY();
	}

	/**
	 * This method is called when the player candy collides with the firstcandy in the row.
	 * @param candyFromPlayer
	 */
	public void candyEvent(Candy candyFromPlayer) {
		//this.player.deleteCandy();
		CandyColumn cc = this.room.getCandyEnemies().columns().get(this.player.columnIndex());
		boolean deleteCandyPlayer = false;
		Candy enemy;
		for (int i = /*cc.candies()-1*/1; i /*>=0*/< cc.candies() ; i/*--*/++) {
			enemy = cc.getCandy(i);
			if (enemy.sameColor(candyFromPlayer)) {
				enemy.delete(cc);
				deleteCandyPlayer = true;
			} else {
				break;
			}
		}
		
		if (deleteCandyPlayer) {
			candyFromPlayer.delete(cc);
		} else {
			//cc.addCandy(this.candyPlayer);
		}
		
	}

}
