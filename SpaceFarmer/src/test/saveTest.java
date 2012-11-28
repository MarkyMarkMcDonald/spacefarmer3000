// $codepro.audit.disable

/* This is a JUnit test case file and is thus not subject to an audit.
 */

package test;

import static org.junit.Assert.*;

import java.io.File;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import org.junit.Test;

import app.factory.UniverseFactory;
import app.listener.FileChooserListener;
import app.model.Game;
import app.model.Settings;
import app.model.player.SkillType;
import app.service.Saver_db;

/**
 * @author Fro
 *
 */
public class saveTest {

	/**
	 * Test method for {@link app.service.Saver_db#Saver_db(java.io.File, java.util.Collection, java.util.Map, app.model.Settings, app.model.Game)}.
	 * @throws SqlJetException 
	 */
	File dbFile = new File("test2.sql");
	@Test
	public void testSaver_db() throws SqlJetException {
		


		Saver_db saveTest=new Saver_db();
		try{
			dbFile.delete();
			} finally{
				
			}
			// create database
			final SqlJetDb db = SqlJetDb.open(dbFile, true);
			
			db.getOptions().setAutovacuum(true);
			db.beginTransaction(SqlJetTransactionMode.WRITE);
			// set DB version
			try {
				db.getOptions().setUserVersion(1);
			} finally {
				db.commit();
				db.beginTransaction(SqlJetTransactionMode.WRITE);
			
			try {
				saveTest.createTables(db);
			} catch (Exception e) {
				fail("Did not sucessfully make tables");
				e.printStackTrace();
			}
			final ISqlJetTable table = db.getTable("players");
			db.beginTransaction(SqlJetTransactionMode.WRITE);

			// Test entry		
				try {
					table.insert("zuul", "9999","999","earth",	"flea", 1, 4, 7, 5);
					db.commit();
				}finally{
					
				}
				
			}
		db.close();
		
	}

	/**
	 * Test method for {@link app.service.Saver_db#saveGame()}.
	 * @throws SqlJetException 
	 */
	@Test
	public void testSaveGame() throws SqlJetException {
		//File dbFile = new File("test.sql");

	//	testSaver_db();
		final SqlJetDb db = SqlJetDb.open(dbFile, true);

		
		final ISqlJetTable table = db.getTable("players");

		// Test entry		
			try {
				db.beginTransaction(SqlJetTransactionMode.WRITE);

				table.insert("zuul", "9999","999","earth",	"flea", 1, 4, 7, 5);
				db.commit();

			} catch (Exception e) {
				fail("Did not sucessfully insert to");
				e.printStackTrace();
			}
			db.close();

	}
	
	

}
