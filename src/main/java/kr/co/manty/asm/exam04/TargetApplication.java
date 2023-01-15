package kr.co.manty.asm.exam04;

import java.util.stream.IntStream;

public class TargetApplication {
    public static void main(String[] args) throws Exception {
        PrintService printService = new PrintService();
        IntStream.range(0, 5).forEach(printService::printInt);

        System.out.printf("elapse time: %d ms \n", PrintService.class.getField("timer").get(null));
    }
}