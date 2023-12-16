import java.util.Scanner;

public class Menu {
    Scanner mayScanner = new Scanner(System.in);

    DANHSACHNHANVIEN trinhqlNhanVien = new DANHSACHNHANVIEN();
    QUANLIDSTHUOC trinhqlThuoc = new QUANLIDSTHUOC();
    private DANHSACHCHITHIETPHIEUNHAP trinhqlDSCTPN = new DANHSACHCHITHIETPHIEUNHAP();
    private DANHSACHPHIEUNHAP trinhqlDSPN = new DANHSACHPHIEUNHAP();
    QUANLYNHAPHANG trinhqlNhapHang = new QUANLYNHAPHANG();
    

    public void MainMenu() {

        // khong biet doc o dau nen doc o day
        trinhqlNhanVien.docFile();
        trinhqlDSCTPN.docfile();
        trinhqlDSPN.docfile();


        int option = 0;
        do {
            System.out.println(
                    "\u001B[31m" + "-".repeat(20) + "CHUONG TRINH QUAN LI PHONG MACH" + "-".repeat(20) + "\u001B[0m");
            System.out.println("\tNhan phim 0 de thoat");
            System.out.println("\tNhan phim 1 de vao trinh quan li danh sach thuoc");
            System.out.println("\tNhan phim 2 de vao trinh quan li nhan vien");
            System.out.println("\tNhan phim 3 de vao trinh quan li nhap hang");
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
            if(option == 2) {
                trinhqlNhanVien.menu();
            }

            if(option == 3) {
                trinhqlNhapHang.menu(trinhqlDSCTPN,trinhqlDSPN);
            }

        } while (option != 0);
    }
}
