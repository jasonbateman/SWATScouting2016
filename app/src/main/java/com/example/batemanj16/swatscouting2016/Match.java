package com.example.batemanj16.swatscouting2016;
//TODO:Add accuracy and scoring and climb/surround and fouls
/**
 * Created by batemanj16 on 1/27/2016.
 */
public class Match {
    private int _id, _matchNum,_accuracy, _shotsTaken, _fouls, _teamNum, _avgPort, _numPort, _avgCheval, _avgMoat, _avgRamp, _avgDraw, _avgSally, _avgRough, _avgRock, _avgLow, _numCheval, _numMoat, _numRamp, _numDraw, _numSally, _numRough, _numRock, _numLow;
    private boolean _defense, _climb;
    private String _notes;

    public Match(int id, int matchNum, int teamNum, boolean defense, String notes,
                 int accuracy, int shotsTaken, boolean climb, int fouls,
                  int avgPort, int numPort,
                  int avgCheval, int numCheval,
                  int avgMoat, int numMoat,
                  int avgRamp, int numRamp,
                  int avgDraw, int numDraw,
                  int avgSally, int numSally,
                  int avgRough, int numRough,
                  int avgRock, int numRock,
                  int avgLow, int numLow){


        id = _id;
        matchNum = _matchNum;
        teamNum = _teamNum;
        defense = _defense;
        notes = _notes;
        accuracy = _accuracy;
        shotsTaken = _shotsTaken;
        climb = _climb;
        fouls = _fouls;

        avgPort = _avgPort;
        avgCheval = _avgCheval;
        avgMoat = _avgMoat;
        avgRamp = _avgRamp;
        avgDraw = _avgDraw;
        avgSally = _avgSally;
        avgRough = _avgRough;
        avgRock = _avgRock;
        avgLow = _avgLow;

        numPort = _numPort;
        numCheval = _numCheval;
        numMoat = _numMoat;
        numRamp = _numRamp;
        numDraw = _numDraw;
        numSally = _numSally;
        numRough = _numRough;
        numRock = _numRock;
        numLow = _numLow;
    }

    public int getId(){return _id;}
    public int getMatchNum(){return _matchNum;}
    public int getTeamNum(){return _teamNum;}
    public boolean getDefense(){return _defense;}
    public String getNotes(){return _notes;}
    public int getAccuracy(){return _accuracy;}
    public int getShotsTaken(){return _shotsTaken;}
    public boolean getClimb(){return _climb;}
    public int getFouls(){return _fouls;}

    public int getAvgPort(){return _avgPort;};
    public int getAvgCheval(){return _avgCheval;}
    public int getAvgMoat(){return _avgMoat;}
    public int getAvgRamp(){return _avgRamp;}
    public int getAvgDraw(){return _avgDraw;}
    public int getAvgSally(){return _avgSally;}
    public int getAvgRough(){return _avgRough;}
    public int getAvgRock(){return _avgRock;}
    public int getAvgLow(){ return _avgLow;}

    public int getNumPort(){return _numPort;}
    public int getNumCheval(){return _numCheval;}
    public int getNumMoat(){return _numMoat;}
    public int getNumRamp(){return _numRamp;}
    public int getNumDraw(){return _numDraw;}
    public int getNumSally(){return _numSally;}
    public int getNumRough(){return _numRough;}
    public int getNumRock(){return _numRock;}
    public int getNumLow(){return _numLow;}

    public void set_id(int id_new){_id = id_new;}
    public void set_matchNum(int matchNum_new){_matchNum = matchNum_new;}
    public void set_teamNum(int teamNum_new){_teamNum = teamNum_new;}
    public void set_defense(boolean defense_new){_defense = defense_new;}
    public void set_notes(String notes_new){_notes = notes_new;}
    public void set_accuracy(int accuracy_new){_accuracy = accuracy_new;}
    public void set_shotsTaken(int shotsTaken_new){_shotsTaken = shotsTaken_new;}
    public void set_climb(boolean climb_new){_climb = climb_new;}
    public void set_fouls(int fouls_new){_fouls = fouls_new;}

    public void set_avgPort(int avgPort_new){_avgPort = avgPort_new;}
    public void set_avgCheval(int avgCheval_new){_avgCheval = avgCheval_new;}
    public void set_avgMoat(int avgMoat_new){_avgMoat = avgMoat_new;}
    public void set_avgRamp(int avgRamp_new){_avgMoat = avgRamp_new;}
    public void set_avgDraw(int avgDraw_new){_avgRamp = avgDraw_new;}
    public void set_avgSally(int avgSally_new){_avgSally = avgSally_new;}
    public void set_avgRough(int avgRough_new){_avgRough = avgRough_new;}
    public void set_avgRock(int avgRock_new){_avgRock = avgRock_new;}
    public void set_avgLow(int avgLow_new){_avgLow = avgLow_new;}

    public void addPort(){_numPort++;}
    public void addCheval(){_numCheval++;}
    public void addMoat(){_numMoat++;}
    public void addRamp(){_numRamp++;}
    public void addDraw(){_numDraw++;}
    public void addSally(){_numSally++;}
    public void addRough(){_numRough++;}
    public void addRock(){_numRock++;}
    public void addLow(){_numLow++;}



}
