package com.company;

public enum Operator {
    LESSTHAN(){
        @Override public boolean apply(int subject, int comparison) {
            return subject < comparison;
        }
    },
    GREATERTHAN(){
        @Override public boolean apply(int subject, int comparison) {
            return subject > comparison;
        }
    };

    Operator() {

    }

    public abstract boolean apply(int x1, int x2);
}
