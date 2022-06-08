public enum StudyProfile {
    PROGRAMMER("Программист"),
    MATHEMATICS("Математик"),
    ENGINEERE("Инженер"),
    MEDICINE("Медик"),
    PHYSICS("Физик"),
    LINGUISTICS("Лингвист");


    private String decryption;

    StudyProfile(String decryption) {
        this.decryption = decryption;
    }
}
