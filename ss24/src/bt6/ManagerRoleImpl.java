package bt6;

public class ManagerRoleImpl implements ManagerRole {
    @Override
    public void performResponsibilities() {
        System.out.println("Performing managerial duties");
    }

    @Override
    public void manageTeam() {
        System.out.println("Managing team members");
    }

    @Override
    public void conductMeeting() {
        System.out.println("Conducting team meeting");
    }
}