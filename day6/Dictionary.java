import java.util.TreeMap;
import java.util.SortedMap;

public class Dictionary {
    static private SortedMap<Character, SortedMap<String, String>> map;
    static {
        map = new TreeMap<>();
        addGeneratedWords();
    }

    private static void addGeneratedWords() {
        String[][] wordPairs = {
            {"apple", "apfel"},
            {"cherry", "kirsche"},
            {"banana", "banane"},
            {"orange", "apfelsine"},
            {"strawberry", "erdbeere"},
            {"blueberry", "heidelbeere"},
            {"grape", "traube"},
            {"watermelon", "wassermelone"},
            {"avocado", "avocado"},
            {"pineapple", "ananas"},
            {"pear", "birne"},
            {"peach", "pfirsich"},
            {"plum", "pflaume"},
            {"lemon", "zitrone"},
            {"lime", "limette"},
            {"kiwi", "kiwi"},
            {"mango", "mango"},
            {"pomegranate", "granatapfel"},
            {"apricot", "aprikose"},
            {"fig", "feige"},
            {"date", "dattel"},
            {"raisin", "rosine"},
            {"nut", "nuss"},
            {"almond", "mandel"},
            {"peanut", "erdnuss"},
            {"walnut", "walnuss"},
            {"hazelnut", "haselnuss"},
            {"cashew", "cashew"},
            {"pistachio", "pistazie"},
            {"coconut", "kokosnuss"},
            {"chestnut", "kastanie"},
            {"bread", "brot"},
            {"butter", "butter"},
            {"cheese", "kase"},
            {"milk", "milch"},
            {"yogurt", "joghurt"},
            {"cream", "sahne"},
            {"egg", "ei"},
            {"bacon", "speck"},
            {"ham", "schinken"},
            {"sausage", "wurst"},
            {"beef", "rindfleisch"},
            {"pork", "schweinefleisch"},
            {"chicken", "huhnchen"},
            {"turkey", "pute"},
            {"duck", "ente"},
            {"lamb", "lamm"},
            {"fish", "fisch"},
            {"shrimp", "garnele"},
            {"crab", "krabbe"},
            {"lobster", "hummer"},
            {"oyster", "auster"},
            {"clam", "muschel"},
            {"mussel", "miesmuschel"},
            {"squid", "tintenfisch"},
            {"octopus", "krake"},
            {"scallop", "jakobsmuschel"},
            {"vegetable", "gemuse"},
            {"fruit", "obst"},
            {"potato", "kartoffel"},
            {"carrot", "mohre"},
            {"onion", "zwiebel"},
            {"garlic", "knoblauch"},
            {"lettuce", "salat"},
            {"cabbage", "kohl"},
            {"broccoli", "brokkoli"},
            {"cauliflower", "blumenkohl"},
            {"spinach", "spinat"},
            {"kale", "grunkohl"},
            {"asparagus", "spargel"},
            {"green bean", "grune bohne"},
            {"pea", "erbse"},
            {"corn", "mais"},
            {"tomato", "tomate"},
            {"bell pepper", "paprika"},
            {"chili pepper", "chilischote"},
            {"mushroom", "pilz"},
            {"zucchini", "zucchini"},
            {"cucumber", "gurke"},
            {"eggplant", "aubergine"},
            {"pumpkin", "kurbis"},
            {"squash", "zucchini"},
            {"sweet potato", "susskartoffel"},
            {"yam", "yamswurzel"},
            {"beet", "rote beete"},
            {"radish", "rettich"},
            {"turnip", "rube"},
            {"parsnip", "pastinake"},
            {"rutabaga", "steckruben"},
            {"celery", "sellerie"},
            {"fennel", "fenchel"},
            {"leek", "lauch"},
            {"scallion", "fruhlingszwiebel"},
            {"garlic", "knoblauch"},
            {"ginger", "ingwer"},
            {"turmeric", "kurkuma"},
            {"cinnamon", "zimt"},
            {"clove", "nelke"},
            {"nutmeg", "muskatnuss"},
            {"vanilla", "vanille"},
            {"sugar", "zucker"},
            {"honey", "honig"},
            {"car", "auto"},
            {"house", "haus"},
            {"dog", "hund"},
            {"cat", "katze"},
            {"water", "wasser"},
            {"tree", "baum"},
            {"fire", "feuer"},
            {"book", "buch"},
            {"phone", "telefon"},
            {"light", "licht"},
            {"computer", "rechner"},
            {"music", "musik"},
            {"air", "luft"},
            {"heart", "herz"},
            {"mountain", "berg"},
            {"river", "fluss"},
            {"forest", "wald"},
            {"ocean", "ozean"},
            {"sun", "sonne"},
            {"moon", "mond"}
        };

        for(String[] pair: wordPairs) { addWord(pair[0], pair[1]); }
    }

    public static void addWord(String en, String du){
        en = en.toLowerCase(); du = du.toLowerCase();
        char firstChar = en.charAt(0);
        SortedMap<String, String> innerMap;
        if(map.containsKey(firstChar)) innerMap = map.get(firstChar);
        else innerMap = new TreeMap<>();
        innerMap.put(en, du);
        map.put(firstChar, innerMap);
    }

    public static void printAllWords(){
        map.forEach((k, v)->{ getWordsByLetter(k); });
    }

    public static void getWordsByLetter(char ch){
        ch = Character.toLowerCase(ch);
        SortedMap<String, String> data = map.get(ch);
        if(data == null) data=new TreeMap<>();
        System.out.print(ch + ": [");
        StringBuilder sb = new StringBuilder();
        data.forEach((en, du) -> {
            sb.append("{").append(en).append(" -> ").append(du).append("}, ");
        });
        if(sb.length()>0) sb.setLength(sb.length()-2);
        System.out.println(sb.toString() + "]");
    }

    public static void removeWord(String en){
        en = en.toLowerCase();
        char firstChar = en.charAt(0);
        SortedMap<String, String> innerMap = map.get(firstChar);
        if(innerMap!=null) innerMap.remove(en);
        map.put(firstChar, innerMap);
    }

    public static void searchWord(String en){
        en = en.toLowerCase();
        char firstChar = en.charAt(0);
        SortedMap<String, String> innerMap = map.get(firstChar);
        if(innerMap!=null){
            String du = innerMap.get(en);
            if(du!=null) System.out.println(en + " -> " + du);
            else System.out.println(en + " not found");
        } else {
            System.out.println(en + " not found");
        }
    }
}
