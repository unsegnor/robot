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
    
    boolean onbullethit; //indica si se ha disparado el evento
    InBulletHitEvent obh_event = new InBulletHitEvent(); //almacena los datos del evento
    boolean onbullethitbullet;
    InBulletHitBulletEvent obhb_event = new InBulletHitBulletEvent();
    boolean onbulletmissed;
    InBulletMissedEvent obm_event = new InBulletMissedEvent();
    boolean ondeath;
    //Deathevent no tiene datos relevantes
    boolean onhitbybullet;
    InHitByBulletEvent ohbb_event = new InHitByBulletEvent();
    boolean onhitrobotevent;
    InHitRobotEvent ohr_event = new InHitRobotEvent();
    boolean onhitwall;
    InHitWallEvent ohw_event = new InHitWallEvent();
    boolean onrobotdeath;
    InRobotDeathEvent ord_event = new InRobotDeathEvent();
    boolean onscannedrobot;
    InScannedRobotEvent osr_event = new InScannedRobotEvent();
    boolean onwin;
    InWinEvent ow_event = new InWinEvent();
    boolean onroundended;
    InRoundEndedEvent ore_event = new InRoundEndedEvent();
    boolean obattleended;
    InBattleEndedEvent obe_event = new InBattleEndedEvent();
    boolean onstatus;
    InStatusEvent os_event = new InStatusEvent();
    
    //Variables de estado
    double battleFieldHeight;
    double battleFieldWidth;
    double energy;
    double gunCoolingRate;
    double gunHeating;
    double gunHeat;
    double heading;
    double height;
    int numRounds;
    int others;
    double radarHeating;
    int roundNum;
    long time;
    double velocity;
    double width;
    double x;
    double y;

    void reiniciar() {
        //Reiniciar todas las variables que dependan de eventos
    onbullethit= false;
    obh_event.reiniciar();
    onbullethitbullet = false;
    obhb_event.reiniciar();
    onbulletmissed = false;
    obm_event.reiniciar();
    ondeath = false;
    //Deathevent no tiene datos relevantes
    onhitbybullet = false;
    ohbb_event.reiniciar();
    onhitrobotevent = false;
    ohr_event.reiniciar();
    onhitwall = false;
    ohw_event.reiniciar();
    onrobotdeath = false;
    ord_event.reiniciar();
    onscannedrobot = false;
    osr_event.reiniciar();
    onwin = false;
    ow_event.reiniciar();
    onroundended = false;
    ore_event.reiniciar();
    obattleended = false;
    obe_event.reiniciar();
    onstatus = false;
    os_event.reiniciar();
        
    }
    
}
