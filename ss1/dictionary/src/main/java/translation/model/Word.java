package translation.model;

public class Word {
    String word;
    String mean;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Word(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }
}
