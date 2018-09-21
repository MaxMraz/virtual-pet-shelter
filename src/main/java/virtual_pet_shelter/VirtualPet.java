package virtual_pet_shelter;

public class VirtualPet {
	private String name;
	private int hunger;
	private int restlessness;
	private int thirst;
	private boolean dead = false;
	private int happiness;
	private String description; //So, we felt like the description should be a procedurally generated string
	//this way, it humorously describes the creature that has shown up at your shelter's door

	// accessors
	public String getName() {
		return name;
	}

	public int getHappiness() {
		return happiness;
	}

	public int getHunger() {
		return hunger;
	}

	public int getRestlessness() {
		return restlessness;
	}
	
	public String getDescription() {
		return description;
	}

	public int getThirst() {
		return thirst;
	}

	public boolean isGameOver() {
		return dead;
	}

	public boolean isHappy() {
		if (happiness >= 10) {
			return true;
		} else {
			return false;
		}
	}

	// constructors
	public VirtualPet(String newName) {
		name = newName;
		description = "Nice guy";
		hunger = 5;
		restlessness = 5;
		thirst = 5;
		happiness = 0;

	}

	public VirtualPet(String newName, String newDescription) {

		name = newName;
		description = newDescription;
		hunger = 5;
		restlessness = 5;
		thirst = 5;
		happiness = 0;

	}

	public VirtualPet(String newName, String newDescription, int newHunger, int newRest, int newThirst) {

		name = newName;
		description = newDescription;
		hunger = newHunger;
		restlessness = newRest;
		thirst = newThirst;
		happiness = 0;
	}

	// funtimes
	public String displayStats() {

		return name + "\r" + description + "\rHunger: " + hunger + " || Restlessness: " + restlessness + " || Thirst: "
				+ thirst + " || Happiness: " + happiness;
	}

	public void tick() {
		hunger++;
		restlessness++;
		thirst++;
		happiness++;
		if (hunger < 1) {
			getsFat();
		}
		if (hunger > 10) {
			starve();
		}
		if (thirst < 1) {
			drown();
		}
		if (thirst > 10) {
			crumbleToDust();
		}
		if (restlessness < 1) {
			overStimulated();
		}
		if (restlessness > 10) {
			runAway();
		}

	}

	private void runAway() {
		dead = true;

	}

	private void overStimulated() {
		dead = true;
	}

	private void crumbleToDust() {
		dead = true;

	}

	public void getsFat() {
		dead = true;
	}

	public void starve() {
		dead = true;
	}

	public void drown() {
		dead = true;
	}

	public void feedPet() {
		hunger -= 3;
	}

	public void playWithPet() {
		restlessness -= 3;
	}

	public void waterPet() {
		thirst -= 3;
	}

	public boolean isDead() {
		return dead;
	}

}
