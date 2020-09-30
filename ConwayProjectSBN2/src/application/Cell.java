package application;


public class Cell {
	private boolean Alive;

//this is "getAlive"
	public boolean isAlive() {
		return Alive;
	}

	public void setAlive(boolean alive) {
		Alive = alive;
	}

	public Cell(boolean alive) {
		super();
		Alive = alive;
	}

//empty constructor lets up set a random boolean
	public Cell() {
		super();
		double r = Math.random();
		if (r < 0.5)
			this.Alive = false;
		else
			this.Alive = true;
	}

	@Override
	public String toString() {
		return Alive + "";
	}

}

