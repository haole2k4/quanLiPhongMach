
public class QUANLIDSHoaDon {
    public void thaoTac() {
        try {
            DANHSACHHOADON ds = new DANHSACHHOADON();
            ds.docFile("data/HOADON.txt");
            ds.xuat();
            ds.thaoTac();
            ds.ghiFile("data/HOADON.txt");
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }
}


