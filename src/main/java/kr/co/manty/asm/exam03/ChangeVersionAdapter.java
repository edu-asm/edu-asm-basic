package kr.co.manty.asm.exam03;

import org.objectweb.asm.ClassVisitor;

import static org.objectweb.asm.Opcodes.*;

public class ChangeVersionAdapter extends ClassVisitor {
    public ChangeVersionAdapter(ClassVisitor cv) {
        super(ASM4, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(V9, access, name,signature, superName, interfaces);
    }
}
