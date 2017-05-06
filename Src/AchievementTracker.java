import java.util.*;
import java.lang.reflect.*;
/*
* instantiate class in GameEngine 
* takes reference to a single player object
* creates achievements inside the player object
* invoke track() method whenever an event that may unlock an achievement is executed
* AchievementTracker interfaces with Player class to handle achievements
*/

public class AchievementTracker{
   
   Player p;
   ArrayList<Integer> unlocked;
   
   public AchievementTracker(Player p,ArrayList<Integer> unlocked){
      this.p = p;
      // addAchievement in Player should create an achievement object and pass these arguements to its constructer
      // then add this object to the arraylist holding achievement that have not been earned
      // do not forget to create a check method for every achievement added here
      p.addAchievement(1,"Earn 1000 money");
      p.addAchievement(2,"Earn 5000 money");
      p.addAchievement(3,"Earn 1000 drugs");
      p.addAchievement(4,"Earn 5000 drugs");
      p.addAchievement(5,"Launder 1000 money");
      p.addAchievement(6,"Launder 5000 money");
      
      this.unlocked = unlocked;
      unlockAchievements();
      
      //unlocked = new ArrayList<>();
   }
   
   // for every achievement that has not been earned, do a check
   public void track(){
      try {
         for(int i = 0; i < p.getLockedSize();i++){ // size of the array holding unearned achievements
            String mName = "checkForAchievement" + p.getAchievement(i).getID(); // index numbers will not always be equal to the ID
            Class<?> c = this.getClass();
            Method m = c.getMethod(mName);
            m.invoke(this);
         }
         unlockAchievements();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   // tells the player to unlock all the achievments that checked out
   private void unlockAchievements(){
      while(unlocked.size() > 0){
         p.unlockAchievement(unlocked.get(0));
         unlocked.remove(0);
      }
   }
   
   // getMethod() will not be able to find these if they are private
   // for every achievement created, add a method here
   // method's name should start with "checkForAchievement" followed by the ID of that achievement
   // since every achievement has custom its conditions, methods here must be tailored for that achievement
   public void checkForAchievement1(){

      if (p.getMoney() >= 1000)
         unlocked.add(1);
   }
   
   public void checkForAchievement2(){
      if (p.getMoney() >= 5000)
         unlocked.add(2);
   }
   
   public void checkForAchievement3(){
      if (p.getDrug() >= 1000)
         unlocked.add(3);
   }
   
   public void checkForAchievement4(){
      if (p.getDrug() >= 5000)
         unlocked.add(4);
   }
   
   public void checkForAchievement5(){
      if (p.getLaunderedMoney() >= 1000){
         unlocked.add(5);}
   }
   
   public void checkForAchievement6(){
      if (p.getLaunderedMoney() >= 5000)
         unlocked.add(6);
   }
}
