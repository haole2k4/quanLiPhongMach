import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DANHSACHPHIEUKHAMBENH {
    PHIEUKHAMBENH[] dsPhieuKham;
    int soPhieuKham;

    Scanner mayScanner = new Scanner(System.in);
    DANHSACHTHUOC dst = new DANHSACHTHUOC();
    DSBS dsbs = new DSBS();
    DSBN dsbn = new DSBN();

    DANHSACHPHIEUKHAMBENH() {
        this.dsPhieuKham = new PHIEUKHAMBENH[0];
        this.soPhieuKham = 0;
    }

    DANHSACHPHIEUKHAMBENH(PHIEUKHAMBENH[] dsPhieuKham, int soPhieuKham) {
        this.dsPhieuKham = dsPhieuKham;
        this.soPhieuKham = soPhieuKham;
    }

    DANHSACHPHIEUKHAMBENH(DANHSACHPHIEUKHAMBENH dspkb2) {
        this.dsPhieuKham = dspkb2.dsPhieuKham;
        this.soPhieuKham = dspkb2.soPhieuKham;
    }

    public PHIEUKHAMBENH[] getDsPhieuKham() {
        return this.dsPhieuKham;
    }

    public int getSoPhieuKham() {
        return this.soPhieuKham;
    }

    public void setSoPhieuKham(int soPhieu) {
        this.soPhieuKham = soPhieu;
    }

    public void setDanhSachPhieuKham(PHIEUKHAMBENH[] dspkb) {
        this.dsPhieuKham = dspkb;
    }

    public void getNeedData() {
        try {
            dst.docData("data/dataThuoc.txt");
            dsbs.docData("data/BacSi.txt");
            // dsbn.docData();
        } catch(IOException e) {
            System.out.println("Doc data can thiet that bai");
        }
    }

    public void themPhieuKhamBenh(PHIEUKHAMBENH newPhieukhambenh) {
        this.soPhieuKham += 1;
        this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, soPhieuKham);
        this.dsPhieuKham[soPhieuKham] = newPhieukhambenh;
    }

    public void themPhieuKhamBenh() {

    }

    public void xoaPhieuKhamBenh(int index) {
        if (index == this.soPhieuKham - 1) {
            this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, this.soPhieuKham - 1);
            this.soPhieuKham -= 1;
        } else {
            for (int i = index; i < this.soPhieuKham - 1; i++) {
                this.dsPhieuKham[i] = this.dsPhieuKham[i + 1];
            }
            this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, this.soPhieuKham - 1);
            this.soPhieuKham -= 1;
        }
    }

    public void inDanhSachPhieuKham() {
        System.out.println("\u001B[32m" + "-".repeat(50) + " DANH SACH PHIEU KHAM " + "-".repeat(50) + "\u001B[0m");
        System.out.format("\u001B[34m" + "|| %-10s | %-15s | %-15s | %-10s | %-10s | %-15s | %-10s ||\n" + "\u001B[0m",
                "MA Pk", "MA BAC SI", "MA BENH NHAN", "NGAY KHAM", "CHUAN DOAN", "NGAY TAI KHAM", "TIEM KHAM");
        for (int i = 0; i < this.soPhieuKham - 1; i++) {
            this.dsPhieuKham[i].inPhieuKham();
        }
        System.out.println("\u001B[32m" + "-".repeat(117) + "\u001B[0m");
    }

    
    public void docData(String filePath) throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner fileScanner = new Scanner(dataFile);
        while (fileScanner.hasNextLine()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String[] danhSachThuocTinh = fileScanner.nextLine().split(", ");
            String tempMaPhieuKham = danhSachThuocTinh[0];
            String tempMaBacSi = danhSachThuocTinh[1];
            String tempMaBenhNhan = danhSachThuocTinh[2];
            LocalDate tempNgayKham = LocalDate.parse(danhSachThuocTinh[3], formatter);
            String tempChuanDoan = danhSachThuocTinh[4];
            LocalDate tempNgayTaiKham = LocalDate.parse(danhSachThuocTinh[5], formatter);
            double tempTienKham = Double.parseDouble(danhSachThuocTinh[6]);
            PHIEUKHAMBENH newPhieuKhamBenh = new PHIEUKHAMBENH(tempMaPhieuKham, tempMaBacSi, tempMaBenhNhan, tempNgayKham, tempChuanDoan, tempNgayTaiKham, tempTienKham);
            this.themPhieuKhamBenh(newPhieuKhamBenh);
        }
        fileScanner.close();
    }

    public void ghiData(String filePath) throws IOException {
        File dataFile = new File(filePath);
        FileWriter writer = new FileWriter(dataFile);
        for (int i = 0; i < soPhieuKham; i++) {
            writer.write(getDataPhieuKham(i) + "\n");
        }
        writer.close();
    }

    public String getDataPhieuKham(int index) {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder dataPhieuKham = new StringBuilder();
        String ngayKham = this.dsPhieuKham[index].getNgayKham().format(dinhDangNgayThang);
        String ngayTaiKham = this.dsPhieuKham[index].getNgayTaiKham().format(dinhDangNgayThang);
        dataPhieuKham.append(this.dsPhieuKham[index].getMaPhieuKham()).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getMaBacSi()).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getMaBenhNhan()).append(", ");
        dataPhieuKham.append(ngayKham).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getChuanDoan()).append(", ");
        dataPhieuKham.append(ngayTaiKham).append(", ");
        dataPhieuKham.append(this.dsPhieuKham[index].getTienKham()).append(", ");
        return dataPhieuKham.toString();
    }


    public void menuThaoTac() {
        int option = 0;

        do {
            System.out.println("\t\tNhap 0 de thoat");
            System.out.println("\t\tNhap 1 de in toan bo hoa don");
            System.out.println("\t\tNhap ");
            System.out.print("\t\tVui long nhap lua chon cua ban: ");
            option = mayScanner.nextInt();

            while (option < 0 || option > 6) {
                System.out.print("\t\tLua chon nay khong ton tai, vui long nhap lai: ");
                option = mayScanner.nextInt();
            }

        } while(option != 0);
    }




}
