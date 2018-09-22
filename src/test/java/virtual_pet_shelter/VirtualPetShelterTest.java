package virtual_pet_shelter;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {
	@Test
	public void shouldAddTwoPetsToAMapThenFeedThemBothAtTheSameTime() {
		VirtualPet pet1 = new VirtualPet("Pebbill");
		VirtualPet pet2 = new VirtualPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.feedAllPets();
		Assert.assertEquals(2, pet1.getHunger());

	}

	@Test
	public void shouldAddTwoPetsToAMapThenWaterThemBothAtTheSameTime() {
		VirtualPet pet1 = new VirtualPet("Pebbill");
		VirtualPet pet2 = new VirtualPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.waterAllPets();
		Assert.assertEquals(2, pet1.getThirst());

	}

	@Test
	public void shouldAddTwoPetsToAMapThenPlayThemBothAtTheSameTime() {
		VirtualPet pet1 = new VirtualPet("Pebbill");
		VirtualPet pet2 = new VirtualPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.playWithAllPets();
		Assert.assertEquals(2, pet1.getRestlessness());
	}

	@Test
	public void shouldIntakeHomelessPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.takeIn("Shellby");
		Map<String, VirtualPet> test = underTest.getAllPets();
		Assert.assertEquals(false, test.isEmpty());
	}

	@Test
	public void shouldAdoptOut() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.takeIn("Cuddles");
		underTest.adoptOut("Cuddles");
		Map<String, VirtualPet> test = underTest.getAllPets();
		Assert.assertEquals(true, test.isEmpty());

	}

	@Test
	public void shouldPlayWithIndividual() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.takeIn("Cuddles");
		underTest.takeIn("Checkers");
		VirtualPet checkers = underTest.getPet("Checkers");
		VirtualPet cuddles = underTest.getPet("Cuddles");
		underTest.playWithPet("Checkers");
		Assert.assertEquals(3, cuddles.getRestlessness() - checkers.getRestlessness());

	}

	@Test
	public void shouldTick() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.takeIn("Cuddles");
		underTest.takeIn("Checkers");
		VirtualPet checkers = underTest.getPet("Checkers");
		VirtualPet cuddles = underTest.getPet("Cuddles");
		underTest.tick();
		Assert.assertEquals(12, checkers.getHunger() + cuddles.getHunger());
	}

	@Test
	public void shouldBeOpen() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		for (int i = 0; i <= 15; i++) {
			underTest.takeIn("Cuddles");
			for (int j = 0; j <= 15; j++) {
				underTest.tick();
			}
		}
		underTest.tick();
		boolean actual = underTest.isOpen();
		Assert.assertEquals(false, actual);
	}

	@Test
	public void shouldRemoveAPetThatsDied() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Cuddles", "", 10, 10, 10);
		VirtualPet pet2 = new VirtualPet("Checkers", "", 10, 10, 10);
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.tick();
		Assert.assertEquals(true, underTest.isEmpty());

	}

	@Test
	public void shouldNotRemoveAPetYouDontHave() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Cuddles", "", 0, 0, 0);
		VirtualPet pet2 = new VirtualPet("Checkers", "", 0, 0, 0);
		underTest.addPet(pet1);
		underTest.addPet(pet2);

		underTest.adoptOut("foo");

		Assert.assertEquals(2, underTest.getAllPets().size());
	}

}
