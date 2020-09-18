package br.edu.oprofvalmor.contatos;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void teste01() {
        Contato c = new Contato("valmor", "123");
        int soma = c.somar(3,2);

        assertEquals(5, soma);
        assertEquals("valmor", c.nome);
        assertEquals("123", c.horario);

    }
}