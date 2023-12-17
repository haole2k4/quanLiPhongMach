import java.util.Scanner;

public class Menu {
    Scanner mayScanner = new Scanner(System.in);

    DANHSACHTHUOC trinhqlThuoc = new DANHSACHTHUOC();
    DANHSACHNHANVIEN trinhqlNhanVien = new DANHSACHNHANVIEN();
    DANHSACHCHITHIETPHIEUNHAP trinhqlDSCTPN = new DANHSACHCHITHIETPHIEUNHAP();
    DANHSACHPHIEUNHAP trinhqlDSPN = new DANHSACHPHIEUNHAP();
    QUANLYNHAPHANG trinhqlNhapHang = new QUANLYNHAPHANG();
    DANHSACHNHACUNGCAP trinhqlNCC = new DANHSACHNHACUNGCAP();
    DANHSACHDONTHUOC trinhqlDONTHUOC = new DANHSACHDONTHUOC();
    QuanLyDSBN trinhqlBenhNhan = new QuanLyDSBN();
    QUANLIDSBACSI trinhqlBacSi = new QUANLIDSBACSI();

    public void MainMenu() {

        // khong biet doc o dau nen doc o day
        trinhqlNhanVien.docFile();
        trinhqlDSCTPN.docfile();
        trinhqlDSPN.docfile();
        trinhqlNCC.docFile();
        try{
        trinhqlThuoc.docData("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\dataThuoc.txt" );
        } catch(Exception E){
            System.out.println("loi !");
        }
        trinhqlDONTHUOC.docFile("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\DONTHUOC.TXT");
        int option = 0;
        do {
            System.out.println(
                    "\u001B[31m" + "-".repeat(20) + "CHUONG TRINH QUAN LI PHONG MACH" + "-".repeat(20) + "\u001B[0m");
            System.out.println("\tNhan phim 0 de thoat");
            System.out.println("\tNhan phim 1 de vao trinh quan li danh sach thuoc");
            System.out.println("\tNhan phim 2 de vao trinh quan li nhan vien");
            System.out.println("\tNhan phim 3 de vao trinh quan li nhap hang");
            System.out.println("\tNhan phim 4 de vao trinh quan li nha cung cap");
            System.out.println("\tNhan phim 5 de vao trinh quan li don thuoc");
            System.out.println("\tNhan phim 6 de vao trinh quan li benh nhan");
            System.out.println("\tNhan phim 7 de vao trinh quan li bac si");
            
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
                trinhqlThuoc.menuThaoTac();
            }
            if(option == 2) {
                trinhqlNhanVien.menu();
            }

            if(option == 3) {
                trinhqlNhapHang.menu(trinhqlDSCTPN,trinhqlDSPN);
            }
             if(option == 4) {
                trinhqlNCC.menu();
            }
            if (option == 5){
                trinhqlDONTHUOC.menu(trinhqlThuoc);
            }
            if (option == 6){
                trinhqlBenhNhan.Menu();
            }
            if (option == 7){
                trinhqlBacSi.thaoTac();;
            }

        } while (option != 0);
    }
}
