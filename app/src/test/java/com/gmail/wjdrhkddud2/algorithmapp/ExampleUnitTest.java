package com.gmail.wjdrhkddud2.algorithmapp;

import com.gmail.wjdrhkddud2.algorithmapp.Dijkstra.Dijkstra;

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

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.run(4);


        //assertEquals(4, 2 + 2);
    }
}