
import java.util.Random;
import java.util.Scanner;


public class MainRoom {
	static Scanner darkly = new Scanner(System.in);
	static Random rnd = new Random();
	static boolean secretFound = false;
	static boolean[] rooms = new boolean[8];

	private static void roomDescribe(String where, String[] stuff, String directions) {
		System.out.println("You are in " + where);
		for (String thing : stuff) {
			System.out.println("You see " + thing);
		}
		System.out.println("You can go " + directions);
	}

	public static void room0() {
		String place = "You have left the house";
		String[] things = new String[1];
		int counter = 0;

		for (boolean count : rooms) {
			if (count == true)
				counter++;	
		}

		int chance;
		chance = rnd.nextInt(4);
		if (chance == 3) {
			things[0] = "You are being followed.  Good Luck";
		} else {
			things[0] = "You are safe now.";
		}

		String direct = "Goodbye";

		System.out.println(place);
		for (String thing : things) {
			System.out.println(thing);
		}
		System.out.println("You visited " + counter + " rooms.");
		System.out.println(direct);

		//	roomDescribe(place, things, direct);

		System.exit(0);

	}	

	public static void room1() {
		String place = "the Foyer";
		String[] things = new String[1];
		things[0] = "a dead scorpion";
		String direct = " to the north (n) or the south (s)";
		rooms[0] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) {
				room2();
			}
			else if (choice.equals("s")) {
				room0();
			}
		} while (1 == 1);
	}

	public static void room2() {
		String place = "the Front Room";
		String[] things = new String[1];
		things[0] = "a phone";
		String direct = " to the east (e), the south (s) or the west (w)";
		rooms[1] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("w")) {
				room3();
			} else if (choice.equals("s")) {
				room1();
			} else if (choice.equals("e")) {
				room4();
			}
		} while (1 == 1);
	}

	public static void room3() {
		String place = "the Library";
		String[] things = new String[1];
		things[0] = "Spiders";
		String direct = " to the north (n) or the east (e)";
		rooms[2] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) {
				room5();
			} else if (choice.equals("e")) {
				room2();
			}
		} while (1 == 1);
	}

	public static void room4() {
		String place = "the Kitchen";
		String[] things = new String[1];
		things[0] = "Bats";
		String direct = " to the north (n) or the west (w)";
		rooms[3] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) {
				room7();
			} else if (choice.equals("w")) {
				room2();
			}
		} while (1 == 1);
	}

	public static void room5() {
		String place = "the Dining Room";
		String[] things = new String[2];
		things[0] = "Dust";
		things[1] = "Empty Box";
		String direct = " to the south (s)";
		rooms[4] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) {
				room3();
			}
		} while (1 == 1);
	}

	public static void room6() {

		int chance;
		if (secretFound == false) {

			chance = rnd.nextInt(4);
			if (chance == 2) {
				secretFound = true;
			}
		}

		String place = "the Vault";
		String[] things = new String[1];
		things[0] = "3 Walking Skeletons";
		rooms[5] = true;

		String direct;
		if (secretFound == true) {
			direct = " to the east (e) or the secret room (s)";
		}
		else {
			direct = " to the east (e)";
		}

		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("e")) {
				room7();
			}
			else if ((choice.equals("s")) && (secretFound))
			{
				room8();
			}
		} while (1 == 1);
	}

	public static void room7() {
		String place = "the Parlor";
		String[] things = new String[1];
		things[0] = "Treasure Chest";
		String direct = " to the west (w) or the south (s)";
		rooms[6] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("w")) {
				room6();
			} else if (choice.equals("s")) {
				room4();
			}
		} while (1 == 1);
	}

	public static void room8() {
		String place = "the Secret Room";
		String[] things = new String[1];
		things[0] = "Piles of Gold";
		String direct = " to the west (w)";
		rooms[7] = true;


		do {
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("w")) {
				room6();
			} 
		} while (1 == 1);
	}	

	public static void main(String[] args) {
		room1();
	}

}
