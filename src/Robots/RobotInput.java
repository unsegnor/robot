/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

/**
 *
 * @author Victor
 */
class RobotInput {
    
    private boolean onbullethit; //indica si se ha disparado el evento
    private InBulletHitEvent obh_event = new InBulletHitEvent(); //almacena los datos del evento
    private boolean onbullethitbullet;
    private InBulletHitBulletEvent obhb_event = new InBulletHitBulletEvent();
    private boolean onbulletmissed;
    private InBulletMissedEvent obm_event = new InBulletMissedEvent();
    private boolean ondeath;
    //Deathevent no tiene datos relevantes
    private boolean onhitbybullet;
    private InHitByBulletEvent ohbb_event = new InHitByBulletEvent();
    private boolean onhitrobotevent;
    private InHitRobotEvent ohr_event = new InHitRobotEvent();
    private boolean onhitwall;
    private InHitWallEvent ohw_event = new InHitWallEvent();
    private boolean onrobotdeath;
    private InRobotDeathEvent ord_event = new InRobotDeathEvent();
    private boolean onscannedrobot;
    private InScannedRobotEvent osr_event = new InScannedRobotEvent();
    private boolean onwin;
    private InWinEvent ow_event = new InWinEvent();
    private boolean onroundended;
    private InRoundEndedEvent ore_event = new InRoundEndedEvent();
    private boolean obattleended;
    private InBattleEndedEvent obe_event = new InBattleEndedEvent();
    private boolean onstatus;
    private InStatusEvent os_event = new InStatusEvent();
    
    //Variables de estado
    private double battleFieldHeight;
    private double battleFieldWidth;
    private double energy;
    private double gunCoolingRate;
    private double gunHeating;
    private double gunHeat;
    private double heading;
    private double height;
    private int numRounds;
    private int others;
    private double radarHeating;
    private int roundNum;
    private long time;
    private double velocity;
    private double width;
    private double x;
    private double y;

    void reiniciar() {
        //Reiniciar todas las variables que dependan de eventos
        setOnbullethit(false);
        getObh_event().reiniciar();
        setOnbullethitbullet(false);
        getObhb_event().reiniciar();
        setOnbulletmissed(false);
        getObm_event().reiniciar();
        setOndeath(false);
    //Deathevent no tiene datos relevantes
        setOnhitbybullet(false);
        getOhbb_event().reiniciar();
        setOnhitrobotevent(false);
        getOhr_event().reiniciar();
        setOnhitwall(false);
        getOhw_event().reiniciar();
        setOnrobotdeath(false);
        getOrd_event().reiniciar();
        setOnscannedrobot(false);
        getOsr_event().reiniciar();
        setOnwin(false);
        getOw_event().reiniciar();
        setOnroundended(false);
        getOre_event().reiniciar();
        setObattleended(false);
        getObe_event().reiniciar();
        setOnstatus(false);
        getOs_event().reiniciar();
        
    }

    /**
     * @return the onbullethit
     */
    public boolean isOnbullethit() {
        return onbullethit;
    }

    /**
     * @param onbullethit the onbullethit to set
     */
    public void setOnbullethit(boolean onbullethit) {
        this.onbullethit = onbullethit;
    }

    /**
     * @return the obh_event
     */
    public InBulletHitEvent getObh_event() {
        return obh_event;
    }

    /**
     * @param obh_event the obh_event to set
     */
    public void setObh_event(InBulletHitEvent obh_event) {
        this.obh_event = obh_event;
    }

    /**
     * @return the onbullethitbullet
     */
    public boolean isOnbullethitbullet() {
        return onbullethitbullet;
    }

    /**
     * @param onbullethitbullet the onbullethitbullet to set
     */
    public void setOnbullethitbullet(boolean onbullethitbullet) {
        this.onbullethitbullet = onbullethitbullet;
    }

    /**
     * @return the obhb_event
     */
    public InBulletHitBulletEvent getObhb_event() {
        return obhb_event;
    }

    /**
     * @param obhb_event the obhb_event to set
     */
    public void setObhb_event(InBulletHitBulletEvent obhb_event) {
        this.obhb_event = obhb_event;
    }

    /**
     * @return the onbulletmissed
     */
    public boolean isOnbulletmissed() {
        return onbulletmissed;
    }

