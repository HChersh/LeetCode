package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import leetcode.JosephRing;
import leetcode.LinkedListRing;
import leetcode.Node;

public class JosephRingTest {     //测试类
    JosephRing jp;
    Node head;
    int m;
    
    @Before
    public void init(){
       jp = new JosephRing();
       head = LinkedListRing.testList1();
       m = 3;
    }
	@Test
	public void testJosePh(){
	  Node answer = jp.josePh(head, m);
      Assert.assertEquals("answer有问题",answer.value,4);
	}

}
