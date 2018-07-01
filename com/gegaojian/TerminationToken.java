package com.gegaojian;

public class TerminationToken {
    private volatile int finished = 0;

    private static TerminationToken singleInstance = new TerminationToken();

    private TerminationToken(){}

    public static TerminationToken getInstance(){
        return singleInstance;
    }

    public void add(){
        synchronized (this){
            finished++;
        }
    }

    public int get(){
        return finished;
    }
}
