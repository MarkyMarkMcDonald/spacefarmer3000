// made my mykal thomas
package app.service;

import app.factory.UniverseFactory;
import app.model.Game;
import app.model.Inventory;
import app.model.Settings;
import app.model.player.Player;
import app.model.player.SkillType;
import app.model.tradegoods.Tradable;
import app.model.universe.Planet;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import java.io.File;
//import java.util.Collection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * hold the information for the game in a database
 * 
 * @author mykal thomas
 * @version 1
 **/
public class Saver_db {
	
	/**
	 * an array of the game's current players
	 */
	private final Player[] players;
	
	/**
	 * an array of the game's current planets
	 */
	 private final Planet[] planets;
	
	/**
	 * the game's current settings
	 */
	private final Settings gameSettings;
	
	/**
	 * the current game
	 */
	private final Game game;

	/**
	 *  db file
	 */
	private final File dbFile;
	
	/**
	 *  table:players
	 */
	private static final String TABLE_PLAYERS = "Players";
	
	/**
	 *  table:Inventory
	 */
	private static final String TABLE_INVENTORY = "Inventory";
	
	/**
	 *  table:Planets
	 */
	private static final String TABLE_PLANETS = "Planets";
	
	/*
	 * table settings
	//private static final String TABLE_SETTINGS = "Game";
	 */
	/**
	 * table:Planetary systems
	 */
	private static final String TABLE_PLANSYS = "PlanetarySys";
	
	//PLAYER COLLUMS
	/** 
	 * Player field: Name
	 */
	private static final String FIELD_NAME = "Name";

	/** 
	 * Player field: Piloting
	 */
	private static final String FIELD_PILOTING = "Piloting";

	/** 
	 * Player field: Trading
	 */
	private static final String FIELD_TRADING = "Trading";

	/** 
	 * Player field: Engineering
	 */
	private static final String FIELD_ENGINEERING = "Engineering";

	/** 
	 * Player field: Fighting
	 */
	private static final String FIELD_FIGHTING = "Fighting";

	/** 
	 * Player field: Money
	 */
	private static final String FIELD_MONEY = "Money";

	/** 
	 * Player field: Ship
	 */
	private static final String FIELD_SHIP = "Ship";

	/** 
	 * Player field: Current Planet
	 */
	private static final String FIELD_CURRPLANET = "Current_Planet";

	// Inventory colls
	/*
	 * private static final String FIELD_ = ""; private static final String
	 * FIELD_ = ""; private static final String FIELD_ = ""; private static
	 * final String FIELD_ = ""; private static final String FIELD_ = "";
	 * private static final String FIELD_ = ""; private static final String
	 * FIELD_ = "";
	 */
	// PLANET COLLUMS
	/**
	 * Planet Table: Name
	 */
	private static final String FIELD_PLANET = "PlanetName";

	/**
	 * Planet Table: Tech Level
	 */
	private static final String FIELD_TECH = "Tech_LV";

	/**
	 * Planet Table: Political system
	 */
	private static final String FIELD_POLSYS = "Political_sys";

	/**
	 * Planet Table: Resource type
	 */
	private static final String FIELD_RESOURCE = "Resource_Type";

	/**
	 * Planet Table: X coordinate
	 */
	private static final String FIELD_X = "X";

	/**
	 * Planet Table: Y coordinate
	 */
	private static final String FIELD_Y = "Y";

	/**
	 * Planet Table/ System Table: SYSTEM
	 */
	private static final String FIELD_SYS = "system";
	
	/**
	 * Player Table: Fule
	 */
	private static final String FIELD_FULE = "fule";

	/**
	 * Planet Table: event
	 */
	private static final String FIELD_EVENT = "event";

	/**
	 * Query short hand
	 */
	private static final String TNN = " TEXT NOT NULL , ";

	/**
	 * table:market
	 */
	private static final String TABLE_MARKETS = "Market";

	/**
	 * Market table: item name
	 */
	private static final String FIELD_ITEM = "ItemName";

	/**
	 * Market table: Quantity
	 */
	private static final String FIELD_Q = "Quantity";
	
	/**
	 * Market table: item subname
	 */
	private static final String FIELD_SUB = "ItemSubName";
	
