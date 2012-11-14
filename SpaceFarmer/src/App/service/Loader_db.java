package App.service;

import App.model.Player.Player;
import App.model.Player.SkillType;
import App.model.Event;
import App.model.MarketPlace;
import App.model.Settings;
import App.model.Ship;
import App.model.ShipModel;
import App.model.TradeGoods.BasicGood;
import App.model.TradeGoods.Tradable;
import App.model.TradeGoods.TradeGood;
import App.model.TradeGoods.TradeGoodType;
import App.model.Universe.Planet;
import App.model.Universe.PlanetarySystem;
import App.model.Universe.PoliticalSystem;
import App.model.Universe.ResourceType;
import App.model.Universe.TechnologyLevel;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/*
import App.model.Universe.Planet;
import App.model.Player.Player;
import App.model.Settings;
*/
public class Loader_db {
	private String saveName;
	private String saveLocation;
	
	
	Settings gameSettings;
	
	//name of the database
	private static String DB_NAME = "db.sqlite";
	private File dbFile = new File(DB_NAME);
	private SqlJetDb db;

	//table names
    private static final String TABLE_PLAYERS = "Players";
    private static final String TABLE_INVENTORY = "Inventory";
    private static final String TABLE_PLANETS = "Planets";
    private static final String TABLE_SETTINGS = "Game";
    private static final String TABLE_PLANSYS = "PlanetarySys";

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
  //added fields
    private static final String FIELD_SYS = "system";
    private static final String FIELD_FULE = "fule";
    private static final String FIELD_EVENT = "event";
    
    private static final String TABLE_MARKETS = "Market";
    private static final String FIELD_ITEM = "Item";
    private static final String FIELD_Q = "Quantity";

    Map<String,PlanetarySystem> PS;
    Map<String,Planet> Planets;
    Collection<Player> players;
	
