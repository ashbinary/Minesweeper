package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import objects.ObjectHandler;
import objects.ObjectID;
import objects.types.Block;
import objects.types.PressedBlock;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -8584703749668887689L;
	public static final int gameWidth = 600;
	public static final int gameHeight = 600;
	
	private ObjectHandler objectHandler;
	
	private Thread thread;
	private boolean running;
	
	public static boolean ouch;
	public static double deathtime;
	public static boolean canInput = true;
	
	public static Board gameboard;
	public static Board camoboard;
	
	public Game() {
		Debug.open();
		gameboard = new Board();
		gameboard.generateBoard();
		
		camoboard = new Board();
		camoboard.initializeBoard();
		
		new Window(gameboard.getSize() * 32 + 14, gameboard.getSize() * 32 + 36, "Minesweeper", this);
		objectHandler = new ObjectHandler();
		
		this.addMouseListener(new Mouse(objectHandler));
		
		for (int y = 0; y <= gameboard.getSize() - 1; y++) {
			for (int x = 0; x <= gameboard.getSize() - 1; x++) {
				objectHandler.addObj(new PressedBlock(x * 32, y * 32, ObjectID.Block, x, y));
				objectHandler.addObj(new Block(x * 32, y * 32, ObjectID.Block, x, y));
			}
		}
	}

	@Override
	public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 64;
        
        int ticks = 0;
        int frames = 0;
        
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            
            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }
            
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            if (shouldRender) {
                frames++;
                render();
            }
            
            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
              	if (!canInput) System.exit(0);
                frames = 0;
                ticks = 0;
            }
        }
    }

	public static void main(String[] args) {
		new Game();
	}
	
	private void tick() {
		objectHandler.tick();
	}
	
	public void render() {
		BufferStrategy memOrganize = this.getBufferStrategy();
		
		if (memOrganize == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = memOrganize.getDrawGraphics();
		objectHandler.render(graphics);
		
		graphics.dispose();
		memOrganize.show();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception threadingFailed) {
			threadingFailed.printStackTrace();
		}
	}
}
