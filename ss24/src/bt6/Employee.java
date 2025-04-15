package bt6;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String id;
    private List<Role> roles = new ArrayList<>();

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void performAllRoles() {
        System.out.println("\nEmployee: " + name + " (ID: " + id + ")");
        for (Role role : roles) {
            role.performResponsibilities();

            // Check for specific role types
            if (role instanceof ManagerRole) {
                ((ManagerRole) role).manageTeam();
                ((ManagerRole) role).conductMeeting();
            }
            else if (role instanceof SalesRole) {
                ((SalesRole) role).makeSale();
                ((SalesRole) role).contactCustomer();
            }
            else if (role instanceof TechnicianRole) {
                ((TechnicianRole) role).repairEquipment();
                ((TechnicianRole) role).diagnoseProblem();
            }
        }
    }
}