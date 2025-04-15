package bt6;
//Xây dựng một hệ thống quản lý nhân viên, trong đó:
//
//Mỗi nhân viên có thể đảm nhận nhiều vai trò như:
//Quản lý (ManagerRole)
//Nhân viên bán hàng (SalesRole)
//Kỹ thuật viên (TechnicianRole) ...
//Mỗi vai trò sẽ có những hành vi khác nhau (ví dụ: quản lý nhân viên khác, bán hàng, sửa chữa kỹ thuật...).
//Hệ thống được thiết kế sao cho dễ mở rộng, ví dụ: khi thêm vai trò mới, không cần sửa code cũ.
public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", "E001");
        emp1.addRole(new ManagerRoleImpl());
        emp1.addRole(new TechnicianRoleImpl());

        Employee emp2 = new Employee("Jane Smith", "E002");
        emp2.addRole(new SalesRoleImpl());

        Employee emp3 = new Employee("Mike Johnson", "E003");
        emp3.addRole(new ManagerRoleImpl());
        emp3.addRole(new TechnicianRoleImpl());
        emp3.addRole(new SalesRoleImpl());

        emp1.performAllRoles();
        emp2.performAllRoles();
        emp3.performAllRoles();
    }
}