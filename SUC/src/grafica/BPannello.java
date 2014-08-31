package grafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BPannello extends JPanel {
	JButton bClose = new JButton("Close");
	JButton bLoad = new JButton("Load");
	JButton bUpdate = new JButton("Update");
	JComboBox<String> box = new JComboBox<>();
	public BPannello(){
		
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		bClose.setPreferredSize(new Dimension(100, 30));
		bLoad.setPreferredSize(new Dimension(100, 30));
		bUpdate.setPreferredSize(new Dimension(100, 30));
		box.setPreferredSize(new Dimension(100, 30));
		bClose.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		bUpdate.setVisible(false);
		box.addItem("ALL Version");
		box.addItem("Only Update");
		box.setVisible(false);
		FlowLayout pan = new FlowLayout();
		pan.setAlignment(FlowLayout.RIGHT);
		setLayout(pan);
		
		add(bUpdate);
		add(box);
		add(bLoad);
		add(bClose);
		
	}

}
