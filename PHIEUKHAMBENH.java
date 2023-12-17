import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PHIEUKHAMBENH { // phieu kham chi thay doi chuan doan ngay tai kham va tien kham
    Scanner mayScanner = new Scanner(System.in);

    private String maPhieuKham;
    private String maBacSi;
    private String maBenhNhan;
    private LocalDate ngayKham; // lay ngay hien tai
    private String chuanDoan;
    private LocalDate ngayTaiKham;
    private double tienKham;


    // thieu 3 ham tao nua ....
    


    PHIEUKHAMBENH(String maPhieuKham, String maBacSi, String maBenhNhan, LocalDate ngayKham, String chuanDoan, LocalDate ngayTaiKham, double tienKham) {

        this.maPhieuKham = maPhieuKham;
        this.maBacSi = maBacSi;
        this.maBenhNhan = maBenhNhan;
        this.ngayKham = ngayKham;
        this.chuanDoan = chuanDoan;
        this.ngayTaiKham = ngayTaiKham;
        this.tienKham = tienKham;
    }

  

    public String getMaPhieuKham() {
        return this.maPhieuKham;
    }

    public String getMaBacSi() {
        return this.maBacSi;
    }

    public String getMaBenhNhan() {
        return this.maBenhNhan;
    }

    public LocalDate getNgayKham() {
        return this.ngayKham;
    }

    public String getChuanDoan() {
        return this.chuanDoan;
    }

    public LocalDate getNgayTaiKham() {
        return this.ngayTaiKham;
    }

    public double getTienKham() {
        return this.tienKham;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public void setNgayTaiKham(LocalDate ngayTaiKham) {
        this.ngayTaiKham = ngayTaiKham;
    }

    public void setTienKham(double tienKham) {
        this.tienKham = tienKham;
    }

    // public void nhapPhieuKhamBenh() {
    //     System.out.print("Nhap ngay tai kham: ");
    //     String ngayTaiKham = mayScanner.nextLine();
    //     System.out.print("Nhap tien kham: ");
    //     double tienKham = mayScanner.nextDouble();
    //     this.ngayTaiKham = LocalDate.parse(ngayTaiKham);
    //     this.tienKham = tienKham;
    // }

    public void inPhieuKham() {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngayTaiKham = this.ngayTaiKham.format(dinhDangNgayThang);
        String ngayKham = this.ngayKham.format(dinhDangNgayThang);
        System.out.format("\u001B[34m" + "|| %-10s | %-15s | %-15s | %-10s | %-10s | %-15s | %-10s ||\n" + "\u001B[0m",  this.maPhieuKham, this.maBacSi, this.maBenhNhan, ngayKham, this.chuanDoan, ngayTaiKham, this.tienKham);
    }

}


