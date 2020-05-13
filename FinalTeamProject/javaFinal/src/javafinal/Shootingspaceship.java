/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

public class Shootingspaceship extends JPanel implements Runnable {

    
    
    
    private ImageIcon icon;
    private Stage stage;
    private PointIcon pointicon;
    private BgmPlay bgmplay;
    private EffectSound se;
    private boolean bgmloop;
    private Ranking rankclass;
    private JButton savebtn;
    
    private Thread th;
    private Player player;
    private Shot[] shots;
    private Bomb bombs;
    
    
    
    
//    private ArrayList enemies; // 기존
    //추가
    private Shot[] shots2;
    private Shot[] shots3;
    private Shot[] shots4;
    private Shot[] bossShot;
    private ArrayList enemies;
    private ArrayList smallEnemies;
    
    private ArrayList bigEnemies;
    private Enemy enemy; //적 객체
    private smallEnemy sEnemy; //적2 객체
    
    private BossEnemy bossEnemy; //보스 객체
    
    private BigEnemy bEnemy; // 큰 적 객체
    
    private boolean enemyCheck = true; //일반적 객체 생성시 체크값
    private boolean senemyCheck = true; //작은적 객체 생성시 체크값
     private boolean benemyCheck = true; //큰 적 객체 생성시 체크값
    private int cnt;
    //
    
    //invincible 추가부분
    
    private boolean invincible = true;
    private int invincibleTime = 300;
    private int invincibleTimer = 0;
    private boolean bombBool = false;
    private int bombTime = 200;
    private int bombTimer = 0;
    
    //
    
    //이미지
    
    Image playerImage;
    Image invincibleImage;
    
    //
    
    
    //item
    
    private ArrayList items;
    private Item item;
 
    private int bossHp = 1000;
    boolean changeBgm = false;
    
    
    //
    private final int shotSpeed = -5;
    private final int playerLeftSpeed = -4;
    private final int playerRightSpeed = 4;
    private final int playerUpSpeed = -4;//추가
    private final int playerDownSpeed = 4;//추가
    private final int width = 900;
    private final int height = 700;
    private final int playerMargin = 10;
    private final int enemyMaxDownSpeed = 1;
    private final int enemyMaxHorizonSpeed = 1;
    private final int enemyTimeGap = 5000; //unit: msec
    private final float enemyDownSpeedInc = 0.3f;
    private final int maxEnemySize = 10;
    private int enemySize;
    private javax.swing.Timer timer;
    private boolean playerMoveLeft;
    private boolean playerMoveRight;
    private boolean playerMoveUp;
    private boolean playerMoveDown;
    private boolean playerShot;
    private Image dbImage;
    private Graphics dbg;
    private Random rand;
    
    
    private int maxShotNum = 50;
    private int bombNumb = 3;
    private final int shotRate = 75; // 플레이어 연사 속도
    private javax.swing.Timer playerShotTimer;
    