    /**
     * @param onbulletmissed the onbulletmissed to set
     */
    public void setOnbulletmissed(boolean onbulletmissed) {
        this.onbulletmissed = onbulletmissed;
    }

    /**
     * @return the obm_event
     */
    public InBulletMissedEvent getObm_event() {
        return obm_event;
    }

    /**
     * @param obm_event the obm_event to set
     */
    public void setObm_event(InBulletMissedEvent obm_event) {
        this.obm_event = obm_event;
    }

    /**
     * @return the ondeath
     */
    public boolean isOndeath() {
        return ondeath;
    }

    /**
     * @param ondeath the ondeath to set
     */
    public void setOndeath(boolean ondeath) {
        this.ondeath = ondeath;
    }

    /**
     * @return the onhitbybullet
     */
    public boolean isOnhitbybullet() {
        return onhitbybullet;
    }

    /**
     * @param onhitbybullet the onhitbybullet to set
     */
    public void setOnhitbybullet(boolean onhitbybullet) {
        this.onhitbybullet = onhitbybullet;
    }

    /**
     * @return the ohbb_event
     */
    public InHitByBulletEvent getOhbb_event() {
        return ohbb_event;
    }

    /**
     * @param ohbb_event the ohbb_event to set
     */
    public void setOhbb_event(InHitByBulletEvent ohbb_event) {
        this.ohbb_event = ohbb_event;
    }

    /**
     * @return the onhitrobotevent
     */
    public boolean isOnhitrobotevent() {
        return onhitrobotevent;
    }

    /**
     * @param onhitrobotevent the onhitrobotevent to set
     */
    public void setOnhitrobotevent(boolean onhitrobotevent) {
        this.onhitrobotevent = onhitrobotevent;
    }

    /**
     * @return the ohr_event
     */
    public InHitRobotEvent getOhr_event() {
        return ohr_event;
    }

    /**
     * @param ohr_event the ohr_event to set
     */
    public void setOhr_event(InHitRobotEvent ohr_event) {
        this.ohr_event = ohr_event;
    }

    /**
     * @return the onhitwall
     */
    public boolean isOnhitwall() {
        return onhitwall;
    }

    /**
     * @param onhitwall the onhitwall to set
     */
    public void setOnhitwall(boolean onhitwall) {
        this.onhitwall = onhitwall;
    }

    /**
     * @return the ohw_event
     */
    public InHitWallEvent getOhw_event() {
        return ohw_event;
    }

    /**
     * @param ohw_event the ohw_event to set
     */
    public void setOhw_event(InHitWallEvent ohw_event) {
        this.ohw_event = ohw_event;
    }

    /**
     * @return the onrobotdeath
     */
    public boolean isOnrobotdeath() {
        return onrobotdeath;
    }

    /**
     * @param onrobotdeath the onrobotdeath to set
     */
    public void setOnrobotdeath(boolean onrobotdeath) {
        this.onrobotdeath = onrobotdeath;
    }

    /**
     * @return the ord_event
     */
    public InRobotDeathEvent getOrd_event() {
        return ord_event;
    }

    /**
     * @param ord_event the ord_event to set
     */
    public void setOrd_event(InRobotDeathEvent ord_event) {
        this.ord_event = ord_event;
    }

    /**
     * @return the onscannedrobot
     */
    public boolean isOnscannedrobot() {
        return onscannedrobot;
    }

    /**
     * @param onscannedrobot the onscannedrobot to set
     */
    public void setOnscannedrobot(boolean onscannedrobot) {
        this.onscannedrobot = onscannedrobot;
    }

    /**
     * @return the osr_event
     */
    public InScannedRobotEvent getOsr_event() {
        return osr_event;
    }

    /**
     * @param osr_event the osr_event to set
     */
    public void setOsr_event(InScannedRobotEvent osr_event) {
        this.osr_event = osr_event;
    }

    /**
     * @return the onwin
     */
    public boolean isOnwin() {
        return onwin;
    }

    /**
     * @param onwin the onwin to set
     */
    public void setOnwin(boolean onwin) {
        this.onwin = onwin;
    }

