
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DSNV {
    private NhanVien[] dsnv = new NhanVien[1];
    private int soLuongNV;
    Scanner input = new Scanner(System.in);
    DSNV()
    {
        soLuongNV = 0;
        dsnv[0] = new NhanVien();
        dsnv[0] = null;
    }
    DSNV(NhanVien [] ds, int sl)
    {
        dsnv = ds;
        soLuongNV = sl;
    }
    DSNV(DSNV ds)
    {
        dsnv = ds.dsnv;
        soLuongNV = ds.soLuongNV;
    }
    public String fileNV()
    {
        return "D:\\phongMach_THUOC\\quanLiPhongMach\\NhanVien.txt";
    }
//ham lay dong de ghi vao file
    public String getLine(int i)
    {
        return (dsnv[i].getMaNV()+","+dsnv[i].getHo()+","+dsnv[i].getTen()+","+dsnv[i].getGioiTinh()+","+dsnv[i].getNgaySinh()+","+dsnv[i].getChucVu()+","+dsnv[i].getHeSoLuong()+","+dsnv[i].getSDT()+","+dsnv[i].getHoatDong());
    }
//ham de xoa data trong 1 file
    public void xoaDataFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write("");

            writer.close();
        } catch (IOException e) {
            System.out.println("loi");
        }
    }
//ham ghi file
    public void ghiLine(String fileName,String s)
    {
        // xoa data trong file tr
        File outFile = new File(fileName);
        PrintWriter write=null;
            try {

                write= new PrintWriter(new FileWriter(outFile,true));
        
                }
        
               catch (Exception e){ System.out.println("Khong the tao tap tin ket qua");
        
                                    return;
               }
               write.print(s);
               write.print("\n");
               write.close();
    }
    void ghiFile()
    {
        xoaDataFile(fileNV());
        ghiLine(fileNV(),String.valueOf(soLuongNV));
        for (int i=0;i<soLuongNV;i++)
        {
            ghiLine(fileNV(),getLine(i));
        }
    }



        void nhap()
        {
            //xoa data trong file truoc khi ghi lai file moi
            xoaDataFile(fileNV());
            Scanner input = new Scanner(System.in);
            System.out.print(" - So nhan vien: "); 
            soLuongNV = input.nextInt();
            dsnv = new NhanVien[soLuongNV];
            for (int i=0;i<soLuongNV;i++)
            {
                dsnv[i] = new NhanVien();
                System.out.print("Nhan vien ["+(i+1)+"] :\n");
                dsnv[i].nhap();
                System.out.print("\n");
            }
            //ghi lai vao file
            ghiFile();
        }
        void docData()
        {
            File inFile = new File(fileNV());
            Scanner read = null;
            try
            {
                read = new Scanner(inFile);
            }
            catch (Exception e)
            {
                System.out.print("khong the mo file NhanVien.txt");
                return ;
            }
            String sl = read.nextLine();
            soLuongNV = Integer.parseInt(sl);
            dsnv = new NhanVien[soLuongNV];
            for (int i=0;i<soLuongNV;i++)
            {
                dsnv[i] = new NhanVien();
                String line = read.nextLine();
                String [] str = line.split(",");
                dsnv[i].setMaNV(str[0]);
                dsnv[i].setHo(str[1]);
                dsnv[i].setTen(str[2]);
                dsnv[i].setGioiTinh(str[3]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate ngaySinh = LocalDate.parse(str[4], formatter);
                dsnv[i].setNgaySinh(ngaySinh);
                dsnv[i].setChucVu(str[5]);
                dsnv[i].setHeSoLuong(Double.parseDouble(str[6]));
                dsnv[i].setSDT(str[7]);
                dsnv[i].setHoatDong(Boolean.parseBoolean(str[8]));
            }
            read.close();
        }
    void xuat()
        {
            docData();
            System.out.println("Danh sach nhan vien: ");
            for (int i=0;i<soLuongNV;i++)
            {
                dsnv[i].xuat();
                System.out.print("\n");
            }
        }


    void them()
    {
        dsnv= Arrays.copyOf(dsnv,soLuongNV+1);
        dsnv[soLuongNV] = new NhanVien();
        dsnv[soLuongNV].nhap();
        soLuongNV++;
        ghiFile();
    }

    void sua()
    {
        Scanner input = new Scanner(System.in);
        System.out.print(" - Nhap ma nhan vien can sua: ");
        String ma = input.nextLine();
        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            
            {
                flag = true;
                dsnv[i].sua();
            }
        }
        if (!flag )
        System.out.println("khong tim thay nhan vien");
        ghiFile();
        
    }

    
    void sua(String ma)
    {
        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            
            {
                flag = true;
                dsnv[i].sua();
            }
        }
        if (!flag )
        System.out.println("khong tim thay nhan vien");

