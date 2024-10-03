package org.example;

public class Main {
    public static void main(String[] args) {
        StringCalculator str = new StringCalculator();
        System.out.println(str.add("3,3"));
        System.out.println(str.add("0"));
        System.out.println(str.add(""));
        System.out.println(str.add("//;\n1;2"));
        System.out.println(str.add("1\n2,3"));
        System.out.println(str.add("//[***]\\n1***2***3"));

    }
}