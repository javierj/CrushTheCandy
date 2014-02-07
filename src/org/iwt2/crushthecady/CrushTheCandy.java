package org.iwt2.crushthecady;

import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.model.logic.ShootCandy;
import org.iwt2.crushthecady.presenter.AddRowTimeEvent;
import org.iwt2.crushthecady.presenter.PlayerMovement;
import org.iwt2.crushthecady.presenter.StartGameDirector;
import org.iwt2.crushthecady.view.Constants;
import org.iwt2.crushthecady.view.Screen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CrushTheCandy implements ApplicationListener {
	
	private SpriteBatch batch;
	private Texture texture;
	private StartGameDirector startGameDirector;
	private Room room;
	private AddRowTimeEvent timeEvent;
	
	public CrushTheCandy() {
		
	}

	/**
	 * For testing only
	 * @param a
	 */
	public CrushTheCandy(int a) {
	}

	
	@Override
	public void create() {
		
		this.startGameDirector = new StartGameDirector();
		this.room = new Room();
		
		
		this.startGameDirector.create(this.room);

		
		PlayerMovement movement = new PlayerMovement(this.room);
		Gdx.input.setInputProcessor(movement);
		movement.setShootCandy(new ShootCandy(this.room));
		this.timeEvent = new AddRowTimeEvent(Constants.NEWROWTIME);
		this.timeEvent.setTimeEventCaller(this.room);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		
		this.draw();
		this.update(Gdx.graphics.getDeltaTime() );
		
	}

	void draw() {
		Screen.Clear();
		this.room.getStage().draw();
	}

	private void update(float deltaTime) {
		this.timeEvent.update(deltaTime);
		this.room.act(deltaTime);
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public void setStartDageDirector(StartGameDirector startGame) {
		this.startGameDirector = startGame;
		
	}

	public void setRoom(Room room) {
		this.room = room;
		
	}

	void setTimeEvent(AddRowTimeEvent event) {
		this.timeEvent = event;
		
	}
}
