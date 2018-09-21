package virtual_pet_shelter;

import java.util.Random;

public class VirtualPet {
	private String name;
	private int hunger;
	private int restlessness;
	private int thirst;
	private boolean dead = false;
	private int happiness;
	private String description; // So, we felt like the description should be a procedurally generated string
	// this way, it humorously describes the creature that has shown up at your
	// shelter's door

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
		description = generateDescription(); // TODO, this isn't reaaaaaally tested, because it's a random string
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
				+ thirst + " || Happiness: " + happiness + "\r";
	}

	// TODO I'm not really sure how to test this. Maybe we should move it to the
	// Shelter App somehow?
	public String generateDescription() {
		String[] list1 = { "smooth pebble", "skipping stone", "mossy boulder", "solid rock", "shambling pile of gravel",
				"crumbling slab of stone", "hefty boulder", "stony tablet", "solid edifice" };
		String[] list2 = { "smells", "tastes", "looks", "seems", "sounds", "feels", "comes across",
				"gives off the impression", "pretends" };
		String[] list3 = { "it was a president in a past life. Maybe Abraham Lincoln.", "the sea breeze.",
				"it once took part in a landslide.", "it yearns to be free.",
				"it taught itself how to walk. And run. Quickly.", "it used to live in Hollywood.",
				"it knows something personal about you, but won't say what.",
				"it learned how to cook really nice meals, but never does.", "it spends way too much on its coffee.",
				"it enjoys the finer things in life.", "it knows how to do trigonometry.", "it can drive stick shift.",
				"it has more friends than you do.", "it was skipped across many lakes as a child", "a riddle",
				"the sidewalk after a rainstorm" };
		Random randNum = new Random();
		int rand1 = randNum.nextInt(list1.length);
		String noun1 = list1[rand1];
		randNum = new Random();
		int rand2 = randNum.nextInt(list2.length);
		String verb = list2[rand2];
		randNum = new Random();
		int rand3 = randNum.nextInt(list3.length);
		String noun2 = list3[rand3];
		return "This " + noun1 + " " + verb + " like " + noun2;
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
