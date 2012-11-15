package App.service;


import App.model.Game;
import App.model.Player.Player;
import App.model.Settings;
import App.model.TradeGoods.Tradable;
import App.model.Universe.Planet;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * hold the information for the
 * game in a database
 *
 * Mykal Thomas Settings 11/1/2012
 *
 **/
public class Saver_db {
	private Collection<Player> players;
	
	private Collection <Planet> planets;
	
	private Settings gameSettings;
	
	private Game game;
	
	//db file
	private File dbFile;
	
	//table names
	private static final String TABLE_PLAYERS = "Players";
	
	private static final String TABLE_INVENTORY = "Inventory";
	
	private static final String TABLE_PLANETS = "Planets";
	
	private static final String TABLE_SETTINGS = "Game";
	
	private static final String TABLE_PLANSYS = "PlanetarySys";

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

	//added fields
	private static final String FIELD_SYS = "system";
	
	private static final String FIELD_FULE = "fule";
	
	private static final String FIELD_EVENT = "event";
	
	private static final String TNN = " TEXT NOT NULL , ";


	private static final String TABLE_MARKETS = "Market";
	
	private static final String FIELD_ITEM = "Item";

	private static final String FIELD_Q = "Quantity";

	/**
	 * Constructer for the saver
	 * @param dbFile
	 * @param people a collection of players in the game
	 * @param universe a collection of planets in the game
	 * @param settings the settings for the game.
	 */
	public Saver_db(File dbFile, Collection<Player> people, Collection<Planet> universe, Settings settings, Game game){
		this.dbFile = dbFile;
		players= people;
		planets=universe;
		gameSettings=settings;
		this.game=game;
	}
	
	/**
	 * saves all tables to the database by running the individual save table functions
	 * 
	 * @throws SqlJetException
	 */
	public void SaveGame()throws SqlJetException {
		dbFile.delete();

		// create database
		SqlJetDb db = SqlJetDb.open(dbFile, true);
		// set DB option that have to be set before running any transactions:
		db.getOptions().setAutovacuum(true);
		db.beginTransaction(SqlJetTransactionMode.WRITE);
		//set DB version
		try{
			db.getOptions().setUserVersion(1);
		}
		finally {
			db.commit();
		}

		db.beginTransaction(SqlJetTransactionMode.WRITE);

		this.SavePlayers(db);
		this.SaveInventory(db);
		this.SavePlanets(db);
		this.SaveSetting(db);
		this.SaveMarkets(db);
		this.SaveSystems(db);
		db.close();
	}
	
	/**
	 * saves the players to the players table in the database
	 * @param db database
	 * @throws SqlJetException
	 */
	private void SavePlayers(SqlJetDb db)throws SqlJetException {
		String createTableQuery = "CREATE TABLE " + TABLE_PLAYERS + " " +
				"(" + FIELD_NAME + TNN + FIELD_MONEY +TNN+FIELD_FULE+TNN+ FIELD_CURRPLANET + TNN + FIELD_SHIP + TNN + FIELD_PILOTING + TNN+ FIELD_TRADING + TNN+ FIELD_ENGINEERING + TNN+ FIELD_FIGHTING + " TEXT NOT NULL)";
		//makes the table
		try {
			db.createTable(createTableQuery);
		} finally {
			db.commit();
		}
		//fill in the Database
		try {
			ISqlJetTable table = db.getTable(TABLE_PLAYERS);
			//Test entry
			table.insert("ZOOL",9999,"Earth","BFS",1,2,3,4);
			for (Player player : players){
				//                table.insert(temp[i].getName(),temp[i].getMoney(),temp[i].getFuel(),temp[i].getCurrentPlanet().getName(),temp[i].getShip().getType().toString(),
				//                            temp[i].getSkillLevels().containsKey(SkillType.PILOTING),temp[i].getSkillLevels().containsKey(SkillType.ENGINEERING),temp[i].getSkillLevels().containsKey(SkillType.FIGHTING),temp[i].getSkillLevels().containsKey(SkillType.TRADING));
				//
			}
		}
		finally {
			db.commit();
		}
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
		 */
	}
	
