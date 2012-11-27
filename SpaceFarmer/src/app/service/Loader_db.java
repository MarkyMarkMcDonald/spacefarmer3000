// $codepro.audit.disable questionableAssignment, handleNumericParsingErrors, nullPointerDereference, packagePrefixNamingConvention
/*This file holds the class Loader_db, which is repronsible for
 * loading the Database.
 */
package app.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import app.factory.UniverseFactory;
import app.model.Event;
import app.model.Game;
import app.model.MarketPlace;
import app.model.Settings;
import app.model.Ship;
import app.model.ShipModel;
import app.model.player.Player;
import app.model.player.SkillType;
import app.model.tradegoods.BasicGood;
import app.model.tradegoods.TradeGoodType;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;
import app.model.universe.PoliticalSystem;
import app.model.universe.ResourceType;
import app.model.universe.TechnologyLevel;

/*
 import app.model.Universe.Planet;
 import app.model.Player.Player;
 import app.model.Settings;
 */
/**
 * 
 * @author Mykal Thomas
 * @version 1
 *
 */
public class Loader_db {
	
	/**
	 * name of the saved game
	 */
	//private String saveName;

	/**
	 * location of the saved game
	 */
//	private String saveLocation;

	/**
	 * the game database
	 */
	private SqlJetDb db;
	
	/**
	 *  table:players
	 */
	private static final String TABLE_PLAYERS = "Players";

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
	 * table:market
	 */
	private static final String TABLE_MARKETS = "Market";

	/**
	 * map of the PlanetarySystems pulled from the tables
	 */
	private static Map<String, PlanetarySystem> Ps=new HashMap<String, PlanetarySystem>();

	/**
	 * map of the planets pulled from the tables
	 */
	private static Map<String, Planet> Planets=new HashMap<String, Planet>();

	/**
	 * array of players pulled from the tables.
	 */
	private static Player[] Players=new Player[10];

	/**
	 * loads the file and recreates the game
	 * @param dbFile
	 * 	the game file
	 * @param ps
	 * 	planetary system
	 * @param planets
	 * 	the planets
	 * @param players
	 * 	array of players
	 * @throws SqlJetException
	 */
	public void loadGame(File dbFile, Map<String, PlanetarySystem> ps,
			Map<String, Planet> planets, Collection<Player> players)
			throws SqlJetException {
		db = SqlJetDb.open(dbFile, true);
		db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
		// make the systems
		ps = loadSystems(db.getTable(TABLE_PLANSYS));
		UniverseFactory.setPlanetarySystems(ps);
		// make the planets
		planets = loadPlanets(db.getTable(TABLE_PLANETS), ps);
		UniverseFactory.setAllPlanets(planets);
		// make the players
		players = loadPlayers(db.getTable(TABLE_PLAYERS), planets);
		Game.setCurrentPlayer(players.iterator().next());
		// markets
		loadMarkets(db.getTable(TABLE_MARKETS), planets);

		// LoadInventory(db.getTable(TABLE_INVENTORY));
		// LoadSettings(db.getTable(TABLE_SETTINGS));
	}

	/**
	 * CREATES A COLLECTION OF PLAYERS AND RETURNS THEM
	 * 
	 * @param tbl
	 * @return a collection of players
	 * @throws SqlJetException
	 */
	private Collection<Player> loadPlayers(ISqlJetTable tbl,Map<String, Planet> pl)
			throws SqlJetException {
		final ISqlJetCursor cursor = tbl.open();
		final Collection<Player> ret = new ArrayList<Player>();
		final Player tempP = new Player();
		final Ship tempShip = new Ship();
		ShipModel tempMod = null;
		// Planet tempPlanet;
		final Map<SkillType, Integer> tempSkill = new HashMap<SkillType, Integer>();
		try {
			if (!cursor.eof()) {
				do {
					// name
					tempP.setName(cursor.getString(FIELD_NAME));
					// money
					tempP.setMoney(Integer.parseInt(cursor
							.getString(FIELD_MONEY)));
					// fule
					tempP.setFuel(Integer.parseInt(cursor.getString(FIELD_FULE)));
					// ship
					//tempMod = ShipModel.valueOf((cursor.getString(FIELD_SHIP)));
					//tempShip.setType(tempMod);
					//tempP.setShip(tempShip);
					// curr planet
					 tempP.setCurrentPlanet(pl.get(cursor.getString(FIELD_CURRPLANET)));
					// inventory
					// tempP.setInventory)
					// skills
					tempSkill.put(SkillType.ENGINEERING, Integer
							.parseInt(cursor.getString(FIELD_ENGINEERING)));
					tempSkill.put(SkillType.FIGHTING,
							Integer.parseInt(cursor.getString(FIELD_FIGHTING)));
					tempSkill.put(SkillType.PILOTING,
							Integer.parseInt(cursor.getString(FIELD_PILOTING)));
					tempSkill.put(SkillType.TRADING,
							Integer.parseInt(cursor.getString(FIELD_TRADING)));
					ret.add(tempP);

					/*
					 * System.out.println("this is a test");
					 * System.out.println(cursor.getRowId() + " " +
					 * cursor.getString(FIELD_NAME) + " " +
					 * cursor.getString(FIELD_MONEY) + " " +
					 * cursor.getString(FIELD_SHIP) + " " +
					 * cursor.getString(FIELD_CURRPLANET) + " "+
					 * cursor.getString(FIELD_PILOTING) + " " +
					 * cursor.getString(FIELD_FIGHTING) + " " +
					 * cursor.getString(FIELD_ENGINEERING) + " " +
					 * cursor.getString(FIELD_TRADING) + " "
					 */

				} while (cursor.next());
			}
		} finally {
			cursor.close();
		}
		return ret;
	}

