public class Program {
    public static void main(String[] args){
        String string1 = "A7med";
        String string2 = "zaki";
        ICondition condition = (s1, s2) -> s1.length() >= s2.length();
        String result = StringUtils.betterString(string1, string2, condition);
        System.out.println(result);
    }
}
