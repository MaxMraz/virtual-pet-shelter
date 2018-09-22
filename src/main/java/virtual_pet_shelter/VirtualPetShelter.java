package virtual_pet_shelter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {
	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	private int deaths = 0;
	private boolean open = true;

	public void addPet(VirtualPet newPet) {
		pets.put(newPet.getName(), newPet);
	}
	// TODO make a generate pet method?

	public void feedAllPets() {
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			currentPet.getValue().feedPet();
		}
	}

	public void waterAllPets() {
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			currentPet.getValue().waterPet();
		}
	}

	public void playWithAllPets() {
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			currentPet.getValue().playWithPet();
		}
	}

	public void takeIn(String name) {
		VirtualPet newPet = new VirtualPet(name);
		addPet(newPet);
	}

	public Map<String, VirtualPet> getAllPets() {
		return pets;
	}

	public void adoptOut(String petID) {
		pets.remove(petID);
	}

	public VirtualPet getPet(String petID) {

		return pets.get(petID);

	}

	public void playWithPet(String petID) {

		getPet(petID).playWithPet();

	}

	public void tick() {
		List<String> deadList = new ArrayList<String>();
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			if (deaths > 10) {
				open = false;
			}
			currentPet.getValue().tick();

			if (currentPet.getValue().isDead()) {
				deaths++;
				deadList.add(currentPet.getKey());

			}
		}
		// remove dead pets from pets collection
		// You can't remove an element WHILE iterating over it.
		// Wait, but itsn't that what I'm doing?
		for (String deadPet : deadList) {
			pets.remove(deadPet);
		}

	}

	public boolean isOpen() {
		return open;
	}

	public boolean isEmpty() {
		return pets.isEmpty();
	}

}