	/**
	 * reads the planets table and creates the planets from them
	 * @param tbl
	 * 	planets table
	 * @param ps 
	 * @return
	 *  a map of the created planets
	 * @throws SqlJetException
	 */
	private Map<String, Planet> loadPlanets(ISqlJetTable tbl, Map<String, PlanetarySystem> ps)
			throws SqlJetException {
		final ISqlJetCursor cursor = tbl.open();
		final Map<String, Planet> ret = new HashMap<String, Planet>();
		final Planet tempPlanet = new Planet();
		TechnologyLevel tempTech = null;
		PlanetarySystem tempSys = new PlanetarySystem() ;
		ResourceType tempRes = null;
		// PlanetarySystem tempPs = null;
		PoliticalSystem tempPol = null;
		Event tempE = null;
		try {
			if (!cursor.eof()) {
				do {
					// planet name
					tempPlanet.setName(cursor.getString(FIELD_PLANET));
					// planet tech level
					tempTech = TechnologyLevel.valueOf(cursor.getString(FIELD_TECH));
					tempPlanet.setTechnologyLevel(tempTech);
					// planet x & y
					tempPlanet
							.setX(Integer.parseInt(cursor.getString(FIELD_X)));
					tempPlanet
							.setX(Integer.parseInt(cursor.getString(FIELD_Y)));
					// resource type
					//tempRes = ResourceType.valueOf(cursor.getString(FIELD_RESOURCE));
					//tempPlanet.setResourceType(tempRes);
					// Political system
					//tempPol = PoliticalSystem.valueOf(cursor.getString(FIELD_POLSYS));
					//tempPlanet.setPoliticalSystem(tempPol);
					// Planetary system
					tempSys = ps.get(cursor.getString(FIELD_SYS));
					tempPlanet.setPlanetarySystem(tempSys);
					// market
					// tempPlanet.setMarket(market)
					// event
					tempE = Event.valueOf(cursor.getString(FIELD_EVENT));
					tempPlanet.setEvent(tempE);

					//ps.get(cursor.getString(FIELD_SYS)).getPlanets().put(tempPlanet.getName(), tempPlanet);

					ret.put(tempPlanet.getName(), tempPlanet);
					/*
					 * System.out.println("this is a test");
					 * System.out.println(cursor.getRowId() + " " +
					 * cursor.getString(FIELD_PLANET) + " " +
					 * cursor.getString(FIELD_TECH) + " " +
					 * cursor.getString(FIELD_POLSYS) + " " +
					 * cursor.getString(FIELD_RESOURCE) + " "+
					 * cursor.getString(FIELD_X) + " " +
					 * cursor.getString(FIELD_Y) + " "
					 */
				} while (cursor.next());
			}
		} finally {
			cursor.close();
		}
		return ret;
	}

	/**
	 * makes the planetary systems based of the table
	 * @param tbl
	 * 	ps table
	 * @return
	 * 	a map of the planetary systems
	 * @throws SqlJetException
	 */
	private Map<String, PlanetarySystem> loadSystems(ISqlJetTable tbl)
			throws SqlJetException {
		final Map<String, PlanetarySystem> psMap = new HashMap<String, PlanetarySystem>();
		final PlanetarySystem tempPS = new PlanetarySystem();
		final ISqlJetCursor cursor = tbl.open();
		// Makes a map of systems
		try {
			if (!cursor.eof()) {
				do {
					if (psMap.containsKey(cursor.getString(FIELD_SYS)) != true) {
						tempPS.setName(cursor.getString(FIELD_SYS));
						tempPS.setX(Integer.parseInt(cursor.getString(FIELD_X)));
						tempPS.setY(Integer.parseInt(cursor.getString(FIELD_Y)));
						psMap.put(tempPS.getName(), tempPS);
					}
				} while (cursor.next());
			}
		} finally {
			cursor.close();
		}
		return psMap;
	}

	/**
	 * loads the markets based on the markets table
	 * @param tbl
	 * @param planets 
	 * @throws SqlJetException
	 */
	private void loadMarkets(ISqlJetTable tbl, Map<String, Planet> planets) throws SqlJetException {
		MarketPlace tempM = null;
		BasicGood tempTrade;
		TradeGoodType tempType = null;
		ArrayList ret = new ArrayList();
		final ISqlJetCursor cursor = tbl.open();
		try {
			if (!cursor.eof()) {
				do {
					/*
					if(planets.get(cursor.getString(FIELD_PLANET)).getMarket()==null)
						planets.get(cursor.getString(FIELD_PLANET)).setMarket(new MarketPlace(planets.get(cursor.getString(FIELD_PLANET))));
					
					tempM=planets.get(cursor.getString(FIELD_PLANET)).getMarket();
					
					tempType = TradeGoodType.valueOf(cursor.getString(FIELD_ITEM));
					tempTrade = new BasicGood(tempType, tempType);
					tempM.setQuantity(tempTrade, cursor.getString(FIELD_Q));
					
					planets.get(cursor.getString(FIELD_PLANET)).setMarket(tempM);
					planets.get(cursor.getString(FIELD_PLANET)).getMarket()
							.changeQuantity(tempTrade,
									Integer.parseInt(cursor.getString(FIELD_Q)));
									*/
				} while (cursor.next());
			}
		} finally {
			cursor.close();
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Loader_db";
	}
}
