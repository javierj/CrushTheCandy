package org.iwt2.crushthecady.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;
import unit.factory.PlayerFactory;

public class TestPlayer {

	private Player player;

	@Before
	public void setUp() throws Exception {
		this.player = PlayerFactory.create();
		this.player.setPosition(300f, 0f);
		this.player.setCandy(Candies.red());
	}

	@Test
	public void testMoveLeft() {
		this.player.moveLeft();
		this.player.act(10f);
		
		assertThat(this.player.getX(), is(225f));
	}

	@Test
	public void testMoveRight() {
		this.player.moveRight();
		this.player.act(10f);
		
		assertThat(this.player.getX(), is(375f));
	}

	@Test
	public void testWhenPlayerIInRightBorder_And_MoveRight_PlayerDontMove() {
		this.player.setPosition(725f, 0f);
		this.player.moveRight();
		this.player.act(10f);
		
		assertThat(this.player.getX(), is(725f));
	}
	
	@Test
	public void testWhenPlayerIInLeftBorder_And_MoveLeft_PlayerDontMove() {
		this.player.setPosition(125f, 0f);
		this.player.moveLeft();
		this.player.act(10f);
		
		assertThat(this.player.getX(), is(125f));
	}
	
	@Test
	public void whenAddingACandy_IsAddedIntoChildrens() {
		this.player = PlayerFactory.create();
		this.player.setCandy(Candies.red());
		
		assertThat(this.player.getChildren().size, is(1));
	}
	
	@Test
	public void testColumn() {
		this.player.setPosition(Constants.STARTENEMIESX, 0);
		assertThat(player.columnIndex(), is (0));
		this.player.setPosition(Constants.STARTENEMIESX + Constants.CANDYWIDHT, 0);
		assertThat(player.columnIndex(), is (1));
	}
	
	@Test
	public void whenDeleteCandy_candyIsNull() {
		this.player.deleteCandy();
		assertNull(this.player.getCandy());
	}
	
	@Test
	public void whenPlayerHasNoCandy_thenDoesNotMove() {
		float x = this.player.getX();
		this.player.candy = null;
		
		this.player.moveLeft();
		this.player.act(10f);
		
		assertThat(this.player.getX(), is(x));
	
		this.player.moveRight();
		this.player.act(10f);
		
		assertThat(this.player.getX(), is(x));
	}

}
