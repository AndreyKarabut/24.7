public enum StudyProfile {
    PROGRAMMER("Программист"),
    HIGHTMATHTEACHER("Математик"),
    ENGINEERE("Инженер"),
    MEDICINE("Медик");
    private String decryption;

    StudyProfile(String decryption) {
        this.decryption = decryption;
    }
}
