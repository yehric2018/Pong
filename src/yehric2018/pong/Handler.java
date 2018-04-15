package yehric2018.pong;

import yehric2018.pong.input.KeyManager;
import yehric2018.pong.input.MouseManager;

public class Handler {
	
	public static final int GAME_WIDTH = 1500, GAME_HEIGHT = 800;
	
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	public Game getGame() {
		return game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
}
