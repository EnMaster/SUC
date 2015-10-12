package grafica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import loader.DBWriter;
import risorse.ZC6603;
import checkVersion.FWCheckVersion;

@SuppressWarnings("serial")
public class APannello extends JPanel{
	
	JTextArea areaText = new JTextArea();
	JTable table;
	FWCheckVersion check;
	Object[][] rowData;
	Object[][] checkData;
	DefaultTableModel model;
	DefaultTableModel model1;
	DefaultTableModel model2;
	ArrayList<ZC6603> phoneC6603;
	public APannello(final BPannello p2) throws IOException{
		
		final Object[] columnNames = {"X/V","Nation","Brand","Serial","Version","New Version"};
		model = new DefaultTableModel(rowData, columnNames);
		
		table = new JTable(model){
		    @SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column){
		        return getValueAt(0, column).getClass();
		    }
		};		
		
		p2.bLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				class MyWorker extends SwingWorker<String, Void>  {
					
				     protected String doInBackground() {
				    	 
				       p2.progressBar.setVisible(true);
				       //p2.progressBar.setIndeterminate(false);
				       p2.progressBar.setValue(0);
				       p2.progressBar.setStringPainted(true);
				     
				       
				      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						
				      check = new FWCheckVersion();
						phoneC6603 = check.phC6603;
						rowData = new Object[phoneC6603.size()][6];
						
						for(int i=0; i<phoneC6603.size();i++){
							int perc =(100*(i+1))/phoneC6603.size();
							rowData[i][0] = new ImageIcon(getClass().getResource(phoneC6603.get(i).getState()));
							rowData[i][1] = phoneC6603.get(i).getNation();
							rowData[i][2] = phoneC6603.get(i).getBrand();
							rowData[i][3] = phoneC6603.get(i).getSerial();
							rowData[i][4] = phoneC6603.get(i).getVersion();
							rowData[i][5] = phoneC6603.get(i).getNewVersion();
							p2.progressBar.setValue(perc);
						}
						model1 = new DefaultTableModel(rowData, columnNames);
						table.setModel(model1); 
					    ((DefaultTableModel)table.getModel()).fireTableDataChanged();
					    /*INIZIO BARBATRUCCO*/
						for (int i = 0; i < table.getColumnCount(); i++) {
							DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
							TableColumn col = colModel.getColumn(i);
							int width = 0;

							TableCellRenderer renderer = col.getHeaderRenderer();
							for (int r = 0; r < table.getRowCount(); r++) {
								renderer = table.getCellRenderer(r, i);
						        Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, i),false, false, r, i);
						        width = Math.max(width, comp.getPreferredSize().width);
						      }
						      col.setPreferredWidth(width + 2);
					    }
						/*FINE BARBATRUCCO*/
						p2.bUpdate.setVisible(true);
						p2.box.setVisible(true);		
				      
				      
					
						return null;
				     }

				     protected void done() {
				       
				       setCursor(Cursor.getDefaultCursor());
				     }
				  }

				  new MyWorker().execute();
		}
				
				
				
				
				
				
					
		});		
		p2.bUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DBWriter(phoneC6603);				
			}
		});
		
		p2.box.addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "unchecked" })
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<String> combo;
				combo = p2.box;
				combo = (JComboBox<String>) arg0.getSource();
				if(combo.getSelectedItem().equals("ALL Version")){
					rowData = new Object[phoneC6603.size()][6];
					for(int i=0; i<phoneC6603.size();i++){
						
						rowData[i][0] = new ImageIcon(getClass().getResource(phoneC6603.get(i).getState()));
						rowData[i][1] = phoneC6603.get(i).getNation();
						rowData[i][2] = phoneC6603.get(i).getBrand();
						rowData[i][3] = phoneC6603.get(i).getSerial();
						rowData[i][4] = phoneC6603.get(i).getVersion();
						rowData[i][5] = phoneC6603.get(i).getNewVersion();
					}
					validate();
					model1 = new DefaultTableModel(rowData, columnNames);
					table.setModel(model1); 
				    ((DefaultTableModel)table.getModel()).fireTableDataChanged();
				}
				
				if(combo.getSelectedItem().equals("Only Update")){
					
					rowData = new Object[phoneC6603.size()][6];
					int counter = 0;
					ArrayList<Integer> stack = new ArrayList<>();
					for(int i=0; i<phoneC6603.size();i++){
						if(phoneC6603.get(i).getState().equals("/img/check.png")){
							stack.add(i);
							counter++;
						}						
					}
					checkData = new Object[counter][6];
					for(int i=0; i<counter;i++){
						checkData[i][0] = new ImageIcon(getClass().getResource(phoneC6603.get(stack.get(i)).getState()));
						checkData[i][1] = phoneC6603.get(stack.get(i)).getNation();
						checkData[i][2] = phoneC6603.get(stack.get(i)).getBrand();
						checkData[i][3] = phoneC6603.get(stack.get(i)).getSerial();
						checkData[i][4] = phoneC6603.get(stack.get(i)).getVersion();
						checkData[i][5] = phoneC6603.get(stack.get(i)).getNewVersion();						
					}
					validate();
					model2 = new DefaultTableModel(checkData, columnNames);
					table.setModel(model2); 
				    ((DefaultTableModel)table.getModel()).fireTableDataChanged();
				}
				
			    /*INIZIO BARBATRUCCO*/
				for (int i = 0; i < table.getColumnCount(); i++) {
					DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
					TableColumn col = colModel.getColumn(i);
					int width = 0;

					TableCellRenderer renderer = col.getHeaderRenderer();
					for (int r = 0; r < table.getRowCount(); r++) {
						renderer = table.getCellRenderer(r, i);
				        Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, i),false, false, r, i);
				        width = Math.max(width, comp.getPreferredSize().width);
				      }
				      col.setPreferredWidth(width + 2);
			    }
				/*FINE BARBATRUCCO*/
			}
		});
		table.setFont(new Font("monospaced", Font.PLAIN, 12));		
		JScrollPane scroller = new JScrollPane();		
		scroller.getViewport().add(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setLayout(new BorderLayout());
        validate();
		add(scroller, BorderLayout.CENTER);
	}
	

}
