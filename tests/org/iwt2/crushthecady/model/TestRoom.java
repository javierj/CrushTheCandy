package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;
import unit.factory.CandyFactoryFactory;
import unit.factory.RoomFactory;
import unit.factory.mocks.MockStage;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class TestRoom {

	private Room room;
	private MockStage mockStage;


	@Before
	public void setUp() throws Exception {
		this.room = RoomFactory.createRoom();
		this.mockStage = (MockStage)room.getStage();
	}

	@Test
	public void whenAddingACadyBullet_ItIsAddedIntoStage() {

		
		assertThat(mockStage.getActors().size, is(0));
		
		room.setCandyBullet(new CandyBullet(null));
		assertThat(mockStage.getActors().size, is(1));
		
	}

	
	@Test
	public void whenAddingACadyEnemies_ItIsAddedIntoStage() {
	
		assertThat(mockStage.getActors().size, is(0));
		
		CandyEnemies ce = new CandyEnemies(1);
		ce.addCandy(0, Candies.red());
		
		room.setCandyEnemies(ce);
		assertThat(mockStage.getActors().size, is(1));
		
	}

	
	@Test
	public void whenAddingAPlayer_ItIsAddedIntoStage() {
		
		Player p = new Player();
		room.setPlayer(p);
		
		assertThat(mockStage.getActors().size, is(1));
		
	}
	
	boolean addOneRowCalled = false;
	@Test
	public void whenTimesExpeires_addNewRowofCandyEnemies() {
		CandyEnemies ce = new CandyEnemies(1) {
			@Override
			public void addOneRow() {
				addOneRowCalled = true;
			}
		};
		this.room.setCandyEnemies(ce);
		
		
		this.room.timeExpires();
		
		assertTrue(addOneRowCalled);
	}

	
	@Test
	public void whenDraw_thenDrawTheStage() {
		this.room.draw();
		assertTrue(this.mockStage.drawCalled);
	}
}
