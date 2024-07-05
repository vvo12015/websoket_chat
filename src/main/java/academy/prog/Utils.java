package academy.prog;
/*
    /add - POST(json) -> list
    /get?from=x - GET(json[])
 */

public class Utils {
    private static final String URL = "http://127.0.0.1";
    private static final int PORT = 8083;
    public static final String ALL_ADDRESSEES = "all";

    public static String getURL() {
        return URL + ":" + PORT;
    }
}
