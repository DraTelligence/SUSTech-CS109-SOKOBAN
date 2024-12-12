package user;

import java.io.Serializable;

/**
 * save类型对象将包含关卡的完成情况与当前所在关卡的相关数据
 * @author 秦嘉曜 刘乙霏
 */

public class Save implements Serializable{
    /**
     * the number of the stages
     */
    final static private int STAGE_NUM=4;

    /**
     * the completed or not situation of each stage
     */
    private boolean[] stagesComplete=new boolean[STAGE_NUM];

    /**
     * the recorded minimum steps of each stage
     */
    private int[] stageMinimumSteps= new int[STAGE_NUM];

    MapMatrix getCurrentStage() {
        return currentStage;
    }

    void setCurrentStage(MapMatrix currentStage) {
        this.currentStage = currentStage;
    }
}
