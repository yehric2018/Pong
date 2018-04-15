package yehric2018.pong.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, w, s;
	
	public KeyManager() {
		keys = new boolean[256];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
		
		up = false;
		down = false;
		w = false;
		s = false;
	}
	public void update() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		w = keys[KeyEvent.VK_W];
		s = keys[KeyEvent.VK_S];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
