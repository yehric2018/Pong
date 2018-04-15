package yehric2018.pong.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage[] score;
	public static BufferedImage[] startButton, exitButton;
	public static BufferedImage win, lose, title;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet("/textures/sheet.png");
		
		title = sheet.crop(SpriteSheet.SPRITE_SIZE * 4, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE * 4, SpriteSheet.SPRITE_SIZE * 2);
		
		score = new BufferedImage[10];
		for (int i = 0; i < 10; i++) {
			score[i] = sheet.crop(SpriteSheet.SPRITE_SIZE * i, 0, SpriteSheet.SPRITE_SIZE, SpriteSheet.SPRITE_SIZE);
		}
		startButton = new BufferedImage[2];
		startButton[0] = sheet.crop(0, SpriteSheet.SPRITE_SIZE, SpriteSheet.SPRITE_SIZE * 3, SpriteSheet.SPRITE_SIZE);
		startButton[1] = sheet.crop(SpriteSheet.SPRITE_SIZE * 3, SpriteSheet.SPRITE_SIZE, SpriteSheet.SPRITE_SIZE * 3, SpriteSheet.SPRITE_SIZE);
		
		exitButton = new BufferedImage[2];
		exitButton[0] = sheet.crop(SpriteSheet.SPRITE_SIZE * 6, SpriteSheet.SPRITE_SIZE, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE);
		exitButton[1] = sheet.crop(SpriteSheet.SPRITE_SIZE * 8, SpriteSheet.SPRITE_SIZE, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE);
		
		win = sheet.crop(0, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE);
		lose = sheet.crop(SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE * 2, SpriteSheet.SPRITE_SIZE);
		System.out.println("Assets loaded");
	}
}
