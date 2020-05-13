package dictest;
import java.util.*;

public class SimpleDictionary {
    ArrayList<DicWord> words;
    
    SimpleDictionary() {
        words = new ArrayList<DicWord>();
    }
    int find(String targetWord) {
        int index=-1;
        for(int i=0;i<words.size();++i) {
            if(targetWord.equals(words.get(i).word)) {
                index = i;
            }
        }
        return index;
    }
    String search(String word) {
        if(find(word) == -1) return null;
        else return words.get(find(word)).meaning;
    }
    boolean insert(String word, String meaning) {
        if(find(word) == -1) {
            DicWord dict = new DicWord(word, meaning);
            words.add(dict);
            return true;
        }
        else return false;
    }
    boolean delete(String word) {
        if(find(word) == -1) {
            return false;
        }
        else {
            words.remove(find(word));
            return true;
        }
    }
    void print() {
        for(int i=0;i<words.size();++i) {
            System.out.println(words.get(i).word +", "+ words.get(i).meaning);
        }
    }
}