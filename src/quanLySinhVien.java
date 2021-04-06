import java.util.Scanner;

public class quanLySinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số sinh viên : ");
        int soSinhVien = sc.nextInt();
        String[] maSinhVien = new String[soSinhVien];
        String[] hoTen = new String[soSinhVien];
        String[] ngaySinh = new String[soSinhVien];
        String[] diemThi = new String[soSinhVien];
        for (int i = 0; i < hoTen.length; i++) {
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Nhập tên sinh viên thứ " + (i + 1) + " : ");
            hoTen[i] = sc1.nextLine();
            System.out.print("Nhập mã sinh viên thứ " + (i + 1) + " : ");
            maSinhVien[i] = sc1.nextLine();
            System.out.print("Nhập ngày sinh của sinh viên thứ " + (i + 1) + " : ");
            ngaySinh[i] = sc1.nextLine();
            System.out.print("Nhập điểm thi sinh viên thứ " + (i + 1) + " : ");
            diemThi[i] = sc1.nextLine();
        }
//        1. Hiển thị danh sách sinh viên:
        hienThiDanhSachSinhVien(hoTen, maSinhVien, ngaySinh, diemThi);
//        2. Thêm sinh viên :
        themMotSinhVienMoi(hoTen, maSinhVien, ngaySinh, diemThi);
////      3. Đổi thông tin :
        chinhSuaThongTin(hoTen, maSinhVien, ngaySinh, diemThi);
        hienThiDanhSachSinhVien(hoTen, maSinhVien, ngaySinh, diemThi);
//        4. Xóa một sinh viên :
        xoaMotSinhVien(hoTen, maSinhVien, ngaySinh, diemThi);
//            5. Tìm sinh viên điểm cao nhất
//        timSinhVienCoDiemCaoNhat(hoTen,maSinhVien,ngaySinh,diemThi);
    }

    static void hienThiDanhSachSinhVien(String hoTen[], String maSinhVien[], String ngaySinh[], String diemThi[]) {
        System.out.println("Danh sách sinh viên : ");
        System.out.printf("%23s%23s%23s%23s\n", "Họ tên", "Mã sinh viên", "Ngày sinh", "Điểm thi");
        for (int i = 0; i < hoTen.length; i++) {
            System.out.printf("%20s%20s%22s%24s\n", hoTen[i], maSinhVien[i], ngaySinh[i], diemThi[i]);
        }
    }

    static void themMotSinhVienMoi(String hoTen[], String maSinhVien[], String ngaySinh[], String diemThi[]) {
        String[] themTen = new String[hoTen.length + 1];
        String[] themMaSinhVien = new String[maSinhVien.length + 1];
        String[] themNgaySinh = new String[ngaySinh.length + 1];
        String[] themDiemThi = new String[diemThi.length + 1];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < hoTen.length; i++) {
            themTen[i] = hoTen[i];
            themMaSinhVien[i] = maSinhVien[i];
            themNgaySinh[i] = ngaySinh[i];
            themDiemThi[i] = diemThi[i];
        }
        System.out.println("Thêm một sinh viên :");
        System.out.print("Tên sinh viên: ");
        themTen[themTen.length - 1] = sc.nextLine();
        System.out.print("Mã sinh viên : ");
        themMaSinhVien[themMaSinhVien.length - 1] = sc.nextLine();
        System.out.print("Ngày sinh : ");
        themNgaySinh[themNgaySinh.length - 1] = sc.nextLine();
        System.out.print("Điểm thi : ");
        themDiemThi[themDiemThi.length - 1] = sc.nextLine();
        System.out.printf("%23s%23s%23s%23s\n", "Họ tên", "Mã sinh viên", "Ngày sinh", "Điểm thi");
        hienThiDanhSachSinhVien(themTen, themMaSinhVien, themNgaySinh, themDiemThi);
    }

    static void chinhSuaThongTin(String hoTen[], String maSinhVien[], String ngaySinh[], String diemThi[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên muốn sửa : ");
        String msv = sc.nextLine();
        int index = 0;
        for (int i = 0; i < maSinhVien.length; i++) {
            if (maSinhVien[i].equals(msv)) {
                index = i;
            }
        }
        System.out.println("Đổi thông tin");
        System.out.print("Đổi tên thành: ");
        hoTen[index] = sc.nextLine();
        System.out.print("Đổi mã sinh viên thành : ");
        maSinhVien[index] = sc.nextLine();
        System.out.print("Đổi ngày sinh thành: ");
        ngaySinh[index] = sc.nextLine();
        System.out.print("Đổi điểm thi thành : ");
        diemThi[index] = sc.nextLine();
    }

    static void xoaMotSinhVien(String hoTen[], String maSinhVien[], String ngaySinh[], String diemThi[]) {
        String[] xoaTen = new String[hoTen.length - 1];
        String[] xoaMaSinhVien = new String[maSinhVien.length - 1];
        String[] xoaNgaySinh = new String[ngaySinh.length - 1];
        String[] xoadiemThi = new String[diemThi.length - 1];
        System.out.println("Nhập mã sinh viên muốn xóa");
        Scanner sc = new Scanner(System.in);
        String msv = sc.nextLine();
        System.out.println("Danh sách sinh viên sau xóa : ");
        System.out.printf("%23s%23s%23s%23s\n", "Họ tên", "Mã sinh viên", "Ngày sinh", "Điểm thi");
        int index = 0;
        for (int i = 0; i < maSinhVien.length; i++) {
            if (msv.equals(maSinhVien[i])) {
                index = i;
                for (int j = 0; j < index; j++) {
                    xoaTen[j] = hoTen[j];
                    xoaMaSinhVien[j] = maSinhVien[j];
                    xoaNgaySinh[j] = ngaySinh[j];
                    xoadiemThi[j] = diemThi[j];
                    System.out.printf("%20s%20s%22s%24s\n", xoaTen[j], xoaMaSinhVien[j], xoaNgaySinh[j], xoadiemThi[j]);
                }
                for (int k = index; k < xoadiemThi.length; k++) {
                    xoaTen[k] = hoTen[k + 1];
                    xoaMaSinhVien[k] = maSinhVien[k + 1];
                    xoaNgaySinh[k] = ngaySinh[k + 1];
                    xoadiemThi[k] = diemThi[k + 1];
                    System.out.printf("%20s%20s%22s%24s\n", xoaTen[k], xoaMaSinhVien[k], xoaNgaySinh[k], xoadiemThi[k]);
                }
            }
        }
    }

    static void timSinhVienCoDiemCaoNhat(String hoTen[], String maSinhVien[], String ngaySinh[], double diemThi[]) {
        int max = (int) diemThi[0];
        int i;
        int index;
        for ( i = 0; i < diemThi.length; i++) {
            if (max < (int) diemThi[i]) {
                max = (int) diemThi[i];
                index = i;
            }
        }
    }
}