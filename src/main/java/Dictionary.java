import java.util.List;
import java.util.ArrayList;

public class Dictionary {

    private List<Word> dictionary = new ArrayList<Word>();

    public void addWord(Word w) {
            int low = 0, high = this.dictionary.size();
            String t = w.getWord_target();
            while (low < high) {
                int middle = (low + high) / 2;
                String wordMid = this.dictionary.get(middle).getWord_target();
                if (wordMid.compareToIgnoreCase(t) == 0) return;
                if (wordMid.compareToIgnoreCase(t) < 0) low = middle + 1;
                else high = middle;
            }
            if (this.dictionary.size() == 0
                    || low == this.dictionary.size()) {this.dictionary.add(w);}
            else this.dictionary.add(low, w);
    }

    public void removeWord(Word w) {
        this.dictionary.remove(w);
    }

    public int getSize() {
        return this.dictionary.size();
    }

    public Word getWord(int i) {
            Word w = this.dictionary.get(i);
            return w;
    }

}
