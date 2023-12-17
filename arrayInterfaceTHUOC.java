import java.io.FileNotFoundException;

/**
 * arrayInterface
 */
public interface arrayInterfaceTHUOC {
    public void themThuoc(THUOC newTHUOC);
    public void xoaThuoc(int index);
    public void suaThongTin(String ma);
    public void inDanhSachThuoc();
    public void nhapThuoc(int soThuocCanNhap);
    public void timThuocTheoTen(String tenThuocCanTim);
    public void inThuocTheoMa(String maThuocCanTim);
    public void docData(String filePath) throws FileNotFoundException;
}


// CÙNG KIỂU DỮ LIỆU ĐỐI SỐ VÀ TRẢ VỀ LÀ ĐƯỢC 