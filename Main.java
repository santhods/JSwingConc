import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Runner frame");
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        frame.setLayout(new FlowLayout());

        buttonStart.setBounds(20, 20, 50, 50);
        buttonStop.setBounds(70, 20, 50, 50);

        SetupRunner runner = new SetupRunner();

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    runner.start();
                } catch (Exception E){
                    E.getStackTrace();
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                runner.stop();
            }
        });


        frame.setPreferredSize(new Dimension(500, 500));

        frame.add(buttonStart);
        frame.add(buttonStop);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

class SetupRunner {
    Repeater runner;


    public SetupRunner(){


    }

    public void start(){
        this.runner = new Repeater();
        this.runner.execute();
    }


    public void stop(){
        this.runner.cancel(true);
    }


}
