package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

import model.app.virtualGarden.Plant;
import model.app.virtualGarden.Simulator;

public class AppView {

	private String title = "";
	private JFrame frame;
	private GroupLayout layout;
	private JButton simulateBtn;
	private JComboBox<String> simulationPeriod;
	private JLabel simulationPeriodLabel;
	private JLabel waterLabel;
	private JLabel waterLabelValue;
	private JLabel sunLevelLabel;
	private JLabel sunLevel;
	private JLabel titleLabel;
	private JLabel eventsLabel;    
	
	private JScrollPane scrollPane;
	private JList labelList;
		
	public AppView(String title) {
		this.title = title;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public GroupLayout getLayout() {
		return layout;
	}

	public void setLayout(GroupLayout layout) {
		this.layout = layout;
	}

	public JButton getSimulateBtn() {
		return simulateBtn;
	}

	public void setSimulateBtn(JButton simulateBtn) {
		this.simulateBtn = simulateBtn;
	}

	public JComboBox<String> getSimulationPeriod() {
		return simulationPeriod;
	}

	public void setSimulationPeriod(JComboBox<String> simulationPeriod) {
		this.simulationPeriod = simulationPeriod;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}
	
	public JLabel getSimulationLabel() {
		return simulationPeriodLabel;
	}

	public void setSimulationLabel(JLabel simulationLabel) {
		this.simulationPeriodLabel = simulationLabel;
	}

	public JLabel getYachtVelocityLabel() {
		return waterLabel;
	}

	public void setYachtVelocityLabel(JLabel yachtVelocityLabel) {
		this.waterLabel = yachtVelocityLabel;
	}

	public JLabel getYachtVelocity() {
		return waterLabelValue;
	}

	public void setYachtVelocity(JLabel yachtVelocity) {
		this.waterLabelValue = yachtVelocity;
	}

	public JLabel getSunLevelLabel() {
		return sunLevelLabel;
	}

	public void setSunLevelLabel(JLabel sunLevelLabel) {
		this.sunLevelLabel = sunLevelLabel;
	}

	public JLabel getSunLevel() {
		return sunLevel;
	}

	public void setSunLevel(JLabel sunLevel) {
		this.sunLevel = sunLevel;
	}

	public JLabel getEventsLabel() {
		return eventsLabel;
	}

	public void setEventsLabel(JLabel eventsLabel) {
		this.eventsLabel = eventsLabel;
	}

	

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JList<JLabel> getLabelList() {
		return labelList;
	}

	public void setLabelList(JList<JLabel> labelList) {
		this.labelList = labelList;
	}

	

	private void initFrameSetup(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 920);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	private void initComponents (int simulationTime) {
		
		simulationPeriodLabel  = new JLabel("Periodo de Simulacion");
	
		
		waterLabel = new JLabel("Nivel de Agua");
		waterLabelValue = new JLabel("NONE");
		sunLevelLabel = new JLabel("Nivel de Sol");
		sunLevel = new JLabel("NONE");
		titleLabel = new JLabel("Virtaul Garden Dashboard ");
		eventsLabel = new JLabel("Eventos");
		simulateBtn = new JButton("Iniciar Simulacion");
	
		scrollPane    = new JScrollPane   ();
		labelList    = new JList();
	
		simulationPeriod = new JComboBox<>(new DefaultComboBoxModel<>(new String[] { simulationTime + " segundos" }));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initJList (ArrayList<Plant> plants) {
		
		
		Item model = new Item();
		model.AddItem(plants);
		ModelPainter painter = new ModelPainter();
		labelList = new JList(model);
		labelList.setCellRenderer( painter);
		labelList.setVisibleRowCount(plants.size());
		labelList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrollPane.setViewportView(labelList);
	
	}
	
	public void InitView (Simulator simulator) {
		initFrameSetup(title);
		initComponents (simulator.getSimulationTime() * 60);
		initJList (simulator.getPlants());
		bindComponents ();
	}
	
	private void bindComponents () {
		layout = new GroupLayout(frame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
	    scrollPane.setViewportView(labelList);
		layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(41, 41, 41)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                        .addComponent(simulationPeriodLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        
	                                        .addComponent(waterLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(sunLevelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                            
	                                            .addComponent(simulationPeriod, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                        .addComponent(waterLabelValue, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(sunLevel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
	                                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addComponent(simulateBtn))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addComponent(scrollPane)
	                    .addComponent(eventsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap())
	        );
		
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(43, 43, 43)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addComponent(titleLabel)
	                .addGap(43, 43, 43)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(simulationPeriodLabel)
	                    .addComponent(simulationPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                    )
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            
	                .addGap(14, 14, 14)
	                
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(waterLabel)
	                    .addComponent(waterLabelValue))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(sunLevelLabel)
	                    .addComponent(sunLevel))
	                .addGap(44, 44, 44)
	                .addComponent(simulateBtn)
	                .addGap(26, 26, 26)
	                .addComponent(eventsLabel)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
	                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
	                .addGap(44, 44, 44))
	        );
		
		frame.getContentPane().setLayout(layout);
	}	
}