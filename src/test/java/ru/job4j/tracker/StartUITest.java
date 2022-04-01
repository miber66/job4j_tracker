package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

   @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
       Output out = new StubOutput();
       Tracker tracker = new Tracker();
       Item one = tracker.add(new Item("test1"));
       String replaceName = "New Test Name";
       Input in = new StubInput(
               new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
       );
       UserAction[] actions = new UserAction[] {
               new ReplaceAction(out),
               new ExitAction(out)
       };
       new StartUI(out).init(in, tracker, actions);
       String ln = System.lineSeparator();
       assertThat(out.toString(), is(
               "Menu:" + ln
                       + "0. Replace item" + ln
                       + "1. Exit" + ln
                       + "===Edit item===" + ln
                       + "Заявка заменена успешно." + ln
                       + "Menu:" + ln
                       + "0. Replace item" + ln
                       + "1. Exit" + ln
       ));
   }

   @Test
   public void whenShowItemTestOutputIsSuccessful() {
      Output out = new StubOutput();
      Tracker tracker = new Tracker();
      Item one = tracker.add(new Item("test1"));
      Input in = new StubInput(
              new String[] {"0", String.valueOf(one.getId()), "1"}
      );
      UserAction[] actions = new UserAction[] {
              new ShowAction(out),
              new ExitAction(out)
      };
      new StartUI(out).init(in, tracker, actions);
      String ln = System.lineSeparator();
      assertThat(out.toString(), is(
              "Menu:" + ln
                      + "0. Show all items" + ln
                      + "1. Exit" + ln
                      + "===Show all items===" + ln
                      + one + ln
                      + "Menu:" + ln
                      + "0. Show all items" + ln
                      + "1. Exit" + ln
      ));
   }

   @Test
   public void whenFindItemByNameOutputIsSuccessful() {
      Output out = new StubOutput();
      Tracker tracker = new Tracker();
      Item one = tracker.add(new Item("test1"));
      Input in = new StubInput(
              new String[] {"0", one.getName(), "1"}
      );
      UserAction[] actions = new UserAction[] {
              new FindByNameAction(out),
              new ExitAction(out)
      };
      new StartUI(out).init(in, tracker, actions);
      String ln = System.lineSeparator();
      assertThat(out.toString(), is(
              "Menu:" + ln
                      + "0. Find by name" + ln
                      + "1. Exit" + ln
                      + "===Find items by name===" + ln
                      + one + ln
                      + "Menu:" + ln
                      + "0. Find by name" + ln
                      + "1. Exit" + ln
      ));
   }

   @Test
   public void whenFindItemByIdOutputIsSuccessful() {
      Output out = new StubOutput();
      Tracker tracker = new Tracker();
      Item one = tracker.add(new Item("test1"));
      Input in = new StubInput(
              new String[] {"0", String.valueOf(one.getId()), "1"}
      );
      UserAction[] actions = new UserAction[] {
              new FindAction(out),
              new ExitAction(out)
      };
      new StartUI(out).init(in, tracker, actions);
      String ln = System.lineSeparator();
      assertThat(out.toString(), is(
              "Menu:" + ln
                      + "0. Find item" + ln
                      + "1. Exit" + ln
                      + "===Find item by id===" + ln
                      + one + ln
                      + "Menu:" + ln
                      + "0. Find item" + ln
                      + "1. Exit" + ln
      ));
   }
}