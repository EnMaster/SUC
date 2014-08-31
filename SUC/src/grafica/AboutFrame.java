package grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import utilies.SWVersion;

public class AboutFrame {
	public AboutFrame(){
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("About");
		frame.setMinimumSize(new Dimension(300,200));
		frame.setLocationRelativeTo(null);
		/*
			Impostazioni Icona (Barra In basso)
		 */
		URL iconURL = getClass().getResource("/icons/about.png");
		ImageIcon img = new ImageIcon(iconURL);
		frame.setIconImage(img.getImage());
		
		
        SWVersion ver = new SWVersion();
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        
        JPanel panelClose = new JPanel();
        
        JButton buttonChiudi = new JButton("Close About");
        panelClose.add(buttonChiudi);
        buttonChiudi.setHorizontalAlignment(SwingConstants.LEFT);
        buttonChiudi.addActionListener(new ActionListener() {			
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);
                frame.dispose();
        	}
        });        
        
        JLabel labelVer = new JLabel();
        labelVer.setHorizontalAlignment(SwingConstants.CENTER);
        labelVer.setText(ver.currentVersion());
        panel.add(labelVer);
        
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(panelClose, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
	}

}
