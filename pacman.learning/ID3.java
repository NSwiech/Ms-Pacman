package pacman.learning;

import java.util.ArrayList;

import dataRecording.DataTuple;

public class ID3 {

	private Table table;
	private int nodeCount;
	
	public ID3(Table table, int nodeCount) {
		this.table = table;
		this.nodeCount = nodeCount;
	}

	public double calculateEntropy(int[] occurrences) {
		double totalOccurrences = 0;
		int counter = 0;
		for (int i = 0; i < occurrences.length; i++) {
			if ((double) occurrences[i] == 0)
				counter++;
			totalOccurrences += (double) occurrences[i];
		}
		if (counter == occurrences.length - 1)
			return 0;
		if (totalOccurrences == 0)
			return 0;
		double entropy = 0;
		for (int i = 0; i < occurrences.length; i++) {
			if (occurrences[i] != 0)
				entropy += (-1) * (occurrences[i] / totalOccurrences)
						* (Math.log10(occurrences[i] / totalOccurrences) / Math.log10(2));
		}
		return entropy;
	}

	private double calculateGain(int attribute, DataTuple data, ArrayList<Attribute> targetAttributes, ArrayList<Attribute> attributes) {
		Table table = new Table(data, targetAttributes, attributes);
		ArrayList<int[]> valueOccurrences = table.getValueOccurrences(attribute, data, targetAttributes);
		int[] targetOccurrences = table.getTargetAttributeOccurrences(targetAttributes);
		double totalOccurrences = 0;
		for (int i = 0; i < targetOccurrences.length; i++) {
			totalOccurrences += targetOccurrences[i];
		}
		double[] valueSummation = new double[valueOccurrences.size()];
		for (int i = 0; i < valueOccurrences.size(); i++) {
			for (int j = 0; j < targetOccurrences.length; j++) {
				valueSummation[i] += valueOccurrences.get(i)[j];
			}
		}
		double value = 0;
		for (int i = 0; i < valueOccurrences.size(); i++) {
			value += (-1) * (valueSummation[i] / totalOccurrences) * calculateEntropy(valueOccurrences.get(i));
		}
		double gain = calculateEntropy(targetOccurrences);
		gain += value;
		return gain;
	}

	private Attribute findBestAttribute(DataTuple data, ArrayList<Attribute> targetAttributes,
			ArrayList<Attribute> attributes) {
		double bestGain = -1;
		int bestAttribute = -1;
		for (Attribute attribute : attributes) {
			int attributeColPos = attribute.getPosition();
			double gain = calculateGain(attributeColPos, data, targetAttributes, attributes);
			/*
			 * double splitInformation = splitInformation(attributeColPos,
			 * examples, targetAttributes, attributes); if (splitInformation >
			 * 0) { gain = gain / splitInformation; }
			 */
			if (gain >= bestGain) {
				bestGain = gain;
				bestAttribute = attributeColPos;
			}
		}
		for (Attribute attribute : attributes) {
			if (attribute.getPosition() == bestAttribute)
				return attribute;
		}
		return null;
	}
	
}
