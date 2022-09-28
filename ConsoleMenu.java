package part03;


import console.Console;
/**
 * An object class to describe a simple text-based Menu
 * 
 * @author A.N.Other
 *
 */
public class ConsoleMenu extends Console{
	private String title;
	private String items[];
	
    
	public ConsoleMenu(String title, String options[]) {
        super(true);
        setSize(500,500);
        setVisible(true);
		this.title = title;
		items = options;
		
	}

	private void display() {
        
		println(title);
		for (int i = 0; i < title.length(); i++) {
			print("+");
		}
		println();
		for (int opt = 1; opt <= items.length; opt++) {
			println(opt + ". " + items[opt - 1]);
		}
		println();
	}

	public int getUserChoice() {
		int value = 0;
        String temp;
		display();
		do {
			try {
				print("Enter Selection: ");
				temp = readLn();
                value = Integer.parseInt(temp);
				break;
			}
			catch(Exception ex) {
				System.out.println("Invalid menu option - try again!");
				readLn();
			}
		} while (true);
		return value;
	}

}
