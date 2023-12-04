import java.util.Scanner;

public class QuanLyDSBN {
    private DSBN dsbn;

    public void Menu() {
        System.out.print("----------------");
        dsbn = new DSBN();
        int menu = 0;
        Scanner sc = new Scanner(System.in);
        while (menu != 8) {
            System.out.print("\n1) Nhap DSBN." + "\n2) Xem DSBN." + "\n3) Them BN." + "\n4) Xoa BN." + "\n5) Sua thong tin BN." + "\n6) Tim kiem." + "\n7) Thong ke. " + "\n8) Ket thuc.");
            System.out.print("\nHay chon chuc nang: ");
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    dsbn.NhapBN();
                    break;
                case 2:
                    dsbn.XuatBN();
                    break;
                case 3:
                    dsbn.ThemBN();
                    break;
                case 4:
                    System.out.print("\nNhap ma benh nhan muon xoa: ");
                    String ma1 = sc.nextLine();
                    dsbn.XoaBN(ma1);
                    break;
                case 5:
                    dsbn.SuaTTBN();
                    break;
                case 6:
                    System.out.print("\nNhap ma benh nhan can tim: ");
                    String ma2 = sc.nextLine();
                    int foundIndex = dsbn.TimkiemBN(ma2);
                    if (foundIndex != -1) {
                        System.out.println("Benh nhan da duoc tim thay o vi tri " + foundIndex);
                    } else {
                        System.out.println("Khong tim thay thong tin benh nhan.");
                    }
                    break;
                //case 7:
                //dsbn.ThongKe();
                //break;
            }
        }
    }
}
