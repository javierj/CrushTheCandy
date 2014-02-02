package org.iwt2.crushthecady.model;

import org.iwt2.crushthecandy.model.events.AddRowEvent;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Room implements AddRowEvent {

	private CandyBullet candyBullet;
	Stage stage;
	private CandyEnemies candyEnemies;
	
	public Room() {
		this.stage = new Stage();
	}

	/**
	 * For testing only
	 * @param stage
	 */
	public Room(Stage stage) {
		this.stage = stage;
	}

	public CandyBullet getCandyBullet() {
		return candyBullet;
	}

	public void setCandyBullet(CandyBullet cb) {
		this.candyBullet = cb;
		this.stage.addActor(this.candyBullet);
		
	}

	public Stage getStage() {
		return this.stage;
	}

	public CandyEnemies getCandyEnemies() {
		
		return this.candyEnemies;
	}

	public void setCandyEnemies(CandyEnemies candyEnemies2) {
		this.candyEnemies = candyEnemies2;
		
		for (EnemyColumn ec: this.candyEnemies.columns()) {
			/*for (Candy c: ec.getCandies())
				this.stage.addActor(c);*/
			this.stage.addActor(ec);
		}
		
	}

	@Override
	public void timeExpires() {
		this.candyEnemies.addOneRow();
	}

}