	public void LoadGame(String fName,Map<String,PlanetarySystem> PS,Map<String,Planet> Planets,Collection<Player> players)throws SqlJetException{
		DB_NAME=fName+".sqlite";
		dbFile = new File(DB_NAME);
	    db = SqlJetDb.open(dbFile, true);
        db.beginTransaction(SqlJetTransactionMode.READ_ONLY);
        //make the systems
		PS=loadSystems(db.getTable(TABLE_PLANSYS));
		//make the planets
		Planets=LoadPlanets(db.getTable(TABLE_PLANETS));
		//make the players
		players=LoadPlayers(db.getTable(TABLE_PLAYERS));
		//markets
		LoadMarkets(db.getTable(TABLE_MARKETS));
		
		
		
		//LoadInventory(db.getTable(TABLE_INVENTORY));
		//LoadSettings(db.getTable(TABLE_SETTINGS));
	}
/**
 * CREATES A COLLECTION OF PLAYERS AND RETURNS THEM	
 * @param tbl
 * @return
 * @throws SqlJetException
 */
private Collection<Player> LoadPlayers(ISqlJetTable tbl )throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		Collection<Player> Ret = null;
		Player tempP = null;
		Ship tempShip = null;
		ShipModel tempMod = null;
		Planet tempPlanet;
		Map<SkillType, Integer> tempSkill = null;
		 try {
	            if (!cursor.eof()) {
	                do {
	                	//name
	                	tempP.setName(cursor.getString(FIELD_NAME));
	                	//money
	                	tempP.setMoney(Integer.parseInt(cursor.getString(FIELD_MONEY)));
	                	//fule
	                	tempP.setFuel(Integer.parseInt(cursor.getString(FIELD_FULE)));
	                	//ship
	                	tempMod=tempMod.valueOf((cursor.getString(FIELD_SHIP)));
	                	tempShip.setType(tempMod);
	                	tempP.setShip(tempShip);
	                	//curr planet
	                	//tempP.setCurrentPlanet(cursor.getString(FIELD_CURRPLANET))
	                	//inventory
	                	//tempP.setInventory)
	                	//skills
	                	tempSkill.put(SkillType.ENGINEERING, Integer.parseInt(cursor.getString(FIELD_ENGINEERING)));
	                	tempSkill.put(SkillType.FIGHTING, Integer.parseInt(cursor.getString(FIELD_FIGHTING)));
	                	tempSkill.put(SkillType.PILOTING, Integer.parseInt(cursor.getString(FIELD_PILOTING)));
	                	tempSkill.put(SkillType.TRADING, Integer.parseInt(cursor.getString(FIELD_TRADING)));
	                	Ret.add(tempP);
	                	
	                	/*System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString(FIELD_NAME)	+ " " + 
	                            cursor.getString(FIELD_MONEY)	+ " " + 
	                            cursor.getString(FIELD_SHIP)	+ " " + 
	                            cursor.getString(FIELD_CURRPLANET)	+ " "+
	                            cursor.getString(FIELD_PILOTING)	+ " " + 
	                            cursor.getString(FIELD_FIGHTING)	+ " " + 
	                            cursor.getString(FIELD_ENGINEERING)	+ " " + 
	                            cursor.getString(FIELD_TRADING)	+ " "
	                            */
	                            
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return Ret;
	}
	
private void LoadInventory(ISqlJetTable tbl)throws SqlJetException{
		/*ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString()	+ " " + 
	                            cursor.getString()	+ " " + 
	                            cursor.getString()	+ " " + 
	                            cursor.getString()	+ " "
	                            );
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}*/
	}
	
private Map<String,Planet> LoadPlanets(ISqlJetTable tbl)throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		Map<String,Planet> Ret=null;
		Planet tempPlanet = null;
		TechnologyLevel tempTech=null;
		PlanetarySystem tempSys=null;
		ResourceType tempRes=null;
		PlanetarySystem tempPs=null;
		PoliticalSystem tempPol=null;
		Event tempE=null;
		 try {
	            if (!cursor.eof()) {
	                do {
	                	//planet name
	                	tempPlanet.setName( cursor.getString(FIELD_PLANET));
	                	//planet tech level
	                	tempTech=tempTech.valueOf(cursor.getString(FIELD_TECH));
	                	tempPlanet.setTechnologyLevel(tempTech);
	                	// planet x & y
	                	tempPlanet.setX(Integer.parseInt(cursor.getString(FIELD_X)));
	                	tempPlanet.setX(Integer.parseInt(cursor.getString(FIELD_Y)));
	                	//resource type
	                	tempRes=tempRes.valueOf(cursor.getString(FIELD_RESOURCE));
	                	tempPlanet.setResourceType(tempRes);
	                	//Political system
	                	tempPol=tempPol.valueOf(cursor.getString(FIELD_POLSYS));
	                	tempPlanet.setPoliticalSystem(tempPol);
	                	//Planetary system
	                	tempSys=PS.get(cursor.getString(FIELD_SYS));
	                	tempPlanet.setPlanetarySystem(tempSys);
	                	//market
	                	//tempPlanet.setMarket(market)
	                	//event
	                	tempE=tempE.valueOf(cursor.getString(FIELD_EVENT));
	                	tempPlanet.setEvent(tempE);
	                	
	                	PS.get(cursor.getString(FIELD_SYS)).getPlanets().put(tempPlanet.getName(), tempPlanet);


	     
	                	Ret.put(tempPlanet.getName(),tempPlanet);
	                	/*
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString(FIELD_PLANET)	+ " " + 
	                            cursor.getString(FIELD_TECH)	+ " " + 
	                            cursor.getString(FIELD_POLSYS)	+ " " + 
	                            cursor.getString(FIELD_RESOURCE)	+ " "+
	                            cursor.getString(FIELD_X)	+ " " + 
	                            cursor.getString(FIELD_Y)	+ " " 
	                            */
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return Ret;
	}
	
private Settings LoadSettings(ISqlJetTable tbl)throws SqlJetException{
		ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {	
	                	
	                	/*               
	                	System.out.println("this is a test");
	                    System.out.println(cursor.getRowId()	+ " " + 
	                            cursor.getString(FIELD_CURRTURN)	+ " " + 
	                            cursor.getString(FIELD_CURRPLAYER)	+ " " + 
	                            cursor.getString(FIELD_DIFF)	+ " "
	                            );*/
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return null;
	}
	
private Map<String,PlanetarySystem>loadSystems(ISqlJetTable tbl)throws SqlJetException{
		Map<String,PlanetarySystem> PSMap = null;
		PlanetarySystem tempPS = null;
		ISqlJetCursor cursor=tbl.open();
		//Makes a map of systeems
		try {
	            if (!cursor.eof()) {
	                do {
	                	if(PSMap.containsKey(cursor.getString(FIELD_SYS))!=true)
	                	{
	                		tempPS.setName(cursor.getString(FIELD_SYS));	          
	                		tempPS.setX(Integer.parseInt(cursor.getString(FIELD_X)));
	                		tempPS.setY(Integer.parseInt(cursor.getString(FIELD_Y)));
	                		PSMap.put(tempPS.getName(), tempPS);
	                	}
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
		return PSMap;
		
	}
	
private void LoadMarkets(ISqlJetTable tbl)throws SqlJetException{
		MarketPlace tempM = null;
		BasicGood tempTrade;
		TradeGoodType tempType = null;
		ArrayList Ret = null;
		ISqlJetCursor cursor=tbl.open();
		 try {
	            if (!cursor.eof()) {
	                do {
	                	tempType=tempType.valueOf(cursor.getString(FIELD_ITEM));
	                	tempTrade=new BasicGood(tempType,tempType);
	                	Planets.get(cursor.getString(FIELD_PLANET)).setMarket(tempM);
	                	Planets.get(cursor.getString(FIELD_PLANET)).getMarket().changeQuantity(tempTrade, Integer.parseInt(cursor.getString(FIELD_Q)));
	                	Ret.add(tempM);
	                } while(cursor.next());
	            }
	        } 
		 finally {cursor.close();}
	}

	
	

}
