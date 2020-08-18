package com.hajni.libjava;

public class Student extends Person {
    private String[] subjects;

    void print_subjecs(){
        System.out.println(name + "'s sbject");
        for(int i = 0; i < subjects.length; i++){
            System.out.println("subject : "+ subjects[i]);
        }
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
