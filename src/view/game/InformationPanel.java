package view.game;

import javax.swing.JLayeredPane;
import view.game.informationPanel.InformationPanelBody;
import view.game.informationPanel.StepCountPanel;
import view.game.informationPanel.TimePanel;

public class InformationPanel extends JLayeredPane {
    final private StepCountPanel step;
    final private TimePanel time;
    final private InformationPanelBody body;

    public InformationPanel() {
        this.setBounds(0,0,555,785);

        this.step = new StepCountPanel();
        this.time = new TimePanel();
        this.body = new InformationPanelBody();

        this.add(this.body,0);
        this.add(this.step,0);
        this.add(this.time,0);
    }

    public void updateStep(int step) {
        this.step.updateStep(step);
    }

    public void pause() {
        this.time.pauseTiming();
    }

    public void continueTiming() {
        this.time.continueTiming();
    }

    /**
     * reset both panels
     */
    public void reset() {
        this.time.reset();
        this.step.reset();
    }
}
