
public class QUANLIDSTHUOC {
    public void trinhQuanLiDanhSachThuoc() {
        try {
            DANHSACHTHUOC ds = new DANHSACHTHUOC();
            ds.docData("data/dataThuoc.txt");
            ds.inDanhSachThuoc();
            ds.menuThaoTac();
        }
        catch(Exception e) {
            // e.printStackTrace();
            System.out.println("Loi khi thuc hien thao tac doc file\n");
        }
    }
}


