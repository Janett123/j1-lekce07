package cz.czechitas.lekce7;


import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {


    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
        assertNull(svatky.kdyMaSvatek("Eva"));
        assertNull(svatky.kdyMaSvatek("gugu"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Nataša"));
        assertFalse(svatky.jeVSeznamu("pipi"));

        //Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        //Otestovat, že vrací počet jmen, která máme v seznamu
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());

        //Zkontrolovat, že seznam jmen má správný počet položek.
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
     */


    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Laura", 1, 6);
        assertTrue(svatky.jeVSeznamu("Laura"));
        assertEquals(1, svatky.kdyMaSvatek("Laura").getDayOfMonth());

        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Jarmil", 2, Month.JUNE);
        assertTrue(svatky.jeVSeznamu("Jarmil"));
        assertEquals(2, svatky.kdyMaSvatek("Jarmil").getDayOfMonth());

        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
     */
    @Test
    void pridatSvatekMonthDay() {
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Tamara", MonthDay.of(6, 3));
        svatky.pridatSvatek("Kevin", MonthDay.of(Month.JUNE, 3));
        assertTrue(svatky.jeVSeznamu("Tamara"));
        assertTrue(svatky.jeVSeznamu("Kevin"));
        assertEquals(3, svatky.kdyMaSvatek("Tamara").getDayOfMonth());
        assertEquals(3, svatky.kdyMaSvatek("Kevin").getDayOfMonth());

        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();
        svatky.smazatSvatek("Přemysl");
        assertEquals(36, svatky.getPocetJmen());
        assertFalse(svatky.jeVSeznamu("Přemysl"));

        //Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    }
}
