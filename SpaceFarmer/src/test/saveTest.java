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
	@Test
	public void testSaver_db() throws SqlJetException {
		

		File dbFile = new File("test.sql");
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
			}
		
	}

	/**
	 * Test method for {@link app.service.Saver_db#saveGame()}.
	 */
	@Test
	public void testSaveGame() {
		fail("Not yet implemented");
	}
	
	

}
