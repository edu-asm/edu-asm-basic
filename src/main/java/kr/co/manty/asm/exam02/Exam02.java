package kr.co.manty.asm.exam02;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;

public class Exam02 extends ClassLoader{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC+ACC_ABSTRACT+ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object",
                new String[]{"kr/co/manty/asm/exam02/Measurable"});
        cw.visitField(ACC_PUBLIC + ACC_FINAL+ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL+ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL+ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();

        Exam02 exam02 = new Exam02();
        Class<?> comparableClass = exam02.defineClass("pkg.Comparable", b, 0, b.length);


    }


}
