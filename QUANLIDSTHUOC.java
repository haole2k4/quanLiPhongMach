import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QUANLIDSTHUOC {
    Scanner quanliScanner = new Scanner(System.in);
    DANHSACHTHUOC ds;
    private File fileDataThuoc = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\dataThuoc.txt");
    String filePathDataThuoc = "D:\\phongMach_THUOC\\quanLiPhongMach\\dataThuoc.txt";

    QUANLIDSTHUOC() {
        this.ds = new DANHSACHTHUOC();
    }

    public void setDSTHUOC(DANHSACHTHUOC new_ds) {
        this.ds = new_ds;
    }



    // ---- LAM VIEC VOI FILE -----------
    public void xoaAllDataThuoc(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println("loi...");
        }
    }

    public void ghiLine(String fileName, String s) {
        // xoa data trong file tr
        File outFile = new File(fileName);
        PrintWriter write = null;
        try {
            write = new PrintWriter(new FileWriter(outFile, true));
        }

        catch (Exception e) {
            System.out.println("Khong the tao tap tin ket qua");

            return;
        }
        write.print(s);
        write.print("\n");
        write.close();
    }

    public void ghiFile() {
        xoaAllDataThuoc(filePathDataThuoc);
        for (int i = 0; i < this.ds.getSoLuongThuoc(); i++) {
            ghiLine(filePathDataThuoc, this.ds.getDataThuoc(i));
        }
    }
    // --------------- END PHAN LAM VIEC VOI FILE --------------











    public void menu() {
        int option = 0;
        try {
            this.ds.docData(fileDataThuoc);
        } catch (Exception e) {
            System.out.println("Khong doc duoc file");
        }

        do {
            System.out.println("Nhap 0 de thoat");
            System.out.println("Nhap 1 de them thuoc");
            System.out.println("Nhap 2 de xoa thuoc");
            System.out.println("Nhap 3 de sua");
            System.out.println("Nhap 4 de thong ke thuoc theo ten");
            System.out.println("Nhap 5 de in toan bo thuoc");
            System.out.println("Nhap 6 de tao don thuoc: ");
            System.out.print("Nhap lua chon: ");
            option = quanliScanner.nextInt();

            if (option == 0) {
                break;
            }

            if (option == 1) {
                System.out.print("Nhap loai thuoc can them (0 la thuoc chich, 1 la thuoc vi): ");
                int loaiThuocCanThem = quanliScanner.nextInt();
                if (loaiThuocCanThem == 0) {
                    THUOCCHICH tempThuocchich = new THUOCCHICH();
                    tempThuocchich.nhapThongTinThuoc();
                    this.ds.themThuoc(tempThuocchich);
                } else if (loaiThuocCanThem == 1) {
                    THUOCVI tempThuocvi = new THUOCVI();
                    tempThuocvi.nhapThongTinThuoc();
                    this.ds.themThuoc(tempThuocvi);
                }
            }

            if (option == 2) {
                System.out.print("Nhap vi tri thuoc can xoa: ");
                int index = quanliScanner.nextInt();
                this.ds.xoaThuoc(index);
                this.ghiFile();


            }

            if (option == 3) {
                this.ds.suaThongTin();
            }

            if (option == 4) {
                quanliScanner.nextLine();
                System.out.println("Nhap ten thuoc can tim: ");
                String tenThuocCanTim = quanliScanner.nextLine();
                ds.timThuocTheoTen(tenThuocCanTim);
            }

            if (option == 5) {
                ds.inDanhSachThuoc();
            }

            if (option == 6) {
                QUANLIDONTHUOC quanlidonthuoc = new QUANLIDONTHUOC(ds);
                quanlidonthuoc.menuDonThuoc();
            }

        } while (option != 0);
    }
}
