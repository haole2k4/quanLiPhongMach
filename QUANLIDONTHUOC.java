import java.util.Arrays;
import java.util.Scanner;

public class QUANLIDONTHUOC {
    Scanner quanliScanner = new Scanner(System.in);
    DONTHUOC[] dsDonThuoc = new DONTHUOC[0];
    DANHSACHTHUOC ds;

    QUANLIDONTHUOC(DANHSACHTHUOC ds) {
        this.ds = ds;
    }

    public void menuDonThuoc() {
        int option = 0;
        do {
            System.out.println("\tNhap 0 de thoat");
            System.out.println("\tNhap 1 de tao don thuoc");
            System.out.println("\tNhap 2 de xoa don thuoc");
            System.out.println("\tNhap 3 de sua don thuoc");
            System.out.println("\tNhap 4 de in don thuoc");
            System.out.print("\tNhap lua chon: ");
            option = quanliScanner.nextInt();

            if (option == 0) {
                break;
            }
            if (option == 1) {
                this.themDonThuoc();
            }

            if (option == 4) {
                this.dsDonThuoc[this.dsDonThuoc.length - 1].inDonThuoc();
            }
        } while (option != 0);
    }

    public void themDonThuoc() {
        this.dsDonThuoc = Arrays.copyOf(this.dsDonThuoc, this.dsDonThuoc.length + 1);
        this.dsDonThuoc[this.dsDonThuoc.length - 1] = new DONTHUOC("PK01", "tri noi");
        this.dsDonThuoc[this.dsDonThuoc.length - 1].nhapThuocBoc(ds);
    }
}
