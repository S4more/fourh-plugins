package com.fourh.sample;

import java.lang.reflect.Constructor;

public class Timeout {
	private int delay;
	private Runnable executor;
	private Thread thread;
	private boolean running = false;

	// Delay between runs in MS
	public Timeout (Runnable executor, int delay) {
		this.delay = delay;
		this.executor = executor;
	}

	public void start() {
		this.running = true;
		this.thread = new Thread(() -> {
			while(this.running) {
				try {
					executor.run();
					Thread.sleep(delay);
				} catch (InterruptedException e) {}
			}
		});
		this.thread.start();
	}

	public void stop() {
		this.running = false;
	}
}
