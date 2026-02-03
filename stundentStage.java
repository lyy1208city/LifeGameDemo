import java.util.*;

class stundentStage {
    private player player1; 
    private Scanner scanner;

    //con 
    public stundentStage(player player1, Scanner scanner){
        this.player1 = player1;
        this.scanner = scanner;
    }

    public void startStundentStage(){
        System.out.println("現在是第一階 - 學生時期");
        lifeGame.line();
        event1();
        lifeGame.line();
        event2();
        lifeGame.line();
        if (!(player1.getVtc())){
            event3();
        }else{
            event5();
        }
        if(!(player1.getlearningLevel() == 2)){
            lifeGame.line();
            event4();
        }
        lifeGame.line();
        summaryOfStudentStage();
    }

    public void event1(){
        System.out.println("活動1:選科\n 玩家選項: \n A.文科 \n B.理科 \n C.前住職業訓練");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        while(!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
            }else{
                break;
            }
        }
        if (input.equalsIgnoreCase("A")){
            player1.defineHighSchoolSubject("art");
            System.out.println("你已選擇修讀文科");
        }
        else if(input.equalsIgnoreCase("B")){
            player1.defineHighSchoolSubject("science");
            System.out.println("你已選擇修讀理科");
        }
        else if(input.equalsIgnoreCase("C")){
            player1.defineHighSchoolSubject("vtc");
            player1.chooseVtc();
            System.out.println("你已選擇修讀職業訓練");
        }
    }

    public void event2(){
        System.out.println("活動2:日常生活\n 玩家選項: \n A.屋企食 \n B.自己煮 \n C.搵朋友食");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        while(!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
            }else{
                break;
            }
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你今日屋企食");
        }
        else if(input.equalsIgnoreCase("B")){
            System.out.println("你今日自己煮飯食");
        }
        else if(input.equalsIgnoreCase("C")){
            player1.addAchievement("終生好友");
            System.out.println("你今日搵朋友食");
            System.out.println("獲得成就 [終生好友]");
        }
    }

    public void event3(){
        System.out.println("活動3:升讀大學\n 玩家選項: \n A.工程  \n B.商科  \n C.藝術 ");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && !(player1.getHighSchoolSubject().equals("science"))){
                System.out.println("只有選修科為理科才能修讀工程");
                System.out.print("你正在修讀非理科, 請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }

        if (input.equalsIgnoreCase("A")){
            System.out.println("你已修讀工程");
            player1.addLearningLevel(2);
            player1.defineMajor("Engine");
        }
        else if(input.equalsIgnoreCase("B")){
            System.out.println("你已修讀商科");
            player1.addLearningLevel(2);
            player1.defineMajor("Bussine");
        }
        else if(input.equalsIgnoreCase("C")){
            System.out.println("你已修讀藝術 ");
            player1.addLearningLevel(2);
            player1.defineMajor("Art");
        }
    }

    public void event5(){
        System.out.println("活動:學習生活\n 玩家選項: \n A.玩樂  \n B.讀書 ");
        System.out.print("你的選項 (請輸入A,B):");
        String input = ""; 
        while(!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B"))){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B"))){
                System.out.print("無效輸入,請再次輸入(A/B):");
            }else{
                break;
            }
        }
        if(input.equalsIgnoreCase("A")){
            player1.addLearningLevel(1);
            System.out.println("由於你成績未如理想, 無法升讀大學, 準備進入社會");
        }else{
            System.out.println("由於你在職業訓練中的努力,你現在可以升讀大學了");
            event3();
        }
    }

    public void event4(){
        System.out.println("活動4:大學生活 \n 玩家選項: \n A.上莊 \n B.Part-time \n C.讀書");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        while(!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C)");
            }else{
                break;
            }
        }
        if (input.equalsIgnoreCase("A")){
            player1.addAchievement("終生好友");
            System.out.println("獲得成就 [終生好友]");
        }
        else if(input.equalsIgnoreCase("B")){
            player1.addMoneyLevel(1);
            System.out.println("你的財富已升級");
        }
        else if (input.equalsIgnoreCase("C")){
            player1.addAchievement("一級榮譽畢業");
            System.out.println("獲得成就 [一級榮譽畢業]");
        }
    }

    public void summaryOfStudentStage(){
        System.out.println("第一階 - 學生時期已結束");
        System.out.println("在財富上: 你已達level: "+player1.getMoneyLevel());
        if (player1.getlearningLevel() == 2){
            System.out.println("在學歷上: 你已達大專");
        }else{
            System.out.println("在學歷上: 你已達學士");
        }
        if (player1.getAchievement().size() > 0 ){
            for (String ach: player1.getAchievement()){
                System.out.println("你獲得成就 ["+ach+"]");
            }
        }
        System.out.println("你的生命過了22年, 準備前往下一階段 - 成年時期");
    }
}