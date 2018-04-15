
package yehric2018.pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import yehric2018.pong.gfx.Assets;
import yehric2018.pong.gfx.Display;
import yehric2018.pong.input.KeyManager;
import yehric2018.pong.input.MouseManager;
//import yehric2018.pong.states.GameState;
import yehric2018.pong.states.MenuState;
import yehric2018.pong.states.State;

public class Game implements Runnable {
	
	public int width, height;
	public String title;
	
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	private Thread thread;
	
	public State menuState;
	public State gameState;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	private void init() {
		Assets.init();
		
		display = new Display(title, width, height);
		width = display.getFrame().getContentPane().getWidth();
		height = display.getFrame().getContentPane().getHeight();
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		handler = new Handler(this);

		State.setState(new MenuState(handler));
	}
	
	private void update() {
		keyManager.update();
		
		if (State.getState() != null) {
			State.getState().update();
		}
	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		State.getState().render(g);
		
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		System.out.println("RUNING");
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		try {
			if (!running) {
				return;
			}
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public KeyManager getKeyManager() {
		return keyManager;
	}
	public MouseManager getMouseManager() {
		return mouseManager;
	}
}
