
import java.io.File;
import java.util.Scanner;
public class ChiTietPhieuNhap {
    private String maCTPhieuNhap;
    THUOC [] dsThuocNhap;
    int soLoaiThuocNhap=0;
    double thanhTien=0;
    public ChiTietPhieuNhap()
    {
        maCTPhieuNhap = null;
        thanhTien =0;
        soLoaiThuocNhap =0;
        dsThuocNhap = new THUOC[0];
        thanhTien =0;
    } 
    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn)
    {
        maCTPhieuNhap = ctpn.maCTPhieuNhap;
        dsThuocNhap = ctpn.dsThuocNhap;
        soLoaiThuocNhap = ctpn.soLoaiThuocNhap;
        thanhTien = ctpn.thanhTien;

    }
    public void nhap()
    {
        Scanner input  = new Scanner(System.in);
        System.out.print("Ma phieu nhap: ");
        maCTPhieuNhap = input.nextLine();
        System.out.print("So loai thuoc nhap: ");
           soLoaiThuocNhap = input.nextInt();
           dsThuocNhap = new THUOC[soLoaiThuocNhap];
        input.nextLine();
        for(int i=0;i<soLoaiThuocNhap;i++)
        {
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
        //   if (danhSachThuocLon.timThuocTheoMa(maThuoc) != null) // neu thuoc da ton trai trong KHO thi add them so luong
                dsThuocNhap[i].setMaThuoc(maThuoc);
                System.out.print("So luong: ");
                int soLuong = input.nextInt();
                dsThuocNhap[i].setSoLuong(soLuong);
              //  danhSachThuocLon.addSoLuongThuoc(danhSachThuocLon.timThuocTheoTenTraVeViTri(maThuoc),soLuong);
                System.out.print("Gia nhap hang / 1 : ");
                double giaCa = input.nextDouble();
                thanhTien = thanhTien+giaCa*soLuong;
                dsThuocNhap[i].setGiaCa(giaCa);    
        }
//else // neu thuoc la thuoc moi thi them thuoc vao KHO
  //          {
           //     danhSachThuocLon.addThuoc();
    //        }
    }

    public void xuatThuocDaNhap()
    {
        for (int i=0;i<soLoaiThuocNhap;i++)
        {
            System.out.println(1+": "+dsThuocNhap[i].getMaThuoc()+"        "+dsThuocNhap[i].getSoLuong()+"         "+dsThuocNhap[i].getGiaCa() );
        }
    }
    public void xuat()
    {
        System.out.println("====  Chi tiet phieu nhap ====");
        System.out.println("ma : "+ maCTPhieuNhap);
        System.out.println("so loai: "+ soLoaiThuocNhap);
        System.out.println("---- CHI TIET ----");
        xuatThuocDaNhap();
        System.out.println("Tong tien : "+ thanhTien);
        System.out.println();
        
    }
    
    public void xoa()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet phieu nhap can xoa:");
        String ma = input.nextLine();
        for (int i=0;i<soLoaiThuocNhap;i++)
        {
            if (dsThuocNhap[i].getMaThuoc().equals(ma))
            {
                for (int j=i;j<soLoaiThuocNhap-1;j++)
                {
                    dsThuocNhap[i] = dsThuocNhap[i+1];
                }
            }
        }
        soLoaiThuocNhap--;
    }

//GET 
    public int getSoLoaiThuocNhap()
    {
        return soLoaiThuocNhap;
    }
    public String getMaCTPhieuNhap()
    {
        return maCTPhieuNhap;
    }
    public Double getThanhTien()
    {
        return thanhTien;
    }
    public THUOC [] getDanhSachThuocNhap()
    {
        return dsThuocNhap;
    }
    public String getChuoiThuocNhap() // ham de viet vao file
    {
        String line =maCTPhieuNhap+","+String.valueOf(soLoaiThuocNhap);
        for (int i=0;i<soLoaiThuocNhap;i++)
        {
            line = line+","+dsThuocNhap[i].getMaThuoc()+","+dsThuocNhap[i].getSoLuong()+","+dsThuocNhap[i].getGiaCa();        
        }
        line = line +"," +thanhTien;
        return line; 
    }

//SET
    public void setSoLoaiThuocNhap(int sl)
    {
        soLoaiThuocNhap = sl;
    }
    public void setMaCTPhieuNhap(String data)
    {
        maCTPhieuNhap = data;
    }
    public void setDanhSachThuocNhap(THUOC[] data)
    {
        dsThuocNhap = data;
    }
    public void setThanhTien(Double tt)
    {
        thanhTien =tt;
    }
}