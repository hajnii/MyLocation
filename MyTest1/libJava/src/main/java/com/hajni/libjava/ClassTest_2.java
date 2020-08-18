package com.hajni.libjava;

public class ClassTest_2 extends ClassTest_1 {
    String department;

    ClassTest_2(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public void getInfomation() {
        String name = super.getName();
        int salary = super.getSalary();
        System.out.println("name : " + name + ", Salary : " + salary + ", department : " + department);
//        super.getInfomation();
//        System.out.println("department : " + department);
    }

    public static void main(String[] args) {

        ClassTest_1 tet1 = new ClassTest_2("Mike",3000,"Edu");
        tet1.getInfomation();
    }
}
