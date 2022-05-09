import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.String;

public class DictionaryManagement {

    private Dictionary dictionaryData;

    public DictionaryManagement(Dictionary d) {
        this.dictionaryData = d;
    }

    public void insertFromFile() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("dictionaries.txt"));
            int wordCount = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < wordCount; i++) {
                String line = sc.nextLine();
                String[] wordList = new String[2];
                wordList = line.split("\t");
                String word_target = wordList[0];
                String word_explain = wordList[1];
                this.dictionaryData.addWord(new Word(word_target, word_explain));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi: Khong tim thay file dictionaries.txt\n");
        }
    }

    public void dictionaryAddWord(String word_target, String word_explain) {
        int sz = this.dictionaryData.getSize();
        if (word_target.trim().isEmpty() || word_explain.trim().isEmpty()) {
            MainFrameAdvance.emptyAdd = true;
        }
        for (int i = 0; i < sz; i++) {
            Word w = this.dictionaryData.getWord(i);
            if (w.getWord_target().equalsIgnoreCase(word_target)) {
                MainFrameAdvance.checkAdd = false;
                break;
            }
        }

        if (!MainFrameAdvance.checkAdd) {
            System.out.println("Tu nay da co trong du lieu");
            System.out.println("Ban co the su dung option 2 de sua tu nay");
            return;
        }
        else if (MainFrameAdvance.emptyAdd) {
            System.out.println("Tu vua nhap khong hop le");
        } else {
            this.dictionaryData.addWord(new Word(word_target, word_explain));
            this.showAllWords();
        }
    }

    public void dictionaryEditWord(String wt, String newWord, String wordMeaning) {

        int sz = this.dictionaryData.getSize();
        for (int i = 0; i < sz; ++i) {
            Word w = this.dictionaryData.getWord(i);
            System.out.print(w.getWord_target() + "   ");
            if (w.getWord_target().equalsIgnoreCase(wt)) {
                MainFrameAdvance.editCheck = true;
                this.dictionaryData.removeWord(w);
                break;
            }
        }
        if (MainFrameAdvance.editCheck) {
            this.dictionaryData.addWord(new Word(newWord, wordMeaning));
            this.dictionaryExportToFile("dictionaries.txt");
        } else System.out.println("ko tim thay tu");

        this.showAllWords();
    }

    public void dictionaryRemoveWord(String t) {
        // remove word
        int sz = this.dictionaryData.getSize();
        for (int i = 0; i < sz; ++i) {
            Word w = this.dictionaryData.getWord(i);
            if (w.getWord_target().equalsIgnoreCase(t)) {
                MainFrameAdvance.removeCheck = true;
                this.dictionaryData.removeWord(w);
                break;
            }
        }
        this.showAllWords();
    }

    // Method: dictionarySearcher(t): searching for words "t*"

    public String dictionarySearcher(String t) {
        String results = "";
        int sz = this.dictionaryData.getSize();
        System.out.printf("%-8s|%-30s|%s\n", "No", "English", "Tieng Viet");

        for (int i = 0, no = 0; i < sz; ++i) {
            Word w = this.dictionaryData.getWord(i);
            if (w.getWord_target().toUpperCase().startsWith(t.toUpperCase()))
                results+= w.getWord_target() + ":    " + w.getWord_explain() +"\n";
        }
        System.out.println(results);
        return results;
    }

    // Method: dictionaryExportToFile(f): export data to file "f"

    public void dictionaryExportToFile(String f) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(f));
            int sz = this.dictionaryData.getSize();
            pw.println(sz);
            for (int i = 0; i < sz; ++i) {
                Word w = this.dictionaryData.getWord(i);
                pw.printf("%s\t%s\n", w.getWord_target(), w.getWord_explain());
            }
            pw.flush();
            System.out.printf("Xuat file %s thanh cong\n", f);
        } catch (IOException e) {
            System.err.println("\nLoi: Khong ghi duoc file");
        }
    }

    public void showAllWords() {
        System.out.printf("%-8s|%-30s|%s\n", "No", "English", "Tieng Viet");
        int size = this.dictionaryData.getSize();
        for (int i = 0; i < size; ++i) {
            String no = String.valueOf(i + 1);            // No. of word
            Word w = this.dictionaryData.getWord(i);    // Word object
            String t = w.getWord_target();                    // word_target
            String e = w.getWord_explain();                    // word_explain
            System.out.printf("%-8s|%-30s|%s\n", no, t, e);
        }
    }
}
