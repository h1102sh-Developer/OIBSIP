import java.util.Scanner;

import College.Book;

public class Student{
    String StudentName;
    String RegNum;

    Book[] BorrowedBooks = new Book[3];
    public int BooksCount = 0;

    Scanner input = new Scanner(System.in);

    public Student()
    {
        System.out.println("Enter Student Name:");

        this.StudentName = input.nextLine();

        System.out.println("Enter Registration Number:");
        this.RegNum = input.nextLine();
    }
}