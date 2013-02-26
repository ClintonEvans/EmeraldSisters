package com.mattdavben.emeraldsisters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class PlayState extends BasicGameState {

	private TiledMap map;
	private Player player;

	public PlayState(int state) {
	}

	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		map = new TiledMap("res/testLevel.tmx");
		player = new Player();
	}

	@Override
	public void leave(GameContainer container, StateBasedGame sbg) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		float viewportX = player.getViewportX();
		float viewportY = player.getViewportY();
		float playerX = player.getPlayerX();
		float playerY = player.getPlayerY();
		map.render((int) -viewportX, (int) -viewportY);
		player.draw(playerX - viewportX, playerY - viewportY);
		g.drawString((int) ((player.getPlayerX() + 16) / 32) + "|" + (int) ((player.getPlayerY() + 24) / 32), 20, 50);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		Input input = container.getInput();
		player.update(delta, input);
	}
}
