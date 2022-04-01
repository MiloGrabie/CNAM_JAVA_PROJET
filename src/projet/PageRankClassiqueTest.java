package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageRankClassiqueTest {

    @Test
    void main_success() {
        Configuration configuration = PageRank.configuration("-K 10 -A .90 -K 20 -P -K 30 -C".split(" "));
        assertEquals(configuration.toString(), "alpha=0.9, epsilon=-1.0, indice=30, mode=CREUSE");
    }
}