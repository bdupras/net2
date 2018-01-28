package net2.karytree;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class KaryTreeTest {
    public void things() throws Exception {
        KaryTree tree = KaryTree.byHeight(5, 5);
        KaryTree.Level level = tree.getLevel(5);
        KaryTree.Node node = tree.getNode(6L);
        System.out.println("tree: " + tree);
        System.out.println("ary: " + tree.getAry());
        System.out.println("height: " + tree.getHeight());
        System.out.println("capacity: " + tree.getCapacity());
        System.out.println("");
        System.out.println("level: " + level);
        System.out.println("nodes: " + level.getNodes());
        System.out.println("");
        System.out.println("node: " + node);
        System.out.println("level: " + node.getLevel());
        System.out.println("parent: " + node.getParent());
        System.out.println("children: " + node.getChildren());
        System.out.println("cousins: " + node.getLevel().getNodes());

        KaryLayout layout = new KaryLayout(tree);
        System.out.println(String.format("layout relX: %.4f", layout.relX(node.getId())));
        System.out.println(String.format("layout relY: %.4f", layout.relY(node.getId())));
    }

    @Test
    public void singleNodeTree() throws Exception {
        IntStream.rangeClosed(2, 12).boxed().forEachOrdered(ary -> {
            KaryTree tree = KaryTree.byHeight(ary, 1);
            assertThat(tree.getCapacity(), equalTo(1L));
            assertThat(tree.getAry(), equalTo(ary));
            assertThat(tree.getHeight(), equalTo(1));
            assertThat(tree.getBase().getId(), equalTo(0));
            assertThat(tree.getBase().getHeight(), equalTo(1));
            assertThat(tree.getBase().getWidth(), equalTo(1L));
            assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(0L));
            assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(0L));
        });
    }


    @Test
    public void tree5x2() throws Exception {
        KaryTree tree = KaryTree.byHeight(5, 2);
        assertThat(tree.getCapacity(), equalTo(6L));
        assertThat(tree.getAry(), equalTo(5));
        assertThat(tree.getHeight(), equalTo(2));
        assertThat(tree.getBase().getId(), equalTo(1));
        assertThat(tree.getBase().getHeight(), equalTo(2));
        assertThat(tree.getBase().getWidth(), equalTo(5L));
        assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(1L));
        assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(5L));
    }

    @Test
    public void tree5x3() throws Exception {
        KaryTree tree = KaryTree.byHeight(5, 3);
        assertThat(tree.getCapacity(), equalTo(31L));
        assertThat(tree.getAry(), equalTo(5));
        assertThat(tree.getHeight(), equalTo(3));
        assertThat(tree.getBase().getId(), equalTo(2));
        assertThat(tree.getBase().getHeight(), equalTo(3));
        assertThat(tree.getBase().getWidth(), equalTo(25L));
        assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(6L));
        assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(30L));
    }


    @Test
    public void tree2x2() throws Exception {
        KaryTree tree = KaryTree.byHeight(2, 2);
        assertThat(tree.getCapacity(), equalTo(3L));
        assertThat(tree.getAry(), equalTo(2));
        assertThat(tree.getHeight(), equalTo(2));
        assertThat(tree.getBase().getId(), equalTo(1));
        assertThat(tree.getBase().getHeight(), equalTo(2));
        assertThat(tree.getBase().getWidth(), equalTo(2L));
        assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(1L));
        assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(2L));
    }

    @Test
    public void tree2x3() throws Exception {
        KaryTree tree = KaryTree.byHeight(2, 3);
        assertThat(tree.getCapacity(), equalTo(7L));
        assertThat(tree.getAry(), equalTo(2));
        assertThat(tree.getHeight(), equalTo(3));
        assertThat(tree.getBase().getId(), equalTo(2));
        assertThat(tree.getBase().getHeight(), equalTo(3));
        assertThat(tree.getBase().getWidth(), equalTo(4L));
        assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(3L));
        assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(6L));
    }

    @Test
    public void tree2x4() throws Exception {
        KaryTree tree = KaryTree.byHeight(2, 4);
        assertThat(tree.getCapacity(), equalTo(15L));
        assertThat(tree.getAry(), equalTo(2));
        assertThat(tree.getHeight(), equalTo(4));
        assertThat(tree.getBase().getId(), equalTo(3));
        assertThat(tree.getBase().getHeight(), equalTo(4));
        assertThat(tree.getBase().getWidth(), equalTo(8L));
        assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(7L));
        assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(14L));
    }

    @Test
    public void treeByCapacity() throws Exception {
        KaryTree tree = KaryTree.byMinCapacity(5, 25L);
        assertThat(tree.getCapacity(), equalTo(31L));
        assertThat(tree.getAry(), equalTo(5));
        assertThat(tree.getHeight(), equalTo(3));
        assertThat(tree.getBase().getId(), equalTo(2));
        assertThat(tree.getBase().getHeight(), equalTo(3));
        assertThat(tree.getBase().getWidth(), equalTo(25L));
        assertThat(tree.getBase().getNodes().getMin().getId(), equalTo(6L));
        assertThat(tree.getBase().getNodes().getMax().getId(), equalTo(30L));
    }

    @Test
    public void treeLayout() throws Exception {
        KaryTree tree = KaryTree.byHeight(2, 4);
        KaryLayout layout = new KaryLayout(tree);

        // Level 0
        assertThat(layout.relX(0), equalTo(1.0 / 2));
        assertThat(layout.relY(0), equalTo(0.0));

        // Level 1
        assertThat(layout.relX(1), equalTo(1.0 / 3));
        assertThat(layout.relX(2), equalTo(2.0 / 3));
        assertThat(layout.relY(1), equalTo(1.0 / 3));
        assertThat(layout.relY(2), equalTo(1.0 / 3));

        //Level 2
        assertThat(layout.relX(3), equalTo(1.0 / 5));
        assertThat(layout.relX(4), equalTo(2.0 / 5));
        assertThat(layout.relX(5), equalTo(3.0 / 5));
        assertThat(layout.relX(6), equalTo(4.0 / 5));
        assertThat(layout.relY(3), equalTo(2.0 / 3));
        assertThat(layout.relY(4), equalTo(2.0 / 3));
        assertThat(layout.relY(5), equalTo(2.0 / 3));
        assertThat(layout.relY(6), equalTo(2.0 / 3));

        //Level 3
        assertThat(layout.relX(7), equalTo(1.0 / 9));
        assertThat(layout.relX(8), equalTo(2.0 / 9));
        assertThat(layout.relX(9), equalTo(3.0 / 9));
        assertThat(layout.relX(10), equalTo(4.0 / 9));
        assertThat(layout.relX(11), equalTo(5.0 / 9));
        assertThat(layout.relX(12), equalTo(6.0 / 9));
        assertThat(layout.relX(13), equalTo(7.0 / 9));
        assertThat(layout.relX(14), equalTo(8.0 / 9));
        assertThat(layout.relY(7), equalTo(3.0 / 3));
        assertThat(layout.relY(8), equalTo(3.0 / 3));
        assertThat(layout.relY(9), equalTo(3.0 / 3));
        assertThat(layout.relY(10), equalTo(3.0 / 3));
        assertThat(layout.relY(11), equalTo(3.0 / 3));
        assertThat(layout.relY(12), equalTo(3.0 / 3));
        assertThat(layout.relY(13), equalTo(3.0 / 3));
        assertThat(layout.relY(14), equalTo(3.0 / 3));
    }

    @Test
    public void byHeightByCapacity() {
        KaryTree tree5H5 = KaryTree.byHeight(5, 5);
        assertThat(tree5H5.getCapacity(), equalTo(781L));
        assertThat(tree5H5.getHeight(), equalTo(5));
        assertThat(tree5H5.getBase().getNodes().getMax().getId(), equalTo(780L));

        KaryTree tree5C781 = KaryTree.byMinCapacity(5, 781L);
        assertThat(tree5C781.getCapacity(), equalTo(781L));
        assertThat(tree5C781.getHeight(), equalTo(5));
        assertThat(tree5C781.getBase().getNodes().getMax().getId(), equalTo(780L));
    }
}
