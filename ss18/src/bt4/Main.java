package bt4;
import java.util.Map;
import java.util.TreeMap;

//Tạo một TreeMap để lưu trữ danh sách nhân viên và mức lương của họ (mã nhân viên là khóa, mức lương là giá trị).
//Thêm 5 nhân viên vào TreeMap.
//In ra danh sách nhân viên theo thứ tự mã nhân viên (khóa) theo thứ tự tăng dần.
//Cập nhật mức lương của một nhân viên (ví dụ: thay đổi lương của nhân viên có mã "NV123").
//Xóa một nhân viên khỏi danh sách và in lại danh sách nhân viên sau khi xóa
public class Main {
    public static void main(String[] args) {
        Map<String, Double> employees = new TreeMap<>();

        employees.put("NV123", 15000000.0);
        employees.put("NV234", 12000000.0);
        employees.put("NV101", 18000000.0);
        employees.put("NV456", 10000000.0);
        employees.put("NV345", 13500000.0);

        // In ra danh sách nhân viên theo thứ tự mã nhân viên tăng dần
        System.out.println("Danh sách nhân viên theo thứ tự mã tăng dần:");
        printEmployees(employees);

        // Cập nhật mức lương của nhân viên có mã "NV123"
        employees.put("NV123", 16500000.0);
        System.out.println("\nDanh sách nhân viên sau khi cập nhật lương của NV123:");
        printEmployees(employees);

        // Xóa một nhân viên khỏi danh sách
        employees.remove("NV456");
        System.out.println("\nDanh sách nhân viên sau khi xóa NV456:");
        printEmployees(employees);
    }

    private static void printEmployees(Map<String, Double> employees) {
        for (Map.Entry<String, Double> entry : employees.entrySet()) {
            System.out.printf("Mã NV: %s - Lương: %.2f VND\n", entry.getKey(), entry.getValue());
        }
    }
}