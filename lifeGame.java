import java.util.*;
public class lifeGame {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        player player1 = new player();
        stundentStage stundentStage1 = new stundentStage(player1,scanner);
        stundentStage1.startStundentStage();
        aldultStage aldultStage1 = new aldultStage(player1,scanner);
        aldultStage1.startAldultStage();
        elderlyStage elderlyStage1 = new elderlyStage(player1,scanner);
        elderlyStage1.startElderlyStage();
        line();
        System.out.println("遊戲結束! 以下是你的人生總結:");
        line();
        player1.Summary();
        scanner.close();
    }

    public static void line(){
        System.out.println("************************************");
    }
}
