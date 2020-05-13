package bookdbtest;

public class BookDB {
    String [] book;
    String name;
    int bookcnt;
    BookDB() {
        book = new String[10];
        for(int i=0;i<book.length;++i) {
            book[i] = null;
        }
        bookcnt=0;
    }
    boolean addBook(String name) {
        if(bookcnt > 9) {
            System.out.println("공간이 없습니다.");
            return false;
        }
        for(int i=0;i<book.length;++i) {
            if(book[i] == null) {
                book[i] = name;
                ++bookcnt;
                return true;
            }
        }
        return true;
    }
    boolean deleteBook(String name) {
        this.name = name;
        for(int i=0;i<book.length;++i) {
            if(book[i]!=null && book[i].equals(name)) {
                book[i] = null;
                --bookcnt;
                return true;
            }
        }
        return false;
    }
    public int size() {
        return bookcnt;
    }
    void printBooks() {
        int cnt=0;
        for(int i=0;i<book.length;++i) {            
            if(book[i] != null) {
                ++cnt;
                System.out.println(cnt +". " + book[i]);
            }
        }
    }
}
