import java.util.Scanner;

public class DS_Login {
    // thuoc tinh
    private Login [] dsLogin;
    private int soLuongTK;
    Scanner input = new Scanner(System.in);

    //phuong thuc
    DS_Login(){
        soLuongTK = 0;
        dsLogin [0] = new Login();
        dsLogin [0] = null;
    }

    DS_Login(int sltk, Login [] dsl){
        soLuongTK = sltk;
        dsLogin = dsl;
    }

    DS_Login(DS_Login l1){
        soLuongTK = l1.soLuongTK;
        dsLogin = l1.dsLogin;
    }

    
}
