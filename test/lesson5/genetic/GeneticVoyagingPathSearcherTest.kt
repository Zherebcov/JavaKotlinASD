package lesson5.genetic

import lesson2.impl.GraphBuilder
import org.junit.Test

import org.junit.Assert.*

class GeneticVoyagingPathSearcherTest {
    @Test
    fun findVoyagingPath() {
        val graph = GraphBuilder().apply {
            val a = addVertex("A")
            val b = addVertex("B")
            val c = addVertex("C")
            val d = addVertex("D")
            val e = addVertex("E")
            val f = addVertex("F")
            addConnection(a, b, 10)
            addConnection(b, c, 15)
            addConnection(c, f, 30)
            addConnection(a, d, 20)
            addConnection(d, e, 25)
            addConnection(e, f, 15)
            addConnection(a, f, 40)
            addConnection(b, d, 10)
            addConnection(c, e, 5)
        }.build()
        val path = GeneticVoyagingPathSearcher(graph).findVoyagingPath(chromosomeNumber = 30, generationNumber = 20)
        assertEquals(105, path.length)
        assertEquals(listOf(graph["A"], graph["D"], graph["B"], graph["C"], graph["E"], graph["F"], graph["A"]),
                path.vertices)
    }

}