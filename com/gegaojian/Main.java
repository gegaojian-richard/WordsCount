package com.gegaojian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {

    Logger logger = Logger.getLogger("WordCounter");

    static volatile Integer finished = 0;

    static final WordCounter wordCounter = new WordCounter();


    public static void main(String[] args) {
	// write your code here
        Logger logger = Logger.getLogger("WordCounter");

        WordCounter wordCounter = new WordCounter();
        ArrayList<Thread> threads = new ArrayList<>(10);

        for(int i = 0; i < 10; ++i) {
            threads.add(new Thread(new Worker(i, wordCounter, finished)));
        }

        for(int i = 0; i < 10; ++i){
            threads.get(i).start();
        }

        while(TerminationToken.getInstance().get() != 10){
            logger.info(Thread.currentThread().getName() + " " + String.valueOf(TerminationToken.getInstance().get()));;
        }
        logger.info("Count of word a : " + wordCounter.get("a"));
    }
}
