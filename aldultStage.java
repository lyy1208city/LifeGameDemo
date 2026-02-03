import java.util.*;

class aldultStage {
    private player player1;
    private Scanner scanner; 

    //con 
    public aldultStage(player player1, Scanner scanner){
        this.player1 = player1;
        this.scanner = scanner;
    }

    public void startAldultStage(){
        lifeGame.line();
        System.out.println("現在是第二階 - 成年時期");
        lifeGame.line();
        event1();
        lifeGame.line();
        event2();
        lifeGame.line();
        event3();
        lifeGame.line();
        event4();
        lifeGame.line();
        event5();
        lifeGame.line();
        event6();
        lifeGame.line();
        summaryOfAldultStage();
    }

    public void event1(){
        System.out.println("活動1:求職\n 玩家選項: \n A.工程公司 \n B.投資銀行 \n C.文職 \n D.藍領");
        System.out.print("你的選項 (請輸入A,B,C,D):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C")||input.equalsIgnoreCase("D"))){
                System.out.print("無效輸入,請再次輸入(A/B/C/D):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && !(player1.getMajor().equalsIgnoreCase("Engine"))){
                System.out.print("公司要求畢業生大學主修為工程, 請再次輸入(A/B/C/D):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("B") && !(player1.getAchievement().contains("一級榮譽畢業"))){
                System.out.print("公司要求畢業生需有優異成績,固未被聘請,請再次輸入(A/B/C/D):");            
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已就職工程公司");
            player1.addMoneyLevel(2);
            player1.addJob("Engine");
        }
        else if (input.equalsIgnoreCase("B")){
            System.out.println("你已就職投資銀行");
            player1.addMoneyLevel(3);
            player1.addJob("IB");
        }
        else if(input.equalsIgnoreCase("C")){
            System.out.println("你已就職文職");
            player1.addMoneyLevel(1);
            player1.addJob("Normal");
        }
        else if(input.equalsIgnoreCase("D")){
            System.out.println("你已就職藍領");
            player1.addMoneyLevel(1);
            player1.addJob("BlueTie");
        }
    }

    public void event2(){
        System.out.println("活動2:日常生活\n 玩家選項:\n A.健身 \n B.進修 \n C.旅行");
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
            System.out.println("你已選擇健身");
            System.out.println("你的健康已升級");
            player1.addLifeLongInTotal(5);
        }
        else if (input.equalsIgnoreCase("B")){
            System.out.println("你已選擇進修");
            System.out.println("你的學歷與財富已升級");
            player1.addMoneyLevel(1);
            player1.addLearningLevel(1);
        }
        else if(input.equalsIgnoreCase("C")){
            System.out.println("你已選擇旅行");
            System.out.println("你的財富已降級");
            System.out.println("獲得成就 [環遊世界]");
            player1.addAchievement("環遊世界");
            player1.minusMoneyLevel(1);
        }
    }

    public void event3(){
        System.out.println("活動3:轉工\n 玩家選項: \n A.公務員 \n B.創業 \n C.不轉工");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && (player1.getlearningLevel() < 4)){
                if (player1.getlearningLevel() == 2){
                    System.out.print("公務員要求碩士學歷, 你目前為大專學歷, 固未被聘請, 請再次輸入(A/B/C):");
                } else{
                    System.out.print("公務員要求碩士學歷,你目前為學士學歷, 固未被聘請, 請再次輸入(A/B/C):");
                }
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已選擇成為公務員");
            player1.addMoneyLevel(2);
            player1.addAchievement("長期服務金");
            player1.addJob("Gov");
        }
        else if (input.equalsIgnoreCase("B")){
            System.out.println("你已選擇創業");
            if (Math.random() < 0.5){
                System.out.println("你創業失敗");
                System.out.println("你的財富已歸零");
                player1.minusMoneyLevel(player1.getMoneyLevel());
            }else{
                System.out.println("你創業成功");
                System.out.println("你的財富已升級");
                player1.addMoneyLevel(4);
            }
            player1.addJob("OwnBus");
        }
        else if(input.equalsIgnoreCase("C")){
            System.out.println("你已選擇維持現況");
        } 
    }

    public void event4(){
        System.out.println("活動4:置業\n 玩家選項: \n A.私人樓宇 \n B.居屋 \n C.不置業");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && (player1.getMoneyLevel() < 5)){
                System.out.print("你未有足夠的財富購買私人樓宇,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("B") && (player1.getMoneyLevel() < 2)){
                System.out.print("你未有足夠的財富購買居屋 ,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已購入私人樓宇");
            player1.addHousing("Private");
        }
        else if(input.equalsIgnoreCase("B")){
            System.out.println("你已購入居屋");
            player1.addHousing("Hos");
        }
        else if (input.equalsIgnoreCase("C")){
            System.out.println("你沒有置業");
            player1.addHousing("N");
        }
    }

    public void event5(){
        System.out.println("活動5:日常生活\n 玩家選項: \n A.中同聚會 \n B.學下烘培 \n C.睇演唱會");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已選擇中同聚會");
            player1.addAchievement("終生好友");
            System.out.println("獲得成就 [終生好友]");
        }
        else if(input.equalsIgnoreCase("B")){
            System.out.println("你已選擇學習烘培");
        }else if(input.equalsIgnoreCase("C")){
            System.out.println("你已選擇看演唱會");
        }
    }

    public void event6(){
        System.out.println("活動6:組織家庭\n 玩家選項: \n A.生兒育女 \n B.丁克 \n C.單身");
        System.out.print("你的選項 (請輸入A,B,C):");
        String input = ""; 
        boolean valueCorrect = true;
        while(valueCorrect){
            input = scanner.nextLine().trim();
            if (!(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("B")||input.equalsIgnoreCase("C"))){
                System.out.print("無效輸入,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (input.equalsIgnoreCase("A") && (player1.getMoneyLevel() < 2)){
                System.out.print("你未有足夠的財富生兒育女,請再次輸入(A/B/C):");
                valueCorrect = false;
            }
            if (valueCorrect){
                break;
            }
            valueCorrect = true;
        }
        if (input.equalsIgnoreCase("A")){
            System.out.println("你已選擇生兒育女");
            System.out.println("獲得成就 [終生好友]");
            System.out.println("你的財富已降級");
            player1.addAchievement("天綸之樂");
            player1.minusMoneyLevel(2);
        }
        else if(input.equalsIgnoreCase("B")){
            System.out.println("你已選擇丁克");
            System.out.println("獲得成就 [終生至愛]");
            player1.addAchievement("終生至愛");
        }
        else if (input.equalsIgnoreCase("C")){
            System.out.println("你已選擇單身");
        }
    }

    public void summaryOfAldultStage(){
        System.out.println("第二階 - 成年時期已結束");
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
        System.out.println("你的生命過了62年, 準備前往下一階段 - 老年時期");
    }
}
