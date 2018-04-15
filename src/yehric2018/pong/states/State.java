package yehric2018.pong.states;

import java.awt.Graphics;

import yehric2018.pong.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	public static State getState() {
		return currentState;
	}
	public static void setState(State state) {
		currentState = state;
	}
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
