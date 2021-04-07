import java.util.Scanner;

public class quanLySinhVien {
    static String[] maSinhVien;
    static String[] hoTen;
    static String[] ngaySinh;
    static String[] diemThi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số sinh viên : ");
        int soSinhVien = sc.nextInt();
        maSinhVien = new String[soSinhVien];
        hoTen = new String[soSinhVien];
        ngaySinh = new String[soSinhVien];
        diemThi = new String[soSinhVien];
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
        int luaChon;
        do {
            System.out.println("Nhập lựa chọn của bạn : ");
            System.out.println("1. Thêm một sinh viên");
            System.out.println("2. Đổi thông tin ");
            System.out.println("3. Xóa một sinh viên ");
            System.out.println("4. Tìm sinh viên điểm cao nhất");
            System.out.println("0. Thoát chương trình");
            luaChon = sc.nextInt();
            hienThiDanhSachSinhVien();
            switch (luaChon) {
                case 1: {
                    themMotSinhVienMoi();
                    break;
                }
                case 2: {
                    chinhSuaThongTin();
                    hienThiDanhSachSinhVien();
                    break;
                }
                case 3: {
                    xoaMotSinhVien();
                    break;
                }
                case 4: {
                    timSinhVienCoDiemCaoNhat();
                    break;
                }
            }
        }while(luaChon!=0);

    }

    static void hienThiDanhSachSinhVien() {
        System.out.println("Danh sách sinh viên : ");
        System.out.printf("%23s%23s%23s%23s\n", "Họ tên", "Mã sinh viên", "Ngày sinh", "Điểm thi");
        for (int i = 0; i < hoTen.length; i++) {
            System.out.printf("%20s%20s%22s%24s\n", hoTen[i], maSinhVien[i], ngaySinh[i], diemThi[i]);
        }
    }

    static void themMotSinhVienMoi() {
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
        hoTen = themTen;
        maSinhVien = themMaSinhVien;
        ngaySinh = themNgaySinh;
        diemThi = themDiemThi;
        hienThiDanhSachSinhVien();
    }

    static void chinhSuaThongTin() {
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

    static void xoaMotSinhVien() {
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

    static void timSinhVienCoDiemCaoNhat() {
        int max = Integer.parseInt(diemThi[0]);
        int i;
        int index = 0;
        for (i = 0; i < diemThi.length; i++) {
            if (max < Integer.parseInt(diemThi[i])) {
                max = Integer.parseInt(diemThi[i]);
                index = i;
            }
        }
        System.out.println("Sinh viên cao điểm nhất là : ");
        System.out.printf("%23s%23s%23s%23s\n", "Họ tên", "Mã sinh viên", "Ngày sinh", "Điểm thi");
        System.out.printf("%20s%20s%22s%24s\n", hoTen[index], maSinhVien[index], ngaySinh[index], diemThi[index]);
    }
}