    public Shootingspaceship() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(width, height));
        
        
        stage = new Stage();
        pointicon = new PointIcon();
        bgmplay = new BgmPlay();
        bgmloop = true;
        rankclass = new Ranking();
        se = new EffectSound();
        
        
        //player 생성자 변경
        player = new Player(width / 2 - 170, (int) (height * 0.9), playerMargin, (width-300)-playerMargin,playerMargin,height-playerMargin );
        shots = new Shot[ maxShotNum ];
        //enemies = new ArrayList();
        
        //
        bossEnemy = new BossEnemy(200, 85, (float) -2.0, (float) 0.5, width-400, height, enemyDownSpeedInc); //보스 생성
        enemies = new ArrayList();
        smallEnemies = new ArrayList(); //두번째 적
         bigEnemies = new ArrayList(); //큰적 Array
        items = new ArrayList();
        shots2 = new Shot[8];
        shots3 = new Shot[6];
        shots4 = new Shot[12]; //큰적 총알
        bossShot = new Shot[30]; //보스 총알
        //
        
        
        
        
        enemySize = 0;
        rand = new Random(1);
        //timer = new javax.swing.Timer(enemyTimeGap, new addANewEnemy());
        //timer.start();
        playerShotTimer = new javax.swing.Timer(shotRate, new playerShooting());
        addKeyListener(new ShipControl());
        setFocusable(true);
    }

    public void start() {
        th = new Thread(this);
        
        bgmplay.playMusic("src/resourcepack/music_background.wav", bgmloop);           //배경음악 반복재생
        th.start();
    }

    
    //적기 생성 코드
    /*
    private class addANewEnemy implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(stage.getStageNum() == 1) { 
            if (++enemySize <= maxEnemySize) {
                float downspeed;
                do {
                    downspeed = rand.nextFloat() * enemyMaxDownSpeed;
                } while (downspeed == 0);

                float horspeed = rand.nextFloat() * 2 * enemyMaxHorizonSpeed - enemyMaxHorizonSpeed;
                //System.out.println("enemySize=" + enemySize + " downspeed=" + downspeed + " horspeed=" + horspeed);

                Enemy newEnemy = new Enemy((int) (rand.nextFloat() * (width-300)), 0, horspeed, downspeed, width-300, height, enemyDownSpeedInc);
                enemies.add(newEnemy);
            } else {
                timer.stop();
            }
            }
        }
    }
*/
    
    //캐릭터 컨트롤링
    private class ShipControl implements KeyListener {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    playerMoveLeft = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    playerMoveRight = true;
                    break;
                case KeyEvent.VK_Z:
                    // generate new shot and add it to shots array
                    /*for (int i = 0; i < shots.length; i++) {
                        if (shots[i] == null) {
                            shots[i] = player.generateShot();
                            break;
                        }
                    }*/
                    playerShotTimer.start();
                    //playerShot = true;
                    break;
                case KeyEvent.VK_X:
                    if(bombNumb !=0&&stage.getGauge()>=1.0f)
                    {
                        se.SE("bomb_use");
                        stage.setGauge(stage.getGauge()-1.0f);
                        bombBool = true;
                        invincible = true;
                        bombs = player.generateBomb();
                    }
                    break;
                    
                case KeyEvent.VK_UP:
                    if(stage.getStageNum() == 1) 
                    playerMoveUp = true;
                    
                    else if(stage.getStageNum() == 0) {            //시작화면 메뉴선택화면
                        if(pointicon.iconpos == 0) {            //게임시작버튼에있는데 위로 누르면 밑에 하우투로
                            pointicon.iconpos = 1;
                            se.SE("se_plst00");
                        }
                        else{
                            se.SE("se_plst00");
                            pointicon.iconpos = 0;}
                    }
                    else if(stage.getStageNum() == 2) {
                        if(pointicon.iconpos == 0) {
                            se.SE("se_plst00");
                            pointicon.iconpos = 3;
                        }
                        else{
                            se.SE("se_plst00");
                            --pointicon.iconpos;}
                    }
                   
                    break;
                case KeyEvent.VK_DOWN:
                    if(stage.getStageNum() == 1)
                    playerMoveDown = true;
                    
                    else if(stage.getStageNum() == 0) {
                        if(pointicon.iconpos == 1) {                    //제일밑에버튼에 있을때 아래로누르면 위로 순환
                            pointicon.iconpos = 0;
                            se.SE("se_plst00");
                        }
                        else{
                            se.SE("se_plst00");
                            pointicon.iconpos = 1;}
                    }
                    else if(stage.getStageNum() == 2) {
                        if(pointicon.iconpos == 3) {
                            se.SE("se_plst00");
                            pointicon.iconpos = 0;
                        }
                        else {
                            se.SE("se_plst00");
                            ++pointicon.iconpos;
                        }
                    }
                    break;
                    
                    case KeyEvent.VK_ENTER:
                    if(stage.getStageNum() == 0) {
                        if(pointicon.iconpos == 0) {
                                
                            changeBgm=true;
                            stage.setStageNum(1);
                            
                        }
                        else if(pointicon.iconpos == 1)
                        {
                            changeBgm=true;
                            stage.setStageNum(3);}
                    }
                    else if(stage.getStageNum() == 2) {
                        if(pointicon.iconpos == 0){
                            changeBgm=true;
                            stage.setStageNum(0);}
                        else if(pointicon.iconpos == 1) {
                            rankclass.saveText(stage);
                        }
                        else if(pointicon.iconpos == 2) {
                            rankclass.readText();
                            stage.setStageNum(4);
                        }
                        else if(pointicon.iconpos == 3)
                            System.exit(0);
                    }
                    else if(stage.getStageNum()==4)
                    {
                        changeBgm=true;
                        stage.setStageNum(2);
                    }
                    else {       //게임오버화면, 게임방법화면에서 엔터치면 처음화면
                        stage.setStageNum(0);
                        
                    }
                    break;
                    
            }
        }
        
        

        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    playerMoveLeft = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    playerMoveRight = false;
                    break;
                case KeyEvent.VK_UP:
                    playerMoveUp = false;
                    break;
                case KeyEvent.VK_DOWN:
                    playerMoveDown = false;
                    break;
                case KeyEvent.VK_Z:
                    playerShotTimer.stop();
                    break;
            }
        }

        public void keyTyped(KeyEvent e) {
        }
    }
    
    /**
     *
     */
    //플레이어 연사 코드
    private class playerShooting implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < shots.length; i++) {
                        if (shots[i] == null) {
                            se.SE("player_shoot");
                            shots[i] = player.generateShot();
                            break;
        }
        }
    }
    }
    
    
    //
   public void EnemyShooting(Shot[] shots, int shotSpeed){
    	for (int i = 0; i < shots.length; i++) {
            if (shots[i] != null) {
                // move shot
                 //se.SE("enemy_shoot");
                shots[i].moveShot(shotSpeed);
                // test if shot is out
                if (shots[i].getY() > 700) {
                    // remove shot from array
                    shots[i] = null;
                }
            }
        }
    }
   public void BossEnemyShooting(Shot[] shots, int shotSpeed){
    	for (int i = 0; i < shots.length; i++) {
            if (shots[i] != null) {
                // move shot
                //se.SE("enemy_shoot");
                shots[i].moveShot(shotSpeed);
                // test if shot is out
                if (shots[i].getY() > 700) {
                    // remove shot from array
                    shots[i] = null;
                }
            }
        }
    }

   
    //
    

    public void run() {
        //int c=0;
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        while (true) {
            //System.out.println( ++c );
            // do operations on shots in shots array
            for (int i = 0; i < shots.length; i++) {
                if (shots[i] != null) {
                    // move shot
                    shots[i].moveShot(shotSpeed);

                    // test if shot is out
                    if (shots[i].getY() < 0) {
                        // remove shot from array
                        shots[i] = null;
                    }
                }
            }
            if(changeBgm==true)
            {
                switch(stage.getStageNum())
                {
                    case 0:
                        bgmplay.stopMusic();
                        bgmplay.playMusic("src/resourcepack/music_background.wav", bgmloop);
                        changeBgm= false;
                        break;
                    case 1:
                         bgmplay.stopMusic();
                        bgmplay.playMusic("src/resourcepack/music_background.wav", bgmloop);
                        changeBgm= false;
                        break;
                    case 2:
                         bgmplay.stopMusic();
                        bgmplay.playMusic("src/resourcepack/music_background.wav", bgmloop);
                        changeBgm= false;
                        break;
                    
                }
            }
            
            
            
            //
            if(stage.getStageNum() == 1) { 
                cnt++;
                if(cnt>7000 && bossEnemy != null){
            		createBossEnemy();
                	BossEnemyShooting(bossShot, 5); //보스 공격
            	}
                createEnemy();
                createSmallEnemy();
                
            	createBigEnemy();
                EnemyShooting(shots2, 5);//적 공격
                EnemyShooting(shots3, 4);//적2 공격
                EnemyShooting(shots4, 3);//적3 공격
            }
            //
            
            
            if(invincible == true)
            {
                invincibleTimer++;
            }
            if(invincibleTimer>invincibleTime)
            {
                invincibleTimer = 0;
                invincible = false;
            }
            
            if(bombBool == true)
            {
                bombTimer++;
            }
            if(bombTimer>bombTime)
            {
                bombTimer = 0;
                bombs = null;
                bombBool = false;
            }
            
            
            
            
            if (bombs != null) {
                    // move shot
                    bombs.bombShot(-1);
            }

            if (playerMoveLeft) {
                player.moveX(playerLeftSpeed);
            } else if (playerMoveRight) {
                player.moveX(playerRightSpeed);
            }
            if (playerMoveUp) {
                player.moveY(playerUpSpeed);
            } else if (playerMoveDown) {
                player.moveY(playerDownSpeed);
            }
            
            
            
            
            

            Iterator enemyList = enemies.iterator();
            while (enemyList.hasNext()) {
                Enemy enemy = (Enemy) enemyList.next();
                enemy.move();
            }
            
            Iterator itemList = items.iterator();
            while (itemList.hasNext()) {
                //Enemy enemy = (Enemy) enemyList.next();
                //enemy.move();
                float i = 1.0f;
                Item item = (Item) itemList.next();
                item.move(i);
                if(item.y_pos<0.0f)
                    itemList.remove();
            }
            
            repaint();

            try {
                Thread.sleep(10);
                
            } catch (InterruptedException ex) {
                // do nothing
            }

            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
    }
    public void createEnemy(){    	
    	for (int i = 0 ; i < enemies.size() ; ++i ){ 
    		enemy = (Enemy)(enemies.get(i)); //배열에 적이 생성되어있을 때 해당되는 적을 판별
    		enemy.move(); //해당 적을 이동시킨다.
    		if(enemy.y_pos > 699){ //적의 좌표가 화면 밖으로 넘어가면
    			enemies.remove(i); // 해당 적을 배열에서 삭제
    		}
    	} 
    	
    	
        if (cnt % 300 == 0 && cnt < 1000){
        	if (enemyCheck == false){
        		for(int i=1; i<5; ++i){
        			enemy = new Enemy((int)((width-300)*(i*0.1)), 0, (float) 0.8, (float) 0.8, width-300, height, enemyDownSpeedInc);
        			enemies.add(enemy);
        	        for (int j = 0; j < shots2.length; j++) {
        	            if (shots2[j] == null) {
        	                shots2[j] = enemy.generateShot();
        	                break;
        	            }
        	        }
        		}
        		for(int i=1; i<5; ++i){
        			enemy = new Enemy((int)((width-300)*(i*0.1)), 50, (float) 0.8, (float) 0.8, width-300, height, enemyDownSpeedInc);
        			enemies.add(enemy);
        			for (int j = 0; j < shots2.length; j++) {
        	            if (shots2[j] == null) {
        	                shots2[j] = enemy.generateShot();
        	                break;
        	            }
        	        }
        		}
                enemyCheck = true;
        	}
        	else{
        		for(int i=9; i>5; --i){
        			enemy = new Enemy((int)((width-300)*(i*0.1)), 0, (float) -0.8, (float) 0.8, width-300, height, enemyDownSpeedInc);
        			enemies.add(enemy);
        			for (int j = 0; j < shots2.length; j++) {
        	            if (shots2[j] == null) {
        	                shots2[j] = enemy.generateShot();
        	                break;
        	            }
        	        }
        		}
        		for(int i=9; i>5; --i){
        			enemy = new Enemy((int)((width-300)*(i*0.1)), 50, (float) -0.8, (float) 0.8, width-300, height, enemyDownSpeedInc);
        			enemies.add(enemy);
        			for (int j = 0; j < shots2.length; j++) {
        	            if (shots2[j] == null) {
        	                shots2[j] = enemy.generateShot();
        	                break;
        	            }
        	        }
        		}
                enemyCheck = false;
        	}
        }
    }
    
    //smallEnemy 생성
    public void createSmallEnemy(){    	
    	for (int i = 0 ; i < smallEnemies.size() ; ++i ){ 
    		sEnemy = (smallEnemy)(smallEnemies.get(i)); //배열에 적이 생성되어있을 때 해당되는 적을 판별
    		sEnemy.move(); //해당 적을 이동시킨다.
    		if(sEnemy.y_pos > 699){ //적의 좌표가 화면 밖으로 넘어가면
    			smallEnemies.remove(i); // 해당 적을 배열에서 삭제
    		}
    	}
        
        if (cnt % 500 == 0 && 1499 < cnt && cnt < 5000){
        	if (senemyCheck == true){
        		for(int i=1; i<4; ++i){
        			sEnemy = new smallEnemy((int)((width-300)*(i*0.1)), 0, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
                    smallEnemies.add(sEnemy);
                    for (int j = 0; j < shots3.length; j++) {
        	            if (shots3[j] == null) {
        	            	shots3[j] = sEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
        		for(int i=1; i<4; ++i){
        			sEnemy = new smallEnemy((int)((width-300)*(i*0.1)), 50, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
                    smallEnemies.add(sEnemy);
                    for (int j = 0; j < shots3.length; j++) {
        	            if (shots3[j] == null) {
        	            	shots3[j] = sEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
                senemyCheck = false;
        	}
        	else{
        		for(int i=9; i>6; --i){
        			sEnemy = new smallEnemy((int)((width-300)*(i*0.1)), 0, (float) -0.5, (float) 0.5, (width-300), height, enemyDownSpeedInc);
                    smallEnemies.add(sEnemy);
                    for (int j = 0; j < shots3.length; j++) {
        	            if (shots3[j] == null) {
        	                shots3[j] = sEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
        		for(int i=9; i>6; --i){
        			sEnemy = new smallEnemy((int)((width-300)*(i*0.1)), 50, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
                    smallEnemies.add(sEnemy);
                    for (int j = 0; j < shots3.length; j++) {
        	            if (shots3[j] == null) {
        	                shots3[j] = sEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
                senemyCheck = true;
        	}
        }
    }
    
    public void createBigEnemy(){    	
    	for (int i = 0 ; i < bigEnemies.size() ; ++i ){ 
    		bEnemy = (BigEnemy)(bigEnemies.get(i)); //배열에 적이 생성되어있을 때 해당되는 적을 판별
    		bEnemy.move(); //해당 적을 이동시킨다.
    		if(bEnemy.y_pos > 699){ //적의 좌표가 화면 밖으로 넘어가면
    			bigEnemies.remove(i); // 해당 적을 배열에서 삭제
    		}
    	}
        
        if (cnt % 400 == 0 && 3300 < cnt && cnt < 7001){
        	if (benemyCheck == true){
        		for(int i=1; i<4; ++i){
        			bEnemy = new BigEnemy((int)((width-300)*(i*0.25)), 0, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
                    bigEnemies.add(bEnemy);
                    for (int j = 0; j < shots4.length; j++) {
        	            if (shots4[j] == null) {
        	            	shots4[j] = bEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
        		for(int i=1; i<4; ++i){
        			bEnemy = new BigEnemy((int)((width-300)*(i*0.25)), 50, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
        			bigEnemies.add(bEnemy);
                    for (int j = 0; j < shots4.length; j++) {
        	            if (shots4[j] == null) {
        	            	shots4[j] = bEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
                benemyCheck = false;
        	}
        	else{
        		for(int i=9; i>6; --i){
        			bEnemy = new BigEnemy((int)((width-300)*(i*0.25)), 0, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
        			bigEnemies.add(bEnemy);
                    for (int j = 0; j < shots4.length; j++) {
        	            if (shots4[j] == null) {
        	            	shots4[j] = bEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
        		for(int i=9; i>6; --i){
        			bEnemy = new BigEnemy((int)((width-300)*(i*0.25)), 50, (float) -0.5, (float) 0.5, width-300, height, enemyDownSpeedInc);
        			bigEnemies.add(bEnemy);
                    for (int j = 0; j < shots4.length; j++) {
        	            if (shots4[j] == null) {
        	            	shots4[j] = bEnemy.generateShot();
        	                break;
        	            }
        	        }
        		}
                benemyCheck = true;
        	}
        }
    }
    
    
    //BossEnemy 생성
    public void createBossEnemy(){    	        
    	for (int j = 0; j < bossShot.length; j++) {
            if (bossShot[j] == null) {
            	bossShot[j] = bossEnemy.generateShot();
                break;
            }
        }
    	bossEnemy.move(); //해당 적을 이동시킨다.
    }

    
    

    public void initImage(Graphics g) {
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        dbg.setColor(getForeground());
        //paint (dbg);
        
//        playerLabel = new JLabel("src/Image/pImage.png");

        playerImage = Toolkit.getDefaultToolkit().getImage("src/Image/sujung_pImage.png");
        invincibleImage = Toolkit.getDefaultToolkit().getImage("src/resourcepack/invincible.png");
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        initImage(g);
        
        Shootingspaceship ship = new Shootingspaceship();
        int playscore = stage.getScore();
        double skillgauge = stage.getGauge();
        int playerlife = stage.getLife();
        if(stage.getStageNum() == 0) {
            icon = new ImageIcon("src/resourcepack/space.jpg");
            g.drawImage(icon.getImage(), 0, 0, width, height, null);
            pointicon.drawPoint(g);
        }
        //플레이화면
        else if(stage.getStageNum() == 1) {
            icon = new ImageIcon("src/resourcepack/gamebackground.png");
            g.drawImage(icon.getImage(), 0, 0, width, height, null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("휴먼모음T", Font.BOLD, 25));
            g.drawString("STAGE ", (int)(width*0.77), (int)(height*0.05));
            g.drawString(String.valueOf(stage.getStageNum()), (int)(width*0.9), (int)(height*0.05));
            g.drawString("SCORE", (int)(width*0.73), (int)(height*0.58));
            g.drawString(String.valueOf(playscore), (int)(width*0.73), (int)(height*0.63));
            g.drawString("PLAYER LIFE ", (int)(width*0.73), (int)(height*0.7));
            g.setColor(Color.YELLOW);
            switch(playerlife) {
                case 4:
                    g.drawString(" ★ ★ ★ ★", (int)(width*0.72), (int)(height*0.75));
                    break;
                case 3:
                    g.drawString(" ★ ★ ★", (int)(width*0.72), (int)(height*0.75));
                    break;
                case 2:
                    g.drawString(" ★ ★", (int)(width*0.72), (int)(height*0.75));
                    break;
                case 1:
                    g.drawString(" ★", (int)(width*0.72), (int)(height*0.75));
                    break;
                case 0:
                    break;
            }
            g.setColor(Color.WHITE);
            g.drawString("SKILL GAUGE ", (int)(width*0.73), (int)(height*0.82));
            g.setColor(Color.YELLOW);
            g.setFont(new Font("휴먼모음T", Font.BOLD, 30));
            String str = String.format("%.2f", skillgauge);
            g.drawString(String.valueOf(str), (int)(width*0.74), (int)(height*0.88));
            g.setFont(new Font("휴먼모음T", Font.BOLD, 20));
            g.drawString("  : 4.00", (int)(width*0.81), (int)(height*0.88));
        }
        //게임오버화면
        else if(stage.getStageNum() == 2) {
            icon = new ImageIcon("src/resourcepack/gameoverbackground.png");
            g.drawImage(icon.getImage(), 0, 0, width, height, null);
            pointicon.drawClearPagePoint(g);
            
        }
        //게임방법화면
        else if(stage.getStageNum() == 3) {
            icon = new ImageIcon("src/resourcepack/Howtopage.png");
            g.drawImage(icon.getImage(), 0, 0, width, height, null);
        }
        //랭킹
        else if(stage.getStageNum() == 4) {
            icon = new ImageIcon("src/resourcepack/rank/RankingBack.png");
            g.drawImage(icon.getImage(), 0, 0, width, height, null);
            rankclass.rankUI(g);
           
        }
        //플레이화면 외에는 플레이어 안나오게 한거!
        if(stage.getStageNum() == 1) {
            // draw player
            //player.drawPlayer(g);
            g.drawImage(playerImage,player.x_pos-18,player.y_pos,this);
            if(invincible == true)
            {
                g.drawImage(invincibleImage,player.x_pos-33,player.y_pos-21,this);
            
            }
            
            
            if (player.isCollidedWithShot(shots2)||player.isCollidedWithShot(shots3)||player.isCollidedWithShot(shots4)||player.isCollidedWithShot(bossShot)){
            if(invincible!=true)
            {
                se.SE("player_die");
                player.setPosition(width / 2- 170, (int) (height * 0.9));
                invincible = true;
                stage.setLife(playerlife-1);
                if(playerlife<=0){
                   gameOver();
                }
            } //System.exit(0);
        }

        Iterator enemyList = enemies.iterator();
        while (enemyList.hasNext()) {
            Enemy enemy = (Enemy) enemyList.next();
            enemy.draw(g,this);
            if (enemy.isCollidedWithShot(shots,g,this)) {
                Item newItem = new Item((int)enemy.x_pos,(int)enemy.y_pos, (float) -0.5, (float) 0.5, width, height, enemyDownSpeedInc,rand.nextInt(2));
                items.add(newItem);
                enemyList.remove();
            }
            if (enemy.isCollidedWithBomb(bombs)) {
                Item newItem = new Item((int)enemy.x_pos,(int)enemy.y_pos, (float) -0.5, (float) 0.5, width, height, enemyDownSpeedInc,rand.nextInt(2));
                items.add(newItem);
                se.SE("se_damage00");
                enemyList.remove();
            }
            if (enemy.isCollidedWithPlayer(player)&&invincible!=true) {
                enemyList.remove();
                se.SE("player_die");

                player.setPosition(width / 2 - 170, (int) (height * 0.9));
                invincible = true;
                stage.setLife(playerlife-1);
                System.out.println(playerlife);
                if(playerlife<=0){
                    gameOver();
                }
            }
            
            
        }
        
        Iterator bigEnemyList = bigEnemies.iterator();
        while (bigEnemyList.hasNext()) {
            BigEnemy benemy = (BigEnemy) bigEnemyList.next();
            benemy.draw(g, this);
            if (benemy.isCollidedWithShot(shots, g, this)) { //총알에 부딪히면 enemy를 list에서 제거
            	Item newItem = new Item((int)benemy.x_pos,(int)benemy.y_pos, (float) -0.5, (float) 0.5, width, height, enemyDownSpeedInc,rand.nextInt(2));
                items.add(newItem);
                se.SE("se_damage00");
                
                bigEnemyList.remove();
            }
             if (benemy.isCollidedWithBomb(bombs)) {
                Item newItem = new Item((int)benemy.x_pos,(int)benemy.y_pos, (float) -0.5, (float) 0.5, width, height, enemyDownSpeedInc,rand.nextInt(2));
                items.add(newItem);
                se.SE("se_damage00");
                bigEnemyList.remove();
            }
            if (benemy.isCollidedWithPlayer(player)&&invincible!=true) { //적과 플레이어가 부딪히면 시스템 종료
            	bigEnemyList.remove();
                se.SE("player_die");
                 player.setPosition(width / 2 - 170, (int) (height * 0.9));
                invincible = true;
                stage.setLife(playerlife-1);
                if(playerlife<=0){
                    gameOver();
                }
            }
        }
        
        
        //samllEnemy 그리는 부분
        Iterator smallEnemyList = smallEnemies.iterator();
        while (smallEnemyList.hasNext()) {
            smallEnemy senemy = (smallEnemy) smallEnemyList.next();
            senemy.draw(g,this);
            if (senemy.isCollidedWithShot(shots,g,this)) { //총알에 부딪히면 enemy를 list에서 제거
                Item newItem = new Item((int)senemy.x_pos,(int)senemy.y_pos, (float) -0.5, (float) 0.5, width, height, enemyDownSpeedInc,rand.nextInt(2));
                items.add(newItem);
                se.SE("se_damage00");
            	smallEnemyList.remove();
            }
             if (senemy.isCollidedWithBomb(bombs)) {
                 Item newItem = new Item((int)senemy.x_pos,(int)senemy.y_pos, (float) -0.5, (float) 0.5, width, height, enemyDownSpeedInc,rand.nextInt(2));
                items.add(newItem);
                se.SE("se_damage00");
                smallEnemyList.remove();
            }
            if (senemy.isCollidedWithPlayer(player)&&invincible!=true) { //적과 플레이어가 부딪히면 시스템 종료
            	smallEnemyList.remove();
               se.SE("player_die");
                 player.setPosition(width / 2 - 170, (int) (height * 0.9));
                invincible = true;
                stage.setLife(playerlife-1);
                if(playerlife<=0){
                    gameOver();
                }
            }
            
           

        }
        
        if(cnt>7000 && bossEnemy != null){
            //bossEnemy 그리는 부분
            bossEnemy.draw(g, this);
            if (bossEnemy.isCollidedWithShot(shots, g, this)) { //총알에 부딪히면 enemy를 list에서 제거
//            	bossEnemy = null;
                bossHp -=10;
                stage.setScore(stage.getScore()+10);
                if(bossHp <0)
                {
                    gameOver();
                }
            }
            if (bossEnemy.isCollidedWithPlayer(player)) { 
                se.SE("player_die");
                player.setPosition(width / 2 - 170, (int) (height * 0.9));
                invincible = true;
                stage.setLife(playerlife-1);
                if(playerlife<=0){
                    gameOver();
                }
            }
         }
        Iterator itemList = items.iterator();
            while (itemList.hasNext()) {
                //Enemy enemy = (Enemy) enemyList.next();
                //enemy.move();
                Item item = (Item) itemList.next();
                item.draw(g,this);
             if (item.isCollidedWithPlayer(player)) { 
                 se.SE("se_item00");
                 if(item.index == 1)
                 {
                     if(stage.getGauge()<4.0f)
                     stage.setGauge(stage.getGauge()+0.2f);
                     
                 }
                 else if(item.index == 0)
                 {
                     stage.setScore(stage.getScore()+100);
                 }
            	itemList.remove();
             }        
        }


        // draw shots
        for (int i = 0; i < shots.length; i++) {
            if (shots[i] != null) {
                shots[i].drawShot(g,this);
            }
        }
        
        //Enemy가 쏘는 총알
        for (int i = 0; i < shots2.length; i++) {
            if (shots2[i] != null) {
                shots2[i].drawShot(g,this);
            }
        }
        
        //samllEnemy가 쏘는 총알
        for (int i = 0; i < shots3.length; i++) {
            if (shots3[i] != null) {
                shots3[i].drawShot(g,this);
            }
        }
        
        for (int i = 0; i < shots4.length; i++) {
            if (shots4[i] != null) {
                shots4[i].drawShot(g,this);
            }
        }
        for (int i = 0; i < bossShot.length; i++) {
            if (bossShot[i] != null) {
            	bossShot[i].drawShot(g,this);
            }
        }
        
        if(bombs!=null)
            bombs.drawShot(g,this);
        }

       
        
        
        
        
        
    
        // draw player
        //player.drawPlayer(g);
        //player.drawPlayer(playerLabel);
        
    }
    
    public void gameOver(){
        // draw shots
        /*
        for (int i = 0; i < shots.length; i++) {
            if (shots[i] != null) {
                shots[i] = null;
            }
        }
        
        //Enemy가 쏘는 총알
        for (int i = 0; i < shots2.length; i++) {
            if (shots2[i] != null) {
                shots2[i] = null;
            }
        }
        
        //samllEnemy가 쏘는 총알
        for (int i = 0; i < shots3.length; i++) {
            if (shots3[i] != null) {
                shots3[i] = null;
            }
        }
        for (int i = 0; i < bossShot.length; i++) {
            if (bossShot[i] != null) {
            	bossShot[i] = null;
            }
        }
         Iterator itemList = items.iterator();
            while (itemList.hasNext()) {
            	itemList.remove();
         }
            
        Iterator enemyList = enemies.iterator();
        while (enemyList.hasNext()) {
            enemyList.remove();
        }
        
        //samllEnemy 그리는 부분
        Iterator smallEnemyList = smallEnemies.iterator();
        while (smallEnemyList.hasNext()) {  
            	smallEnemyList.remove();
        }
        
        bossEnemy = null;
        */
        
        
        //전체 wipe out
        
        
        
        //초기화
        changeBgm=true;
        bossHp = 1000;
        stage.setLife(4);
        stage.setGauge(0.0f);
        cnt=0;
        
        //초기화
        
        
        stage.setStageNum(2);
       
        

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Shooting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Shootingspaceship ship = new Shootingspaceship();
        frame.getContentPane().add(ship);
        frame.pack();
        frame.setVisible(true);
        ship.start();
    }
}
