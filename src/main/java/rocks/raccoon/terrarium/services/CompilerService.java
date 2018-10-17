package rocks.raccoon.terrarium.services;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import net.openhft.compiler.CompilerUtils;

public class CompilerService {
    public String foo() {
        String result = "default value";
        String className = "mypackage.MyClass";
        String javaCode2 = "package mypackage;\n" +
                "import java.util.function.Function;\n" +
                "import java.util.Map;\n" +
                "public class MyClass implements Function<Map<String, String>, String> {\n" +
                "    public String apply(Map<String, String> values) {\n" +
                "        return \"Hello compiled supplier World\" + values;" +
                "    }\n" +
                "}\n";
        try {
            Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode2);

            Function<Map<String, String>, String> func = (Function<Map<String, String>, String>) aClass.newInstance();
            Map<String, String> values = new HashMap<>();
            values.put("a-a-a", "b-b-b");
            values.put("c-c-c", "d-d-d");

            result = func.apply(values);

            System.out.println(result);
        } catch (Exception e) {
        }

        return result;
    }
}
