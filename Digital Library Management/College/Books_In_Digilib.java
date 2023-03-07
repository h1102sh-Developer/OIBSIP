package College;

import java.util.Scanner;

public class Books_In_Digilib {

    Book[] theBooks = new Book[50];
    public static int count;

    Scanner input = new Scanner(System.in);

    public int compareBookObjects(Book b1, Book b2)
    {

        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {

            System.out.println("Book of this Name Already Exists, Please Check and Enter Another Name.");
            return 0;
        }

        if (b1.sNo == b2.sNo) {

            System.out.println("Book of this Serial No Already Exists, Choose Another No. .");

            return 0;
        }
        return 1;
    }

    public void addBook(Book b)
    {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i])
                    == 0)
                return;
        }

        if (count < 50) {

            theBooks[count] = b;
            count++;
        }
        else {

            System.out.println("No Space to Add More Books.");
        }
    }

    public void searchBySno()
    {

        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("|\tS.No\t|\t\tName\t\t|\t\tAuthor\t\t|\tAvailable Qty\t|\tTotal Qty\t|");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("|\t" + theBooks[i].sNo + "\t\t|\t" + theBooks[i].bookName + "\t|\t"
                        + theBooks[i].authorName + "\t\t|\t\t" + theBooks[i].bookQtyCopy + "\t\t\t|\t\t"
                        + theBooks[i].bookQty + "\t\t|");
                System.out.println("------------------------------------------------------------------------------------------");
                flag++;
                return;
            }
        }
        System.out.println("No Book for Serial No " + sNo + " Found.");
    }

    public void searchByAuthorName()
    {

        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("|\tS.No\t|\t\tName\t\t|\t\tAuthor\t\t|\tAvailable Qty\t|\tTotal Qty\t|");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {

            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {

                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("|\t" + theBooks[i].sNo + "\t\t|\t" + theBooks[i].bookName + "\t|\t"
                        + theBooks[i].authorName + "\t\t|\t\t" + theBooks[i].bookQtyCopy + "\t\t\t|\t\t"
                        + theBooks[i].bookQty + "\t\t|");
                System.out.println("------------------------------------------------------------------------------------------");
                flag++;
            }
        }

        if (flag == 0)
            System.out.println("No Books of " + authorName + " Found.");
    }

    public void showAllBooks()
    {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("----------------------------------------" +
                "------------------------------------------------------------------------------");
        System.out.println("|\tS.No\t|\t\tName\t\t|\t\tAuthor\t\t|\tAvailable Qty\t|\tTotal Qty\t|");
        System.out.println("-----------------------------------------" +
                "-------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {

            System.out.println("--------------------------------------" +
                    "---------------------------------------------------");
            System.out.println("|\t" + theBooks[i].sNo + "\t\t|\t" + theBooks[i].bookName + "\t|\t"
                    + theBooks[i].authorName + "\t\t|\t\t" + theBooks[i].bookQtyCopy + "\t\t\t|\t\t"
                    + theBooks[i].bookQty + "\t\t|");
            System.out.println("---------------------------------------" +
                    "--------------------------------------------------");
        }
    }

    public void upgradeBookQty()
    {

        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                System.out.println("Enter No of Books To be Added:");

                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    public void Disp_Data()
    {

        System.out.println("------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("------------------------------------------------");
    }

    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {

                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number " + " Available in Library.");
        return -1;
    }

    public Book checkOutbook()
    {

        System.out.println("Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    public void checkInbook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
