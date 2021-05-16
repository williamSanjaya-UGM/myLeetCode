package cafeB;

public enum PatternRegex {
    patternDate("(\\d{4}-\\d{2}-\\d{2})"),
    patternOrders("\"([^\"]*)\""),
    patternFulfilled("(fulfilled=FALSE)"),
    patternTime("(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]");

    private final String patterns;
    PatternRegex(String patterns){
        this.patterns=patterns;
    }

    public String getPatterns() {
        return patterns;
    }
}
