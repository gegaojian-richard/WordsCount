package com.gegaojian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;

public class Worker implements Runnable {

    Logger logger = Logger.getLogger("WordCounter");

    int index;

    final WordCounter wordCounter;

    Integer finished;

    public Worker(int index, WordCounter wordCounter, Integer finished){
        this.index = index;
        this.wordCounter = wordCounter;
        this.finished = finished;
    }

    @Override
    public void run() {
        String fileName = "document" + String.valueOf(index) + ".txt";

        logger.info(Thread.currentThread().getName() + " 开始统计" + fileName);
//                    System.out.println(Thread.currentThread().getName() + " 开始统计" + fileName);
        File file = new File("/Users/gegaojian/Downloads/WordsCount/src/com/gegaojian/document" + String.valueOf(index) + ".txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String word = null;
            while((word = br.readLine()) != null){
                wordCounter.increase(word);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        TerminationToken.getInstance().add();

        logger.info(Thread.currentThread().getName() + " 统计结束");
    }
}
