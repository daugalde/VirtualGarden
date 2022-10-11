package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

import model.app.virtualGarden.Plant;

public class AppView {

	private String title = "";
	private JFrame frame;
	private GroupLayout layout;
	private JButton simulateBtn;
	private JLabel simulationPeriod;
	private JLabel simulationPeriodLabel;
	private JLabel numberOfSeasonsForSimulationLabel;
	private JLabel numberOfSeasonsForSimulationLabelValue;
	private JLabel daysPassLabel;
	private JLabel daysPassLabelValue;
	private JLabel waterLabel;
	private JLabel waterLabelValue;
	private JLabel sunLevelLabel;
	private JLabel sunLevel;
	private JLabel titleLabel;
	private JLabel eventsLabel;	
	private JScrollPane scrollPane;
	private JList<?> labelList;
		
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

	public JLabel getSimulationPeriod() {
		return simulationPeriod;
	}

	public void setSimulationPeriod(JLabel simulationPeriod) {
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

	public JLabel getWaterLabel() {
		return waterLabel;
	}

	public void setWaterLabel(JLabel waterLabel) {
		this.waterLabel = waterLabel;
	}

	public JLabel getWaterLabelValue() {
		return waterLabelValue;
	}

	public void setWaterLabelValue(JLabel waterLabelValue) {
		this.waterLabelValue = waterLabelValue;
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

	public JList<?> getLabelList() {
		return labelList;
	}

	public void setLabelList(JList<?> labelList) {
		this.labelList = labelList;
	}
	
	public JLabel getNumberOfSeasonsForSimulationLabel() {
		return numberOfSeasonsForSimulationLabel;
	}

	public void setNumberOfSeasonsForSimulationLabel(JLabel temperatureLabel) {
		this.numberOfSeasonsForSimulationLabel = temperatureLabel;
	}

	public JLabel getNumberOfSeasonsForSimulationLabelValue() {
		return numberOfSeasonsForSimulationLabelValue;
	}

	public void setNumberOfSeasonsForSimulationLabelValue(JLabel temperatureLabelValue) {
		this.numberOfSeasonsForSimulationLabelValue = temperatureLabelValue;
	}

	public JLabel getDaysPassLabel() {
		return daysPassLabel;
	}

	public void setDaysPassLabel(JLabel daysPassLabel) {
		this.daysPassLabel = daysPassLabel;
	}

	public JLabel getDaysPassLabelValue() {
		return daysPassLabelValue;
	}

	public void setDaysPassLabelValue(JLabel daysPassLabelValue) {
		this.daysPassLabelValue = daysPassLabelValue;
	}

	private void initFrameSetup(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void initComponents () {
		
		simulationPeriodLabel  = new JLabel("Simulation Period");
		daysPassLabel = new JLabel("Days Passed");
		daysPassLabelValue = new JLabel("0");
		numberOfSeasonsForSimulationLabel = new JLabel("Number Of Seasons");
		numberOfSeasonsForSimulationLabelValue = new JLabel("0");
		waterLabel = new JLabel("Water Level");
		waterLabelValue = new JLabel("0");
		sunLevelLabel = new JLabel("Sun Level");
		sunLevel = new JLabel("0");
		titleLabel = new JLabel("Virtaul Garden Dashboard ");
		eventsLabel = new JLabel("Events");
		simulateBtn = new JButton("Start Simulation");
		labelList    = new JList<ModelPainter>();
		scrollPane    = new JScrollPane   (labelList);
		simulationPeriod = new JLabel("0");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initJList (ArrayList<Plant> plants) {	
		Item model = new Item();
		model.AddItem(plants);
		ModelPainter painter = new ModelPainter();
		labelList = new JList(model);
		labelList.setPreferredSize(new Dimension(20, 140));
		labelList.setCellRenderer(painter);
		labelList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);		
		scrollPane.setViewportView(labelList);	
	}
	
	@SuppressWarnings("unchecked")
	public void addItemToJList (ArrayList<Plant> plants) {	

		Item model = new Item();
		model.AddItem(plants);
		ModelPainter painter = new ModelPainter();
		JList list = new JList(model);
		list.setPreferredSize(new Dimension(20, plants.size()*140));
		list.setCellRenderer(painter);
		list.setVisibleRowCount(2);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
		setLabelList(list);
		scrollPane.setViewportView(labelList);	
	}
	
	public void InitView ( ) {
		initFrameSetup(title);
		initComponents ();
		bindComponents ();
	}
	
	private void bindComponents () {
		layout = new GroupLayout(frame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
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
	                                        .addComponent(numberOfSeasonsForSimulationLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(waterLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(sunLevelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(daysPassLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)	                                            
	                                            .addComponent(simulationPeriod, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(numberOfSeasonsForSimulationLabelValue, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(waterLabelValue, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(sunLevel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(daysPassLabelValue, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
	                                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addComponent(simulateBtn))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(simulationPeriodLabel).addComponent(simulationPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)	            
	                .addGap(14, 14, 14)	                
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(numberOfSeasonsForSimulationLabel).addComponent(numberOfSeasonsForSimulationLabelValue))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGap(14, 14, 14)	                
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(waterLabel).addComponent(waterLabelValue))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(sunLevelLabel).addComponent(sunLevel))
	                .addGap(44, 44, 44)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(daysPassLabel).addComponent(daysPassLabelValue))
	                .addGap(34, 34, 34)
	                .addComponent(simulateBtn)
	                .addGap(26, 26, 26)
	                .addComponent(eventsLabel)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
	                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
	                .addContainerGap())
	        );
		
		frame.getContentPane().setLayout(layout);
	
	}
}