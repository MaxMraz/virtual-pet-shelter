package virtual_pet_shelter;

import java.util.Scanner;
import java.util.Map.Entry;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);
		System.out.println("One day, you find yourself wanting to make a difference in the world.");
		System.out.println("While wandering and pondering your true calling, you come across a direlict building.");
		System.out.println("The sign reads \"Max and Riley's Shelter for Abandoned and Feral Pet Rocks");
		System.out.println("You go inside to find the director staring at a pen full of straw.");
		System.out.println("He looks you dead in the eyes, hands you the keys to the shelter, and walks out.");
		System.out.println("You are the director now.");

		while (shelter.isOpen()) {
			if (shelter.isEmpty()) {
				noPets(shelter, input);
			} else {
				hasPets(shelter, input);

			}

		}
	}

	private static void hasPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("\rThis is the status of your pets:\r");
		for (Entry<String, VirtualPet> currentPet : shelter.getAllPets().entrySet()) {
			System.out.println("\r" + currentPet.getValue().displayStats());
		}
		System.out.println("\rWhat would you like to do next?\r\n" + "\r\n" + "1. Feed the pets\r\n"
				+ "2. Water the pets\r\n" + "3. Play with the pets\r\n" + "4. Put a pet up for adoption\r\n"
				+ "5. Admit a new pet\r\n" + "6. Exit");
		shelter.tick();
		String userChoice = input.nextLine();
		userChoice(shelter, userChoice, input);

	}

	private static void userChoice(VirtualPetShelter shelter, String userChoice, Scanner input) {
		switch (userChoice) {
		case "1":
			feedPets(shelter, input);
			break;
		case "2":
			waterPets(shelter, input);
			break;
		case "3":
			playWithPets(shelter, input);
			break;
		case "4":
			adoptOutPets(shelter, input);

			break;
		case "5":
			takeInNewPet(shelter, input);

			break;
		case "6":
			resignFromShelter();
			break;
		default:
			System.out.println("Invalid input... ");
			break;
		}

	}

	private static void resignFromShelter() {
		System.out.println("You burned down the shelter. System failure...");
		System.exit(0);
	}

	private static void takeInNewPet(VirtualPetShelter shelter, Scanner input) {
		System.out.println("\rName your new pet: ");
		String newName = input.nextLine();
		shelter.takeIn(newName);
	}

	private static void adoptOutPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("\rWhich rock do you want to adpot out?");
		String petToAdopt = input.nextLine();
		if (!shelter.getAllPets().containsKey(petToAdopt)) {
			System.out.println("You cannot adopt out a pet you do not have.");
		} else {
			onlyAdoptOutIfHappyEnough(shelter, petToAdopt);
		}
	}

	private static void onlyAdoptOutIfHappyEnough(VirtualPetShelter shelter, String petToAdopt) {
		int happiness = shelter.getPet(petToAdopt).getHappiness();
		if (happiness >= 10) {
			System.out.println(shelter.getPet(petToAdopt).getName() + " was adopted to a lovely family!");
			shelter.adoptOut(petToAdopt);

		} else {
			System.out.println("\rThis pet is not happy enough for anyone to want it.");
		}
	}

	private static void playWithPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("Type ALL to play with all your rocks or type a rock's name to play with just that one.");
		String playChoice = input.nextLine();
		if (playChoice.equalsIgnoreCase("all")) {
			shelter.playWithAllPets();
		} else {
			if (shelter.getAllPets().containsKey(playChoice)) {
				shelter.getPet(playChoice).playWithPet();
				System.out.println("\rRestlessness was decreased.");
			} else {
				System.out.println("Invalid Input");
			}
		}
	}

	private static void waterPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("Type ALL to water all your rocks or type a rock's name to water just that one.");
		String waterChoice = input.nextLine();
		if (waterChoice.equalsIgnoreCase("all")) {
			shelter.waterAllPets();
		} else {
			if (shelter.getAllPets().containsKey(waterChoice)) {
				shelter.getPet(waterChoice).waterPet();
				System.out.println("\rThirst was decreased.");
			} else {
				System.out.println("Invalid Input");
			}
		}
	}

	private static void feedPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("Type ALL to feed all your rocks or type a rock's name to feed just that one.");
		String feedChoice = input.nextLine();
		if (feedChoice.equalsIgnoreCase("all")) {
			shelter.feedAllPets();
		} else {
			if (shelter.getAllPets().containsKey(feedChoice)) {
				shelter.getPet(feedChoice).feedPet();
				System.out.println("\rHunger was decreased.");
			} else {
				System.out.println("Invalid Input");
			}
		}
	}

	private static void noPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("You realize there is a single rock sitting in the pen. Name it.");
		String name = input.nextLine();
		shelter.takeIn(name);
	}

}
