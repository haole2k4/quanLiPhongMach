import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class THUOCCHICH extends THUOC {
    private int dungTichThuoc;

    THUOCCHICH() {
        super();
        this.dungTichThuoc = 0;
    }

    THUOCCHICH(String maThuoc, String maNhaSanXuat, String tenThuoc, int soLuong, LocalDate ngaySanXuat,
            LocalDate hanSuDung, double giaCa, int dungTichThuoc) {

        super(maThuoc, maNhaSanXuat, tenThuoc, soLuong, ngaySanXuat, hanSuDung, giaCa);
        this.dungTichThuoc = dungTichThuoc;
    }

    THUOCCHICH(THUOCCHICH newThuocChich) {
        super((THUOC) newThuocChich);
        this.dungTichThuoc = newThuocChich.dungTichThuoc;
        System.out.println("--------------------------------");
    }

    public int getDungTichThuoc() {
        return this.dungTichThuoc;
    }

    public void setDungTichThuoc(int newDungTichThuoc) {
        this.dungTichThuoc = newDungTichThuoc;
    }

    public void suaThongTinThuoc() {
        System.out.println("Nhap ten thuoc tinh thuoc can sua: ");
        int newThuocTinhCanSua = mayScanner.nextInt();

        switch (newThuocTinhCanSua) {
            case 1:
                System.out.print("Nhap ma thuoc: ");
                String newMaThuoc = mayScanner.nextLine();
                this.setMaThuoc(newMaThuoc);
                break;
            case 2:
                System.out.print("Nhap nha san xuat: ");
                String newMaNhaSanXuat = mayScanner.nextLine();
                this.setMaNhaSanXuat(newMaNhaSanXuat);
                break;
            case 3:
                System.out.print("Nhap ten thuoc: ");
                String newTenThuoc = mayScanner.nextLine();
                this.setTenThuoc(newTenThuoc);
                break;
            case 4:
                System.out.print("Nhap so luong thuoc: ");
                int newSoLuong = mayScanner.nextInt();
                this.setSoLuong(newSoLuong);
                break;
            case 5:
                System.out.print("Nhap ngay san xuat thuoc: ");
                String newNgaySanXuat = mayScanner.nextLine();
                this.setNgaySanXuat(LocalDate.parse(newNgaySanXuat));
                break;
            case 6:
                System.out.print("Nhap han su dung thuoc: ");
                String newHanSuDung = mayScanner.nextLine();
                this.setHanSuDung(LocalDate.parse(newHanSuDung));
                break;
            case 7:
                System.out.print("Nhap gia ca thuoc: ");
                double newGiaCa = mayScanner.nextDouble();
                this.setGiaCa(newGiaCa);
                break;
            case 8:
                System.out.print("Nhap dung tich thuoc: ");
                int newDungTichThuoc = mayScanner.nextInt();
                this.dungTichThuoc = newDungTichThuoc;
                break;
            default:
                System.out.println("Khong ton tai thuoc tinh can sua");
                break;
        }
    }

    public void inThongTinThuoc() {
        DateTimeFormatter dinhDangNgayThang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngaySanXuat = this.getNgaySanXuat().format(dinhDangNgayThang);
        String hanSuDung = this.getHanSuDung().format(dinhDangNgayThang);
        // System.out.println(
        //         this.getMaThuoc() + " " + this.getMaNhaSanXuat() + " " + this.getTenThuoc() + " " + this.getSoLuong()
        //                 + " " + ngaySanXuat + " " + hanSuDung + " " + this.dungTichThuoc);
        System.out.format("|| %-10s | %-15s | %-25s | %-8s | %-10s | %-10s | %-14s ||\n", this.getMaThuoc(), this.getMaNhaSanXuat(), this.getTenThuoc(), this.getSoLuong(), ngaySanXuat, hanSuDung, this.getGiaCa());
    }

    public void nhapThongTinThuoc() {
        super.nhapThongTinThuoc();
        mayScanner.nextLine();
        System.out.print("Nhap dung tich thuoc: ");
        int newDungTichThuoc = mayScanner.nextInt();
        this.dungTichThuoc = newDungTichThuoc;
    }

}
