package org.tomcurran.controlpad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.tomcurran.controlpad.controllers.ControllerStateChange;

public class OrientationGraph extends ApplicationFrame implements Observer {

	private static final long serialVersionUID = -1727948182617521282L;

    private TimeSeries seriesX;
    private TimeSeries seriesY;
    private TimeSeries seriesZ;

	@SuppressWarnings("deprecation")
	public OrientationGraph(final String title) {

        super(title);
        seriesX = new TimeSeries("Orientation X", Millisecond.class);
        seriesY = new TimeSeries("Orientation Y", Millisecond.class);
        seriesZ = new TimeSeries("Orientation Z", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(seriesX);
        dataset.addSeries(seriesY);
        dataset.addSeries(seriesZ);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);

        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(content);

    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Controller Orientation", 
            "Time", 
            "Value",
            dataset, 
            true, 
            true, 
            false
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(-128.0, 127.0); 
        return result;
    }

	@Override
	public void update(Observable o, Object arg) {
		ControllerStateChange stateChange = (ControllerStateChange) arg;
		if (stateChange.isOrientationChanged()) {
			System.out.printf("x=%d y=%d z=%d\n", stateChange.getOrientationX(), stateChange.getOrientationY(), stateChange.getOrientationZ());
	        seriesX.addOrUpdate(new Millisecond(), stateChange.getOrientationX());
	        seriesY.addOrUpdate(new Millisecond(), stateChange.getOrientationY());
	        seriesZ.addOrUpdate(new Millisecond(), stateChange.getOrientationZ());
		}
	}

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final OrientationGraph demo = new OrientationGraph("Controller Orientation");
        demo.pack();

        ControlPad t = new ControlPad();
		t.addObserver(demo);

        RefineryUtilities.centerFrameOnScreen(demo);
		t.start();
        demo.setVisible(true);

    }

}
