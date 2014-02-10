package org.iwt2.crushthecady.model;

import org.iwt2.crushthecandy.model.events.AddRowEvent;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Room implements AddRowEvent {

	private CandyBullet candyBullet;
	Stage stage;
	private CandyEnemies candyEnemies;
	private Player player;
	
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
		
		for (CandyColumn ec: this.candyEnemies.columns()) {
			this.stage.addActor(ec);
		}
		
	}

	/**
	 * Add row event
	 */
	@Override
	public void timeExpires() {
		this.candyEnemies.addOneRow();
	}

	
	public void act(float deltaTime) {
		this.stage.act(deltaTime);
		
	}

	public void setPlayer(Player player) {
		this.player = player;
		this.stage.addActor(player);
	}

	public Player getPlayer() {
		return this.player;
	}

	public void draw() {
		this.stage.draw();
	}
}
