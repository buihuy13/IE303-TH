import java.util.Scanner;

public class Bai2 {

    public static double dientichhinhtron(double r) {
        int dem_trong = 0;
        int so_diem=1000000;
        double max = r;
        double min = -r;
        for (int i = 0; i < so_diem; i++) {
            double x = (Math.random() * (max - min)) + min;
            double y = (Math.random() * (max - min)) + min;
            if (Math.pow(x, 2) + Math.pow(y, 2) <= r * r) {
                dem_trong += 1;
            }
        }
        double dien_tich_hinh_vuong = Math.pow((2 * r),2);
        return ((double) dem_trong / so_diem) * dien_tich_hinh_vuong;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pi = dientichhinhtron(1);
        System.out.printf("Gia tri xap xi cua pi la: %.2f%n", pi);

        sc.close();
    }
}