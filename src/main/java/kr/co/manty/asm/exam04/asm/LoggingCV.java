package kr.co.manty.asm.exam04.asm;


import kr.co.manty.asm.exam04.LogWorker;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.ASM4;

public class LoggingCV extends ClassVisitor {
    public LoggingCV(ClassVisitor cv) {
        super(ASM4, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
//        System.out.printf("visit method ==>");
//        System.out.printf("name: %s, ", name);
//        System.out.printf("descriptor: %s \n", descriptor);

        if ( name.equals("printInt") && descriptor.equals("(I)V")) {
            return new LoggingMV(mv);
        }
        return mv;
    }
}
class LoggingMV extends MethodVisitor {
    private static final String LOG_WORKER = LogWorker.class.getName().replace('.', '/');
    protected LoggingMV(MethodVisitor methodVisitor) {
        super(ASM4, methodVisitor);
    }

    @Override
    public void visitCode() {
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, LOG_WORKER, "log", "(I)V", false);
    }


}