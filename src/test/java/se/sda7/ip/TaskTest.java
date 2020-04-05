package se.sda7.ip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
  // for positive test
  private Task t1 = new Task();
  // for negative test
  private Task t2 = new Task();

  @Before
  public void setUp() {
    t1.setTitle("do the homework");
    t1.setTaskDone(true);
    t1.setProjectTitle("study java");

    t2.setTitle("buy milk");
    t2.setTaskDone(false);
    t2.setProjectTitle("house work");
  }

  @Test
  public void testGetTitle() {
    Assert.assertTrue(t1.getTitle().equals("do the homework"));
    Assert.assertFalse(t2.getTitle().equals("buy apple"));
  }

  @Test
  public void testIsTaskDone() {
    Assert.assertEquals(t1.isTaskDone(), true);
    Assert.assertEquals(t2.isTaskDone(), false);
  }

  @Test
  public void testGetProjectTitle() {
    Assert.assertTrue(t1.getProjectTitle().equals("study java"));
    Assert.assertFalse(t2.getProjectTitle().equals("home work"));
  }
}
