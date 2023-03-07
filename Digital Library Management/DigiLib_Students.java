import College.Book;
import College.Books_In_Digilib;

import java.util.Scanner;

public class DigiLib_Students {

    Scanner input = new Scanner(System.in);
    Student[] TheStudents = new Student[50];

    public static int count = 0;

    public void addStudent(Student s)
    {
        for (int i = 0; i < count; i++) {

            if (s.RegNum.equalsIgnoreCase(
                    TheStudents[i].RegNum)) {

                System.out.println("Student of Reg Num " + s.RegNum + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            TheStudents[count] = s;
            count++;
        }
    }
    public void showAllStudents()
    {
        System.out.println("-------------------------------");
        System.out.println("Student Name\t|\tReg Number");
        System.out.println("-------------------------------");
        for (int i = 0; i < count; i++) {

            System.out.println("-------------------------------");
            System.out.println(TheStudents[i].StudentName + "\t\t|\t" + TheStudents[i].RegNum);
            System.out.println("-------------------------------");
        }
    }
    public int isStudent()
    {
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (TheStudents[i].RegNum.equalsIgnoreCase(regNum)) {

                return i;
            }
        }

        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    public void checkOutBook(Books_In_Digilib Book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("Checking Out");

            Book.showAllBooks();
            Book b = Book.checkOutbook();

            System.out.println("Checking Out");
            if (b != null) {

                if (TheStudents[studentIndex].BooksCount <= 3) {

                    System.out.println("Adding Book");
                    TheStudents[studentIndex].BorrowedBooks[TheStudents[studentIndex].BooksCount] = b;
                    TheStudents[studentIndex].BooksCount++;

                    return;
                }
                else {

                    System.out.println("As Per Library Rules :- Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.\nSorry!!! For The Inconvenience");
        }
    }
    public void checkInBook(Books_In_Digilib Book)
    {
        int StudentIndex = this.isStudent();//Due to ambiguity issues (this.) keyword is used

        if (StudentIndex != -1) {
            System.out.println("-------------------------------------------------");
            System.out.println("|\tS.No\t|\tBook Name\t|\tAuthor Name");
            System.out.println("-------------------------------------------------");

            Student s = TheStudents[StudentIndex];

            for (int i = 0; i < s.BooksCount; i++) {

                System.out.println("-------------------------------------------------");
                System.out.println("|\t" + s.BorrowedBooks[i].sNo + "\t\t|\t" + s.BorrowedBooks[i].bookName + "\t|\t"
                        + s.BorrowedBooks[i].authorName );
                System.out.println("-------------------------------------------------");
            }

            System.out.println("Enter Serial Number of Book to Be Checked In : ");

            int sNo = input.nextInt();

            for (int i = 0; i < s.BooksCount; i++) {
                if (sNo == s.BorrowedBooks[i].sNo) {
                    Book.checkInbook(s.BorrowedBooks[i]);
                    s.BorrowedBooks[i] = null;
                    return;
                }
            }
            System.out.println("Book of Serial No " + sNo + "Not Found");
        }
    }
}