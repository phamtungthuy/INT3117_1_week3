public class Student {
    private StudentSituation studentSituation;
    private Double GPA;

    public Student(StudentSituation studentSituation, Double GPA) {
        this.studentSituation = studentSituation;
        this.GPA = GPA;
    }


    public boolean isEligibleForLoan() {
        if (GPA < 0 || GPA > 4.0) {
            throw new RuntimeException("Input is invalid");
        }
        return studentSituation != StudentSituation.NORMAL &&
                (studentSituation != StudentSituation.NEEDY || !(GPA < 3.2)) &&
                (studentSituation != StudentSituation.POOR || !(GPA < 2.5));
    }

    public int getLoanAmount() {
        if(!isEligibleForLoan()) {
            return 0;
        }
        if (studentSituation == StudentSituation.NEEDY) {
            if (GPA < 3.6) {
                return 6_000_000;
            } else {
                return 12_000_000;
            }
        } else {
            if (GPA < 3.2) {
                return 6_000_000;
            } else if (GPA < 3.6) {
                return 12_000_000;
            } else {
                return 15_000_000;
            }
        }
    }
}
