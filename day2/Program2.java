import java.util.regex.*;
import java.util.StringTokenizer;

class Program2{
    public static void main(String[] args) {
        // Use String
        String word = "ITI";
        String str = "ITI develops people and ITI house of developers and ITI for people ITI";
        String []splitStr = str.split(" ");
        int count = 0;
        for(String s: splitStr) {
            if(s.equals(word)) count++;
        }
        System.out.println("\nStringTokenizer:");
        System.out.println("way1: count word \'ITI\': " + count);
        
        count = 0;
        for (int i = 0; i <= str.length()-word.length(); i++) {
            if (str.charAt(i) == word.charAt(0)) {
                for (int j = 0; j < word.length(); j++) {
                    if (str.charAt(i + j) != word.charAt(j)) {
                        break;
                    }
                    if (j == word.length()-1) {
                        count++;
                    }
                }
            }
        }
        System.out.println("way2: count word \'ITI\': " + count);

        count = 0;
        while (str.contains(word)) {
            str = str.substring(str.indexOf(word)+word.length());
            count++;
        }
        System.out.println("way3: count word \'ITI\': " + count);

        // Use StringTokenizer
        count = 0;
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().equals(word)) count++;
        }
        System.out.println("\nStringTokenizer:");
        System.out.println("count word \'ITI\': " + count);

        // IP Address
        Program2 p = new Program2();
        String ipAddress = "89.207.132.170";
        System.out.print("\n" + ipAddress);
        if (p.isValidIPAddress(ipAddress)) System.out.println(" is valid IpAddress");
        else System.out.println(" is invalid IpAddress");
        
        System.out.print("IP Address parts: ");
        String []splitIpAddress = ipAddress.split("\\.");
        for (String s: splitIpAddress) {
            System.out.print(s + "\t");
        }
    }

    boolean isValidIPAddress(String ip){
        String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
        String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        Pattern p = Pattern.compile(regex);
        if (ip == null) return false;
        Matcher m = p.matcher(ip);
        return m.matches();
    }
}