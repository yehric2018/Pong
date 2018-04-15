package yehric2018.pong.states;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.pong.Handler;
import yehric2018.pong.gfx.Assets;
import yehric2018.pong.ui.ClickListener;
import yehric2018.pong.ui.UIImageButton;
import yehric2018.pong.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		this.uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(handler.getWidth() / 2 - 48 * 4, handler.getHeight() / 2 + 50, 48 * 8, 16 * 8, Assets.startButton, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(new GameState(handler));
			}}));
		uiManager.addObject(new UIImageButton(handler.getWidth() / 2 - 32 * 4, handler.getHeight() / 2 + 200, 32 * 8, 16 * 8, Assets.exitButton, new ClickListener() {
			@Override
			public void onClick() {
				System.exit(1);
			}}));
	}
	
	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.title, handler.getWidth() / 2 - 64 * 6, handler.getHeight() / 2 - 32 * 6 - 200, 64 * 12, 32 * 12, null);
		uiManager.render(g);
	}

}