	/**
	 * Constructor for the saver
	 * 
	 * @param dbFile
	 * 	the database file
	 * @param people
	 *  an array of players in the game
	 * @param universe
	 * 	an array of players
	 * @param settings
	 * 	the games settings
	 * @param game
	 * 	the actual game
	 */
	public Saver_db(File dbFile, List<Player> people,
			Map<String,Planet> universe, Settings settings, Game game) {
		this.dbFile = dbFile;
		this.players = new Player[people.size()];
		for(int i=0;i<people.size();i++)
			players[i]=people.get(i);
			
		Set temp=universe.keySet();
		
		Object[] tempO=temp.toArray();
		Planet[] tempP=new Planet[tempO.length];
		for(int i=0;i<tempO.length;i++)
			tempP[i]=universe.get(tempO[i]);
		
		this.planets =tempP;
		this.gameSettings = settings;
		this.game = game;
	}

	/**
	 * saves all tables to the database by running the individual save table
	 * functions
	 * 
	 * @throws SqlJetException
	 */
	public void saveGame() throws SqlJetException {
		try{
		dbFile.delete();
		} finally{
			
		}
		// create database
		final SqlJetDb db = SqlJetDb.open(dbFile, true);
		// set DB option that have to be set before running any transactions:
		db.getOptions().setAutovacuum(true);
		db.beginTransaction(SqlJetTransactionMode.WRITE);
		// set DB version
		try {
			db.getOptions().setUserVersion(1);
		} finally {
			db.commit();

			db.beginTransaction(SqlJetTransactionMode.WRITE);

			this.savePlayers(db);
			//this.saveInventory(db);
			this.savePlanets(db);
			//this.SaveSetting(db);
			this.saveMarkets(db);
			this.saveSystems(db);
			db.close();
		}
	}

	/**
	 * saves the players to the players table in the database
	 * 
	 * @param db
	 *            database
	 * @throws SqlJetException
	 */
	private void savePlayers(SqlJetDb db) throws SqlJetException {
		final String createTableQuery = "CREATE TABLE " + TABLE_PLAYERS + " " + "("
				+ FIELD_NAME + TNN + FIELD_MONEY + TNN + FIELD_FULE + TNN
				+ FIELD_CURRPLANET + TNN + FIELD_SHIP + TNN + FIELD_PILOTING
				+ TNN + FIELD_TRADING + TNN + FIELD_ENGINEERING + TNN
				+ FIELD_FIGHTING + " TEXT NOT NULL)";
		// makes the table
		try {
			db.createTable(createTableQuery);
		} finally {
			db.commit();
		}
		// fill in the Database
		try {
			final ISqlJetTable table = db.getTable(TABLE_PLAYERS);
			// Test entry
			//table.insert("ZOOL", 9999, "Earth", "BFS", 1, 2, 3, 4);
			 for (int i=0;i<this.players.length;i++) {
				 table.insert(this.players[i].getName(),this.players[i].getMoney(),
						 this.players[i].getFuel(),this.players[i].getCurrentPlanet().getName(),
						 this.players[i].getShip().getType().toString(),
						 this.players[i].getSkillLevels().containsKey(SkillType.PILOTING),
						 this.players[i].getSkillLevels().containsKey(SkillType.ENGINEERING),
						 this.players[i].getSkillLevels().containsKey(SkillType.FIGHTING),
						 this.players[i].getSkillLevels().containsKey(SkillType.TRADING));			 }
		} finally {
			db.commit();
		}
	}

	/**
	 * saves the planets to the planets table
	 * 
	 * @param db
	 * @throws SqlJetException
	 */
	private void savePlanets(SqlJetDb db) throws SqlJetException {
		final Planet[] temp =planets;
		final String createTableQuery = "CREATE TABLE " + TABLE_PLANETS + " " + "("
				+ FIELD_PLANET + " TEXT NOT NULL PRIMARY KEY, " + FIELD_SYS
				+ TNN + FIELD_TECH + TNN + FIELD_POLSYS + TNN + FIELD_RESOURCE
				+ TNN + FIELD_X + TNN + FIELD_Y + TNN + FIELD_EVENT
				+ " TEXT NOT NULL)";
		// makes the table
		try {
			db.createTable(createTableQuery);
		} finally {
			db.commit();
		}
		// fill in the Database
		try {
			final ISqlJetTable table = db.getTable(TABLE_PLANETS);
			// Test entry
			/*table.insert("EARTH", "milky way", "OVER9000", "BICKERING",
					"EVERYTHING", 1, 2);*/
			for (int i = 0; i < temp.length; i++)
				table.insert(temp[i].getName(), temp[i].getPlanetarySystem()
						.getName(), temp[i].getTechnologyLevel().name(),
						temp[i].getPoliticalSystem().getName(), temp[i]
								.getResourceType().getName(), temp[i].getX(),
						temp[i].getY(), temp[i].getEvent().toString());

		} finally {
			db.commit();
		}
	}

