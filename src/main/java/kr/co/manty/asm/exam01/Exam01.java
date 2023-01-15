package kr.co.manty.asm.exam01;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

public class Exam01 {

    public static void main(String[] args) throws IOException {
        ClassPrinter cp = new ClassPrinter();
        ClassReader cr = new ClassReader("java.lang.Runnable");
        cr.accept(cp, 0);
    }
}
