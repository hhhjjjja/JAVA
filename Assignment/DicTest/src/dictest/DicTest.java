package dictest;

public class DicTest {
    public static void main(String[] args) {
        SimpleDictionary sdic = new SimpleDictionary();
        sdic.insert("apple", "The round fruit of a tree of the rose family, which typically has thin green or red skin and crisp flesh.");
        sdic.insert("banana", "A long curved fruit which grows in clusters and has soft pulpy flesh and yellow skin when ripe.");
        System.out.println(sdic.search("apple"));
//      sdic.print();
        System.out.println(sdic.search("grape"));
//      System.out.println(sdic.delete("banana"));
    }
}