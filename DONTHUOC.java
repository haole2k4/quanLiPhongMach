
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
    public void them(DANHSACHTHUOC dstchinh)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma don thuoc: ");
        maDonThuoc = input.nextLine();
        System.out.print("So loai thuoc boc: "); 
        soLuongThuocBoc = input.nextInt();
        for (int i=0;i<soLuongThuocBoc;i++)
        {
            System.out.print("Thuoc "+ i+1 + " : "); 
            System.out.print("Ma: "); 
            String ma = input.nextLine();
            if (dstchinh.isExists(ma) == 0){
                System.out.println("Thuoc khong ton tai ! Nhap lai!");
                return;
            }
            else{
                dst[i].setMaThuoc(ma);
                System.out.print("So luong: "); 
                int soluong = input.nextInt();
                if ((soluong>= 0) && soluong <= dstchinh.getSoLuongThuocTheoLoai(ma)){
                    dst[i].setSoLuong(soluong);
                    dst[i].setGiaCa(dstchinh.getGiaCaTheoMa(ma));
                    // tinh don gia 
                    donGia+=dst[i].getGiaCa()*dst[i].getSoLuong();
                    //khi nhap xong don thuoc thi set lai so luong trong danh sach thuoc
                    dstchinh.giamSoLuongThuocTheoMa(ma, soluong);
                    try{
                        dstchinh.ghiData("D:\\phongMach_THUOC\\quanLiPhongMach\\data");
                    } catch(Exception e){
                        System.out.println("LOI!");

                    }
                }
                else{
                    System.out.println("So luong thuoc khong phu hop!");
                    return;
                }
            }

            


        }
    }
    public void xuat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ma: "+ maDonThuoc);
        System.out.println("So loai thuoc boc: "+ soLuongThuocBoc);
        System.out.format("%-3s %-15s %-40s %-15s %-15s","STT","Ma","Ten","So luong","gia ca");
        for (int i=0;i<soLuongThuocBoc;i++)
        {
            System.out.format("%-3s %-15s %-40s %-15s %-15s",i+1,dst[i].getMaThuoc(),dst[i].getTenThuoc(),dst[i].getSoLuong(),dst[i].getGiaCa());
        }
        System.out.println("Don gia: "+ donGia);
    }


}