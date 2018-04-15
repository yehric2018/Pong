package yehric2018.pong.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import yehric2018.pong.Handler;

public class Paddle extends Entity {

	public static final int PADDLE_WIDTH = 30, PADDLE_HEIGHT = 150, PADDLE_SPEED = 20;
	public Rectangle bounds;
	
	public Paddle(Handler handler, float x, float y) {
		super(handler, x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.bounds = new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public void update() {
		this.bounds = new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, width, height);
	}
	public boolean contains(int x, int y) {
		return bounds.contains(x, y);
	}
}