    /**
     * @return the ow_event
     */
    public InWinEvent getOw_event() {
        return ow_event;
    }

    /**
     * @param ow_event the ow_event to set
     */
    public void setOw_event(InWinEvent ow_event) {
        this.ow_event = ow_event;
    }

    /**
     * @return the onroundended
     */
    public boolean isOnroundended() {
        return onroundended;
    }

    /**
     * @param onroundended the onroundended to set
     */
    public void setOnroundended(boolean onroundended) {
        this.onroundended = onroundended;
    }

    /**
     * @return the ore_event
     */
    public InRoundEndedEvent getOre_event() {
        return ore_event;
    }

    /**
     * @param ore_event the ore_event to set
     */
    public void setOre_event(InRoundEndedEvent ore_event) {
        this.ore_event = ore_event;
    }

    /**
     * @return the obattleended
     */
    public boolean isObattleended() {
        return obattleended;
    }

    /**
     * @param obattleended the obattleended to set
     */
    public void setObattleended(boolean obattleended) {
        this.obattleended = obattleended;
    }

    /**
     * @return the obe_event
     */
    public InBattleEndedEvent getObe_event() {
        return obe_event;
    }

    /**
     * @param obe_event the obe_event to set
     */
    public void setObe_event(InBattleEndedEvent obe_event) {
        this.obe_event = obe_event;
    }

    /**
     * @return the onstatus
     */
    public boolean isOnstatus() {
        return onstatus;
    }

    /**
     * @param onstatus the onstatus to set
     */
    public void setOnstatus(boolean onstatus) {
        this.onstatus = onstatus;
    }

    /**
     * @return the os_event
     */
    public InStatusEvent getOs_event() {
        return os_event;
    }

    /**
     * @param os_event the os_event to set
     */
    public void setOs_event(InStatusEvent os_event) {
        this.os_event = os_event;
    }

    /**
     * @return the battleFieldHeight
     */
    public double getBattleFieldHeight() {
        return battleFieldHeight;
    }

    /**
     * @param battleFieldHeight the battleFieldHeight to set
     */
    public void setBattleFieldHeight(double battleFieldHeight) {
        this.battleFieldHeight = battleFieldHeight;
    }

    /**
     * @return the battleFieldWidth
     */
    public double getBattleFieldWidth() {
        return battleFieldWidth;
    }

    /**
     * @param battleFieldWidth the battleFieldWidth to set
     */
    public void setBattleFieldWidth(double battleFieldWidth) {
        this.battleFieldWidth = battleFieldWidth;
    }

    /**
     * @return the energy
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * @return the gunCoolingRate
     */
    public double getGunCoolingRate() {
        return gunCoolingRate;
    }

    /**
     * @param gunCoolingRate the gunCoolingRate to set
     */
    public void setGunCoolingRate(double gunCoolingRate) {
        this.gunCoolingRate = gunCoolingRate;
    }

    /**
     * @return the gunHeating
     */
    public double getGunHeating() {
        return gunHeating;
    }

    /**
     * @param gunHeating the gunHeating to set
     */
    public void setGunHeating(double gunHeating) {
        this.gunHeating = gunHeating;
    }

    /**
     * @return the gunHeat
     */
    public double getGunHeat() {
        return gunHeat;
    }

    /**
     * @param gunHeat the gunHeat to set
     */
    public void setGunHeat(double gunHeat) {
        this.gunHeat = gunHeat;
    }

    /**
     * @return the heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @param heading the heading to set
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the numRounds
     */
    public int getNumRounds() {
        return numRounds;
    }

    /**
     * @param numRounds the numRounds to set
     */
    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    /**
     * @return the others
     */
    public int getOthers() {
        return others;
    }

    /**
     * @param others the others to set
     */
    public void setOthers(int others) {
        this.others = others;
    }

    /**
     * @return the radarHeating
     */
    public double getRadarHeating() {
        return radarHeating;
    }

    /**
     * @param radarHeating the radarHeating to set
     */
    public void setRadarHeating(double radarHeating) {
        this.radarHeating = radarHeating;
    }

    /**
     * @return the roundNum
     */
    public int getRoundNum() {
        return roundNum;
    }

    /**
     * @param roundNum the roundNum to set
     */
    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @return the velocity
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    
}
