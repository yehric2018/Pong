package yehric2018.pong.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	public static final int SPRITE_SIZE = 16;
	
	private BufferedImage sheet;
	
	public SpriteSheet(String path) {
		sheet = ImageLoader.loadImage(path);
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
