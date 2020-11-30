import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Solution to Part 1 By Professor Klump used
 * Sets up the different options for the bar up top that is often seen in common applications everywhere
 * ALSO reads and writes to and from files and if not successful tells the user Tiles could not be read and Could not write Tiles
 * ALSO sets the dimensions of the frame and adds the buttons to the bottom 
 * 
 * 
 */
public class SlotMachineFrame extends JFrame {
	private TilePanel tpan;
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	private Double playerBalance=5.0;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		JMenuItem miRestart = new JMenuItem("Restart");
		JMenuItem miExit = new JMenuItem("Exit");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				ArrayList<Tile> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read.");
					}
				}
			}
		});
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),tpan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
			}
		});
		
		miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,tpan.toString());
			}
		});
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vegas Baby 2 By Matthew Diaz .https://github.com/mdiaz10/Diaz_Matthew_cpsc24500.git");
			}
		});
		
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMax.setEnabled(true);
				btnMid.setEnabled(true);
				btnMin.setEnabled(true);
				playerBalance=5.0;
				txtBalance.setText(String.format("%.2f",playerBalance));

			}
		});
		
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public void setupLook() {
		setBounds(100,100,750,300);
		setTitle("Vegas Baby Vegas Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileRandomizer tRandom= new TileRandomizer(tpan);
				TileChecker tChecker = new TileChecker();
				tRandom.spin(tpan.getTiles());
				playerBalance=tChecker.checkWinningCombinationsMax(tpan.getTiles(), playerBalance);
				if(playerBalance==0) {
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);

				}
				txtBalance.setText(String.format("%.2f",playerBalance));
			}
		});
		
		
		btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileRandomizer tRandom= new TileRandomizer(tpan);
				TileChecker tChecker = new TileChecker();
				tRandom.spin(tpan.getTiles());
				playerBalance=tChecker.checkWinningCombinationsMid(tpan.getTiles(), playerBalance);

				txtBalance.setText(String.format("%.2f",playerBalance));
			}
		});
		
		
		btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileRandomizer tRandom= new TileRandomizer(tpan);
				TileChecker tChecker = new TileChecker();
				tRandom.spin(tpan.getTiles());
				playerBalance=tChecker.checkWinningCombinationsMin(tpan.getTiles(), playerBalance);

				txtBalance.setText(String.format("%.2f",playerBalance));
			}
		});
		panSouth.add(btnMax);
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		tpan = new TilePanel();
		c.add(tpan,BorderLayout.CENTER);
		JLabel lblBalance = new JLabel("$");
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText(String.format("%.2f",playerBalance));
		panSouth.add(txtBalance);
		setupMenu();
	}
	public SlotMachineFrame() {
		setupLook();
	}
}

