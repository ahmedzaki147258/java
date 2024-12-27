public class Program {
    public static void main(String[] args) {
        Dictionary.addWord("apple", "apfel");
        Dictionary.removeWord("zucchini");
        Dictionary.printAllWords();
        Dictionary.searchWord("apple");
        Dictionary.searchWord("aPpLE");
        Dictionary.getWordsByLetter('a');
    }
}
