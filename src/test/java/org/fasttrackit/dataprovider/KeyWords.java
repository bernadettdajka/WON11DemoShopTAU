package org.fasttrackit.dataprovider;

public class KeyWords {

    private final String keyword1;

    private final String keyword2;


    public KeyWords(String keyword1, String keyword2) {
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    @Override
    public String toString() {
        return "Test run with keywords: "+keyword1+keyword2;
    }
}
