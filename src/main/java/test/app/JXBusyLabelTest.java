package test.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXBusyLabel;

/**
 * Classe JXBusyLabelTest, TP1
 * @author 18011548
 */
public class JXBusyLabelTest extends JFrame implements ActionListener {
	/**
	 * Serialisable 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	 * Label
	 */
	private JXBusyLabel bLabel1;
	/***
	 * Ajout code mort
	 */
	private JXBusyLabel bLabel2;
	private JXBusyLabel bLabel3;
	private JXBusyLabel bLabel4;
	/**
	 * Fenetres
	 */
	private JComboBox<Object> comboBackground, comboForeground;
	/**
	 * Boutons
	 */
	private JButton btnStart, btnStop;
	/**
	 * Couleurs
	 */
	private Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW};

	/**
	 * Constructeur
	 * Creation d'une fenetre
	 * Ajout de boutons
	 */
	private JXBusyLabelTest() {
		bLabel1 = new JXBusyLabel(new Dimension(60, 60));
		bLabel1.setBusy(true);

		String[] colorsName = {"Choose a color", "BLACK", "WHITE", "RED", "BLUE", "GREEN", "GRAY", "YELLOW"};
		comboBackground = new JComboBox<Object>(colorsName);
		comboForeground = new JComboBox<Object>(colorsName);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");

		comboBackground.addActionListener(this);
		comboForeground.addActionListener(this);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);

		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		panelSouth.add(new JLabel("Background"));
		panelSouth.add(comboBackground);
		panelSouth.add(new JLabel("Foreground"));
		panelSouth.add(comboForeground);
		panelNorth.add(btnStart);
		panelNorth.add(btnStop);

		add(panelNorth, BorderLayout.NORTH);
		add(bLabel1, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		setSize(400, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Performance
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBackground) {
			bLabel1.getBusyPainter().setBaseColor(colors[comboBackground.getSelectedIndex()-1]);
		} else if (e.getSource() == comboForeground) {
			bLabel1.getBusyPainter().setHighlightColor(colors[comboForeground.getSelectedIndex()-1]);
		} else if (e.getSource() == btnStart) {
			bLabel1.setBusy(true);
		} else if (e.getSource() == btnStop) {
			bLabel1.setBusy(false);
		}
	}

	/**
	 * Le main
	 * @param args
	 */
	public static void main(String[] args) {
		new JXBusyLabelTest();
	}

}
