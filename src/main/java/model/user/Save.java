package model.user;

import java.io.Serial;
import java.io.Serializable;
import model.game.Map;

/**
 * save类型对象将包含关卡的完成情况与当前所在关卡的相关数据
 * 
 * @author 秦嘉曜 刘乙霏
 */

class Save implements Serializable {
    /**
     * the number of the stages
     */
    final static private int STAGE_NUM = 6;

    /**
     * the completed or not situation of each stage
     */
    @Serial
    private boolean[] stagesComplete = new boolean[STAGE_NUM];

    /**
     * the recorded minimum steps of each stage
     */
    @Serial
    private int[] stageMinimumSteps = new int[STAGE_NUM];

    @Serial
    private long[] stageMinimumTime = new long[STAGE_NUM];

    @Serial
    private Map currMap;

    public Save(){
        for(int i=0;i<STAGE_NUM;i++){
            stagesComplete[i]=false;
            stageMinimumSteps[i]=999;
            stageMinimumTime[i]=999;
        }
    }

    Map getCurrMap() {
        return this.currMap;
    }

    void setCurrMap(Map currMap) {
        this.currMap = currMap;
    }

    void setMapCompletion(int levelNum, int step, int time) {
        if (stagesComplete[levelNum]) {
            if (this.stageMinimumSteps[levelNum] > step) {
                this.stageMinimumSteps[levelNum] = step;
            }

            if (this.stageMinimumTime[levelNum] > time) {
                this.stageMinimumTime[levelNum] = time;
            }
        } else {
            this.stagesComplete[levelNum] = true;
            this.stageMinimumSteps[levelNum] = step;
            this.stageMinimumTime[levelNum] = time;
        }
    }
}
