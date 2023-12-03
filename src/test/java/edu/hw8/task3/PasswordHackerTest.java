package edu.hw8.task3;

import edu.hw8.task3.passwordHackers.PasswordHacker;
import edu.hw8.task3.passwordHackers.PasswordHackerAsync;
import edu.hw8.task3.passwordHackers.PasswordHackerMono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class PasswordHackerTest {
    @Test
    public void testSpeed() {
        PasswordHacker passwordHacker = new PasswordHackerMono();
        double startMono = System.currentTimeMillis();
        Map<String, String> crackedMono = passwordHacker.cracked(1, 4);
        double endMono = System.currentTimeMillis();
        passwordHacker = new PasswordHackerAsync();
        double startAsync = System.currentTimeMillis();
        Map<String, String> crackedAsync = passwordHacker.cracked(1, 4);
        double endAsync = System.currentTimeMillis();
        System.out.println(endMono - startMono);
        System.out.println(endAsync - startAsync);
        System.out.println((endMono - startMono) / (endAsync - startAsync));
        System.out.println(crackedMono);
        System.out.println(crackedAsync);
    }

    @Test
    public void testMomo() {
        PasswordHacker passwordHacker = new PasswordHackerMono();
        Map<String, String> crackedMono = passwordHacker.cracked(1, 4);
        Assertions.assertTrue(crackedMono.containsValue("1234"));
        Assertions.assertTrue(crackedMono.containsValue("ABCD"));
        Assertions.assertTrue(crackedMono.containsValue("Dog5"));
        Assertions.assertTrue(crackedMono.containsValue("gg"));
    }

    @Test
    public void testAsync() {
        PasswordHacker passwordHacker = new PasswordHackerAsync();
        Map<String, String> crackedMono = passwordHacker.cracked(1, 4);
        Assertions.assertTrue(crackedMono.containsValue("1234"));
        Assertions.assertTrue(crackedMono.containsValue("ABCD"));
        Assertions.assertTrue(crackedMono.containsValue("Dog5"));
        Assertions.assertTrue(crackedMono.containsValue("gg"));
    }
}
