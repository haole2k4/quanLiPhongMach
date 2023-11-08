
import java.util.Scanner;
public class QLDSNCC {
    DSNCC ql = new DSNCC();
    public void menu()
    {
        int i;
        do
        {
            System.out.println("0: Thoat");
            System.out.println("1: Nhap Nha Cung Cap");
            System.out.println("2: Xuat Nha Cung Cap");
            System.out.print("Lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch (i) {
                case 1:
                    ql.them();
                    break;
                case 2:
                    ql.xuat();
                    break;
            }
        }
        while (i!=0);
    }

    public static void main(String[] args) {
        QLDSNCC ql = new QLDSNCC();
        ql.menu();
    }
}
