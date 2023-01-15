package kr.co.manty.asm.exam04;

import kr.co.manty.asm.exam04.asm.ElapseTimeCV;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Exam04Agent {
    public static void premain(String agentArgs, Instrumentation inst) {

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] b) {
                if ( !"kr/co/manty/asm/exam04/PrintService".equals(className)) {
                    ClassReader cr = new ClassReader(b);
                    ClassWriter cw = new ClassWriter(cr, 0);
                    ClassVisitor cv = new LoggingCV(cw);
                    cr.accept(cv,  ClassReader.EXPAND_FRAMES);
                    return cw.toByteArray();
                }else{
                    ClassReader cr = new ClassReader(b);
                    ClassWriter cw = new ClassWriter(cr, 0);
                    ElapseTimeCV cv = new ElapseTimeCV(cw);
                    cr.accept(cv,  ClassReader.EXPAND_FRAMES);
                    return cw.toByteArray();
                }
            }
        });

    }
}
