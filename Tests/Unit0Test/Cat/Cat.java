public class Cat {//made public lowercase changed to cat
	private String name;
	private String breed;
	private boolean isHungry;
	private int livesRemaining;
	
	// 2-Parameter Constructor
	public Cat(String name, String breed) { //added string breed and Cat to uppercase
		this.name = name; //added this
		this.breed = breed; //added this
		this.isHungry = true; //changed to true
		this.livesRemaining = 9; //added this
	}

	public String getName() {//changed to string
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsHungry() { // changed to boolean
		return isHungry;
	}

	public boolean feed() {
		return false;// changed to return
	}

	public boolean equals(Cat other) {
		return this.name == other.name && this.breed.equals(other.breed)
			&& this.livesRemaining == other.livesRemaining;// added equals
	}

	public String toString() {
		return (name + " is of breed " + breed + " and has " + livesRemaining + " lives remaining.");//changed to return
	}
}