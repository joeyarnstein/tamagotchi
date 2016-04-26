public class Tamagotchi {
  public static final int MAX_FOOD = 10;
  public static final int MAX_SLEEP = 10;
  public static final int MAX_ACTIVITY = 10;

  String mName;
  int mFood;
  int mSleep;
  int mActivity;
  String mImage;
  String mAge;

  public Tamagotchi(String name, String age, String img) {
    mAge = age;
    mName = name;
    mFood = MAX_FOOD;
    mSleep = MAX_SLEEP;
    mActivity = MAX_ACTIVITY;
    mImage = "/images/" + img + ".png";
  }
  public String getImage(){
    return mImage;}
  public String getName(){
    return mName;}
    public String getAge(){
      return mAge;}
  public int getFoodLevel(){
    return mFood;}
  public int getSleepLevel(){
    return mSleep;}
  public int getActivityLevel(){
    return mActivity;}

  public boolean isAlive(){
    if (getFoodLevel() > 1){
      return true;
    } else {
      return false;
    }
  }

  // public void setFoodLevel(int number){
  //   if (number > 10 || number < 0){
  //     throw new IllegalArgumentException("Tamagotchi can't eat more than 10 . . . whatevers");
  //   }
  //   mFood = number;
  // }

  public void timePasses(){
    mFood -= 1;
    mSleep -= 1;
    mActivity -=1;
  }

  public void playWithPet(){
    mActivity = MAX_ACTIVITY;}
  public void feedPet(){
    mFood = MAX_FOOD;}
  public void napPet(){
    mSleep = MAX_SLEEP;}


}
