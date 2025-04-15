package bt6;

public class TechnicianRoleImpl implements TechnicianRole {
    @Override
    public void performResponsibilities() {
        System.out.println("Performing technical duties");
    }

    @Override
    public void repairEquipment() {
        System.out.println("Repairing equipment");
    }

    @Override
    public void diagnoseProblem() {
        System.out.println("Diagnosing technical problem");
    }
}