package grafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	APannello p1;
	BPannello p2;
	public Frame() throws IOException{
		SystemGraphics systemClass = new SystemGraphics();
		String sistema = systemClass.SystemCheck();
		try	{
			UIManager.setLookAndFeel(sistema);;
		}catch (Exception e){
			
		}
		JMenuBar menubar = new JMenuBar();
		JMenu help = new JMenu("Help");
		JMenuItem eMenuItem = new JMenuItem("About");
		eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	new AboutFrame();
            }
        });
        help.add(eMenuItem);
        menubar.add(help);
        setJMenuBar(menubar);	
		setTitle("SUC: Xperia Z Update");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		p2 = new BPannello();
		p1 = new APannello(p2);
		add(p1,BorderLayout.CENTER);
		
		add(p2,BorderLayout.NORTH);
		validate();
		URL iconURL = getClass().getResource("/icons/icon.png");
		ImageIcon img = new ImageIcon(iconURL);
		setIconImage(img.getImage());
		setVisible(true);
		setResizable(false);
	}
}
