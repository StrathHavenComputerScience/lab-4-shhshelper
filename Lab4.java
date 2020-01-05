
public class Lab4
{
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }
  
  public static void completeBars()
  {
    int moveTo;
    boolean keepRunning=true;
    while(keepRunning){
        moveTo=checkDark();
        for(int a=moveTo;a>0;a--){
            Robot.makeDark();
            Robot.move();
        }
        turnAround();
        for(int a=moveTo;a>0;a--){
            Robot.move();
        }
        Robot.turnLeft();
        if(Robot.frontIsClear()){
            Robot.move();
        }
        else{
            keepRunning=false;
        }
    }

    
    
  }
  
  public static void testCompleteBars1()
  {
    Robot.load("bars1.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void testCompleteBars2()
  {
    Robot.load("bars2.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void combinePiles()
  {
    int addNum=countLeft();
    turnRight();
    Robot.move();
    Robot.turnLeft();
    if(Robot.onDark()){
        while(Robot.onDark()){
        Robot.move();
    }
}
    for(int b=addNum;b>0;b--){
        Robot.makeDark();
        if(Robot.frontIsClear()){
            Robot.move();
        }
    }
    turnAround();
    while(Robot.frontIsClear()){
        Robot.move();
    }
    turnRight();
    Robot.move();
    turnRight();
  }

  public static void testCombinePiles1()
  {
    Robot.load("piles1.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void testCombinePiles2()
  {
    Robot.load("piles2.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void connectDots()
  {
      while(darkDotCheck()){
          Robot.move();
          Robot.makeDark();
          Robot.move();
        }
}
  
  public static void testConnectDots1()
  {
    Robot.load("connect1.txt");
    Robot.setDelay(0.025);
    //Robot.setDelay(1);
    connectDots();
  }
  
  public static void testConnectDots2()
  {
    Robot.load("connect2.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  public static int checkDark(){
      Robot.turnLeft();
      int darkSquare=0;
      while(!Robot.onDark()){
      if(Robot.frontIsClear()){
      Robot.move();
    }
    darkSquare++;
    }
    turnAround();
    while(Robot.frontIsClear()){
        Robot.move();
    }
    turnAround();
    return darkSquare;
}
public static int countLeft(){
    int numLeft=0;
    boolean leftCleared=false;
    while(Robot.onDark()){
        numLeft++;
        if(Robot.frontIsClear()){
            Robot.move();
        }
        else{
            clearLeft(numLeft);
            leftCleared=true;
        }
    }
    if(!Robot.onDark()&&!leftCleared){
        clearLeft(numLeft);
    }
    return numLeft;
}
public static void clearLeft(int leftCount){
    if(!Robot.onDark()|!Robot.frontIsClear()){
        turnAround();
        for(int i=leftCount;i>0;i--){
            if(Robot.onDark()){
                Robot.makeLight();
            }
            if(Robot.frontIsClear()){
                Robot.move();
            }
        }
        turnAround();
        if(Robot.onDark()){
            Robot.makeLight();
        }
    }
}
public static boolean darkDotCheck(){
    Robot.move();
    Robot.move();
    if(Robot.onDark()){
        turnAround();
        Robot.move();
        Robot.move();
        turnAround();
        return true;
    }
    else{
        turnAround();
        Robot.move();
        Robot.move();
        turnAround();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        if(Robot.onDark()){
            turnAround();
            Robot.move();
            Robot.move();
            turnAround();
            return true;
        }
        else{
            turnAround();
            Robot.move();
            Robot.move();
            Robot.move();
            Robot.move();
            if(Robot.onDark()){
                turnAround();
                Robot.move();
                Robot.move();
                turnAround();
                return true;
            }
            else{
                turnAround();
                Robot.move();
                Robot.move();
                turnAround();
                return false;
    }
}
}
}
}
