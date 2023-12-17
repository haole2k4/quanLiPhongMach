import java.util.Scanner;
import java.time.LocalDate;
public class HOADON {
    
    private String maHoaDon;
    private String maDonThuoc;
    private String maPhieuKhamBenh;
    private double tongTien;
    private LocalDate ngayTao;
    private String hinhThucThanhToan;
    private String NVThuNgan;

    private DANHSACHDONTHUOC donThuoc;
    private DANHSACHPHIEUKHAMBENH phieuKhamBenh;
    private DANHSACHNHANVIEN dsnv;
    private DSBN dsbn;
    private DSBS dsbs;

    private String tenBS,sdtBS,tenBN,ngaysinhBN,tenNV;
   
    // Getter methods
    public String getThongTin(){
        String s=maHoaDon+","+maDonThuoc+","+maPhieuKhamBenh+","+NVThuNgan+","+ngayTao+","+hinhThucThanhToan+","+tongTien;
        return s;
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getMaDonThuoc() {
        return maDonThuoc;
    }

    public String getMaPhieuKhamBenh() {
        return maPhieuKhamBenh;
    }

    public double getTongTien() {
        return tongTien;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public String getNVThuNgan() {
        return NVThuNgan;
    }

    // Setter methods
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaDonThuoc(String maDonThuoc) {
        this.maDonThuoc = maDonThuoc;
    }

    public void setMaPhieuKhamBenh(String maPhieuKhamBenh) {
        this.maPhieuKhamBenh = maPhieuKhamBenh;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public void setNVThuNgan(String NVThuNgan) {
        this.NVThuNgan = NVThuNgan;
    }
    // 3 ham khoi tao
    public HOADON() {
        maHoaDon = null;
        maDonThuoc = null;
        maPhieuKhamBenh = null;
        tongTien = 0.0;
        ngayTao = null;
        hinhThucThanhToan = null;
        NVThuNgan = null;

        donThuoc = new DANHSACHDONTHUOC();
        phieuKhamBenh = new DANHSACHPHIEUKHAMBENH();
        dsnv = new DANHSACHNHANVIEN();
        dsbn = new DSBN();
        dsbs = new DSBS();
    }

    public HOADON(String maHoaDon, String maDonThuoc, String maPhieuKhamBenh, double tongTien, LocalDate ngayTao, String hinhThucThanhToan, String NVThuNgan) {
        this.maHoaDon = maHoaDon;
        this.maDonThuoc = maDonThuoc;
        this.maPhieuKhamBenh = maPhieuKhamBenh;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.NVThuNgan = NVThuNgan;

        donThuoc = new DANHSACHDONTHUOC();
        phieuKhamBenh = new DANHSACHPHIEUKHAMBENH();
        dsnv = new DANHSACHNHANVIEN();
        dsbn = new DSBN();
        dsbs = new DSBS();
    }

    public HOADON(HOADON hd) {
        maHoaDon = hd.maHoaDon;
        maDonThuoc = hd.maDonThuoc;
        maPhieuKhamBenh = hd.maPhieuKhamBenh;
        tongTien = hd.tongTien;
        ngayTao = hd.ngayTao;
        hinhThucThanhToan = hd.hinhThucThanhToan;
        NVThuNgan = hd.NVThuNgan;

        donThuoc = hd.donThuoc;
        phieuKhamBenh = hd.phieuKhamBenh;
        dsnv = hd.dsnv;
        dsbn = hd.dsbn;
        dsbs = hd.dsbs;
    }
    public int checkPK(String ma)
    {
        phieuKhamBenh = new DANHSACHPHIEUKHAMBENH();
        try{
            phieuKhamBenh.docData("data\\dataPhieuKham.txt");
        } catch(Exception e){
            System.out.println("loi doc file!");
            return 0;
        }
         if (phieuKhamBenh.timKiemTheoMa(maPhieuKhamBenh)==0){
            return 0;
            tenBS = dsbs.timKiemTraVeBacSi(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi()).getHo()+" "+dsbs.timKiemTraVeBacSi(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi()).getTen();
        }

        return 1;
    }
    public void them(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma hoa don : ");
        maHoaDon = input.nextLine();
        ngayTao= ngayTao.now();
        System.out.print("Nhap ma don thuoc: ");
        maDonThuoc = input.nextLine();
        donThuoc = new DANHSACHDONTHUOC();
        donThuoc.docFile("data\\DONTHUOC.TXT");
        if (donThuoc.timKiemTheoMa(maDonThuoc) == 0 ){
            System.out.println("Ma don thuoc nay khong ton tai! nhap lai !!!!");
            them();
        }
        System.out.print("Nhap ma phieu kham benh: ");

        maPhieuKhamBenh = input.nextLine();
        phieuKhamBenh = new DANHSACHPHIEUKHAMBENH();
        try{
            phieuKhamBenh.docData("data\\dataPhieuKham.txt");
        } catch(Exception e){
            System.out.println("loi doc file!");
            return;
        }
         if (phieuKhamBenh.timKiemTheoMa(maPhieuKhamBenh)==0){
            System.out.println("Ma phieu kham benh nay khong ton tai ! nhap lai!!!");
          them();
        }

    System.out.print("Hinh thuc thanh toan: (1:CK / 2:Tien mat) ");
    int option = input.nextInt();
    do{
        if (option ==1){
            hinhThucThanhToan ="CHUYEN KHOAN";
        }
        if (option == 2){
            hinhThucThanhToan= "TIEN MAT";
        }

    } while (option !=1 && option !=2);
    input.nextLine();
    System.out.print("Ma nhan vien :"); 
    NVThuNgan = input.nextLine();
    dsnv = new DANHSACHNHANVIEN();
    dsnv.docData("data\\NHANVIEN.TXT" );
    if (dsnv.kiemTraMaNhanVien(NVThuNgan)==0){
        System.out.println("Nhan vien khong ton tai!");
        them();
    }
    else{
        System.out.println("Da xong!");
    }
    dsbs.docData("data\\BacSi.txt");
    dsbn.docData("data\\BenhNhan.txt");
    tongTien = donThuoc.getDonThuocTuMa(maDonThuoc).getDonGia()+phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getTienKham();

    
        
    }

    public void xuat(){
        System.out.println("=".repeat(100));
        System.out.format("|| %94s ||\n","HOA DON BAN HANG");
        System.out.format("||       %-47s %40s ||\n","TIEM THUOC NHOM 10","Ngay tao: "+ngayTao);
        System.out.format("|| %94s ||\n","So / Ma: "+maHoaDon);
        System.out.format("|| %-94s ||\n","Bac si quan ly: "+dsbs.timKiemTraVeBacSi(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi()).getHo()+" "+dsbs.timKiemTraVeBacSi(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi()).getTen() );
        System.out.format("|| %-94s ||\n","Ma BSI: "+phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi());
        System.out.format("|| %-94s ||\n","SDT: "+dsbs.timKiemTraVeBacSi(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBacSi()).getSDT());
        System.out.format("|| %-94s ||\n"," ");
        System.out.format("|| %-94s ||\n","Ten benh nhan: "+ dsbn.timKiemBenhNhan(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan()).getHo()+ " "+dsbn.timKiemBenhNhan(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan()).getTen());
        System.out.format("|| %-94s ||\n","Ma benh nhan: "+phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan());
        System.out.format("|| %-94s ||\n","Ngay sinh: "+dsbn.timKiemBenhNhan(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan()).getNgaySinh());
        System.out.format("|| %-94s ||\n"," ");
        System.out.format("|| %-94s ||\n"," ".repeat(38)+"DON THUOC");
        // xuat don thuoc
        donThuoc.xuatDonThuocTheoMa(maDonThuoc);
        System.out.format("|| %53s %-40s ||\n"," ","Cong Tien Kham : "+ phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getTienKham());
        System.out.format("|| %53s %-40s ||\n"," ","Tong Tien Thanh Toan : "+ tongTien);
        System.out.format("|| %53s %-40s ||\n"," ", "Hinh thuc thanh toan : "+ hinhThucThanhToan);
        System.out.format("|| %-94s ||\n"," ");
        System.out.format("||          %-48s %-31s      ||\n","Benh Nhan","Nguoi Ban Hang");
        System.out.format("||         %-49s %-31s      ||\n",dsbn.timKiemBenhNhan(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan()).getHo()+ " "+dsbn.timKiemBenhNhan(phieuKhamBenh.getPhieuKhamBenh(maPhieuKhamBenh).getMaBenhNhan()).getTen(),dsnv.timkiem(NVThuNgan).getHo().toUpperCase()+" "+dsnv.timkiem(NVThuNgan).getTen().toUpperCase());
        System.out.println("=".repeat(100));


        
        

    }

    
}
