import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void Tamagotchi_instantiatesCorrectly_true() {
    Tamagotchi test = new Tamagotchi("Gatsby");
    assertEquals("Gatsby", test.getName());
    assertEquals(10, test.getFoodLevel());
    assertEquals(10, test.getSleepLevel());
    assertEquals(10, test.getActivityLevel());
  }

  @Test
  public void timePasses_foodDecreasesByOne_9() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.timePasses();
    assertEquals(9, myPet.getFoodLevel());
  }

  @Test
  public void isAlive_foodLevelAbove0_true() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(true, myPet.isAlive());
  }
  // @Test
  // public void isAlive_foodBelow1_false() {
  //   Tamagotchi myPet = new Tamagotchi("lil dragon");
  //   myPet.setFoodLevel(0);
  //   assertEquals(false, myPet.isAlive());
  // }
  @Test
  public void feedPet_foodRefills_10(){
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.timePasses();
    myPet.feedPet();
    assertEquals(10, myPet.getFoodLevel());
    assertEquals(9, myPet.getSleepLevel());
    assertEquals(9, myPet.getActivityLevel());
  }

  @Test
  public void napPet_foodRefills_10(){
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.timePasses();
    myPet.napPet();
    assertEquals(9, myPet.getFoodLevel());
    assertEquals(10, myPet.getSleepLevel());
    assertEquals(9, myPet.getActivityLevel());
  }

  @Test
  public void playWithPet_foodRefills_10(){
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.timePasses();
    myPet.playWithPet();
    assertEquals(9, myPet.getFoodLevel());
    assertEquals(9, myPet.getSleepLevel());
    assertEquals(10, myPet.getActivityLevel());
  }
}
