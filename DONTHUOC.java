
import java.util.Scanner;

class DONTHUOC {
    private String maDonThuoc;
    private THUOC[] dst;
    private int soLuongThuocBoc;
    private double donGia;

    public DONTHUOC(){
        maDonThuoc = null;
        soLuongThuocBoc = 0;
        donGia =0;
    }
    public DONTHUOC(String ma, THUOC [] thuoc , int sl,double gia)
    {
        this.maDonThuoc = ma;
        this.dst = thuoc;
        this.soLuongThuocBoc = sl;
        this.donGia = gia;
    }
    public DONTHUOC(DONTHUOC dt){
        this.maDonThuoc = dt.maDonThuoc;
        this.dst = dt.dst;
        this.soLuongThuocBoc = dt.soLuongThuocBoc;
        this.donGia = dt.donGia;
    }
    public int them(DANHSACHTHUOC dstchinh)
    {   Scanner input = new Scanner(System.in);
        System.out.print("Ma don thuoc: ");
        maDonThuoc = input.nextLine();
        System.out.print("So loai thuoc boc: "); 
        soLuongThuocBoc = input.nextInt();
        dst = new THUOC[soLuongThuocBoc];
        input.nextLine();
        for (int i=0;i<soLuongThuocBoc;i++)
        {
            // chỗ này chưa định dạng đc 2 loạit thuốc :v nên để đại , fix sau
            dst[i] = new THUOCCHICH();
            System.out.print("Thuoc "+ (i+1) + " : "); 
            System.out.print("Ma: "); 
            String ma = input.nextLine();
            if (dstchinh.isExists(ma) == 0){
                System.out.println("Thuoc khong ton tai ! Nhap lai!");
                return 0;
            }
            else{
                dst[i].setMaThuoc(ma);
                dst[i].setTenThuoc(dstchinh.getTenThuocTheoMa(ma));
                System.out.print("So luong: "); 
                int soluong = input.nextInt();
                input.nextLine();
                if ((soluong>= 0) && soluong <= dstchinh.getSoLuongThuocTheoLoai(ma)){
                    dst[i].setSoLuong(soluong);
                    dst[i].setGiaCa(dstchinh.getGiaCaTheoMa(ma));
                    // tinh don gia 
                    donGia+=dst[i].getGiaCa()*dst[i].getSoLuong();
                    //khi nhap xong don thuoc thi set lai so luong trong danh sach thuoc
                    dstchinh.giamSoLuongThuocTheoMa(ma, soluong);
                    
                }
                else{
                    System.out.println("So luong thuoc khong phu hop!");
                    return 0;
                }
        
            }

            


        }
        try{
                        dstchinh.ghiData("D:\\phongMach_THUOC\\quanLiPhongMach\\data\\dataThuoc.txt");
                    } catch(Exception e){
                        System.out.println("Loi ghi file!");

                      
                    }
        return 1;
    
    }
    public void xuat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ma: "+ maDonThuoc);
        System.out.println("So loai thuoc boc: "+ soLuongThuocBoc);
        System.out.format("%-3s %-15s %-40s %-15s %-15s\n","STT","Ma","Ten","So luong","gia ca");
        for (int i=0;i<soLuongThuocBoc;i++)
        {
            System.out.format("%-3s %-15s %-40s %-15s %-15s\n",i+1,dst[i].getMaThuoc(),dst[i].getTenThuoc(),dst[i].getSoLuong(),dst[i].getGiaCa());
        }
        System.out.println("Don gia: "+ donGia);
    }
    public String getThongTin(){
        String s=maDonThuoc+","+soLuongThuocBoc;
        for (int i=0;i<soLuongThuocBoc;i++){
            if (dst[i] == null ) return null;
            s=s+","+dst[i].getMaThuoc()+","+dst[i].getTenThuoc()+","+dst[i].getGiaCa()+","+dst[i].getSoLuong();
        }
        s=s+","+donGia;
        return s;
    }

    public String getMaDonThuoc() {
        return maDonThuoc;
    }

    public void setMaDonThuoc(String maDonThuoc) {
        this.maDonThuoc = maDonThuoc;
    }

    public THUOC[] getDst() {
        return dst;
    }

    public void setDst(THUOC[] dst) {
        this.dst = dst;
    }

    public int getSoLuongThuocBoc() {
        return soLuongThuocBoc;
    }

    public void setSoLuongThuocBoc(int soLuongThuocBoc) {
        this.soLuongThuocBoc = soLuongThuocBoc;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }


}