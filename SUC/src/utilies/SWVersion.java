package utilies;

public class SWVersion {
	public String currentVersion(){
		String releaseNum = new String();
		String releaseType = new String();
		String versionNum = new String();
		String version = new String();
		String authorA = new String();
		String authorX = new String();
		String stampa = new String();
		releaseNum = "2";
		versionNum = "1";
		releaseType = "A";
		authorA = "MasterEd";
		authorX = "Ichinose";
		version = releaseNum +"."+ versionNum +"."+ releaseType;
		//stampa = String.format("<html>Version:%-20s<br>Androidiani Forum:%-20s<br>XDA Forum:%-20s</html>", version,authorX,authorA);
		stampa = "<html><br><br><b>Version:</b>  "+version+"<br><b>Androidiani Forum:</b>  "+authorA+"<br><b>XDA Forum:</b>   "+authorX+"</html>";
		return stampa;		
	}
}