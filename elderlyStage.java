import java.util.*;

class elderlyStage {
    private player player1;
    private Scanner scanner; 

    //con 
    public elderlyStage(player player1,Scanner scanner){
        this.player1 = player1;
        this.scanner = scanner;
    }

    public void startElderlyStage(){
        lifeGame.line();
        System.out.println("現在是第三階 - 老年時期");
        lifeGame.line();
        event1();
        lifeGame.line();
        event2();
        lifeGame.line();
        event3();
        lifeGame.line();
        summaryOfElderlyStage();
    }

    public void event1(){
        System.out.println("活動1:日常生活\n 玩家選項: \n A.打麻雀 \n B.湊孫 \n C.散步");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && !(player1.getAchievement().contains("終生好友"))){
                System.out.print("打麻雀需有終生好友才能打, 請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("B") && !(player1.getAchievement().contains("天綸之樂"))){
                System.out.print("你未有生兒育女沒有下一代,請再次輸入(A/B/C):");            
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已選擇打麻雀");
        }
        else if (input.equalsIgnoreCase("B")){
            System.out.println("你已選擇湊孫");
        }
        else if (input.equalsIgnoreCase("C")){
            System.out.println("你已選擇散步");
            player1.addLifeLongInTotal(1);
        }
    }

    public void event2(){
        System.out.println("活動2:急病 \n 玩家選項: \n A.積極治療 \n B.保守治療");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B"))){
                System.out.print("無效輸入,請再次輸入(A/B):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && (!player1.getAchievement().contains("長期服務金"))|| input.equalsIgnoreCase("A") && (player1.getMoneyLevel()<1)){
                System.out.print("你未有足夠的財富A積極治療, 請再次輸入(A/B):");
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已選擇積極治療");
            System.out.println("你的財富已降級");
            player1.minusMoneyLevel(2);
            player1.addLifeLongInTotal(5);
        }
        else if (input.equalsIgnoreCase("B")){
            System.out.println("你已選擇保守治療");
        }
    }
    public void event3(){
        System.out.println("活動3:日常生活 \n 玩家選項: \n A.飲荼 \n B.晨操 \n C.訓多陣");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B):");
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已選擇打飲荼");
        }
        else if (input.equalsIgnoreCase("B")){
            System.out.println("你已選擇晨操");
            player1.addLifeLongInTotal(1);
        }
        else if (input.equalsIgnoreCase("C")){
            System.out.println("你已選擇訓多陣");
        }
    }
    public void summaryOfElderlyStage(){
        System.out.println("第三階 - 老年時期已結束");
        System.out.println("在財富上: 你已達level: "+player1.getMoneyLevel());
        if (player1.getlearningLevel() == 2){
            System.out.println("在學歷上: 你已達大專");
        }
        else if (player1.getlearningLevel() == 3){
            System.out.println("在學歷上: 你已達學士");
        }else{
            System.out.println("在學歷上: 你已達碩士");
        }
        if (player1.getAchievement().size() > 0 ){
            for (String ach: player1.getAchievement()){
                System.out.println("你獲得成就 ["+ach+"]");
            }
        }
        System.out.println("你的生命過了" + player1.getlifeLongInTotal() + "年, 準備前往大結局");
    }
}
