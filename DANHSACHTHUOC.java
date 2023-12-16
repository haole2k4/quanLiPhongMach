import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DANHSACHTHUOC implements arrayInterfaceTHUOC {
    Scanner mayScanner = new Scanner(System.in);
    private THUOC[] dsThuoc;
    private int soLuongThuoc;

    DANHSACHTHUOC() {
        this.dsThuoc = new THUOC[0];
        this.soLuongThuoc = 0;
    }

    DANHSACHTHUOC(THUOC[] dsThuoc, int soLuongThuoc) {
        this.dsThuoc = dsThuoc;
        this.soLuongThuoc = soLuongThuoc;
    }

    DANHSACHTHUOC(DANHSACHTHUOC newDsThuoc) {
        this.dsThuoc = newDsThuoc.dsThuoc;
        this.soLuongThuoc = newDsThuoc.soLuongThuoc;
    }

    public THUOC[] getDsThuoc() {
        return this.dsThuoc;
    }

    public int getSoLuongThuoc() {
        return this.soLuongThuoc;
    }

    public void setSoLuongThuoc(int soLuongThuoc) {
        this.soLuongThuoc = soLuongThuoc;
    }

    public int[] getSoThuocTungLoai() {
        int[] thuocTungLoai = new int[2];
        Arrays.fill(thuocTungLoai, 0);
        // thuoc chich la 0
        // thuoc vi la 1
        for (THUOC i : this.dsThuoc) {
            if (i instanceof THUOCCHICH)
                thuocTungLoai[0] += 1;
            else if (i instanceof THUOCVI)
                thuocTungLoai[1] += 1;
        }
        return thuocTungLoai;
    }

    public void nhapThuoc(int soThuocCanNhap) {
        for (int i = 0; i < soThuocCanNhap; i++) {
            int typeThuoc;
            do {
                System.out.print("Nhap loai thuoc(0 la thuoc chich, 1 la thuoc vi): ");
                typeThuoc = mayScanner.nextInt();
                if (typeThuoc == 0) {
                    this.dsThuoc[i] = new THUOCCHICH();
                    this.dsThuoc[i].nhapThongTinThuoc();
                } else if (typeThuoc == 1) {
                    this.dsThuoc[i] = new THUOCVI();
                    this.dsThuoc[i].nhapThongTinThuoc();
                }
            }

            while (typeThuoc < 0 && typeThuoc > 1);

        }
    }

    public void themThuoc(THUOC newThuoc) {
        this.soLuongThuoc += 1;
        this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc);
        this.dsThuoc[soLuongThuoc - 1] = newThuoc;
    }

    public void xoaThuoc(int index) {
        if (index == this.soLuongThuoc - 1) {
            this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc - 1);
            this.soLuongThuoc -= 1;
        } else {
            for (int i = index; i < this.soLuongThuoc - 1; i++)
                this.dsThuoc[i] = this.dsThuoc[i + 1];
            this.dsThuoc = Arrays.copyOf(this.dsThuoc, this.soLuongThuoc - 1);
            this.soLuongThuoc -= 1;
        }
    }

    public void suaThongTin() {
        System.out.println("Nhap ma thuoc can sua: ");
        String maThuocCanSua = mayScanner.nextLine();
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (maThuocCanSua.equals(this.dsThuoc[i].getMaThuoc()))
                this.dsThuoc[i].suaThongTinThuoc();
        }
    }

    public void inDanhSachThuoc() {
        int[] thuocTungLoai = this.getSoThuocTungLoai();
        System.out.println("So thuoc chich: " + thuocTungLoai[0]);
        System.out.println("So thuoc vi: " + thuocTungLoai[1]);
        System.out.println("Tong so thuoc: " + this.soLuongThuoc);
        // System.out.println("-".repeat(50) + " DANH SACH THUOC " + "-".repeat(50));
        System.out.println("\u001B[32m" + "-".repeat(50) + " DANH SACH THUOC " + "-".repeat(50) + "\u001B[0m");

        // System.out.format("|| %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s
        // ||\n", "MA THUOC", "MA NHA SAN XUAT",
        // "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD", "GIA CA");
        System.out.format("\u001B[34m" + "|| %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n" + "\u001B[0m",
                "MA THUOC", "MA NHA SAN XUAT",
                "TEN THUOC", "SO LUONG", "NGAY SX", "HAN SD", "GIA CA");

        for (int i = 0; i < this.soLuongThuoc; i++) {
            this.dsThuoc[i].inThongTinThuoc();
        }
        System.out.println("\u001B[32m" + "-".repeat(117) + "\u001B[0m");
    }

    public void timThuocTheoTen(String tenThuocCanTim) {
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getTenThuoc().equals(tenThuocCanTim))
                dsThuoc[i].inThongTinThuoc();
        }
    }

    // ----------- START XU LI THEO MA THOC ---------
    public THUOC timThuocTheoMa(String maThuocCanTim) {
        int index = 0;
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getMaThuoc().equalsIgnoreCase(maThuocCanTim))
                index = i;
        }
        if (this.dsThuoc[index] instanceof THUOCCHICH) {
            THUOCCHICH thuocchich = new THUOCCHICH();
            thuocchich = (THUOCCHICH) this.dsThuoc[index];
            return thuocchich;
        }
        THUOCVI thuocvi = new THUOCVI();
        thuocvi = (THUOCVI) this.dsThuoc[index];
        return thuocvi;
    }

    public void inThuocTheoMa(String maThuocCanTim) {
        for (THUOC tempThuoc : this.dsThuoc) {
            if (tempThuoc.getMaThuoc().equals(maThuocCanTim)) {
                tempThuoc.inThongTinThuoc();
            }
        }
    }
    // ----------- END XU LI THEO MA THUOC -------------

    // ------ START XU LI THUOC THEO MA NHA SAN XUAT ----------
    public int[] thongKeThuocCungMaNSX(String maNSX) {
        int[] index = new int[0];
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getMaNhaSanXuat().equalsIgnoreCase(maNSX)) {
                index = Arrays.copyOf(index, index.length + 1);
                index[index.length - 1] = i;
            }
        }
        return index;
    }

    public void inThuocCungMaMSX(String maNSX) {
        for (int i = 0; i < this.soLuongThuoc; i++) {
            if (this.dsThuoc[i].getMaNhaSanXuat().equalsIgnoreCase(maNSX)) {
                this.dsThuoc[i].inThongTinThuoc();
            }
        }
    }
    // ---------- END XU LI THUOC THEO MA NHA SAN XUAT ----------

    public THUOC[] checkThuocHetHanSuDungChua() {
        THUOC[] outOfDateTHUOC = new THUOC[0];
        LocalDate today = LocalDate.now();
        for (int i = 0; i < this.dsThuoc.length; i++) {
            if (!this.dsThuoc[i].getHanSuDung().isEqual(today) && this.dsThuoc[i].getHanSuDung().isBefore(today)) {
                outOfDateTHUOC = Arrays.copyOf(outOfDateTHUOC, outOfDateTHUOC.length + 1);
                outOfDateTHUOC[outOfDateTHUOC.length - 1] = this.dsThuoc[i];
            }
        }
        return outOfDateTHUOC;
    }








    // DOC DATA CUA FILE ROI GHI VAO MANG
    public void docData(String filePath) throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner fileScanner = new Scanner(dataFile);
        while (fileScanner.hasNextLine()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String[] danhSachThuocTinh = fileScanner.nextLine().split(", ");
            String tempMaThuoc = danhSachThuocTinh[0];
            String tempMaNhaSanXuat = danhSachThuocTinh[1];
            String tempTenThuoc = danhSachThuocTinh[2];
            int tempSoLuong = Integer.parseInt(danhSachThuocTinh[3]);
            LocalDate tempNgaySanXuat = LocalDate.parse(danhSachThuocTinh[4], formatter);
            LocalDate tempHanSuDung = LocalDate.parse(danhSachThuocTinh[5], formatter);
            double tempGiaCa = Double.parseDouble(danhSachThuocTinh[6]);
            if (danhSachThuocTinh.length == 8) {
                int tempDungTichThuoc = Integer.parseInt(danhSachThuocTinh[7]);
                THUOCCHICH newThuocChich = new THUOCCHICH(tempMaThuoc, tempMaNhaSanXuat, tempTenThuoc, tempSoLuong,
                        tempNgaySanXuat, tempHanSuDung, tempGiaCa, tempDungTichThuoc);
                this.themThuoc(newThuocChich);
            }
            if (danhSachThuocTinh.length == 9) {
                int tempSoLuongVi = Integer.parseInt(danhSachThuocTinh[7]);
                int tempSoThuocMoiVi = Integer.parseInt(danhSachThuocTinh[8]);
                THUOCVI newThuocVi = new THUOCVI(tempMaThuoc, tempMaNhaSanXuat, tempTenThuoc, tempSoLuong,
                        tempNgaySanXuat, tempHanSuDung, tempGiaCa, tempSoLuongVi, tempSoThuocMoiVi);
                this.themThuoc(newThuocVi);
            }
        }
        fileScanner.close();
    }

    public void ghiData(String filePath) throws IOException {
        File dataFile = new File(filePath);
        FileWriter writer = new FileWriter(dataFile);
        for (int i = 0; i < soLuongThuoc; i++) {
            writer.write(getDataThuoc(i) + "\n");
        }
        writer.close();
    }

    // TRA VE DATA CUA CLASS VAO 1 STRING ROI GHI LEN FILE THEO DONG
    public String getDataThuoc(int index) {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder dataThuoc = new StringBuilder();
        String ngaySanXuat = this.dsThuoc[index].getNgaySanXuat().format(dinhDangNgayThang);
        String hanSuDung = this.dsThuoc[index].getHanSuDung().format(dinhDangNgayThang);
        if (this.dsThuoc[index] instanceof THUOCCHICH) {
            THUOCCHICH tempThuocChich = (THUOCCHICH) this.dsThuoc[index];
            dataThuoc.append(this.dsThuoc[index].getMaThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getMaNhaSanXuat()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getTenThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getSoLuong()).append(", ");
            dataThuoc.append(ngaySanXuat).append(", ");
            dataThuoc.append(hanSuDung).append(", ");
            dataThuoc.append(this.dsThuoc[index].getGiaCa()).append(", ");
            dataThuoc.append(tempThuocChich.getDungTichThuoc());
        }
        if (this.dsThuoc[index] instanceof THUOCVI) {
            THUOCVI tempThuocVi = (THUOCVI) this.dsThuoc[index];
            dataThuoc.append(this.dsThuoc[index].getMaThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getMaNhaSanXuat()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getTenThuoc()).append(", ");
            dataThuoc.append(this.dsThuoc[index].getSoLuong()).append(", ");
            dataThuoc.append(ngaySanXuat).append(", ");
            dataThuoc.append(hanSuDung).append(", ");
            dataThuoc.append(this.dsThuoc[index].getGiaCa()).append(", ");
            dataThuoc.append(tempThuocVi.getSoLuongVi()).append(", ");
            dataThuoc.append(tempThuocVi.getSoThuocMoiVi());
        }
        return dataThuoc.toString();
    }

    public void menuThaoTac() {
        int option = 0;

        do {
            System.out.println("\t\tNhap 0 de thoat");
            System.out.println("\t\tNhap 1 de them thuoc");
            System.out.println("\t\tNhap 2 de xoa thuoc");
            System.out.println("\t\tNhap 3 de sua thuoc ?????");
            System.out.println("\t\tNhap 4 de thong ke thuoc");
            System.out.println("\t\tNhap 5 de in danh sach thuoc ra");
            System.out.println("\t\tNhap 6 de thoat khoi quan li thuoc");
            System.out.print("\t\tVui long nhap lua chon cua ban: ");
            option = mayScanner.nextInt();

            while (option < 0 || option > 6) {
                System.out.print("\t\tLua chon nay khong ton tai, vui long nhap lai: ");
                option = mayScanner.nextInt();
            }

            if (option == 0) {
                break;
            }

            if (option == 1) {
                System.out.print("\t\t\tNhap loai thuoc can them (0 la thuoc chich, 1 la thuoc vi): ");
                int loaiThuocCanThem = mayScanner.nextInt();
                if (loaiThuocCanThem == 0) {
                    THUOCCHICH tempThuocchich = new THUOCCHICH();
                    tempThuocchich.nhapThongTinThuoc();
                    this.themThuoc(tempThuocchich);
                    // this.ghiFile();
                } else if (loaiThuocCanThem == 1) {
                    THUOCVI tempThuocvi = new THUOCVI();
                    tempThuocvi.nhapThongTinThuoc();
                    this.themThuoc(tempThuocvi);
                    // this.ghiFile();
                }
            }

            if (option == 2) {
                int index = 0;
                boolean isSuccess = false;
                System.out.println("\t\t\t\t\tNhap ma thuoc can xoa: ");
                String maThuocCanXoa = mayScanner.nextLine();
                for (int i = 0; i < this.dsThuoc.length; i++) {
                    if (this.dsThuoc[i].getMaThuoc().indexOf(maThuocCanXoa) != -1) { // da tim thay
                        isSuccess = true;
                        index = i;
                        break;
                    }
                }
                if (isSuccess) {
                    this.xoaThuoc(index);
                    System.out.println("Da xoa thanh cong!\n");
                } else {
                    System.out.println("Xoa that bai do khong tim thay ma thuoc yeu cau\n");
                }
            }

            if (option == 3) {

            }

            if(option == 4) {

            }

            if(option == 5) {
                this.inDanhSachThuoc();
            }

            if(option == 6) {
                break;
            }

        } while (option != 0);
    }






















    public void themSoLuongChoThuoc(String ma, int soLuong) {
        // doc data thuoc de lam vien tren array va sau khi sua so luong thanh cong thi
        // ghi lai vao file !
        File file = new File("data/dataThuoc.txt");
        // File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\dataThuoc.txt");
        try {
            docData("data/dataThuoc.txt");
        } catch (Exception e) {
            System.out.println("Loi!");
            return;
        }

        for (int i = 0; i < soLuongThuoc; i++) {
            if (dsThuoc[i].getMaThuoc().trim().equals(ma)) {
                dsThuoc[i].setSoLuong(soLuong + dsThuoc[i].getSoLuong());
            }
        }

        PrintWriter write = null;
        try {
            write = new PrintWriter(file);
        } catch (Exception e) {
            System.out.println("Loi !");
            return;
        }
        for (int i = 0; i < soLuongThuoc; i++) {
            write.println(getDataThuoc(i));
        }
        write.close();

    }











    // ham ghi line vao cuoi dong
    public void ghiLine(String s) {
        File file = new File("data/dataThuoc.txt");
        PrintWriter write = null;
        try {
            write = new PrintWriter(new FileWriter(file, true));
        } catch (Exception e) {
            System.out.println("Loi !");
            return;
        }
        write.println(s);
        write.close();
    }
}
