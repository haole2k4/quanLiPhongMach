
import java.util.Scanner;
public class QUANLYNHAPHANG
{
    
    public void menu(DANHSACHCHITHIETPHIEUNHAP dsctpn, DANHSACHPHIEUNHAP dspn)
    {
        System.out.println("\n\t\u001B[34m======[ Trinh quan ly nhap hang ]=====\u001B[0m");
        System.out.println("\t -> Nhap 0 de quay tro lai");
        System.out.println("\t -> Nhap 1 de quan ly chi tiet phieu nhap");
        System.out.println("\t -> Nhap 2 de quuan ly phieu nhap");
        int i; 
        do
        {
            System.out.print("\t -> lua chon: ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();
            switch(i)
            {
                case 0:
                {
                   break;
                }
                case 1:
                { 
                
                    dsctpn.menu(); 
                    
                }break;
                case 2: dspn.menu(); break;
            }


        }
        while (i!=0);

    
    
    }
}