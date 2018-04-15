package yehric2018.pong.entities;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.pong.Handler;

public class Ball extends Entity {

	public static final int BALL_SIZE = 25, BALL_XVEL = 15;
	private float xVel, yVel;
	private ScoreKeeper sk;
	
	public Ball(Handler handler, ScoreKeeper sk) {
		super(handler, handler.getWidth() / 2, handler.getHeight() / 2, BALL_SIZE, BALL_SIZE);
		this.sk = sk;;
		xVel = BALL_XVEL;
		yVel = (float)(Math.random() * (handler.getHeight() * xVel / (2 * handler.getWidth())));
		if (moveNegativeDirection())
			xVel *= -1;
		if (moveNegativeDirection())
			yVel *= -1;
	}

	@Override
	public void update() {
		checkCollision();
		x += xVel;
		y += yVel;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, BALL_SIZE, BALL_SIZE);
	}

	public boolean moveNegativeDirection() {
		double rand = Math.random();
		if (rand >= 0.5)
			return true;
		return false;
	}
	
	public void checkCollision() {
		//WALLS
		if (y + yVel < 0) {
			y = Math.abs(yVel - y);
			yVel *= -1;
		} else if (y + yVel + height > handler.getHeight()) {
			y = handler.getHeight() - Math.abs(yVel - (handler.getHeight() - (y + height)));
			yVel *= -1;
		}
		//PADDLES
		if (xVel < 0 && x + xVel < sk.getLeft().getX() +  sk.getLeft().getWidth() && x > sk.getLeft().getX() &&
				y + yVel + height > sk.getLeft().getY() && y + yVel < sk.getLeft().getY() + sk.getLeft().getHeight()) {
			x = sk.getLeft().getX() + sk.getLeft().getWidth() + Math.abs(xVel - (x - sk.getLeft().getX() - sk.getLeft().getWidth()));
			xVel *= -1;
			double dfc = (y + height / 2) - (sk.getLeft().getY() + sk.getLeft().getHeight() / 2);
			yVel = (float)(dfc / (sk.getLeft().getHeight() / 2) * BALL_XVEL);
		} else if (xVel > 0 && x + xVel + width > sk.getRight().getX() && x + xVel < sk.getRight().getX() + sk.getRight().getWidth() &&
				y + yVel + height > sk.getRight().getY() && y + yVel < sk.getRight().getY() + sk.getRight().getHeight()) {
			x = sk.getRight().getX() - Math.abs(xVel - (sk.getRight().getX() - x - width));
			xVel *= -1;
			double dfc = (y + height / 2) - (sk.getRight().getY() + sk.getRight().getHeight() / 2);
			yVel = (float)(dfc / (sk.getRight().getHeight() / 2) * BALL_XVEL);
		}
	}

	public float getxVel() {
		return xVel;
	}

	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	public float getyVel() {
		return yVel;
	}

	public void setyVel(float yVel) {
		this.yVel = yVel;
	}
}