	/**
	 * saves the planets to the planets table
	 * @param db
	 * @throws SqlJetException
	 */
	private void SavePlanets(SqlJetDb db)throws SqlJetException {
		Planet[] temp=(Planet[]) planets.toArray();
		String createTableQuery = "CREATE TABLE " + TABLE_PLANETS + " " +
				"(" + FIELD_PLANET + " TEXT NOT NULL PRIMARY KEY, "+FIELD_SYS +TNN+ FIELD_TECH + TNN + FIELD_POLSYS + TNN + FIELD_RESOURCE + TNN+ FIELD_X + TNN+ FIELD_Y + TNN+ FIELD_EVENT+" TEXT NOT NULL)";
		//makes the table
		try {
			db.createTable(createTableQuery);
		}
		finally {
			db.commit();
		}
		//fill in the Database
		try {
			ISqlJetTable table = db.getTable(TABLE_PLANETS);
			//Test entry
			table.insert("EARTH","milky way","OVER9000","BICKERING","EVERYTHING",1,2);
			for(int i=0;i<temp.length;i++)
				table.insert(temp[i].getName(),temp[i].getPlanetarySystem().getName(),temp[i].getTechnologyLevel().name(),temp[i].getPoliticalSystem().getName(),temp[i].getResourceType().getName(),temp[i].getX(),temp[i].getY(),temp[i].getEvent().toString());

		}
		finally {
			db.commit();
		}
	}
	
	/**
	 * saves the settings to the settings table
	 * @param db
	 * @throws SqlJetException
	 */
	private void SaveSetting(SqlJetDb db)throws SqlJetException {
		/*
		String createTableQuery = "CREATE TABLE " + TABLE_SETTINGS + " " +
		 		"(" + FIELD_DIFF + TNN + FIELD_CURRTURN + TNN + FIELD_CURRPLAYER + " TEXT NOT NULL )";
		//makes the table
		try {db.createTable(createTableQuery);}
			finally {db.commit();}
		 //fill in the Database
		 try
		    {
			 //gameSettings.
		    	ISqlJetTable table = db.getTable(TABLE_SETTINGS);
		    	//Test entry
		    	//table.insert("ZOOL",1,2);
		    	//table.insert(game.getNumberOfTurns(),game.getCurrentPlayer());

		    }
		 	finally {db.commit();}
		 */
	}

	private void SaveMarkets(SqlJetDb db)throws SqlJetException {
		Planet[] tempP=(Planet[]) planets.toArray();
		Map<Tradable,Integer> tempM;
		Tradable[] tempTradeArray;
		String createTableQuery = "CREATE TABLE " + TABLE_MARKETS + " " +
				"("+FIELD_ITEM + TNN + FIELD_Q + TNN+ FIELD_PLANET + " TEXT NOT NULL)";

		//makes the table
		try {
			db.createTable(createTableQuery);
		}
		finally {
			db.commit();
		}
		//fill in the Database
		try {
			ISqlJetTable table = db.getTable(TABLE_MARKETS);
			//Test entry

			//table.insert("ZOOL",1,2);
			for(int i=0;i<tempP.length;i++) {
				tempM=tempP[i].getMarket().getQuantityMap();
				tempTradeArray=(Tradable[]) tempM.keySet().toArray();
				for(int j=0;j<tempTradeArray.length;j++) {
					table.insert(tempTradeArray[j],tempM.get(tempTradeArray[j]),tempP[i].getName());

				}
			}
		}
		finally {
			db.commit();
		}
	}

	private void SaveSystems(SqlJetDb db)throws SqlJetException {
		Planet[] tempPlan=(Planet[]) planets.toArray();
		String createTableQuery = "CREATE TABLE " + TABLE_PLANSYS + " " +
				"("+FIELD_SYS + TNN +FIELD_X+ TNN+FIELD_Y+TNN+FIELD_PLANET + " TEXT NOT NULL)";

		//makes the table
		try {
			db.createTable(createTableQuery);
		}
		finally {
			db.commit();
		}
		//fill in the Database
		try {
			ISqlJetTable table = db.getTable(TABLE_PLANSYS);
			for(int i=0;i<tempPlan.length;i++) {
				table.insert(tempPlan[i].getPlanetarySystem().getName(),tempPlan[i].getPlanetarySystem().getX(),tempPlan[i].getPlanetarySystem().getY(),tempPlan[i].getName());
			}
		}
		finally {
			db.commit();
		}
	}
}
