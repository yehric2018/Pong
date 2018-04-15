package yehric2018.pong.entities;

import yehric2018.pong.Handler;

public class LeftPaddle extends Paddle {

	public LeftPaddle(Handler handler, float x, float y) {
		super(handler, x, y);
	}
	
	@Override
	public void update() {
		if (handler.getKeyManager().w) {
			if (y - Paddle.PADDLE_SPEED < 0)
				y = 0;
			else
				y -= Paddle.PADDLE_SPEED;
		} else if (handler.getKeyManager().s) {
			if (y + Paddle.PADDLE_SPEED + height > handler.getHeight())
				y = handler.getHeight() - height;
			else
				y += Paddle.PADDLE_SPEED;
		}
	}
}
