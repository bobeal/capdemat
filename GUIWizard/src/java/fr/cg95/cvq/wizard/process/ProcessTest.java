package fr.cg95.cvq.wizard.process;

import java.io.FileWriter;

public class ProcessTest {

	public ProcessTest() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String xmlFile = args[0];
			String outFile = args[1];
			
			FileWriter out = new FileWriter(outFile);
			
			ProcessWizardPlugin plugin = new ProcessWizardPlugin();
			
			plugin.setFiles(xmlFile);
			
			plugin.init(null, null);
			
			ProcessWizard process = (ProcessWizard)plugin.getProcess("eCitizen");
			
			if (process != null) {
//				process.testPage(out);
				out.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
