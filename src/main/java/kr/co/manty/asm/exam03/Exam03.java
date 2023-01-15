package kr.co.manty.asm.exam03;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

public class Exam03 extends ClassLoader {
    public static void main(String[] args) throws IOException {
        Exam03 exam03 = new Exam03();

        long start = System.currentTimeMillis();

        ClassWriter cw = new ClassWriter(0);
        ChangeVersionAdapter adapter = new ChangeVersionAdapter(cw);
        ClassReader cr = new ClassReader("kr.co.manty.asm.exam03.Exam03Target");
        cr.accept(adapter, 0);
        byte[] b2 = cw.toByteArray();

        long end = System.currentTimeMillis();
        System.out.printf("elapsed : %d ms", end -start);
        ClassReader changedCr = new ClassReader(b2);


    }
}
