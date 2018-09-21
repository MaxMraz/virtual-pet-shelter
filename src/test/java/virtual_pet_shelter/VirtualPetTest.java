package virtual_pet_shelter;


import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldHaveName() {
		VirtualPet underTest = new VirtualPet("Stoney");
		String name = underTest.getName();
		Assert.assertEquals("Stoney", name);

	}

	@Test
	public void shouldHaveAllInstances() {
		VirtualPet underTest = new VirtualPet("", "", 0, 0, 0);
		String test = underTest.displayStats();
		Assert.assertEquals(underTest.getName() + "\r" + underTest.getDescription() + "\rHunger: " + underTest.getHunger() + " || Restlessness: " + underTest.getRestlessness() + " || Thirst: "
				+ underTest.getThirst() + " || Happiness: " + underTest.getHappiness(), test);
	}

	@Test
	public void shouldHaveNameAndDescription() {
		VirtualPet underTest = new VirtualPet("Chuck", "Cool Rock");
		String test = underTest.displayStats();
		Assert.assertEquals(underTest.getName() + "\r" + underTest.getDescription() + "\rHunger: " + underTest.getHunger() + " || Restlessness: " + underTest.getRestlessness() + " || Thirst: "
				+ underTest.getThirst() + " || Happiness: " + underTest.getHappiness(), test);
	}

	@Test
	public void shouldHaveHunger() {
		VirtualPet underTest = new VirtualPet("Stoney");
		int test = underTest.getHunger();
		Assert.assertEquals(5, test);
	}

	@Test
	public void shouldHaveThirst() {
		VirtualPet underTest = new VirtualPet("Stoney");
		int test = underTest.getThirst();
		Assert.assertEquals(5, test);
	}

	@Test
	public void shouldHaveRestlessness() {
		VirtualPet underTest = new VirtualPet("Stoney");
		int test = underTest.getRestlessness();
		Assert.assertEquals(5, test);
	}

	@Test
	public void shouldReduceHunger() {
		VirtualPet underTest = new VirtualPet("Sandy");
		underTest.tick();
		underTest.feedPet();
		Assert.assertEquals(3, underTest.getHunger());
	}

	@Test
	public void shouldReduceRestlessness() {
		VirtualPet underTest = new VirtualPet("Sandy");
		underTest.tick();
		underTest.playWithPet();
		Assert.assertEquals(3, underTest.getRestlessness());
	}

	@Test
	public void shouldReduceThirst() {
		VirtualPet underTest = new VirtualPet("Sandy");
		underTest.tick();
		underTest.waterPet();
		Assert.assertEquals(3, underTest.getThirst());
	}

	@Test
	public void shouldBeFat() {
		VirtualPet underTest = new VirtualPet("Sandy", "cool rock", 0, 0, 0);
		underTest.feedPet();
		underTest.tick();
		boolean test = underTest.isGameOver();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldBeStarved() {
		VirtualPet underTest = new VirtualPet("Sandy", "cool rock", 11, 0, 0);
		underTest.tick();
		boolean test = underTest.isGameOver();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldDrown() {
		VirtualPet underTest = new VirtualPet("Sandy", "cool rock", 5, 5, 0);
		underTest.waterPet();
		underTest.tick();
		boolean test = underTest.isGameOver();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldCrumbleToDust() {
		VirtualPet underTest = new VirtualPet("Sandy", "cool rock", 5, 5, 11);
		underTest.tick();
		boolean test = underTest.isGameOver();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldBeOverStimulated() {
		VirtualPet underTest = new VirtualPet("Sandy", "cool rock", 5, 0, 5);
		underTest.playWithPet();
		underTest.tick();
		boolean test = underTest.isGameOver();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldRunAway() {
		VirtualPet underTest = new VirtualPet("Sandy", "cool rock", 5, 11, 5);
		underTest.tick();
		boolean test = underTest.isGameOver();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldBeHappy() {
		VirtualPet underTest = new VirtualPet("Sandy");
		// 1
		underTest.waterPet();
		underTest.tick();
		// 2
		underTest.playWithPet();
		underTest.tick();
		// 3
		underTest.playWithPet();
		underTest.tick();
		// 4
		underTest.tick();
		// 5
		underTest.tick();
		// 6
		underTest.feedPet();
		underTest.tick();
		// 7
		underTest.playWithPet();
		underTest.tick();
		// 8
		underTest.waterPet();
		underTest.tick();
		// 9
		underTest.tick();
		// 10
		underTest.tick();
		boolean test = underTest.isHappy();
		Assert.assertEquals(true, test);
	}

	@Test
	public void shouldBeDead() {
		VirtualPet underTest = new VirtualPet("Sandy");
		for (int i = 0; i <= 15; i++) {
			underTest.tick();
		}
		boolean actual = underTest.isDead();
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void shouldHaveADescriptionGenerated() {
		VirtualPet underTest = new VirtualPet("Metamorph", "test", 0, 0, 0);
		
		Assert.assertEquals("test", underTest.getDescription());
	}
}
