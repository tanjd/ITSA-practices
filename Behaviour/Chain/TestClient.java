public class TestClient { // Developer A
    public static void main(String[] args) {
        ClaimsForm form = new ClaimsForm();
        form.submitClaim(999);
        form.submitClaim(4999);
        form.submitClaim(10000);
    }
}

class ClaimsForm { // Developer B
    private Approver firstApprover;

    public ClaimsForm() {
        firstApprover = new ApproverReportingManager();
        firstApprover.nextApprover(new ApproverDeptHead());
        firstApprover.getNextApprover().nextApprover(new ApproverCompanyHead());
    }

    public void submitClaim(int amount) {
        firstApprover.handleMessage(amount);
    }
}

// You are the developer
interface Approver { // handler
    void handleMessage(int amount);

    void nextApprover(Approver nextApprover);

    Approver getNextApprover();
}

class ApproverReportingManager implements Approver {
    private Approver nextApprover;
    private int limit = 1000;

    public void handleMessage(int amount) {
        if (amount < limit) {
            System.out.println("Reporting Manager is handling it");
        } else {
            nextApprover.handleMessage(amount);
        }
    }

    public void nextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public Approver getNextApprover() {
        return nextApprover;
    }
}

class ApproverDeptHead implements Approver {
    private Approver nextApprover;
    private int limit = 5000;

    public void handleMessage(int amount) {
        if (amount < limit) {
            System.out.println("Department Head is handling it");
        } else {
            nextApprover.handleMessage(amount);
        }
    }

    public void nextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public Approver getNextApprover() {
        return nextApprover;
    }
}

class ApproverCompanyHead implements Approver {
    private Approver nextApprover;

    public void handleMessage(int amount) {
        System.out.println("Company Head is handling it");
    }

    public void nextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public Approver getNextApprover() {
        return nextApprover;
    }
}