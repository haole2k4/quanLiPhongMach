import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
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
        for (int i = 0; i < this.soLuongThuoc; i++) {
            this.dsThuoc[i].inThongTinThuoc();
        }
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
        for(int i = 0; i < this.dsThuoc.length; i++ ) {
            // xu li ngay o day
        }
        return outOfDateTHUOC;
    }

    // DOC DATA CUA FILE ROI GHI VAO MANG
    public void docData(File dataFile) throws FileNotFoundException {
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

}
