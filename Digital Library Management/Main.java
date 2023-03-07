import College.Book;
import College.Books_In_Digilib;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

        System.out.println("-----------------Welcome to the Digital Library!-----------------");
        System.out.println(" Select From The Following Options : ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\n");

        Books_In_Digilib Aobj = new Books_In_Digilib();

        DigiLib_Students AobjStudent = new DigiLib_Students();

        int Choice;
        int SearchChoice;

        do {

            Aobj.Disp_Data();
            Choice = input.nextInt();

            switch (Choice) {
                case 1 -> {
                    Book b = new Book();
                    Aobj.addBook(b);
                }
                case 2 -> Aobj.upgradeBookQty();
                case 3 -> {
                    System.out.println(" press 1 to Search with Book Serial No.");
                    System.out.println(" Press 2 to Search with Book's Author Name.");
                    SearchChoice = input.nextInt();
                    switch (SearchChoice) {

                        case 1 -> Aobj.searchBySno();

                        case 2 -> Aobj.searchByAuthorName();
                    }
                }
                case 4 -> Aobj.showAllBooks();
                case 5 -> {
                    Student s = new Student();
                    AobjStudent.addStudent(s);
                }
                case 6 -> AobjStudent.showAllStudents();
                case 7 -> AobjStudent.checkOutBook(Aobj);
                case 8 -> AobjStudent.checkInBook(Aobj);
                default -> System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }

        while (Choice != 0);
        System.out.println("------------Thank You!------------");
    }
}