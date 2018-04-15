package yehric2018.pong.states;

import java.awt.Graphics;

import yehric2018.pong.Handler;
import yehric2018.pong.entities.ScoreKeeper;

public class GameState extends State {
	
	private ScoreKeeper scoreKeeper;
	
	public GameState(Handler handler) {
		super(handler);
		this.scoreKeeper = new ScoreKeeper(handler);
	}
	
	@Override
	public void update() {
		scoreKeeper.update();
	}

	@Override
	public void render(Graphics g) {
		scoreKeeper.render(g);
	}
}
