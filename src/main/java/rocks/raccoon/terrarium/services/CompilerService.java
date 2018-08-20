package rocks.raccoon.terrarium.services;

import net.openhft.compiler.CompilerUtils;

import java.util.function.Supplier;

public class CompilerService {
    public String foo() {
        String result = "default value";
        String className = "mypackage.MyClass";
        String javaCode2 = "package mypackage;\n" +
                "import java.util.function.Supplier;\n" +
                "public class MyClass implements Supplier<String> {\n" +
                "    public String get() {\n" +
                "        return \"Hello compiled supplier World\";" +
                "    }\n" +
                "}\n";
        try {
            Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode2);
            Supplier<String> runner = (Supplier<String>) aClass.newInstance();
            result = runner.get();
            System.out.println(result);
        } catch (Exception e) {

        }
        return result;
    }
}
