/*
Mykal Thomas
Settings
10/7/2012
*/
public class Settings {
	int difficulty;
	int currentTurn;
	int numPlayers;
	String saveLocation;
	
	Settings(String save, int diff){
		difficulty=diff;
		currentTurn=0;
		numPlayers=0;
		saveLocation=null;
	}
	private int  getDiff(){
		return difficulty;
	}
	private void setDiff(int num){
		if (num>3|num<1)
			throw new IndexOutOfBoundsException();
		else
			difficulty=num;
	}
	private int getCurTurn(){
		return currentTurn;
	}
	private void setCurTurn(int num){
		currentTurn=num;
	}
	private int getPlayers(){
		return numPlayers;
	}
	private void setPlayers(int num){
		numPlayers=num;
	}
	private String getSave(){
		return saveLocation;
	}
	private void setSave(String save){
		saveLocation=save;
	}
	private boolean Load(String save){
		return false;
	}
	private boolean Load(){
		return false;
	}
	private void Save(){
		
	}
	private void Save(String save){
		
	}
	


}
