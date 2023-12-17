import java.util.Scanner;

public class NHASANXUAT {
    private String ma;
    private String tenNhaSanXuat;

    public NHASANXUAT() {
        ma = null;
        tenNhaSanXuat = null;
    }

    public NHASANXUAT(String ma, String tenNhaSanXuat) {
        this.ma = ma;
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public NHASANXUAT(NHASANXUAT nsx) {
        ma = nsx.ma;
        tenNhaSanXuat = nsx.tenNhaSanXuat;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma NSX: ");
        ma = scanner.nextLine();
        System.out.print("Nhap ten NSX: ");
        tenNhaSanXuat = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("Ma NSX: " + ma);
        System.out.println("Ten NSX: " + tenNhaSanXuat);
    }
}