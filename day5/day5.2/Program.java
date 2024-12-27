public class Program {
    public static void main(String[] args) {
        System.out.println(containOnlyAlphabets("A7med"));
    }

    private static boolean containOnlyAlphabets(String name) {
        if(name == null || name.isEmpty()) return false;
        for(char c: name.toCharArray()){
            if(!Character.isLetter(c)) return false;
        }
        return true;
    }
}
