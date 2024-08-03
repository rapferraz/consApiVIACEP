import zipCodeFinder.classes.Menu;
import zipCodeFinder.classes.ShowZipCodeInfo;
import zipCodeFinder.classes.AddresReg;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Menu.showMenu();
        Scanner dataReader = new Scanner(System.in);
        int option = dataReader.nextInt();

        System.out.print("Digit the Zip Code: ");
        int zipCode = dataReader.nextInt();

        switch (option) {
            case 1:
                System.out.println("Showing Zip Code " + zipCode + " information:");
                new ShowZipCodeInfo(zipCode);
                break;
            case 2:
                System.out.println("Digit the house number: ");
                int number = dataReader.nextInt();
                System.out.println("Digit the house complement (press ENTER for NO complement): ");
                String complement = dataReader.nextLine();
                new AddresReg(zipCode, number, complement);
                break;
            case 0:
                System.out.println("Good bye!");
                break;
            default:
                System.out.println("Invalid Option!");
                break;
        }
    }
}
