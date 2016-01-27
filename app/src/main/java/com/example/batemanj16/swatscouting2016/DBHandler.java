package com.example.batemanj16.swatscouting2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by batemanj16 on 1/27/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "matchManager",
            TABLE_MATCH = "matches",
            KEY_ID = "id",
            KEY_MATCH_NUMBER = "matchNum",
            KEY_TEAM_NUMBER = "teamNum",
            KEY_DEFENSE = "defense",
            KEY_NOTES = "notes",

            KEY_AVG_PORT = "avgPort",
            KEY_AVG_CHEVAL = "avgCheval",
            KEY_AVG_MOAT = "avgMoat",
            KEY_AVG_RAMP = "avgRamp",
            KEY_AVG_DRAW = "avgDraw",
            KEY_AVG_SALLY = "avgSally",
            KEY_AVG_ROUGH = "avgRough",
            KEY_AVG_ROCK = "avgRock",
            KEY_AVG_LOW = "avgLow",

            KEY_NUM_PORT = "numPort",
            KEY_NUM_CHEVAL = "numCheval",
            KEY_NUM_MOAT = "numMoat",
            KEY_NUM_RAMP = "numRamp",
            KEY_NUM_DRAW = "numDraw",
            KEY_NUM_SALLY = "numSally",
            KEY_NUM_ROCK = "numRock",
            KEY_NUM_ROUGH = "numRough",
            KEY_NUM_LOW = "numLow";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MATCH
                + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_MATCH_NUMBER + " INTEGER,"
                + KEY_TEAM_NUMBER + " INTEGER,"
                + KEY_DEFENSE + " BIT,"
                + KEY_NOTES + " TEXT,"

                + KEY_AVG_PORT + " INTEGER,"
                + KEY_AVG_CHEVAL + " INTEGER,"
                + KEY_AVG_MOAT + " INTEGER,"
                + KEY_AVG_RAMP + " INTEGER,"
                + KEY_AVG_DRAW + " INTEGER,"
                + KEY_AVG_SALLY + " INTEGER,"
                + KEY_AVG_ROUGH + " INTEGER,"
                + KEY_AVG_ROCK + " INTEGER,"
                + KEY_AVG_LOW + " INTEGER"

                + KEY_NUM_PORT + " INTEGER,"
                + KEY_NUM_CHEVAL + " INTEGER,"
                + KEY_NUM_MOAT + " INTEGER,"
                + KEY_NUM_RAMP + " INTEGER,"
                + KEY_NUM_DRAW + " INTEGER,"
                + KEY_NUM_SALLY + " INTEGER,"
                + KEY_NUM_ROCK + " INTEGER,"
                + KEY_NUM_ROUGH + " INTEGER,"
                + KEY_NUM_LOW + "INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_MATCH);

        onCreate(db);
    }

    public void createMatch(Match match) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_MATCH_NUMBER, match.getMatchNum());
        values.put(KEY_TEAM_NUMBER, match.getTeamNum());
        values.put(KEY_DEFENSE, match.getDefense());
        values.put(KEY_NOTES, match.getNotes());

        values.put(KEY_AVG_PORT, match.getAvgPort());
        values.put(KEY_AVG_CHEVAL, match.getAvgCheval());
        values.put(KEY_AVG_MOAT, match.getAvgMoat());
        values.put(KEY_AVG_RAMP, match.getAvgRamp());
        values.put(KEY_AVG_DRAW, match.getAvgDraw());
        values.put(KEY_AVG_SALLY, match.getAvgSally());
        values.put(KEY_AVG_ROUGH, match.getAvgRough());
        values.put(KEY_AVG_RAMP, match.getAvgRamp());
        values.put(KEY_AVG_LOW, match.getAvgLow());

        values.put(KEY_NUM_PORT, match.getNumPort());
        values.put(KEY_NUM_CHEVAL, match.getNumCheval());
        values.put(KEY_NUM_MOAT, match.getNumMoat());
        values.put(KEY_NUM_RAMP, match.getNumRamp());
        values.put(KEY_NUM_DRAW, match.getNumDraw());
        values.put(KEY_NUM_SALLY, match.getNumSally());
        values.put(KEY_NUM_ROUGH, match.getNumRough());
        values.put(KEY_NUM_ROCK, match.getNumRock());
        values.put(KEY_NUM_LOW, match.getNumLow());

        db.insert(TABLE_MATCH, null, values);
        db.close();


    }


    public Match getMatch(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor  = db.query(TABLE_MATCH, new String[]{
                KEY_ID,
                KEY_TEAM_NUMBER,
                KEY_DEFENSE,
                KEY_NOTES,
                KEY_AVG_PORT,
                KEY_AVG_CHEVAL,
                KEY_AVG_MOAT,
                KEY_AVG_RAMP,
                KEY_AVG_DRAW,
                KEY_AVG_SALLY,
                KEY_AVG_ROUGH,
                KEY_AVG_LOW,

                KEY_NUM_PORT,
                KEY_NUM_CHEVAL,
                KEY_NUM_MOAT,
                KEY_NUM_RAMP,
                KEY_NUM_DRAW,
                KEY_NUM_SALLY,
                KEY_NUM_ROUGH,
                KEY_NUM_ROCK,
                KEY_NUM_LOW}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Match match = new Match(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)),
                Boolean.parseBoolean(cursor.getString(3)),
                cursor.getString(4),
                Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)),
                Integer.parseInt(cursor.getString(8)),
                Integer.parseInt(cursor.getString(9)),
                Integer.parseInt(cursor.getString(10)),
                Integer.parseInt(cursor.getString(11)),
                Integer.parseInt(cursor.getString(12)),
                Integer.parseInt(cursor.getString(13)),
                Integer.parseInt(cursor.getString(14)),
                Integer.parseInt(cursor.getString(15)),
                Integer.parseInt(cursor.getString(16)),
                Integer.parseInt(cursor.getString(17)),
                Integer.parseInt(cursor.getString(18)),
                Integer.parseInt(cursor.getString(19)),
                Integer.parseInt(cursor.getString(20)),
                Integer.parseInt(cursor.getString(21)),
                Integer.parseInt(cursor.getString(22))

                );
        db.close();
        cursor.close();

        return match;
    }

    public void deleteMatch(Match match){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_MATCH, KEY_ID + "=?", new String[]{String.valueOf(match.getId())});
        db.close();
    }

    public int getMatchesCount(){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT & FROM " + TABLE_MATCH, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count;


    }

    public int updateMatch(Match match){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_MATCH_NUMBER, match.getMatchNum());
        values.put(KEY_TEAM_NUMBER, match.getTeamNum());
        values.put(KEY_DEFENSE, match.getDefense());
        values.put(KEY_NOTES, match.getNotes());

        values.put(KEY_AVG_PORT, match.getAvgPort());
        values.put(KEY_AVG_CHEVAL, match.getAvgCheval());
        values.put(KEY_AVG_MOAT, match.getAvgMoat());
        values.put(KEY_AVG_RAMP, match.getAvgRamp());
        values.put(KEY_AVG_DRAW, match.getAvgDraw());
        values.put(KEY_AVG_SALLY, match.getAvgSally());
        values.put(KEY_AVG_ROUGH, match.getAvgRough());
        values.put(KEY_AVG_RAMP, match.getAvgRamp());
        values.put(KEY_AVG_LOW, match.getAvgLow());

        values.put(KEY_NUM_PORT, match.getNumPort());
        values.put(KEY_NUM_CHEVAL, match.getNumCheval());
        values.put(KEY_NUM_MOAT, match.getNumMoat());
        values.put(KEY_NUM_RAMP, match.getNumRamp());
        values.put(KEY_NUM_DRAW, match.getNumDraw());
        values.put(KEY_NUM_SALLY, match.getNumSally());
        values.put(KEY_NUM_ROUGH, match.getNumRough());
        values.put(KEY_NUM_ROCK, match.getNumRock());
        values.put(KEY_NUM_LOW, match.getNumLow());

        return db.update(TABLE_MATCH, values, KEY_ID + "?", new String[]{String.valueOf(match.getId())});
    }

    public List<Match> getAllMatches(){
        List<Match> matches = new ArrayList<Match>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_MATCH, null);

        if(cursor.moveToFirst()) {
            do {
                Match match = new Match(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2)),
                        Boolean.parseBoolean(cursor.getString(3)),
                        cursor.getString(4),
                        Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(cursor.getString(6)),
                        Integer.parseInt(cursor.getString(7)),
                        Integer.parseInt(cursor.getString(8)),
                        Integer.parseInt(cursor.getString(9)),
                        Integer.parseInt(cursor.getString(10)),
                        Integer.parseInt(cursor.getString(11)),
                        Integer.parseInt(cursor.getString(12)),
                        Integer.parseInt(cursor.getString(13)),
                        Integer.parseInt(cursor.getString(14)),
                        Integer.parseInt(cursor.getString(15)),
                        Integer.parseInt(cursor.getString(16)),
                        Integer.parseInt(cursor.getString(17)),
                        Integer.parseInt(cursor.getString(18)),
                        Integer.parseInt(cursor.getString(19)),
                        Integer.parseInt(cursor.getString(20)),
                        Integer.parseInt(cursor.getString(21)),
                        Integer.parseInt(cursor.getString(22)));
                matches.add(match);
            }
            while (cursor.moveToNext());
        }
        return matches;
    }
}