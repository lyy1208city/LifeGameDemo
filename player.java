import java.util.*;

class player {
    private int moneyLevel;
    private int learningLevel;
    private int lifeLongInTotal; //one display 
    private HashSet<String> achievement = new HashSet<String>(); //value [終生好友, 一級榮譽畢業, 環遊世界,天綸之樂,終生至愛]
    private String major; //value range [Engine, Bussine, Art]
    private boolean vtc;
    private String highSchoolSubject; //value range [art, science, vtc] 
    private HashSet<String> job = new HashSet<String>(); //value range [Engine, IB, Normal, BlueTie, Gov, OwnBus]
    private String housing; //value range [Private, Hos, N]
    
    //con
    public player(){
        this.moneyLevel = 0;
        this.learningLevel = 1;
        this.lifeLongInTotal = 70;
        this.major = "";
        this.highSchoolSubject = "";
        this.vtc = false;
        this.housing = "";
    }

    //Get value 
    public int getMoneyLevel(){
        return moneyLevel;
    }

    public int getlearningLevel(){
        return learningLevel;
    }

    public int getlifeLongInTotal(){
        return lifeLongInTotal;
    }

    public HashSet<String> getAchievement(){
        return achievement; 
    }

    public String getMajor(){
        return major;
    }

    public String getHighSchoolSubject(){
        return highSchoolSubject;
    }

    public boolean getVtc(){
        return vtc;
    }

    public HashSet<String> getJob(){
        return job;
    }

    public String getHousing(){
        return housing;
    }

    //Modifity data 
    public void addMoneyLevel(int value){
        moneyLevel = moneyLevel + value;
    }

    public void minusMoneyLevel(int value){
        moneyLevel = moneyLevel - value;
    }

    public void addLearningLevel(int value){
        learningLevel = learningLevel + value;
    }

    public void addLifeLongInTotal(int value){
        lifeLongInTotal = lifeLongInTotal + value;
    }

    public void addAchievement(String value){
        achievement.add(value);
    }

    public void defineMajor(String value){
        major = value;
    }

    public void chooseVtc(){
        vtc = true;
    }

    public void defineHighSchoolSubject(String value){
        highSchoolSubject = value;
    }

    public void addJob(String value){
        job.add(value);
    }

    public void addHousing(String value){
        housing = value;
    }

    //Summary
    public void Summary(){
        System.out.println("你活了" + lifeLongInTotal + "年");
        System.out.println("你最後財富達到了"+moneyLevel);
        if (learningLevel == 2){
            System.out.println("你最後學歷達到了大專");
        }
        else if (learningLevel == 3){
            System.out.println("你最後學歷達到了學士");
        }else {
            System.out.println("你最後學歷達到了碩士");
        }
        System.out.println("你從事了"+job.size()+"個工作");
        if (job.size() > 0 ){
            for (String j:job){
                if (j.equals("Engine")){
                    j="工程師";
                }else if (j.equals("IB")){
                    j="投資銀行";
                }else if (j.equals("Normal")){
                    j="文職";
                }else if (j.equals("BlueTie")){
                    j="藍領工人";
                }else if (j.equals("Gov")){
                    j="公務員"; 
                }else if (j.equals("OwnBus")){
                    j="創業";
                }
                System.out.println("你曾經的職業包括["+j+"]");
            }
        }
        if (!housing.equals("N")){
            if (housing.equals("Private")){
            System.out.println("你的居所是私人屋苑");
            }else{
            System.out.println("你的居所是居屋");
            }
        }
        System.out.println("你一生中獲得了 "+ achievement.size()+" 個成就");
        if (achievement.size() > 0 ){
            for (String ach:achievement){
                System.out.println("你獲得成就 ["+ach+"]");
            }
        }
    }
}
