package com.gegaojian;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WordCounter {
    private final Map<String, Long> wordsCounter = new ConcurrentHashMap<>();

    public Long increase(String word){
        Long oldValue;
        Long newValue;
        while (true){
            oldValue = wordsCounter.get(word);
            if(oldValue == null){
                if((oldValue = wordsCounter.putIfAbsent(word, 1L)) == null) return 1L;
            }
            newValue = oldValue + 1;
            if (wordsCounter.replace(word, oldValue, newValue)) return newValue;
        }
    }

    public Long get(String word){
        return wordsCounter.get(word);
    }
}
