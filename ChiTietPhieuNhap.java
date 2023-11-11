
import java.io.File;
import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String maCTPhieuNhap;
    THUOC[] dsThuocNhap;
    int soLoaiThuocNhap = 0;
    double thanhTien = 0;

    public ChiTietPhieuNhap() {
        maCTPhieuNhap = null;
        thanhTien = 0;
        soLoaiThuocNhap = 0;
        dsThuocNhap = new THUOC[0];
        thanhTien = 0;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        maCTPhieuNhap = ctpn.maCTPhieuNhap;
        dsThuocNhap = ctpn.dsThuocNhap;
        soLoaiThuocNhap = ctpn.soLoaiThuocNhap;
        thanhTien = ctpn.thanhTien;

    }

    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma phieu nhap: ");
        maCTPhieuNhap = input.nextLine();
        System.out.print("So loai thuoc nhap: ");
        soLoaiThuocNhap = input.nextInt();
        dsThuocNhap = new THUOC[soLoaiThuocNhap];
        input.nextLine();
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            System.out.print("Nhap loai thuoc(0 la thuoc chich, 1 la thuoc vi): ");
            int typeThuoc = input.nextInt();
            if (typeThuoc == 0) {
                dsThuocNhap[i] = new THUOCCHICH();

            } else if (typeThuoc == 1) {
                dsThuocNhap[i] = new THUOCVI();
            }
            input.nextLine();
            System.out.print("Ma thuoc: ");
            String maThuoc = input.nextLine();
            // doc data thuoc de check xem thuoc co ton tai hay khong ?
            File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\dataThuoc.txt");
            Scanner read = null;
            try {
                read = new Scanner(file);

            } catch (Exception e) {
                System.out.println("Loi doc file!");
                return;
            }
            boolean flag = false;

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String arr[] = line.split(",");
                if (arr[0].trim().equals(maThuoc)) {
                    flag = true;
                }
            }

            if (!flag) {
                System.out.println("Thuoc khong ton tai!");
                System.out.println("1. Nhap lai!");
                System.out.println("2. Nhap thong tin thuoc moi");
                System.out.println("Lua chon: ");
                int chon = input.nextInt();
                input.nextLine();
                if (chon == 2) {
                    // nhap thong tin thuoc
                    System.out.print("Nhap loai thuoc can them (0 la thuoc chich, 1 la thuoc vi): ");
                    int loaiThuocCanThem = input.nextInt();
                    QUANLIDSTHUOC ql = new QUANLIDSTHUOC();
                    input.nextLine();
                    if (loaiThuocCanThem == 0) {
                        THUOCCHICH tempThuocchich = new THUOCCHICH();
                        tempThuocchich.nhapThongTinThuoc();
                        DANHSACHTHUOC dst = new DANHSACHTHUOC();
                        dst.themThuoc(tempThuocchich);
                        dst.ghiLine(dst.getDataThuoc(0));
                    } else if (loaiThuocCanThem == 1) {
                        THUOCVI tempThuocvi = new THUOCVI();
                        tempThuocvi.nhapThongTinThuoc();
                        DANHSACHTHUOC dst = new DANHSACHTHUOC();
                        dst.themThuoc(tempThuocvi);
                        dst.ghiLine(dst.getDataThuoc(0));
                    }
                    System.out.println("De tao thong tin thuoc thanh cong. Hay tiep tuc!");
                } else if (chon == 1) {
                    nhap();
                }
                else nhap();

            }   
                dsThuocNhap[i].setMaThuoc(maThuoc);
                System.out.print("So luong :");
                int soLuong = input.nextInt();
                dsThuocNhap[i].setSoLuong(soLuong);
                
                {
                    DANHSACHTHUOC ql = new DANHSACHTHUOC();
                    ql.themSoLuongChoThuoc(maThuoc, soLuong);
                }
                System.out.print("Gia nhap hang / 1 : ");
                double giaCa = input.nextDouble();
                thanhTien = thanhTien + giaCa * soLuong;
                dsThuocNhap[i].setGiaCa(giaCa);
                read.close();
            }
        }


    public void xuatThuocDaNhap() {
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            System.out.println(1 + ": " + dsThuocNhap[i].getMaThuoc() + "        " + dsThuocNhap[i].getSoLuong()
                    + "         " + dsThuocNhap[i].getGiaCa());
        }
    }

    public void xuat() {
        System.out.println("====  Chi tiet phieu nhap ====");
        System.out.println("ma : " + maCTPhieuNhap);
        System.out.println("so loai: " + soLoaiThuocNhap);
        System.out.println("---- CHI TIET ----");
        xuatThuocDaNhap();
        System.out.println("Tong tien : " + thanhTien);
        System.out.println();

    }

    public void xoa() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet phieu nhap can xoa:");
        String ma = input.nextLine();
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            if (dsThuocNhap[i].getMaThuoc().equals(ma)) {
                for (int j = i; j < soLoaiThuocNhap - 1; j++) {
                    dsThuocNhap[i] = dsThuocNhap[i + 1];
                }
            }
        }
        soLoaiThuocNhap--;
    }

    // GET
    public int getSoLoaiThuocNhap() {
        return soLoaiThuocNhap;
    }

    public String getMaCTPhieuNhap() {
        return maCTPhieuNhap;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public THUOC[] getDanhSachThuocNhap() {
        return dsThuocNhap;
    }

    public String getChuoiThuocNhap() // ham de viet vao file
    {
        String line = maCTPhieuNhap + "," + String.valueOf(soLoaiThuocNhap);
        for (int i = 0; i < soLoaiThuocNhap; i++) {
            line = line + "," + dsThuocNhap[i].getMaThuoc() + "," + dsThuocNhap[i].getSoLuong() + ","
                    + dsThuocNhap[i].getGiaCa();
        }
        line = line + "," + thanhTien;
        return line;
    }

    // SET
    public void setSoLoaiThuocNhap(int sl) {
        soLoaiThuocNhap = sl;
    }

    public void setMaCTPhieuNhap(String data) {
        maCTPhieuNhap = data;
    }

    public void setDanhSachThuocNhap(THUOC[] data) {
        dsThuocNhap = data;
    }

    public void setThanhTien(Double tt) {
        thanhTien = tt;
    }

    public static void main(String[] args) {
        ChiTietPhieuNhap ql = new ChiTietPhieuNhap();
        ql.nhap();
    }
}