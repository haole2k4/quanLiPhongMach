import java.util.Scanner;

public class Login {
    // thuoc tinh
    Scanner input = new Scanner(System.in);
    private String uSer, passWord;

    // phuong thuc
    // tai khoan admin
    Login(){
        uSer = "Admin";
        passWord = "123";
    }

    Login(String u, String p){
        uSer = u;
        passWord = p;
    }

    Login(Login l){
        uSer = l.uSer;
        passWord = l.passWord;
    }

    // nhap
    public void nhap(){
        System.out.print("\n+------------------------+");
        System.out.print("\n        *PHONG MACH*      ");
        System.out.print("\n        Tao tai khoan     ");
        System.out.print("\n  Nhap tai khoan: ");
        uSer = input.nextLine();
        System.out.print("  Nhap mat khau: ");
        passWord = input.nextLine();
        System.out.print("+------------------------+");
    }

    public void xuat(){
        System.out.print("\nTai khoan: " + uSer + "\nMat khau: " + passWord);
    }

    //GET

    public String getUSer(){
        return uSer;
    }

    public String getPassWord(){
        return passWord;
    }

    //SET

    public void setUSer(String data){
        uSer = data;
    }

    public void setPassWord(String data){
        passWord = data;
    }

    public void sua(){
        System.out.print("\n+-----------------+");
        System.out.print("\n| *SUA TAI KHOAN* | \n| 1.Tai khoan.    | \n| 2.Mat khau.     | \n+-----------------+");
        System.out.print("\nChon thong tin sua: ");
        int n = input.nextInt();
        input.nextLine();
        
        switch (n) {
            case 1:
            {
                System.out.print("\nThong tin cu: " + uSer);
                System.out.print("\nSua thanh: ");
                String nd = input.nextLine();
                setUSer(nd);
            }break;
            case 2:
            {
                System.out.print("\nThong tin cu: " + passWord);
                System.out.print("\nSua thanh: ");
        String nd = input.nextLine();
                setPassWord(nd);  
            }break;
        }

    }

}
