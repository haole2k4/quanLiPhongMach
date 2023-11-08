
import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class PhieuNhap {
    private String maPhieuNhap,maCTPhieuNhap;
    private String maNhanVien,maNhaCungCap;
    private LocalDate ngayNhap;
    private double tongTien;
    public PhieuNhap()
    {
        maPhieuNhap= null;
        maCTPhieuNhap = null;
        maNhaCungCap =null;
        maNhanVien = null;
        ngayNhap = null;
        tongTien=0;
    }
    public PhieuNhap(String mpn , String mctpn, String mnv, String mncc, LocalDate nn)
    {
        maPhieuNhap = mpn;
        maCTPhieuNhap = mctpn;
        maNhanVien = mnv;
        maNhaCungCap = mncc;
        ngayNhap = nn;

    }


    public void nhap()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Ma Phieu nhap:");
        maPhieuNhap = input.nextLine();
        System.out.print("Ma chi tiet phieu nhap: ");
        maCTPhieuNhap = input.nextLine(); 
        
        //doc file chi tiet phieu nhap xem ma nay co ton tai khong !
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\chitietphieunhap.txt");
        Scanner read = null;
        try
        {
            read = new Scanner(file);
        } catch( Exception e){
            System.out.println("loi doc file!");
        }
        if (read.hasNextLine())
        {   
            int soLuong = Integer.parseInt(read.nextLine());
        }
        else return;    
        boolean flag = true;
        while ( read.hasNextLine())
        {
            String line = read.nextLine();
            String arr[] = line.split(",");
            if(arr[0].equals(maCTPhieuNhap))
            {
                flag = false;
        
                System.out.print("Ma nhan vien: ");
                maNhanVien = input.nextLine(); 
                File f = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\NhanVien.txt");
                Scanner readf = null;
                try{
                    readf = new Scanner(f);
                }
                catch(Exception e){
                System.out.println("loi doc file nhan vien!");
                 }
                if (readf.hasNextLine())
                {
                readf.nextLine();
                }
                else 
                {
                    nhap();
                }
                
                boolean flag1 = false;
                boolean onlineFlag =false;
                while (readf.hasNextLine())
                {
                String line1 = readf.nextLine();
                String [] arr1 = line1.split(",");
                if (arr1[0].equals(maNhanVien))
                flag1 = true;
                if ( Boolean.parseBoolean(arr1[8]))
                {
                    onlineFlag = true;
                }
                

                }
                if (!flag1)
                {
                    System.out.println("khong tim thay nhan vien nay!");
                    return;
                }
                if (!onlineFlag)
                {
                    System.out.println("Nhan vien nay khong hoat dong!");
                }
                readf.close();
        
        System.out.print("Ma nha cung cap: ");
        maNhaCungCap = input.nextLine(); 
        System.out.print("Ngay nhap (yyyy-mm-dd): ");
        String ngayNhapTemp = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ngayNhap = LocalDate.parse(ngayNhapTemp, formatter);
      //      
    //    }
  //      while ( !(maPhieuNhap.equals(ctpn.getMaCTPhieuNhap())));
        }
        
        }
    
        if ( flag ) 
        {
            System.out.println("ma chi tiet phieu nhap khong ton tai!");
            nhap();
        }
        
        
        read.close();
        
    }
    
    public void xuatPhieuNhap()
    {
       
        System.out.println("====== PHIEU NHAP HANG ======");
        System.out.println("Ma phieu nhap : "+ maPhieuNhap); ;
        System.out.println("Ma chi tiet phieu nhap : "+ maCTPhieuNhap); 
        System.out.println("Ma nhan vien : "+ maNhanVien); 
        System.out.println("Ma nha cung cap : "+ maNhaCungCap); 
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("--- CHI TIET PHIEU NHAP ---");
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\chitietphieunhap.txt");
        Scanner read = null;
        try
        {
            read = new Scanner(file);
        } catch( Exception e){
            System.out.println("loi doc file!");
        }
    
        String soLuong = read.nextLine();
        while (read.hasNextLine())
        {
            String line = read.nextLine();
            String arr[] = line.split(",");

            if (arr[0].equals(maCTPhieuNhap))
            {
                for (int    i=2; i<= arr.length-2;i++)
                {
                    System.out.print(arr[i]+"       ");
                    if (i%3==1 )
                    {
                        System.out.println();
                    }
                }
            System.out.println("Tong tien nhap hang : "+ arr[arr.length-1] );
            }
            
        }
        read.close();
        
    
    }
    //SET
    public void setMaPhieuNhap(String data)
    {
        maPhieuNhap = data;
    }
    public void setMaCTPhieuNhap(String data)
    {
        maCTPhieuNhap = data;
    }
    public void setMaNhanVien(String data)
    {
        maNhanVien = data;
    }
    public void setMaNhaCungCap(String data)
    {
        maNhaCungCap = data;
    }
    public void setNgayNhap(LocalDate data)
    {
        ngayNhap = data;
    }
    public void setTongTien(Double data)
    {
        tongTien = data;
    }
    

    //get
    public String getMaPhieuNhap()
    {
        return maPhieuNhap;
    }
    public String getMaChiTietPhieuNhap()
    {
        return maCTPhieuNhap;
    }
    public LocalDate getNgayNhap()
    {
        return ngayNhap;
    }
    public String getMaNhanVien()
    {
        return maNhanVien;
    }
    public String getMaNhaCungCap()
    {
        return maNhaCungCap;
    }

    public String getLine()
    {
        String s="";
        s=s+maPhieuNhap+","+maNhanVien+","+maNhaCungCap+","+ngayNhap+",";
        File file = new File("D:\\phongMach_THUOC\\quanLiPhongMach\\chitietphieunhap.txt");
        Scanner read = null;
        try
        {
            read = new Scanner(file);
        } catch( Exception e){
            System.out.println("loi doc file!");
        }
    
        String soLuong = read.nextLine();
        while (read.hasNextLine())
        {
            String line = read.nextLine();
            String arr[] = line.split(",");

            if (arr[0].equals(maCTPhieuNhap))
            {
                s=s+line;
            }
        }
        return s;
    }

}
