package org.iwt2.crushthecady.presenter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.crushthecady.CrushTheCandy;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.model.CandyColumn;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.EnemyColumn;
import org.iwt2.crushthecady.model.Player;
import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.presenter.StartGameDirector;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import unit.factory.FakeTextureDict;
import unit.factory.RoomFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**
 * feature Game Start
	As a player
	I want to start a game
	to have fun
	
 * @author Javier
 *
 */
public class TestStartGameFeature {

	private CrushTheCandy game;
	private Room room;

	@Before
	public void setUp() throws Exception {
		this.game = new CrushTheCandy(1);
		StartGameDirectorWithoutTextures startGame = new StartGameDirectorWithoutTextures();
		this.room = RoomFactory.createRoom();
		game.setStartDageDirector(startGame);
		game.setRoom(room);
		Gdx.input = mock(Input.class);
	}

	
	/**
	 * 	scenario new game
		given A new game of 750, 500
		when starting a game
		then I have a column with 10 random candies from 0, 0 to 75, 500
		
		TODO:
		 1. Create the start game presenter
		 2. Create the room class
		 3. Create the candy class that extends actor
		 4. Load the list of candies
		 5. Create a factory to creta the initial object of CandyBullet
		 6. Crete the class of candy bullets
	 */
	@Test
	public void testCreateCandyBullet() {
		
		game.create();
		
		
		CandyBullet candyBullet = room.getCandyBullet();
		int numOfCandyBullets = Constants.HEIGHT / Constants.CANDYHEIDHT;
		assertThat(candyBullet.candies(), is(numOfCandyBullets) );
	}
	
	/**
	 * 	scenario new game
		given A new game of 750, 500
		when starting a game
		then I have three rows of random candies from  125, 500 to 675, 350
		 and each row has 9 candies 
	
		1) Factory to create an initial enemycandies (using te candy factory)
		
		
	 */
	@Test
	public void testCreateCandyEnemies() {
		game.create();
		
		
		CandyEnemies candyEnemies = room.getCandyEnemies();
		for(CandyColumn ec: candyEnemies.columns()) {
			assertThat(ec.candies(), is(Constants.INITIALCANDIES) );
		}
	}
	
	
	
	/**
	 * 	scenario new player
		give a new game of 750 x 500
		when starting a game
		then player is at (350, 0)
		 and player has a random candy
	 * @author Javier
	 *
	 */
	@Test
	public void testCreatePlayer() {
		game.create();
		
		Player p = this.room.getPlayer();
		
		assertThat(p.getX(), is((float)75 + 50 + (75*4)));
		assertThat(p.getY(), is(0f));
		assertTrue(p.getCandy() instanceof Candy);
	}
	
	//-----------------------------------------------------------
	
	class StartGameDirectorWithoutTextures extends StartGameDirector {
		
		@Override
		void loadTextures() {
			this.dict = new FakeTextureDict();
			System.out.println("Creating fake texture.");
		}
	}

}
