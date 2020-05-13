package javafinal;

public class Stage {
    protected int score;
    protected int life;
    protected double gauge;
    protected int stageNum;       //0:시작, 1:게임, 2:게임오버, 3:HowToPlay, 4:랭킹
    
    Stage() {
        this.score = 10;
        this.life = 4;
        this.gauge = 0;
        this.stageNum = 0;
    }
    public int getScore() {
        return this.score;
    }
    public double getGauge() {
        return this.gauge;
    }
    public int getLife() {
        return this.life;
    }
    public void setGauge(double gauge) {
        this.gauge = gauge;
    }
    
    
    public void setLife(int life) {
        this.life = life;
    }
    
    public int getStageNum() {
        return this.stageNum;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setStageNum(int stageNum) {
        this.stageNum = stageNum;
    }
}