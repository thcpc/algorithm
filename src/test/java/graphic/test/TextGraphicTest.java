package graphic.test;

import datastructures.graph.TextGraphic;
import org.testng.annotations.Test;
import std.In;

import java.io.*;

public class TextGraphicTest {
    @Test
    public void testTextGraphic() throws IOException {
        In in = new In(new File("src/test/resources/graph/tinyG.txt"));
        TextGraphic graphic = new TextGraphic(in);
        graphic.toString();
    }
}
