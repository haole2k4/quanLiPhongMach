import java.util.Scanner;

public class Menu {
    Scanner mayScanner = new Scanner(System.in);


    QUANLIDSTHUOC trinhqlThuoc = new QUANLIDSTHUOC();
    

    public void MainMenu() {
        int option = 0;
        do {
            System.out.println(
                    "\u001B[31m" + "-".repeat(20) + "CHUONG TRINH QUAN LI PHONG MACH" + "-".repeat(20) + "\u001B[0m");
            System.out.println("\tNhan phim 0 de thoat");
            System.out.println("\tNhan phim 1 de vao trinh quan li danh sach thuoc");
            System.out.print("\tVui long nhap lua chon cua ban: ");
            option = mayScanner.nextInt();

            while (option < 0) {
                System.out.print("\tKhong hop le. Vui long nhap lai lua chon cua ban: ");
                option = mayScanner.nextInt();
            }

            if(option == 0) {
                break;
            }

            if(option == 1) {
                trinhqlThuoc.trinhQuanLiDanhSachThuoc();
            }

        } while (option != 0);
    }
}