//sua trong file
        ghiFile();


    }
    boolean locThongTin(String line,String s)
    {
        if (line.indexOf(s) == -1)
        return false;
        else
        return true;
    }




    void xoa()
    {
//xoa trong array hien tai
        System.out.print(" - Nhap ma nhan vien can xoa: ");
        Scanner input = new Scanner(System.in);
        String ma;
        ma = input.nextLine();
        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            {
                flag = true;
                for (int j=i;j<soLuongNV-1;j++)
                {
                    dsnv[j] = dsnv [ j+1];
                }
                soLuongNV--;
            }

        }
        if (!flag)
        {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }
        ghiFile();
    }



    void xoa(String ma)
    {
//xoa trong array hien tai

        boolean flag = false;
        for (int i=0;i<soLuongNV;i++)
        {
            if (ma.equals(dsnv[i].getMaNV()))
            {
                flag = true;
                for (int j=i;j<soLuongNV-1;j++)
                {
                    dsnv[j] = dsnv [ j+1];
                }
                soLuongNV--;
            }

        }
        if (!flag)
        {
            System.out.println("Khong tim thay ma nhan vien!");
            return;
        }
// xoa trong file
        ghiFile();
    }

    public NhanVien timkiem()
    {
        Scanner input = new Scanner(System.in);
        System.out.print(" - Nhap ma nhan vien hoac ten nhan vien can tim kiem: ");
        String ma = input.nextLine();
        for (int i=0;i<soLuongNV;i++)
        {
            if ((ma.equals(dsnv[i].getMaNV())) || (ma.equals(dsnv[i].getTen())) )
            {
                return dsnv[i];
            }
        }
        System.out.println("Khong tim thay nhien vien");
        NhanVien nv = new NhanVien();
        return nv;
    }

    public NhanVien timkiem(String ma)
    {
       for (int i=0;i<soLuongNV;i++)
        {
            if ((ma.equals(dsnv[i].getMaNV())) || (ma.equals(dsnv[i].getTen())) )
            {
                return dsnv[i];
            }
        }
        System.out.println("Khong tim thay nhien vien");
        NhanVien nv = new NhanVien();
        return nv;
    }

    public void thongKeHoatDong()
    {
        int hd =0;
        for (int i=0;i<soLuongNV;i++)
        {
            if (dsnv[i].getHoatDong())
            {
                hd++;
            }
        }
        System.out.print("So nhan vien dang hoat dong: "+ hd +" : ");
        for (int i=0;i<soLuongNV;i++)
        {
            if (dsnv[i].getHoatDong())
            {
                System.out.print(dsnv[i].getHo()+" "+dsnv[i].getTen()+"  ,  ");
            }
        }

        System.out.print("\n");
        System.out.print("So nhan vien khong hoat dong: "+ (soLuongNV - hd) +" : ");
        for (int i=0;i<soLuongNV;i++)
        {
            if (!dsnv[i].getHoatDong())
            {
                System.out.print(dsnv[i].getHo()+" "+dsnv[i].getTen()+"  ,  ");
            }
        }
        System.out.println("\n");

    }

    
}
