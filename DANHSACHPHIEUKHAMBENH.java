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
    public PHIEUKHAMBENH getPhieuKhamBenh(String ma){
        for (int i=0;i<soPhieuKham;i++){
            if (dsPhieuKham[i].getMaPhieuKham().equals(ma))
        return dsPhieuKham[i];
    
        }
        return null;
        
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

    public void getNeedData(String filePathThuoc, String filePathBacSi, String filePathBenhNhan) {
        try {
            dst.docData(filePathThuoc);
            dsbs.docData(filePathBacSi);
            // dsbn.docData();
        } catch (IOException e) {
            System.out.println("Doc data can thiet that bai");
        }
    }
    public int timKiemTheoMa(String ma){
        for (int i=0;i<soPhieuKham;i++){
            if (ma.equals(dsPhieuKham[i].getMaPhieuKham())){
                return 1;
            }
        }
        return 0;
    }

    public boolean checkValidDate(LocalDate ngayKham, LocalDate ngayTaiKham) {
        boolean isValid = true;
        if (ngayKham.isEqual(ngayTaiKham) && ngayKham.isBefore(ngayTaiKham))
            isValid = true;
        return isValid;
    }

    public void themPhieuKhamBenh(PHIEUKHAMBENH newPhieukhambenh) {
        this.soPhieuKham += 1;
        this.dsPhieuKham = Arrays.copyOf(this.dsPhieuKham, soPhieuKham);
        this.dsPhieuKham[soPhieuKham] = newPhieukhambenh;
    }

    public void taoPhieuKhamBenh() { // them vào cuối index
        String maPhieuKham;
        String maBacSi;
        String maBenhNhan;
        String tempNgayTaiKham;

        do {
            System.out.print("Nhap ma phieu kham: ");
            maPhieuKham = mayScanner.nextLine();
        } while (timMaPhieuKham(maPhieuKham) == -1);


        do {
            System.out.print("Nhap ma bac si: ");
            maBacSi = mayScanner.nextLine();
        }while();
        
        do {
             System.out.print("Nhap ma benh nhan: ");
            maBenhNhan = mayScanner.nextLine();
        }while();
       

        LocalDate ngayKham = LocalDate.now();

        System.out.print("Nhap chuan doan: ");
        String chuanDoan = mayScanner.nextLine();

        do {
            System.out.print("Nhap ngay tai kham(yyyy--MM-dd): ");
            tempNgayTaiKham = mayScanner.nextLine();
        } while(checkValidDate(ngayKham, LocalDate.parse(tempNgayTaiKham)));
        
        LocalDate ngayTaiKham = LocalDate.parse(tempNgayTaiKham);

        System.out.print("Nhap tien kham: ");
        double tienKham = mayScanner.nextDouble();

        PHIEUKHAMBENH newPhieuKham = new PHIEUKHAMBENH(maPhieuKham, maBacSi, maBenhNhan, ngayKham, chuanDoan,
                ngayTaiKham, tienKham);

        this.themPhieuKhamBenh(newPhieuKham);
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

    public int timMaPhieuKham(String findedMaPhieuKham) {
        int index = -1;
        for (int i = 0; i < this.soPhieuKham; i++) {
            if (this.dsPhieuKham[i].getMaPhieuKham().equals(findedMaPhieuKham))
                index = i;
        }
        return index;
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
            PHIEUKHAMBENH newPhieuKhamBenh = new PHIEUKHAMBENH(tempMaPhieuKham, tempMaBacSi, tempMaBenhNhan,
                    tempNgayKham, tempChuanDoan, tempNgayTaiKham, tempTienKham);
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
            System.out.println("\t\tNhap 2 de nhap them mot phieu kham benh");
            System.out.print("\t\tVui long nhap lua chon cua ban: ");
            option = mayScanner.nextInt();

            while (option < 0 || option > 6) {
                System.out.print("\t\tLua chon nay khong ton tai, vui long nhap lai: ");
                option = mayScanner.nextInt();
            }

            if(option == 0) {
                break;
            }

            if(option == 1) {
                this.inDanhSachPhieuKham();
            }

            if(option == 2) {
                this.taoPhieuKhamBenh();
            }

        } while (option != 0);
    }



    public void findOption() {
        int find_option = 0; 
        
        do {
            System.out.println("\t\tNhap 0 de thoat");
            System.out.println("Nhap 1 de tim kiem theo ma phieu");
            System.out.println("nhap 2 de tim kiem phieu kham theo ngay");
            System.out.print("\t\tVui long nhap lua chon cua ban: ");
            find_option = mayScanner.nextInt();

            while(find_option < 0 || find_option > 6) {
                System.out.println("Ban nhap khong dung gia tri, vui long nhap lai: ");
                find_option = mayScanner.nextInt();
            }

            if(find_option == 0) {
                break;
            }

            if(find_option == 1) {
                mayScanner.nextInt();
                System.out.println("Nhap ma phieu can tim kiem: ");
                String maPhieuKhamCanTim = mayScanner.nextLine();
                if(timMaPhieuKham(maPhieuKhamCanTim) == -1) {
                    System.out.println("Khong tim thay ma phieu kham can tim");
                }
                else {
                    this.dsPhieuKham[timMaPhieuKham(maPhieuKhamCanTim)].inPhieuKham();
                }
            }

            if(find_option == 2) {

            }



        }while(find_option != 0);
    }

}
