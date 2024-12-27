public class StringUtils {
    public static String betterString(String s1, String s2, ICondition condition) {
        if(condition.isFirstBetter(s1, s2)) return s1;
        else return s2;
    }
}
