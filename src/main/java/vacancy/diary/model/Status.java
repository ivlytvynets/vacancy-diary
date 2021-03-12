package vacancy.diary.model;

public enum Status {
    APPLIED("APPLIED"),
    GIVEN_TEST("GIVEN_TEST"),
    WAITING_FOR_FEEDBACK("WAITING_FOR_FEEDBACK"),
    SCREENING("SCREENING"),
    TECHNICAL_INTERVIEW("TECHNICAL_INTERVIEW"),
    OFFER("OFFER"),
    REJECTION("REJECTION"),
    NO_ANSWER("NO_ANSWER");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
