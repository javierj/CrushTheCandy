package unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Room;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;
import unit.factory.CandyFactoryFactory;
import unit.factory.RoomFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class TestRoom {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenAddingACadyBullet_ItIsAddedIntoStage() {
		Room room = RoomFactory.createRoom();
		Stage mockStage = room.getStage();
		
		assertThat(mockStage.getActors().size, is(0));
		
		room.setCandyBullet(new CandyBullet());
		assertThat(mockStage.getActors().size, is(1));
		
	}

	@Test
	public void whenAddingACadyEnemies_ItIsAddedIntoStage() {
		Room room = RoomFactory.createRoom();
		Stage mockStage = room.getStage();
		
		assertThat(mockStage.getActors().size, is(0));
		
		CandyEnemies ce = new CandyEnemies(1);
		ce.addCandy(0, Candies.red());
		
		room.setCandyEnemies(ce);
		assertThat(mockStage.getActors().size, is(1));
		
	}

}
