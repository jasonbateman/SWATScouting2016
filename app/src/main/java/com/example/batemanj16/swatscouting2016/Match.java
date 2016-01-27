package com.example.batemanj16.swatscouting2016;

/**
 * Created by batemanj16 on 1/27/2016.
 */
public class Match {
    private int _id, _matchNum, _teamNum, _avgPort, _numPort, _avgCheval, _avgMoat, _avgRamp, _avgDraw, _avgSally, _avgRough, _avgRock, _avgLow, _numCheval, _numMoat, _numRamp, _numDraw, _numSally, _numRough, _numRock, _numLow;
    private boolean _defense;
    private String _notes;

    public Match(int id, int matchNum, int teamNum, boolean defense, String notes,
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

    public int getAvgPort(){return _avgPort;};
    public int getAvgCheval(){return _avgCheval;}
    public int getAvgMoat(){return _avgMoat;}
    public int getAvgRamp(){return _avgRamp;}
    public int getAvgDraw(){return _avgDraw;}
    public int getAvgSally(){return _avgSally;}
    public int getAvgRough(){return _avgRough;}
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

}
