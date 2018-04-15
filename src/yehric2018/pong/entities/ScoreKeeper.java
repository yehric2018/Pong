package yehric2018.pong.entities;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.pong.Handler;
import yehric2018.pong.gfx.Assets;

public class ScoreKeeper {
	
	private Handler handler;
	
	private Ball ball;
	private LeftPaddle left;
	private RightPaddle right;
	private int leftScore, rightScore;
	
	public ScoreKeeper(Handler handler) {
		this.handler = handler;
		left = new LeftPaddle(handler, 50, handler.getHeight() / 2 - Paddle.PADDLE_HEIGHT / 2);
		right = new RightPaddle(handler, handler.getWidth() - 50 - Paddle.PADDLE_WIDTH, handler.getHeight() / 2 - Paddle.PADDLE_HEIGHT / 2);
		ball = new Ball(handler, this);
		
		leftScore = 0;
		rightScore = 0;
	}
	
	public void update() {
		if (leftScore >= 10 || rightScore >= 10) {
			
		} else {
			left.update();
			right.update();
			ball.update();
			if (ball.getX() > handler.getWidth()) {
				leftScore++;
				ball = new Ball(handler, this);
			} else if (ball.getX() + ball.getWidth() < 0) {
				rightScore++;
				ball = new Ball(handler, this);
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(handler.getWidth() / 2, 0, handler.getWidth() / 2, handler.getHeight());
		if (leftScore >= 10) {
			g.drawImage(Assets.win, handler.getWidth() / 4 - 32 * 4, 20, 32 * 8, 16 * 8, null);
			g.drawImage(Assets.lose, handler.getWidth() * 3 / 4 - 32 * 4, 20, 32 * 8, 16 * 8, null);
		} else if (rightScore >= 10) {
			g.drawImage(Assets.lose, handler.getWidth() / 4 - 32 * 4, 20, 32 * 8, 16 * 8, null);
			g.drawImage(Assets.win, handler.getWidth() * 3 / 4 - 32 * 4, 20, 32 * 8, 16 * 8, null);
		} else {
			g.drawImage(Assets.score[leftScore], handler.getWidth() / 4 - 16 * 4, 20, 16 * 8, 16 * 8, null);
			g.drawImage(Assets.score[rightScore], handler.getWidth() * 3 / 4 - 16 * 4, 20, 16 * 8, 16 * 8, null);
		}
		left.render(g);
		right.render(g);
		ball.render(g);
	}
	public LeftPaddle getLeft() {
		return left;
	}
	public RightPaddle getRight() {
		return right;
	}
}
