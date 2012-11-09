package App.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.schema.ISqlJetIndexDef;
import org.tmatesoft.sqljet.core.schema.ISqlJetTableDef;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.ISqlJetTransaction;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import App.model.Planet;
import App.model.Player;
import App.model.Settings;

/*
import App.model.Planet;
import App.model.Player;
import App.model.Settings;
*/
public class Loader_db {
	private String saveName;
	private String saveLocation;
	/*
	Collection <Player> players;
	Collection <Planet> planets;
	Settings gameSettings;
	*/
	//name of the database
	private static String DB_NAME = "db.sqlite";
	private File dbFile = new File(DB_NAME);
	private SqlJetDb db;

	//table names
    private static final String TABLE_PLAYERS = "Players";
    private static final String TABLE_INVENTORY = "Inventory";
    private static final String TABLE_PLANETS = "Planets";
    private static final String TABLE_SETTINGS = "Game";
    //player colls
    //private static final String FIELD_INDEX = "NUMBER";
    private static final String FIELD_NAME = "Name";
    private static final String FIELD_PILOTING = "Piloting";
    private static final String FIELD_TRADING = "Trading";
    private static final String FIELD_ENGINEERING = "Engineering";
    private static final String FIELD_FIGHTING = "Fighting";
    private static final String FIELD_MONEY = "Money";
    private static final String FIELD_SHIP = "Ship";
    private static final String FIELD_CURRPLANET = "Current_Planet";

    //Inventory colls
    /*
    private static final String FIELD_ = "";
    private static final String FIELD_ = "";
    private static final String FIELD_ = "";
    private static final String FIELD_ = "";
    private static final String FIELD_ = "";
    private static final String FIELD_ = "";
    private static final String FIELD_ = "";
	*/
    //Planet colls
    private static final String FIELD_PLANET = "name";
    private static final String FIELD_TECH = "Tech_LV";
    private static final String FIELD_POLSYS = "Political_sys";
    private static final String FIELD_RESOURCE = "Resource_Type";
    private static final String FIELD_X = "X";
    private static final String FIELD_Y = "Y";
    //Game
    private static final String FIELD_CURRTURN = "Current_Turn";
    private static final String FIELD_CURRPLAYER = "Current_player";
    private static final String FIELD_DIFF = "Difficulty";
    private static final String FIELD_XDIM = "X_dimension";
    private static final String FIELD_YDIM = "y_diminsion";
	
	
	public void LoadGame(String fName)throws SqlJetException{
		DB_NAME=fName+".sqlite";
		dbFile = new File(DB_NAME);
	    db = SqlJetDb.open(dbFile, true);
        db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
		LoadPlayers(db.getTable(TABLE_PLAYERS));
		LoadPlanets(db.getTable(TABLE_PLANETS));
		//LoadInventory(db.getTable(TABLE_INVENTORY));
		LoadSettings(db.getTable(TABLE_SETTINGS));
	}
	private Collection<Player> LoadPlayers(ISqlJetTable tbl )throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString(FIELD_NAME)	+ " " + 
	                            cursor.getString(FIELD_MONEY)	+ " " + 
	                            cursor.getString(FIELD_SHIP)	+ " " + 
	                            cursor.getString(FIELD_CURRPLANET)	+ " "+
	                            cursor.getString(FIELD_PILOTING)	+ " " + 
	                            cursor.getString(FIELD_FIGHTING)	+ " " + 
	                            cursor.getString(FIELD_ENGINEERING)	+ " " + 
	                            cursor.getString(FIELD_TRADING)	+ " "
	                            );
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return null;
	}
	private void LoadInventory(ISqlJetTable tbl)throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {/*
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString()	+ " " + 
	                            cursor.getString()	+ " " + 
	                            cursor.getString()	+ " " + 
	                            cursor.getString()	+ " "
	                            );*/
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
	}
	private Collection<Planet> LoadPlanets(ISqlJetTable tbl)throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString(FIELD_PLANET)	+ " " + 
	                            cursor.getString(FIELD_TECH)	+ " " + 
	                            cursor.getString(FIELD_POLSYS)	+ " " + 
	                            cursor.getString(FIELD_RESOURCE)	+ " "+
	                            cursor.getString(FIELD_X)	+ " " + 
	                            cursor.getString(FIELD_Y)	+ " " 
	                            );
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return null;
	}
	private Settings LoadSettings(ISqlJetTable tbl)throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {	               
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString(FIELD_CURRTURN)	+ " " + 
	                            cursor.getString(FIELD_CURRPLAYER)	+ " " + 
	                            cursor.getString(FIELD_DIFF)	+ " "
	                            );
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return null;
	}
	
	
	

}
