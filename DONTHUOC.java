
import java.util.Scanner;

class DONTHUOC {
    Scanner mayScanner = new Scanner(System.in);
    private THUOC[] dst;
    private String maPhongKham;
    private double tongTien;
    private String chuanDoan;
    private int soThuocBoc;

    // thieu 3 ham tao nua ...

    // 2 mang

    DONTHUOC(String maPhongKham, String chuanDoan) {
        this.dst = new THUOC[0];
        this.maPhongKham = maPhongKham;
        this.tongTien = 0;
        this.chuanDoan = chuanDoan;
        this.soThuocBoc = 0;
    }

    public void nhapThuocBoc(DANHSACHTHUOC dsThuocLon) {
        System.out.print("Nhap so loai thuoc can boc: ");
        int soThuocBoc = mayScanner.nextInt();
        mayScanner.nextLine();
        this.soThuocBoc = soThuocBoc;
        this.dst = new THUOC[this.soThuocBoc];
        
        for (int i  = 0; i < soThuocBoc; i++) {
            int num = 0;
            do {
                System.out.print("Nhap ma thuoc can boc: ");
                String maThuocCanBoc = mayScanner.nextLine();
                System.out.print("Nhap so luong can boc ra: ");
                num = mayScanner.nextInt();
                mayScanner.nextLine();
                THUOC tempThuoc = dsThuocLon.timThuocTheoMa(maThuocCanBoc);
                if(tempThuoc == null && num > dst[i].getSoLuong()) {
                    System.out.println("Nhap sai so lieu, vui long nhap lai");
                }
                else {
                    this.dst[i] = tempThuoc;
                    this.dst[i].setSoLuong(num);
                }
            }
            while (dst[i] == null && num > dst[i].getSoLuong());
        }
    }

    public void suaThuocBoc() {
        
    }

    public void xoaThuocBoc() {

    }

    public double getTongTienThuoc() {
        for (THUOC temp_thuoc : this.dst) {
            this.tongTien = this.tongTien + temp_thuoc.getGiaCa() * temp_thuoc.getSoLuong();
        }
        return this.tongTien;
    }

    public void inDonThuoc() {
        System.out.println("Ma phong kham: " + this.maPhongKham);
        System.out.println("Chuan doan: " + this.chuanDoan);

        for (THUOC temp_thuoc : this.dst) {
            temp_thuoc.inThongTinThuoc();
        }

        System.out.println("Tong tien: " + this.getTongTienThuoc());
    }

}