	/**
	 * saves the settings to the settings table
	 * 
	 * @param db
	 * @throws SqlJetException
	 */
	
	private void saveInventory(SqlJetDb db) throws SqlJetException {
		
		  String createTableQuery = "CREATE TABLE " + TABLE_INVENTORY + " " +
		  "(" + FIELD_NAME + TNN + FIELD_ITEM+ TNN+ FIELD_Q+
		  " TEXT NOT NULL )"; //makes the table try
		  
		  try
		  {db.createTable(createTableQuery);
		  }finally {db.commit();} 
		  //fill inthe Database 
		  try { ISqlJetTable table =db.getTable(TABLE_INVENTORY); //Test entry //table.insert("ZOOL",1,2);
		  for (int i=0;i<this.players.length;i++)
		  {
			  Inventory tempI=players[i].getInventory();
			  Set tempS=tempI.getInventoryEntries();
			  Tradable tempTrade= (Tradable) tempS.iterator().next();
			  
			  table.insert(players[i].getName(),"bla","bla");
		  }
		  
		  } finally {db.commit();}
		 
	}

	private void saveMarkets(SqlJetDb db) throws SqlJetException {
		final Planet[] tempP =this.planets;
		//UniverseFactory.getAllPlanets().values().toArray(tempP);
		Map<Tradable, Integer> tempM;
		Tradable[] tempTradeArray = null;
		Tradable thing=null;
		Set tempS=null;
		final String createTableQuery = "CREATE TABLE " + TABLE_MARKETS + " " + "("
				+ FIELD_ITEM + TNN + /**/"Price"+TNN+ FIELD_Q + TNN + FIELD_PLANET
				+ " TEXT NOT NULL)";

		// makes the table
		try {
			db.createTable(createTableQuery);
		} finally {
			db.commit();
		}
		// fill in the Database
		try {
			final ISqlJetTable table = db.getTable(TABLE_MARKETS);
			// Test entry

			// table.insert("ZOOL",1,2);
			
			for (int i = 0; i < tempP.length; i++) {
				tempM = tempP[i].getMarket().getQuantityMap();
				//tempTradeArray=tempM.keySet().toArray(tempTradeArray);
				tempS=tempM.keySet();
				tempTradeArray=new Tradable[tempS.size()];
				//for(int j=0;j<tempS.size();j++){
					thing=(Tradable) tempS.iterator().next();
					//tempTradeArray[j]=thing;
			//	}
				//System.out.println(tempS.iterator().toString());
				//tempTradeArray=(Tradable[]) tempO;
				//for (int j = 0; j < tempTradeArray.length; j++) {
					table.insert(thing.getName(),
							thing.getBasePrice(),
							tempM.get(thing),
							tempP[i].getName());

				//}
				
			}
		} finally {
			db.commit();
		}
	}
	
/**
 * 
 * @param db
 * 	database passed into the function
 * @throws SqlJetException
 */
	private void saveSystems(SqlJetDb db) throws SqlJetException {
		final Planet[] tempPlan =planets;
		final String createTableQuery = "CREATE TABLE " + TABLE_PLANSYS + " " + "("
				+ FIELD_SYS + TNN + FIELD_X + TNN + FIELD_Y + TNN
				+ FIELD_PLANET + " TEXT NOT NULL)";

		// makes the table
		try {
			db.createTable(createTableQuery);
		} finally {
			db.commit();
		}
		// fill in the Database
		try {
			final ISqlJetTable table = db.getTable(TABLE_PLANSYS);
			for (int i = 0; i < tempPlan.length; i++) {
				table.insert(tempPlan[i].getPlanetarySystem().getName(),
						tempPlan[i].getPlanetarySystem().getX(), tempPlan[i]
								.getPlanetarySystem().getY(), tempPlan[i]
								.getName());
			}
		} finally {
			db.commit();
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Saver_db";
	}
}
