/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame1;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 *
 * @author ben__
 */
public class FirstGame1 extends Application {
    private int x = 0;
    private int y=0;
    private int i=0;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        primaryStage.setTitle("FirstGame!");
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        
        Canvas canvas = new Canvas ( 750, 500 );
        root.getChildren().add( canvas );
        Image alien = new Image(getClass().getResourceAsStream("alien.png"), 20, 20, false, false);
        Image missile = new Image(getClass() .getResourceAsStream("missle.png"), 10, 10, false, false);
      
        Image space = new Image(getClass().getResourceAsStream("space.jpg"));
        Image spaceShip = new Image(getClass().getResourceAsStream("spaceShip.png"), 20, 35,false,false);

//        ArrayList<String> input = new ArrayList<>();
//        
//        theScene.setOnKeyPressed(
//        new EventHandler<KeyEvent>(){
//            public void handle(KeyEvent e){
//                String code = e.getCode().toString();
//                if(!input.contains(code))
//                    input.add(code);
//            }
//        });
//        theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
//            public void handle(KeyEvent e){
//                String code = e.getCode().toString();
//                input.remove(code);
//            }
//        });
        ArrayList<Integer> targets = new ArrayList<>();
        for (int j=0; j<10; j++){
            targets.add(j);
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        theScene.addEventHandler(KeyEvent.KEY_PRESSED,(key) ->{
        if(key.getCode()==KeyCode.LEFT){
            System.out.println("You pressed Left");
            x--;
            gc.drawImage(space, 0, 0);
            gc.drawImage( spaceShip, x*10, 450 );
            
        }
        });
        theScene.addEventHandler(KeyEvent.KEY_PRESSED,(key1) ->{
        if(key1.getCode()==KeyCode.RIGHT){
            System.out.println("You pressed right");
            x++;
            gc.drawImage(space, 0, 0);
            gc.drawImage( spaceShip, x*10, 450 );
            
        }
        });
        
        theScene.addEventHandler(KeyEvent.KEY_PRESSED,(key2) ->{
        if(key2.getCode()==KeyCode.SPACE){
            System.out.println("You pressed fire");
            gc.drawImage(space, 0, 0);
            gc.drawImage( spaceShip, x*10, 450 );
            for(int k=0; k<10; k++ ){
            //gc.drawImage(space, 0, 0);
            gc.drawImage( spaceShip, x*10, 450 );
            gc.drawImage(missile,x*10, 100*k);
            
            }
            
             
        }
        });
        
        
        
               
    
        final long startNanoTime = System.nanoTime();
        
         
          gc.drawImage(space, 0, 0);
            while(i<10){
                gc.drawImage(missile, 700*random() ,100*random());
            i++;
            }
            // background image clears canvas
            
            
        long lastNanoTime=0L;
        
        
        new AnimationTimer()
    {
        public void handle(long currentNanoTime)
        {
           double y = (currentNanoTime - startNanoTime) / 1000000000.0; 
           lastNanoTime.value = currentNanoTime;
           
           
        
          
            
        }
    }.start();
      
        
        
        primaryStage.show();
        
        
    };
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}