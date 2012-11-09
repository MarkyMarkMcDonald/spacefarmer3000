package App.service;


import App.model.Player.Player;
import App.model.Universe.Planet;
import App.model.Settings;
import App.model.Player.SkillType;
import App.model.Game;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import java.io.File;
import java.util.Collection;

/**
* hold the information for the
* game in a database
*
* Mykal Thomas Settings 11/1/2012
*
**/
public class Saver_db {
	String saveName;
	String saveLocation;
	Collection<Player> players;
	Collection <Planet> planets;
	Settings gameSettings;
	Game game;
	//name of the database
	private static String DB_NAME = "db.sqlite";
	//table names
    private static final String TABLE_PLAYERS = "Players";
    private static final String TABLE_INVENTORY = "Inventory";
    private static final String TABLE_PLANETS = "Planets";
    private static final String TABLE_SETTINGS = "Game";
    //player colls
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

	/**
	 * Constructer for the saver
	 * @param loc the array of save locations
	 * @param people a collection of players in the game
	 * @param universe a collection of planets in the game
	 * @param settings the settings for the game.
	 */
	 Saver_db(String name,String loc, Collection <Player>people, Collection <Planet>universe, Settings settings, Game game){
		saveName=name;
		saveLocation=loc;
		players= people;
		planets=universe;
		gameSettings=settings;
		DB_NAME=name+".sqlite";
		this.game=game;
	}
	 /**
	  * saves all tables to the database by running the individual save table functions
	  * 
	  * @throws SqlJetException
	  */
	private void SaveGame()throws SqlJetException {
		File dbFile = new File(DB_NAME);
	    dbFile.delete();

	    // create database
	    SqlJetDb db = SqlJetDb.open(dbFile, true);
	    // set DB option that have to be set before running any transactions:
	    db.getOptions().setAutovacuum(true);
	    db.beginTransaction(SqlJetTransactionMode.WRITE);
	    //set DB version
	    try{db.getOptions().setUserVersion(1);}
	    finally {db.commit();}

	    db.beginTransaction(SqlJetTransactionMode.WRITE);

		this.SavePlayers(db);
		this.SaveInventory(db);
		this.SavePlanets(db);
		this.SaveSetting(db);
    	db.close();
	}
	/**
	 * saves the players to the players table in the database
	 * @param db database
	 * @throws SqlJetException
	 */
	private void SavePlayers(SqlJetDb db)throws SqlJetException {
		 Player[] temp=(Player[]) players.toArray();
		String createTableQuery = "CREATE TABLE " + TABLE_PLAYERS + " " +
		 		"(" + FIELD_NAME + " TEXT NOT NULL , " + FIELD_MONEY +" TEXT NOT NULL , "+ FIELD_CURRPLANET + " TEXT NOT NULL , " + FIELD_SHIP + " TEXT NOT NULL , " + FIELD_PILOTING + " TEXT NOT NULL , "+ FIELD_TRADING + " TEXT NOT NULL , "+ FIELD_ENGINEERING + " TEXT NOT NULL , "+ FIELD_FIGHTING + " TEXT NOT NULL)";
		 //makes the table
		 try {db.createTable(createTableQuery);}
		 	finally {db.commit();}
		 //fill in the Database
		 try
		    {
		    	ISqlJetTable table = db.getTable(TABLE_PLAYERS);
		    	//Test entry
		    	table.insert("ZOOL",9999,"Earth","BFS",1,2,3,4);
		    	for(int i=0;i<players.size();i++)
			    	table.insert(temp[i].getName(),temp[i].getMoney(),temp[i].getCurrentPlanet().getName(),temp[i].getShip().getType().toString(),
			    			temp[i].getSkillLevels().containsKey(SkillType.PILOTING),temp[i].getSkillLevels().containsKey(SkillType.ENGINEERING),temp[i].getSkillLevels().containsKey(SkillType.FIGHTING),temp[i].getSkillLevels().containsKey(SkillType.TRADING));
		    }
		 	finally {db.commit();}
	}
	/**
	 * saves the players inventories to the  database
	 * @param db
	 * @throws SqlJetException
	 */
	private void SaveInventory(SqlJetDb db)throws SqlJetException {
	/*	String createTableQuery = "CREATE TABLE " + TABLE_INVENTORY + " " +
		 		"(" + FIELD_NAME + " TEXT NOT NULL , " + FIELD_CURR + " TEXT NOT NULL , " + FIELD_SHIP + " TEXT NOT NULL , " + FIELD_PILOTING + " TEXT NOT NULL , "+ FIELD_TRADING + " TEXT NOT NULL , "+ FIELD_ENGINEERING + " TEXT NOT NULL , "+ FIELD_FIGHTING + " TEXT NOT NULL)";

		//makes the table
		 try {db.createTable(createTableQuery);}
		 finally {db.commit();}
		  //fill in the Database
		 try
		    {
		    	ISqlJetTable table = db.getTable(TABLE_PLAYERS);
		    	table.insert("Thomas","Mykal");
		    	table.insert("nortan","Mykal");
		    }
		 	finally {db.commit();}
		*/}
	/**
	 * saves the planets to the planets table
	 * @param db
	 * @throws SqlJetException
	 */
	private void SavePlanets(SqlJetDb db)throws SqlJetException {
		 Planet[] temp=(Planet[]) planets.toArray();
		String createTableQuery = "CREATE TABLE " + TABLE_PLANETS + " " +
		 		"(" + FIELD_PLANET + " TEXT NOT NULL , " + FIELD_TECH + " TEXT NOT NULL , " + FIELD_POLSYS + " TEXT NOT NULL , " + FIELD_RESOURCE + " TEXT NOT NULL , "+ FIELD_X + " TEXT NOT NULL , "+ FIELD_Y + " TEXT NOT NULL)";
		//makes the table
		try {db.createTable(createTableQuery);}
			finally {db.commit();}
		 //fill in the Database
		 try
		    {
		    	ISqlJetTable table = db.getTable(TABLE_PLANETS);
		    	//Test entry
		    	table.insert("EARTH","OVER9000","BICKERING","EVERYTHING",1,2);
		    	for(int i=0;i<temp.length;i++)
			    	table.insert(temp[i].getName(),temp[i].getTechnologyLevel().name(),temp[i].getPoliticalSystem().getName(),temp[i].getResourceType().getName(),temp[i].getX(),temp[i].getY());

		    }
		 	finally {db.commit();}
	}
	/**
	 * saves the settings to the settings table
	 * @param db
	 * @throws SqlJetException
	 */
	private void SaveSetting(SqlJetDb db)throws SqlJetException {
		String createTableQuery = "CREATE TABLE " + TABLE_SETTINGS + " " +
		 		"(" + FIELD_DIFF + " TEXT NOT NULL , " + FIELD_CURRTURN + " TEXT NOT NULL , " + FIELD_CURRPLAYER + " TEXT NOT NULL )";
		//makes the table
		try {db.createTable(createTableQuery);}
			finally {db.commit();}
		 //fill in the Database
		 try
		    {
		    	ISqlJetTable table = db.getTable(TABLE_SETTINGS);
		    	//Test entry
		    	table.insert(7,-8,"ZOOL",1,2);
//		    	table.insert(gameSettings.getDifficulty(),game.getTurnNumber(),game.getCurrentPlayer());

		    }
		 	finally {db.commit();}
	}
}
