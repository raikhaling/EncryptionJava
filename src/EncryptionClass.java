import java.util.*;

public class EncryptionClass {
	
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character; 
	private String line;
	private char[] letters;
	
 	
	
	EncryptionClass(){
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList<>();
		shuffledList = new ArrayList<>();
		character = ' ';
		
		newKey();
		askQuestion();
	}
	
	private void askQuestion() {
		while(true) {
			System.out.println("*********************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ew Key,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
				
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a valid anser....");
				
			}
		}
	}
	
	private void newKey() {
		character = ' ';
		list.clear();
		shuffledList.clear(); 
		
		for(int i = 32,j=0; i < 127; i++,j++) {	//asci values between 32 to 127 normally can be typed inkeyboard
			list.add(Character.valueOf(character));
			//System.out.println(list.get(j));
			character++;
		}
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList); //shuffles the list
		//System.out.println(shuffledList);
		System.out.println("A new key has been generated*");
	}
	
	private void getKey() {
		System.out.println("Key: ");
		for(Character x: list){
			System.out.print(x);
		}
		System.out.println();
		for(Character x: shuffledList){
			System.out.print(x);
		}System.out.println();
		
	}
	
	private void encrypt() {
		System.out.println("Enter the message to be encrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray(); //converts String to char arrays
		
		for(int i = 0; i<letters.length; i++) {
			for(int j = 0; j<list.size(); j++) {
				if(letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted Message is: ");
		for(char x: letters) {
			System.out.print(x);
		}
		System.out.println();
	}
	
	private void decrypt() {
		System.out.println("Enter the message to be decrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray(); //converts String to char arrays
		
		for(int i = 0; i<letters.length; i++) {
			for(int j = 0; j<list.size(); j++) {
				if(letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted Message is: ");
		for(char x: letters) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void quit() {
		 System.out.println("Thank You. Going to exit....");
	//	 System.out.print("\033[H\033[2J");    
		 System.out.flush();  
		 System.exit(0);
	}
}
