package grafica;

public class SystemGraphics {
	public String SystemCheck(){
		String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		String mac= "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		String linux = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		String link = null;
		String sistema = System.getProperty("os.name");
		if(sistema.contains("uni")||sistema.contains("linu")||sistema.contains("nix")||sistema.contains("Linu")){
			return link = linux;
		}
		if(sistema.contains("win")||sistema.contains("dos")||sistema.contains("Win")){
			return link = windows;
		}
		if(sistema.contains("Mac")||sistema.contains("mac")){
			return link = mac;
		}
		return link;
	}
}