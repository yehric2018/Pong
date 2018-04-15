package yehric2018.pong;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Pong", Handler.GAME_WIDTH, Handler.GAME_HEIGHT);
		game.start();
	}
}
