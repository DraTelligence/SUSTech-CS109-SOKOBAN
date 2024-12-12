package view.myComponents;

import javax.swing.JComponent;
import javax.swing.Timer;

public abstract class Animation extends JComponent {
    private final Timer timer, trigger;
    private final Thread mainThread;
    private final int duration, DELAY;

    protected Animation(int DELAY, int duration) {
        this(DELAY, duration, null);
    }

    @SuppressWarnings("unused")
    protected Animation(int DELAY, int duration, Animation nextAnimation) {
        this.DELAY= DELAY;
        this.duration= duration;

        trigger = new Timer(DELAY, (var noUse) -> {
            this.repaint();
        });
        timer = new Timer(duration, (var noUse) -> {
            trigger.stop();

            if (nextAnimation != null) {
                nextAnimation.start();
            }
        });

        timer.setRepeats(false);

        this.mainThread=new Thread(()->{
            timer.start();
            trigger.start();
        });
    }

    public void start() {
        mainThread.start();
    };

    public int getDuration() {
        return duration;
    }

    public int getDELAY() {
        return DELAY;
    }
}
