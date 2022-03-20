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
        dijkstra.addWeight(0, 3, 5);
        dijkstra.addWeight(0, 8, 8);
        dijkstra.addWeight(0, 1, 3);
        dijkstra.addWeight(1, 2, 5);
        dijkstra.addWeight(1, 9, 4);
        dijkstra.addWeight(2, 7, 6);
        dijkstra.addWeight(2, 5, 2);
        dijkstra.addWeight(3, 9, 1);
        dijkstra.addWeight(3, 6, 6);
        dijkstra.addWeight(4, 3, 2);
        dijkstra.addWeight(4, 7, 3);
        dijkstra.addWeight(5, 8, 4);
        dijkstra.addWeight(5, 2, 3);
        dijkstra.addWeight(6, 9, 8);
        dijkstra.addWeight(7, 1, 2);
        dijkstra.addWeight(7, 6, 5);
        dijkstra.addWeight(8, 3, 3);
        dijkstra.addWeight(9, 2, 9);
        dijkstra.addWeight(9, 4, 4);;

        dijkstra.run(4);


        //assertEquals(4, 2 + 2);
    }
}